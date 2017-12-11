package com.company.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Configurator {

    public static final String gameSettingsFile = "gameSettings.properties";
    public static final String moves = "moves.properties";

    public static Properties readConfigFile(String file) {
        try {
            Path path = Paths.get(file).toAbsolutePath();
            InputStream propfileInput = new FileInputStream(path.toString());
            Properties prop = new Properties();
            prop.load(propfileInput);
            return prop;
        }
        catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
