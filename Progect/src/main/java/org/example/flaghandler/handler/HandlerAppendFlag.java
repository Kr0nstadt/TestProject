package org.example.flaghandler.handler;

import org.example.config.Configuration;

public class HandlerAppendFlag implements IHandleConfig{
    @Override
    public void handle(Configuration config) {

    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return  true;
        }
        if(obj == null ||
        getClass() != obj.getClass()){
            return false;
        }
        HandlerAppendFlag other = (HandlerAppendFlag)obj;
        return this.equals(other);
    }
    @Override
    public int hashCode(){
        return 3;
    }
}
