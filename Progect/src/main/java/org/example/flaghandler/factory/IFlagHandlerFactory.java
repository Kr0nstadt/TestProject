package org.example.flaghandler.factory;
import org.example.flaghandler.handler.IHandleConfig;
public interface IFlagHandlerFactory {
    public IHandleConfig createHandler();
    public Boolean isMatch(String flag);
}
