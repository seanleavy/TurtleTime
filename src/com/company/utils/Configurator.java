package com.company.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configurator {

    public static final String gameSettingsFile = "C:\\Users\\sean\\IdeaProjects\\Turtle\\src\\com\\company\\gameSettings.properties";
    public static final String moves = "C:\\Users\\sean\\IdeaProjects\\Turtle\\src\\com\\company\\moves.properties";

    public static Properties readConfigFile(String file) {
        try {
            InputStream propfileInput = new FileInputStream(file);
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
