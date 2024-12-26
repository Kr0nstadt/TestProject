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
        String[] paramArray = parameter.split(" ");
        for(int i = 0; i < paramArray.length; i++){
            if(paramArray[i] == "-p"){
                prefix = paramArray[i + 1];
            }
        }
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
