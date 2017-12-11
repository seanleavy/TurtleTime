package com.company.interfaces;

import com.company.enums.Direction;

public interface Position<X, Y> {
    public X getX();
    public Y getY();
    public Direction getDirection();
    public void setX(int x);
    public void setY(int y);
    public void setDirection(Direction d);
}
