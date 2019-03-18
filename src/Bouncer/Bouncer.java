package Bouncer;

import Displayer.BouncerDisplayer;

import java.awt.*;
import java.util.Random;

public abstract class Bouncer implements Bouncable {

    private int width;
    private int height;

    private Point position;
    private Point velocityPoint;
    public Bouncer(int maxPosX, int maxPosY, int maxSize) {

        Random random = new Random();

        this.width =  random.nextInt(maxSize);
        this.height =  this.width;

        this.position = new Point(random.nextInt(maxPosX),random.nextInt(maxPosY));
        this.velocityPoint = new Point(random.nextInt(11)-5,random.nextInt(11)-5);
    }

    @Override
    public void draw() {
        getRenderer().display(BouncerDisplayer.getInstance().getGraphics(), this);
    }

    @Override
    public void move() {
        if (position.x < 0) {
            velocityPoint.x=Math.abs(velocityPoint.x);
        }
        if(position.x > BouncerDisplayer.getInstance().getWidth()-width){
            velocityPoint.x=-Math.abs(velocityPoint.x);
        }

        if(position.y < 0) {
            velocityPoint.y=Math.abs(velocityPoint.y);
        }
        if ( position.y > BouncerDisplayer.getInstance().getHeight()-height){
            velocityPoint.y=-Math.abs(velocityPoint.y);

        }
        position.x += velocityPoint.x;
        position.y += velocityPoint.y;
    }

    @Override
    public Color getColor() {
        return null;
    }

    public int getPositionX() {
        return position.x;
    }

    public int getPositionY() {
        return position.y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return height;
    }
}
