package org.example.flaghandler.factory;
import org.example.flaghandler.handler.HandlerInputFiles;
import org.example.flaghandler.handler.IHandleConfig;
public class HandlerInputFilesFactory implements IFlagHandlerFactory{
    @Override
    public IHandleConfig createHandler() {
        return new HandlerInputFiles();
    }

    @Override
    public Boolean isMatch(String flag) {
        return true;
    }
}
