package com.company.interfaces;

import com.company.enums.Direction;

public interface Position<X, Y> {
    public X getX();
    public Y getY();
    public Direction getDirection();
    public void setX(X x);
    public void setY(Y y);
    public void setDirection(Direction d);
}
