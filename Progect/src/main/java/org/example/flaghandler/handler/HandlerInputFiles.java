package org.example.flaghandler.handler;

import java.io.File;
import java.util.List;
import org.example.config.Configuration;

public class HandlerInputFiles implements IHandleConfig, IHandleWithParameters{
    public HandlerInputFiles(String flag){

    }
    @Override
    public void handle(Configuration config) {

    }

    @Override
    public void addParameter(String parameter) {

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
        HandlerInputFiles other = (HandlerInputFiles)obj;
        return this.equals(other);
    }
    @Override
    public int hashCode(){
        return 7;
    }
    private List<File> files;
}
