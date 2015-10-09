package com.gl.controller;

import com.gl.entity.ISOMsgE;
import com.gl.repository.Repository;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ggpratama on 10/8/2015.
 */
@RestController
public class ISORestController {
    @RequestMapping(value = "/isomsg",method = RequestMethod.GET)
    public ISOMsgE getMessageRest(){
        Repository repository = Repository.getInstance();
        ISOMsg isoMsg = repository.getISOMessage();
        ISOMsgE isoMsgE = new ISOMsgE();
        try {
            //Buat test aja
            isoMsgE.setField0(isoMsg.getMTI());
            isoMsgE.setField11(isoMsg.getString(11));
            isoMsgE.setField3(isoMsg.getString(3));
            isoMsgE.setField4(isoMsg.getString(4));

        } catch (ISOException e) {
            e.printStackTrace();
        }
        return isoMsgE;
    }


}
