package com.example.composite.reader;

import java.nio.file.Path;

public interface TextReader {
    String read(Path path);
}
