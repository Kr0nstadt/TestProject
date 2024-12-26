package org.example.flaghandler.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.example.config.Configuration;

public class HandlerInputFiles implements IHandleConfig, IHandleWithParameters{
    
    @Override
    public void handle(Configuration config) {
        addParameter(config.getCommand());
        for(File file : files){
            config.addInputFile(file);
        }
    }

    @Override
    public void addParameter(String parameter) {
        String[] parts = parameter.split(" ");
        for (String part : parts) {
            File temp = new File(part);
            if(temp.exists()){
                files.add(temp);
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
    private List<File> files;
}
