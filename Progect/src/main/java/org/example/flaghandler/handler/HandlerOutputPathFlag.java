package org.example.flaghandler.handler;
import org.example.configFlaghander.Configuration;

import java.nio.file.Path;

public class HandlerOutputPathFlag implements IHandleConfig, IHandleWithParameters{

    @Override
    public void handle(Configuration config) {
        config.setOutputPath(path);
    }

    @Override
    public void addParameter(String parameter) {
        path = Path.of(parameter);
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
    private Path path;
}
