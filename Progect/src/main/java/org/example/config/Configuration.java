package org.example.config;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Configuration {
    public static Configuration getInstance(){
        if(instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public void setOutputPath(Path path){
        this.outputPath = path;
    }
    public Path getOutputPath(){
        return outputPath;
    }

    public void setPrefix(String prefix){
        this.prefix = prefix;
    }
    public String getPrefix(){
        return prefix;
    }

    public void setIsAppend(Boolean append){
        this.append = append;
    }
    public Boolean isAppend(){
        return  append;
    }

    public void setStatisticMode(StatisticMode mode){
        statisticMode = mode;
    }
    public StatisticMode getStatisticMode(){
        return  statisticMode;
    }

    public void addInputFile(File inputFile){
        inputFiles.add(inputFile);
    }
    public List<File> getInputFiles(){
        return inputFiles;
    }

    private Configuration(){
        prefix = "";
        append = true;
        statisticMode = StatisticMode.None;
        inputFiles = new ArrayList<>();
        outputPath = null;
    }
    private Path outputPath;
    private String prefix;
    private Boolean append;
    private StatisticMode statisticMode;
    private List<File> inputFiles;
    private static Configuration instance;
}
