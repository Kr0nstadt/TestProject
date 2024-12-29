package org.example.collect;

import org.example.configFlaghander.Configuration;
import org.example.separator.Separator;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class CollectOutFile {
    public CollectOutFile(){
        Configuration configuration = Configuration.getInstance();
        Separator separator = new Separator(configuration.getInputFiles()
                .stream().map(File::getAbsolutePath)
                .collect(Collectors.toList()));

        MakeFile(separator.GetDouble().stream()
                .map(String::valueOf)
                .collect(Collectors.toList()), "float.txt");
        MakeFile(separator.GetLong().stream()
                .map(String::valueOf)
                .collect(Collectors.toList()), "integer.txt");
        MakeFile(separator.GetString(),"string.txt");
    }
    private void MakeFile(List<String> array, String valueType){
        try{
            Configuration configuration = Configuration.getInstance();
            String nameFile = configuration.getPrefix() + valueType;
            Path filePath = configuration.getOutputPath().resolve(nameFile);
            File file = new File(filePath.toUri());
            if(!file.exists()){
                Files.write(filePath, array, StandardOpenOption.CREATE);
            }
            if (configuration.isAppend()) {
                Files.write(filePath, array, StandardOpenOption.TRUNCATE_EXISTING);
            } else {
                Files.write(filePath, array, StandardOpenOption.APPEND);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
