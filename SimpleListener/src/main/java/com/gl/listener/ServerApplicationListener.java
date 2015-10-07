package com.gl.listener;

import com.constant.Constants;
import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;
import org.jpos.space.Space;
import org.jpos.space.SpaceFactory;
import org.jpos.transaction.Context;

/**
 * Created by ggpratama on 10/7/2015.
 */
public class ServerApplicationListener implements ISORequestListener,Configurable{

    private Configuration configuration;
    @Override
    public void setConfiguration(Configuration configuration) throws ConfigurationException {
        this.configuration = configuration;
    }

    @Override
    public boolean process(ISOSource isoSource, ISOMsg isoMsg) {
        String spaceN = configuration.get("space");
        Long timeout = configuration.getLong("spaceTimeout");
        String queueN = configuration.get("queue");
        Context context = new Context();
        Space<String,Context> space = SpaceFactory.getSpace(spaceN);

        try {
            ISOMsg respMsg = (ISOMsg)isoMsg.clone();
            respMsg.setResponseMTI();
            respMsg.set(39,"00");

            context.put(Constants.REQUEST_KEY,isoMsg);
            context.put(Constants.RESPONSE_KEY,respMsg);
            context.put(Constants.RESOURCE_KEY,isoSource);

        } catch (ISOException e) {
            e.printStackTrace();
        }

        space.out(queueN,context,timeout);
        return false;
    }
}
