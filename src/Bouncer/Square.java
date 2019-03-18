package Bouncer;

import java.awt.*;

public abstract class Square extends Bouncer {
    public Square(int maxPosX, int maxPosY,int maxSize){

        super(maxPosX,maxPosY,maxSize);
    }
    @Override
    public Shape getShape() {
        return new Rectangle(getPositionX(),getPositionY(),getWidth(),getHeigth());
    }
}
