package org.example.collect;

import org.example.config.Configuration;
import org.example.separator.Separator;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectOutFile {
    public CollectOutFile(){
        Configuration configuration = Configuration.getInstance();
        Separator separator = new Separator(ReadFile(configuration.getInputFiles()));

        if(!separator.GetDouble().isEmpty()){
            MakeFile(separator.GetDouble().stream()
                    .map(String::valueOf)
                    .collect(Collectors.toList()), "float.txt");
        }
        if(!separator.GetLong().isEmpty())
        {
            MakeFile(separator.GetLong().stream()
                    .map(String::valueOf)
                    .collect(Collectors.toList()), "integer.txt");
        }
        if(!separator.GetString().isEmpty())
        {
            MakeFile(separator.GetString(), "string.txt");
        }
    }
    public static   List<String> ReadFile(List<File> files){
        List<String> allLines = new ArrayList<>();
        for (File file : files) {
            try {
                allLines.addAll(readLinesFromFile(file));
            } catch (IOException e) {
                String txt = new String("Ошибка при чтении файла: ".getBytes(Charset.defaultCharset()));
                System.err.println(txt + file.getName());
            }
        }
        return allLines;
    }
    private static List<String> readLinesFromFile(File file) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
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
