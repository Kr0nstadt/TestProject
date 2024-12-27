package org.example.flaghandler.handler;

import org.example.config.Configuration;

public class HandlerAppendFlag implements IHandleConfig{
    @Override
    public void handle(Configuration config) {
        config.setIsAppend(true);
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null ||
                getClass() != obj.getClass()){
            return false;
        }
        return true;
    }
    @Override
    public int hashCode(){
        return getClass().hashCode();
    }
}
