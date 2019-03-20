/**
 * @file Circle.java
 * @author Page Didier & Stalder Nicodème
 * @date 12.03.19
 */
package Bouncer;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Le Cercle hérite de Bouncer et redéfini juste la shape de swing pour l'affichage
 */
public abstract class Circle extends Bouncer{
    public Circle(int maxPosX, int maxPosY,int maxSize){
        super(maxPosX,maxPosY,maxSize);
    }
    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(getPositionX(),getPositionY(),getWidth(),getHeigth());
    }
}
