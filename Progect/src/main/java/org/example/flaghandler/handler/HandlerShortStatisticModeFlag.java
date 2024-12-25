package org.example.flaghandler.handler;

import org.example.config.Configuration;
public class HandlerShortStatisticModeFlag implements IHandleConfig{
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
        HandlerShortStatisticModeFlag other = (HandlerShortStatisticModeFlag)obj;
        return this.equals(other);
    }
    @Override
    public int hashCode(){
        return 17;
    }
}
