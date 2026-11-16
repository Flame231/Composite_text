package org.example.reader.impl;

import org.example.reader.TextReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomTextTextReader implements TextReader {

    @Override
    public String read(Path path) throws IOException {
       return Files.readString(path, StandardCharsets.UTF_8);
    }
}
