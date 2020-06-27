package com.galdovich.task4_1.reader;

import com.galdovich.task4_1.exception.CustomException;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArrayReader {
    private static final String DEFAULT_FILE = "resources\\ArrayResources.txt";
    private final String REGEX = " ";

    public String[] readFromFile(String file) throws CustomException {
        Path path = Paths.get(file);
        StringBuilder sb = new StringBuilder();
        if (Files.notExists(path)) {
            path = Paths.get(DEFAULT_FILE);
        }
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String stringLine = reader.readLine();
            String[] array = stringLine.split(REGEX);
            return array;
        } catch (IOException e) {
            throw new CustomException("Reading problem");
        }
    }

}
