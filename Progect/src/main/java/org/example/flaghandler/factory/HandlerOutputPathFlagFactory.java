package org.example.flaghandler.factory;
import org.example.flaghandler.handler.HandlerOutputPathFlag;
import org.example.flaghandler.handler.IHandleConfig;
public class HandlerOutputPathFlagFactory implements IFlagHandlerFactory{
    @Override
    public IHandleConfig createHandler() {
        return new HandlerOutputPathFlag();
    }

    @Override
    public Boolean isMatch(String flag) {
        return flag.contains("-o");
    }
}
