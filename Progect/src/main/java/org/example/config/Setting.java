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
        HandlerAppendFlagFactory handlerAppendFlagFactory = new HandlerAppendFlagFactory();
        HandlerFullStatisticModeFlagFactory handlerFullStatisticModeFlagFactory = new HandlerFullStatisticModeFlagFactory();
        HandlerInputFilesFactory handlerInputFilesFactory = new HandlerInputFilesFactory();
        HandlerOutputPathFlagFactory handlerOutputPathFlagFactory = new HandlerOutputPathFlagFactory();
        HandlerPrefixFlagFactory handlerPrefixFlagFactory = new HandlerPrefixFlagFactory();
        HandlerShortStatisticModeFlagFactory handlerShortStatisticModeFlagFactory = new HandlerShortStatisticModeFlagFactory();

        if(handlerAppendFlagFactory.isMatch(comand)){
            list.add(handlerAppendFlagFactory.createHandler());
        }
        if(handlerFullStatisticModeFlagFactory.isMatch(comand)){
            list.add(handlerFullStatisticModeFlagFactory.createHandler());
        }
        if(handlerInputFilesFactory.isMatch(comand)){
            list.add(handlerInputFilesFactory.createHandler());
        }
        if(handlerOutputPathFlagFactory.isMatch(comand)){
            list.add(handlerOutputPathFlagFactory.createHandler());
        }
        if(handlerPrefixFlagFactory.isMatch(comand)){
            list.add(handlerPrefixFlagFactory.createHandler());
        }
        if(handlerShortStatisticModeFlagFactory.isMatch(comand)){
            list.add(handlerShortStatisticModeFlagFactory.createHandler());
        }

        return list;
    }
}
