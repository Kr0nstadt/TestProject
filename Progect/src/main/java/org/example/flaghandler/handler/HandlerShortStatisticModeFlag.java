package org.example.flaghandler.handler;

import org.example.configFlaghander.Configuration;
import org.example.configFlaghander.StatisticMode;

public class HandlerShortStatisticModeFlag implements IHandleConfig{
    @Override
    public void handle(Configuration config) {
        config.setStatisticMode(StatisticMode.ShortMode);
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
