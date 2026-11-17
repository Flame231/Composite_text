package com.example.composite.reader.impl;

import com.example.composite.exception.FileException;
import com.example.composite.reader.TextReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomTextTextReader implements TextReader {

    @Override
    public String read(Path path) {
        try {
            return Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new FileException("Cannot read file!", e);
        }
    }
}
