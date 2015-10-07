package com.gl.participant;

import com.constant.Constants;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;

import java.io.Serializable;

/**
 * Created by ggpratama on 10/7/2015.
 */
public class NetworkParticipant implements TransactionParticipant{

    @Override
    public int prepare(long l, Serializable serializable) {
        Context ctx = (Context)serializable;
        //Set Response for Network Check
        ISOMsg respMsg = (ISOMsg)ctx.get(Constants.RESPONSE_KEY);
        try {
            respMsg.set(39,"00");
            ctx.put(Constants.RESPONSE_KEY,respMsg);
        } catch (ISOException e) {
            e.printStackTrace();
        }
        return PREPARED;
    }

    @Override
    public void commit(long l, Serializable serializable) {

    }

    @Override
    public void abort(long l, Serializable serializable) {
    }
}
