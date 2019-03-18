package Bouncer;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public abstract class Circle extends Bouncer{
    public Circle(int maxPosX, int maxPosY,int maxSize){
        super(maxPosX,maxPosY,maxSize);
    }
    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(getPositionX(),getPositionY(),getWidth(),getHeigth());
    }
}
