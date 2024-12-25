package org.example.flaghandler.factory;

public interface IFlagHandlerFactory {
    public IHandleConfig createHandler(String flag);
    public Boolean isMatch(String flag);
}
