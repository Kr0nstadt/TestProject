package org.example.flaghandler.factory;

import org.example.flaghandler.handler.HandlerPrefixFlag;
import org.example.flaghandler.handler.IHandleConfig;

public class HandlerPrefixFlagFactory implements IFlagHandlerFactory{
    @Override
    public IHandleConfig createHandler(String flag) {
        return new HandlerPrefixFlag(flag);
    }

    @Override
    public Boolean isMatch(String flag) {
        return flag.contains("-p");
    }
}
