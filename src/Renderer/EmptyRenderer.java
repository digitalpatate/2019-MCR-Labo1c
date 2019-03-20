/**
 * @file EmptyRenderer.java
 * @author Page Didier & Stalder Nicodème
 * @date 12.03.19
 */
package Renderer;

import java.awt.*;

import Bouncer.Bouncable;


/**
 * Singleton qui gère le rendu de forme vide avec un bordure
 */
public class EmptyRenderer extends BouncerRenderer {

    private static EmptyRenderer instance;

    private EmptyRenderer() {

    }


    public static EmptyRenderer getInstance(){
        if(instance == null){
            instance = new EmptyRenderer();
        }
        return instance;
    }
    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.setStroke(new BasicStroke(2));
        g.draw(b.getShape());
    }
}
