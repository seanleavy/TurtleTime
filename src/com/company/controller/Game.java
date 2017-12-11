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
        //set starting position and direction for the turtle
        Actor actor = new Turtle((Position) config.get("startingPosition"));
        String[] moves = ((String[]) config.get("moves"));
        actor.setPosition((Position) config.get("startingPosition"));
        System.out.println("Facing " + ((Position) config.get("startingPosition")).getDirection());

        // Loop through the moves
        for(int totalMoves = 0; totalMoves < moves.length; totalMoves++) {
            ((Turtle) actor).move(moves[totalMoves]);
            if(actor.getPosition().equals((Position) config.get("exit"))) {
                System.out.println("Success!!");
                break;
            }
            if(totalMoves == moves.length - 1)
                System.out.println("Still in danger!! Game Over");
        }
    }
}
