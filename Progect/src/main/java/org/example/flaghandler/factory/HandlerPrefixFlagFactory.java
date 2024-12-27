package org.example.flaghandler.factory;

import org.example.flaghandler.handler.HandlerPrefixFlag;
import org.example.flaghandler.handler.IHandleConfig;

public class HandlerPrefixFlagFactory implements IFlagHandlerFactory{
    @Override
    public IHandleConfig createHandler() {
        return new HandlerPrefixFlag();
    }

    @Override
    public Boolean isMatch(String flag) {
        return flag.equals("-p");
    }
}
