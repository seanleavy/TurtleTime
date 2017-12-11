package com.company.data;

import com.company.enums.Direction;
import com.company.interfaces.Position;

/**
 * PositionImpl data structure to store pairs
 */
public class PositionImpl<X, Y> implements Position {
    private X x;
    private Y y;
    private Direction direction = Direction.randomDirection();

    public PositionImpl(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public PositionImpl(X x, Y y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public Object getX() {
        return this.x;
    }

    @Override
    public Object getY() {
        return this.y;
    }

    // Return the direction that the Actor is facing
    @Override
    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public void setX(Object o) {
        this.x = (X)o;
    }

    @Override
    public void setY(Object o) {
        this.y = (Y)o;
    }

    @Override
    public void setDirection(Direction d) {
        this.direction = d;
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
