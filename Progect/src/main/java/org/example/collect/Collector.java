package org.example.collect;

import org.example.configFlaghander.Configuration;
import org.example.configFlaghander.StatisticMode;
import org.example.flaghandler.factory.*;
import org.example.flaghandler.handler.*;
import org.example.separator.Separator;
import org.example.statistic.FullStatisticDouble;
import org.example.statistic.FullStatisticLong;
import org.example.statistic.FullStatisticString;
import org.example.statistic.ShortStatistic;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Collector {
    public Collector(String[] args){
        listFactory = new ArrayList<>();
        listFactory.add(new HandlerAppendFlagFactory());
        listFactory.add(new HandlerFullStatisticModeFlagFactory());
        listFactory.add(new HandlerOutputPathFlagFactory());
        listFactory.add(new HandlerPrefixFlagFactory());
        listFactory.add(new HandlerShortStatisticModeFlagFactory());
        listFactory.add(new HandlerInputFilesFactory());

        try {
            Configuration configuration = Configuration.getInstance();
            Set<IHandleConfig> handlers = getHandlers(listFactory, args);
            for(IHandleConfig handler : handlers) {
                handler.handle(configuration);
            }
            CollectOutFile collectOutFile = new CollectOutFile();
            System.out.println(MakeStatistic());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private String MakeStatistic(){
        String res = "";
        Configuration configuration = Configuration.getInstance();
        Separator separator = new Separator(CollectOutFile.ReadFile(configuration.getInputFiles()));
        if(configuration.getStatisticMode() == StatisticMode.None){
            res = "Вид статистики не выбран";
        }
        if(configuration.getStatisticMode() == StatisticMode.ShortMode){
            ShortStatistic statistic = new ShortStatistic(separator);
            res = statistic.statistic();
        }
        if(configuration.getStatisticMode() == StatisticMode.FullMode){
            FullStatisticLong statisticLong = new FullStatisticLong(separator);
            FullStatisticString statisticString = new FullStatisticString(separator);
            FullStatisticDouble statisticDouble = new FullStatisticDouble(separator);

            res = statisticDouble.statistic() +
                    statisticLong.statistic() +
                    statisticString.statistic();
        }
        return res;
    }
    private Set<IHandleConfig> getHandlers(List<IFlagHandlerFactory> factories, String[] args) {
        boolean isReadParameter = false;
        boolean isStatisticOn = false;
        Set<IHandleConfig> handlers = new HashSet<>();
        IHandleWithParameters currentHandlerWithParameters = null;

        for(String arg : args) {
            if(isReadParameter) {
                if(!(currentHandlerWithParameters instanceof HandlerInputFiles)) {
                    isReadParameter = false;
                }
                currentHandlerWithParameters.addParameter(arg);
            }
            else {
                IHandleConfig currentHandler = factories.stream()
                        .filter(factory -> factory.isMatch(arg))
                        .findFirst()
                        .orElseThrow()
                        .createHandler();

                if(currentHandler instanceof IHandleWithParameters handlerWithParameters) {
                    currentHandlerWithParameters = handlerWithParameters;
                    isReadParameter = true;
                }

                if(currentHandlerWithParameters instanceof HandlerInputFiles) {
                    currentHandlerWithParameters.addParameter(arg);
                }

                if(handlers.contains(currentHandler)) {
                    throw new IllegalArgumentException("Duplicate flag " + arg);
                }
                if(currentHandler instanceof HandlerFullStatisticModeFlag ||
                        currentHandler instanceof HandlerShortStatisticModeFlag){
                    if(isStatisticOn) {
                        throw new IllegalArgumentException("Duplicate statistic mode " + arg);
                    }
                    else {
                        isStatisticOn = true;
                    }

                }
                handlers.add(currentHandler);

            }
        }

        return handlers;
    }
    private List<IFlagHandlerFactory> listFactory;
}
