package org.example.reader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface TextReader {
    String read(Path path) throws IOException;
}
