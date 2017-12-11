package com.company.enums;

import java.util.Random;

public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    private static Random rnd = new Random();

    // Face a random direction each call
    static public Direction randomDirection() {
        return Direction.values()[rnd.nextInt(4)];
    }

    public Direction rotateLeft() {
        return values()[(ordinal() - 1) % 4];
    }

    public Direction rotateRight() {
        return values()[(ordinal() + 1) % 4];
    }
}
