package com.anatolii;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public List<String> readFileToList(String path) {
        List<String> parseFileToLines = new ArrayList<>();
        if (isValidPath(path)) {
            try (Stream<String> stream = Files.lines(Paths.get(path))) {
                parseFileToLines = stream.collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("File not found!");
        }
        if(parseFileToLines.isEmpty()){
            throw new IllegalArgumentException("File is empty!");
        }
        return parseFileToLines;
    }

    private boolean isValidPath(String path) {
        if(path == null){
            return false;
        }
        File fileChecker = new File(path);
        return fileChecker.exists() && fileChecker.isFile();
    }
}
