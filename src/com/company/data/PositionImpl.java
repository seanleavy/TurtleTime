package com.company.data;

import com.company.enums.Direction;
import com.company.interfaces.Position;

/**
 * PositionImpl data structure to store pairs
 */
public class PositionImpl<X, Y> implements Position {
    private int x;
    private int y;
    private Direction direction = Direction.randomDirection();

    public PositionImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PositionImpl(int x, int y, Direction direction) {
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
    public void setX(int o) {
        this.x = this.x + o;
    }

    @Override
    public void setY(int o) {
        this.y = this.y + o;
    }

    @Override
    public void setDirection(Direction d) {
        this.direction = d;
    }


    //need to overrride to check the winning position
    @Override
    public boolean equals(Object obj) {
        if(this.x == ((PositionImpl)obj).x && this.y == ((PositionImpl)obj).y)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
