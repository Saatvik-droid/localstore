package com.github.localstore.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Constants {
    public final static Path DATA_PATH;

    static {
        try {
            DATA_PATH = Path.of(new File(".").getCanonicalPath() + "/data/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
