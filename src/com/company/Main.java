package com.company;

import com.company.controller.Game;
import com.company.dataStructures.GameConfigImpl;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap config = new GameConfigImpl().getConfig();
        new Game(config);
    }
}
