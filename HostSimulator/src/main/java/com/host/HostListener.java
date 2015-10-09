package com.host;

import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;

/**
 * Created by ggpratama on 10/8/2015.
 */
public class HostListener implements ISORequestListener{

    @Override
    public boolean process(ISOSource isoSource, ISOMsg isoMsg) {
        ISOMsg msg = isoMsg;
        System.out.println("Receive ISO Message: "+msg);

        return false;
    }
}
