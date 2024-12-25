package org.example.flaghandler.factory;
import org.example.flaghandler.handler.IHandleConfig;
public class HandlerInputFilesFactory implements IFlagHandlerFactory{
    @Override
    public IHandleConfig createHandler(String flag) {
        return null;
    }

    @Override
    public Boolean isMatch(String flag) {
        return null;
    }
}
