package com.gl.participant;

import com.constant.Constants;
import com.gl.repository.Repository;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;

import java.io.Serializable;

/**
 * Created by ggpratama on 10/8/2015.
 */
public class SendRestfullParticipant implements TransactionParticipant{
    @Override
    public int prepare(long l, Serializable serializable) {
        String test = "Masuk 2";
        return PREPARED;
    }

    @Override
    public void commit(long l, Serializable serializable) {
        putRestResponse((Context)serializable);
    }

    @Override
    public void abort(long l, Serializable serializable) {

    }
    private void putRestResponse(Context context){
        Repository repository = Repository.getInstance();
        ISOMsg respMessage = (ISOMsg)context.get(Constants.RESPONSE_KEY);
        repository.putISOMessage(respMessage);
    }
}
