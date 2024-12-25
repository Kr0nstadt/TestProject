package org.example.flaghandler.factory;
import org.example.flaghandler.handler.HandlerFullStatisticModeFlag;
import org.example.flaghandler.handler.IHandleConfig;
public class HandlerFullStatisticModeFlagFactory implements IFlagHandlerFactory{
    @Override
    public IHandleConfig createHandler(String flag) {
        return new HandlerFullStatisticModeFlag();
    }

    @Override
    public Boolean isMatch(String flag) {
        return flag.contains("-f");
    }
}
