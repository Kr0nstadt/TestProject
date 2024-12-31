package org.example.configFlaghander;

import org.example.config.Configuration;
import org.example.config.StatisticMode;
import org.example.flaghandler.factory.*;
import org.example.flaghandler.handler.*;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationTest {
    Configuration configuration = Configuration.getInstance();
    @Test
    public void ConfigurationAppendTest(){
        String flag = "-a";
        HandlerAppendFlagFactory factory = new HandlerAppendFlagFactory();
        HandlerAppendFlag handler = (HandlerAppendFlag)factory.createHandler();
        handler.handle(configuration);

        assertFalse(configuration.isAppend());
        assertTrue(factory.isMatch(flag));
    }
    @Test
    public void ConfigurationFullStatisticModeTest(){
        String flag = "-f";
        HandlerFullStatisticModeFlagFactory factory = new HandlerFullStatisticModeFlagFactory();
        HandlerFullStatisticModeFlag handler = (HandlerFullStatisticModeFlag)factory.createHandler();

        assertEquals(configuration.getStatisticMode(), StatisticMode.None);
        handler.handle(configuration);
        assertEquals(configuration.getStatisticMode(),StatisticMode.FullMode);
        assertTrue(factory.isMatch(flag));
    }
    @Test
    public void ConfigurationInputFilesTest(){
        String flag = "";
        HandlerInputFilesFactory factory = new HandlerInputFilesFactory();
        HandlerInputFiles handler = (HandlerInputFiles)factory.createHandler();

        handler.addParameter("in1.txt");
        handler.handle(configuration);
        int lengthBef = configuration.getInputFiles().size();
        handler.addParameter("in2.txt");
        handler.handle(configuration);
        assertNotEquals(configuration.getInputFiles().size(),lengthBef);

        var thrown = assertThrows(RuntimeException.class, () -> handler.addParameter("file"));
        assertEquals(thrown.getMessage(), "File file not found");
        assertTrue(factory.isMatch(flag));
    }
    @Test
    public void ConfigurationOutputPathTest(){
        String flag = "-o";
        HandlerOutputPathFlagFactory factory = new HandlerOutputPathFlagFactory();
        HandlerOutputPathFlag handler = (HandlerOutputPathFlag)factory.createHandler();
        handler.handle(configuration);

        assertNull(configuration.getOutputPath());

        handler.addParameter("/sksa/nsfa");
        handler.handle(configuration);

        assertEquals(configuration.getOutputPath(),Path.of("/sksa/nsfa"));
        assertTrue(factory.isMatch(flag));
    }
    @Test
    public void ConfigurationPrefixTest(){
        String flag = "-p";
        HandlerPrefixFlagFactory factory = new HandlerPrefixFlagFactory();
        HandlerPrefixFlag handler = (HandlerPrefixFlag)factory.createHandler();
        handler.handle(configuration);

        assertNull(configuration.getPrefix());

        handler.addParameter("prefix");
        handler.handle(configuration);
        assertEquals(configuration.getPrefix(),"prefix");
        assertTrue(factory.isMatch(flag));
    }
    @Test
    public void ConfigurationShortStatisticModeTest(){
        String flag = "-s";
        HandlerShortStatisticModeFlagFactory factory = new HandlerShortStatisticModeFlagFactory();
        HandlerShortStatisticModeFlag handler = (HandlerShortStatisticModeFlag)factory.createHandler();

        assertEquals(configuration.getStatisticMode(), StatisticMode.None);
        handler.handle(configuration);
        assertEquals(configuration.getStatisticMode(),StatisticMode.ShortMode);
        assertTrue(factory.isMatch(flag));
    }
}