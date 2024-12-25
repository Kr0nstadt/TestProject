package org.example.flaghandler.factory;
import org.example.flaghandler.handler.IHandleConfig;
public class HandlerShortStatisticModeFlagFactory implements IFlagHandlerFactory{
    @Override
    public IHandleConfig createHandler(String flag) {
        return null;
    }

    @Override
    public Boolean isMatch(String flag) {
        return flag.contains("-s");
    }
}
