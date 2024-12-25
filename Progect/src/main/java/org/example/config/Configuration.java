package org.example.config;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class Configuration {
    private Path outputPath;
    private String prefix;
    private Boolean append;
    private StatisticMode statisticMode;
    private List<File> inputFiles;
    private Configuration instance;
}
