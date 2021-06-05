package com.ptg.ptgchannelimpl.util;


import com.ptg.ptgchannelimpl.exception.GatewayException;

import java.util.Objects;


public class ObjectAssert {

    public static void requireNotNull(Object obj, String message) throws GatewayException{
        if(Objects.isNull( obj )){
            throw new GatewayException( message );
        }
    }

}
