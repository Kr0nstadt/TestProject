package org.example.flaghandler.handler;

import org.example.config.Configuration;

public class HandlerFullStatisticModeFlag implements IHandleConfig{
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
        HandlerFullStatisticModeFlag other = (HandlerFullStatisticModeFlag)obj;
        return this.equals(other);
    }
    @Override
    public int hashCode(){
        return 5;
    }
}
