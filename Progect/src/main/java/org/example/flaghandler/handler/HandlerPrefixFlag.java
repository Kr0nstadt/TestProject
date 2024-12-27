package org.example.flaghandler.handler;
import org.example.config.Configuration;

import java.nio.file.Path;

public class HandlerPrefixFlag implements IHandleConfig, IHandleWithParameters{

    @Override
    public void handle(Configuration config) {
        config.setPrefix(prefix);
    }

    @Override
    public void addParameter(String parameter) {
        prefix = parameter;
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
    private String prefix;
}
