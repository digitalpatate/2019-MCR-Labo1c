/**
 * @file Bouncer.java
 * @author Page Didier & Stalder Nicodème
 * @date 12.03.19
 */

package Bouncer;

import Displayer.BouncerDisplayer;

import java.awt.*;
import java.util.Random;

public abstract class Bouncer implements Bouncable {

    private int width;
    private int height;

    private Point position;
    private Point velocityPoint;

    // Constructeur
    public Bouncer(int maxPosX, int maxPosY, int maxSize) {

        Random random = new Random();

        // Générale la taile, la position et la direction de mouvement de mankère aléatoire
        this.width =  random.nextInt(maxSize);
        this.height =  this.width;

        this.position = new Point(random.nextInt(maxPosX),random.nextInt(maxPosY));
        this.velocityPoint = new Point(random.nextInt(11)-5,random.nextInt(11)-5);
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
    @Override
    public void draw() {
        getRenderer().display(BouncerDisplayer.getInstance().getGraphics(), this);
    }

    @Override
    public void move() {

        // Si la forme touche le bord gauche
        if (position.x < 0) {
            velocityPoint.x=Math.abs(velocityPoint.x);
        }

        // Si la forme touche le bord droit
        if(position.x > BouncerDisplayer.getInstance().getWidth()-width){
            velocityPoint.x=-Math.abs(velocityPoint.x);
        }

        //Si la forme touche le haut
        if(position.y < 0) {
            velocityPoint.y=Math.abs(velocityPoint.y);
        }

        //Si la forme touche le bas
        if ( position.y > BouncerDisplayer.getInstance().getHeight()-height){
            velocityPoint.y=-Math.abs(velocityPoint.y);

        }

        // Mets à jour la position
        position.x += velocityPoint.x;
        position.y += velocityPoint.y;
    }

}
