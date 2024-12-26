package org.example.config;

import org.example.flaghandler.factory.*;
import org.example.flaghandler.handler.HandlerAppendFlag;
import org.example.flaghandler.handler.HandlerFullStatisticModeFlag;
import org.example.flaghandler.handler.IHandleConfig;

import java.util.ArrayList;
import java.util.List;

public class Setting {
    public Setting(String comand){
        SettingConfiguration(GetArgyment(comand));
    }
    private void SettingConfiguration(List<IHandleConfig> list){
        for(IHandleConfig config : list){
            config.handle(Configuration.getInstance());
        }
    }
    private List<IHandleConfig> GetArgyment(String comand){
        List<IHandleConfig> list = new ArrayList<>();
        List<IFlagHandlerFactory> listFactory = new ArrayList<>();
        listFactory.add(new HandlerAppendFlagFactory());
        listFactory.add(new HandlerFullStatisticModeFlagFactory());
        listFactory.add(new HandlerInputFilesFactory());
        listFactory.add(new HandlerOutputPathFlagFactory());
        listFactory.add(new HandlerPrefixFlagFactory());
        listFactory.add(new HandlerShortStatisticModeFlagFactory());

        for(IFlagHandlerFactory factory : listFactory){
            if(factory.isMatch(comand)){
                list.add((factory.createHandler()));
            }
        }

        return list;
    }
}
