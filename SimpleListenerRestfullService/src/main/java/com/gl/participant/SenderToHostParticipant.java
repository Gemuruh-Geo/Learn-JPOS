package com.gl.participant;

import com.constant.Constants;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.MUX;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;
import org.jpos.util.*;

import java.io.Serializable;

/**
 * Created by ggpratama on 10/8/2015.
 */
public class SenderToHostParticipant implements TransactionParticipant{

    @Override
    public int prepare(long l, Serializable serializable) {
        String test = "Masuk";
        return PREPARED;
    }

    @Override
    public void commit(long l, Serializable serializable) {
        try {
            sendToRemoteHost((Context)serializable);
        } catch (NameRegistrar.NotFoundException e) {
            e.printStackTrace();
        } catch (ISOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void abort(long l, Serializable serializable) {
        try {
            sendToRemoteHost((Context)serializable);
        } catch (NameRegistrar.NotFoundException e) {
            e.printStackTrace();
        } catch (ISOException e) {
            e.printStackTrace();
        }
    }

    private void sendToRemoteHost(Context context) throws NameRegistrar.NotFoundException, ISOException {
        MUX mux = (MUX) NameRegistrar.get("mux.mymux");
        ISOMsg resMsg = (ISOMsg)context.get(Constants.RESPONSE_KEY);
        ISOMsg buffMsg = (ISOMsg)mux.request(resMsg,1000);
        if(buffMsg!=null){
            System.out.println("========================= "+buffMsg.pack());
        }

//        Logger logger = new Logger();
//        logger.addListener (new SimpleLogListener(System.out));
//        LogEvent evt = new LogEvent (buffMsg, "my-event");
//        evt.addMessage ("A String message");
//        evt.addMessage (anyLoggeableObject);
//        Logger.log (evt);
    }
}
