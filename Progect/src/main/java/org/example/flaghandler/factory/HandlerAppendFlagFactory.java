package org.example.flaghandler.factory;
import org.example.flaghandler.handler.HandlerAppendFlag;
import org.example.flaghandler.handler.IHandleConfig;

public class HandlerAppendFlagFactory implements IFlagHandlerFactory{
    @Override
    public IHandleConfig createHandler() {
        return new HandlerAppendFlag();
    }

    @Override
    public Boolean isMatch(String flag) {
        return flag.contains("-a");
    }
}
