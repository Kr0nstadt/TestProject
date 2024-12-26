package org.example.flaghandler.handler;

import java.io.File;
import java.util.List;
import org.example.config.Configuration;

public class HandlerInputFiles implements IHandleConfig, IHandleWithParameters{
    
    @Override
    public void handle(Configuration config) {
        for(File file : files){
            config.addInputFile(file);
        }
    }

    @Override
    public void addParameter(String parameter) {
        String[] parts = parameter.split(" ");
        for (String part : parts) {
            if (part.endsWith(".txt")) {
                files.add(new File(part));
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
