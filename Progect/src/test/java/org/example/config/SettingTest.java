package org.example.config;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class SettingTest {
    @Test
    public void SettingTestVanila(){
        Setting setting = new Setting("");

        assertEquals(Configuration.getInstance().getPrefix(),"");
        assertEquals(Configuration.getInstance().isAppend(),true);
        assertEquals(Configuration.getInstance().getStatisticMode(),StatisticMode.None);
    }
    @Test
    public void SettingTest1(){
        Setting setting = new Setting("java -jar util.jar -s -a -p sample- in1.txt in2.txt");

        assertEquals(Configuration.getInstance().isAppend(),false);
        assertEquals(Configuration.getInstance().getStatisticMode(),StatisticMode.ShortMode);
        assertEquals(Configuration.getInstance().getPrefix(),"sample-");
        assertEquals(Configuration.getInstance().getOutputPath(),null);
        //assertTrue(Configuration.getInstance().getInputFiles().contains(new File("in1.txt")));
        //assertTrue(Configuration.getInstance().getInputFiles().contains(new File("in2.txt")));
    }
}