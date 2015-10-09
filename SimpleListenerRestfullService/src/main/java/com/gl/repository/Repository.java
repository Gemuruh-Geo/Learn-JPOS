package com.gl.repository;

import org.jpos.iso.ISOMsg;

/**
 * Created by ggpratama on 10/8/2015.
 */
public class Repository {
    private ISOMsg responseISOMsg;
    private static Repository instance;
    private Repository(){}
    public static Repository getInstance(){
        if(instance==null){
            instance = new Repository();
        }
        return instance;
    }
    public void putISOMessage(ISOMsg isoMsg){this.responseISOMsg = isoMsg;}
    public ISOMsg getISOMessage(){
        return responseISOMsg;
    }

}
