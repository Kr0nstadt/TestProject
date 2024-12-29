package org.example.collect;

import org.example.flaghandler.factory.*;
import org.example.flaghandler.handler.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CollectorTest {
    @Test
    void testGetHandlers() {
        List<IFlagHandlerFactory> listFactory = new ArrayList<>();
        listFactory.add(new HandlerAppendFlagFactory());
        listFactory.add(new HandlerFullStatisticModeFlagFactory());
        listFactory.add(new HandlerOutputPathFlagFactory());
        listFactory.add(new HandlerPrefixFlagFactory());
        listFactory.add(new HandlerShortStatisticModeFlagFactory());
        listFactory.add(new HandlerInputFilesFactory());

        String[] args = {
                "-s", "-a", "-p", "sample-", "in1.txt",  "in2.txt"
        };

        Set<IHandleConfig> expected = new HashSet<>();
        expected.add(new HandlerAppendFlag());
        expected.add(new HandlerShortStatisticModeFlag());
        HandlerPrefixFlag handlerPrefixFlag = new HandlerPrefixFlag();
        handlerPrefixFlag.addParameter("sample-");
        expected.add(handlerPrefixFlag);

        HandlerInputFiles handlerInputFiles = new HandlerInputFiles();
        assertDoesNotThrow(() -> handlerInputFiles.addParameter("in1.txt"));
        assertDoesNotThrow(() -> handlerInputFiles.addParameter("in2.txt"));
        expected.add(handlerInputFiles);

        Set<IHandleConfig> handlers = getHandlers(listFactory, args);

        assertEquals(expected, handlers);
    }

    @Test
    void testGetHandlersWithDuplicateFlag() {
        List<IFlagHandlerFactory> listFactory = new ArrayList<>();
        listFactory.add(new HandlerAppendFlagFactory());
        listFactory.add(new HandlerFullStatisticModeFlagFactory());
        listFactory.add(new HandlerOutputPathFlagFactory());
        listFactory.add(new HandlerPrefixFlagFactory());
        listFactory.add(new HandlerShortStatisticModeFlagFactory());
        listFactory.add(new HandlerInputFilesFactory());

        String[] args = {
                "-s", "-a", "-a", "-p", "sample-", "in1.txt",  "in2.txt"
        };


        var thrown = assertThrows(IllegalArgumentException.class, () -> getHandlers(listFactory, args));

        assertEquals(thrown.getMessage(), "Duplicate flag -a");
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
}