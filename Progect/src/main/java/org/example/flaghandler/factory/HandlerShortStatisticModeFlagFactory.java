package org.example.flaghandler.factory;
import org.example.flaghandler.handler.HandlerShortStatisticModeFlag;
import org.example.flaghandler.handler.IHandleConfig;
public class HandlerShortStatisticModeFlagFactory implements IFlagHandlerFactory{
    @Override
    public IHandleConfig createHandler() {
        return new HandlerShortStatisticModeFlag();
    }

    @Override
    public Boolean isMatch(String flag) {
        return flag.equals("-s");
    }
}
