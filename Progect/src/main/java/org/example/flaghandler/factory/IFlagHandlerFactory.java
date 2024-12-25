package org.example.flaghandler.factory;
import org.example.flaghandler.handler.IHandleConfig;
public interface IFlagHandlerFactory {
    public IHandleConfig createHandler(String flag);
    public Boolean isMatch(String flag);
}
