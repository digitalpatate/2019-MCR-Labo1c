/**
 * @file Square.java
 * @author Page Didier & Stalder Nicodème
 * @date 12.03.19
 */
package Bouncer;

import java.awt.*;
/**
 * Le Carré hérite de Bouncer et redéfini juste la shape de swing pour l'affichage
 */
public abstract class Square extends Bouncer {
    public Square(int maxPosX, int maxPosY,int maxSize){

        super(maxPosX,maxPosY,maxSize);
    }
    @Override
    public Shape getShape() {
        return new Rectangle(getPositionX(),getPositionY(),getWidth(),getHeigth());
    }
}
