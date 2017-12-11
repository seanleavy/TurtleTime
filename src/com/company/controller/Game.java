package com.company.controller;

import com.company.enums.Direction;
import com.company.interfaces.Actor;
import com.company.interfaces.Position;
import com.company.models.Turtle;

import java.util.HashMap;

public class Game {

    private HashMap config;

    public Game(HashMap gameConfig) {
        this.config = gameConfig;
        gameLoop(config);
    }


    private void gameLoop(HashMap config) {
        Actor actor = new Turtle((Position) config.get("startingPosition"));
        //set starting position and direction for the turtle
        ((Position)(actor.getPosition())).setX(config.get("startX"));
        ((Position)(actor.getPosition())).setY(config.get("startY"));
        ((Position)(actor.getPosition())).setDirection((Direction) config.get("direction"));

        String[] moves = ((String[]) config.get("moves"));
        int totalMoves = moves.length;
        actor.setPosition((Position) config.get("startingPosition"));

        // Loop through the moves
        while(totalMoves != moves.length) {
            ((Turtle) actor).move(moves[totalMoves]);
            if(actor.getPosition() == (Position) config.get("exit"))
                System.out.println("Success!!");
            totalMoves ++;
            if(totalMoves > moves.length)
                System.out.println("Still in danger!! Game Over");
        }
    }
}
