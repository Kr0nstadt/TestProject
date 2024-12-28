package org.example.collect;

import org.example.config.Configuration;
import org.example.flaghandler.factory.*;
import org.example.flaghandler.handler.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            //TODO: Основной алгоритм
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
