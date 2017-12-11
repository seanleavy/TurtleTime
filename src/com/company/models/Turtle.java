package com.company.models;

import com.company.data.PositionImpl;
import com.company.interfaces.Actor;
import com.company.interfaces.Position;
import com.company.interfaces.Move;
import com.company.interfaces.Rotate;

public class Turtle implements Actor, Move, Rotate {

    private Position position;

    public Turtle(Position position) {
        this.position = position;
    }

    @Override
    public void move(String move) {

        switch (move) {
            case "move":
                switch (position.getDirection()) {
                    case NORTH:
                        position.setY(1);
                        System.out.println("Moved North one step");
                        break;
                    case SOUTH:
                        position.setY(-1);
                        System.out.println("Moved South one step");
                        break;
                    case EAST:
                        position.setX(1);
                        System.out.println("Moved East one step");
                        break;
                    case WEST:
                        position.setX(-1);
                        System.out.println("Moved West one step");
                        break;
                }
                System.out.println("Position: " + position.getX() + "," + position.getY());
                break;
            case "rotateRight":
                rotateClockwise();
                System.out.println("Rotated!. Now facing " + ((PositionImpl) this.getPosition()).getDirection());
                break;
            case "rotateLeft":
                rotateAntiClockwise();
                System.out.println("Rotated! Now facing " + ((PositionImpl) this.getPosition()).getDirection());
                break;
        }
    }

    @Override
    public void rotateClockwise() {
        this.position.setDirection(position.getDirection().rotateRight());
    }

    @Override
    public void rotateAntiClockwise() {
        this.position.setDirection(position.getDirection().rotateLeft());
    }

    @Override
    public Object getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }
}
