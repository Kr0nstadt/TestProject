package org.example.flaghandler.handler;
import org.example.config.Configuration;
public class HandlerOutputPathFlag implements IHandleConfig, IHandleWithParameters{

    @Override
    public void handle(Configuration config) {

    }

    @Override
    public void addParameter(String parameter) {

    }@Override
    public boolean equals(Object obj){
        if(this == obj){
            return  true;
        }
        if(obj == null ||
                getClass() != obj.getClass()){
            return false;
        }
        HandlerOutputPathFlag other = (HandlerOutputPathFlag)obj;
        return this.equals(other);
    }
    @Override
    public int hashCode(){
        return 11;
    }

}
