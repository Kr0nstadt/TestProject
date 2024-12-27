package org.example.flaghandler.handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        File temp = new File(parameter);
        if(temp.exists()){
            files.add(temp);
        }
        else {
            throw new RuntimeException(String.format("File %s not found", parameter));
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
    private List<File> files = new ArrayList<>();
}
