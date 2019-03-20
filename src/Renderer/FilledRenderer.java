/**
 * @file FilledRenderer.java
 * @author Page Didier & Stalder Nicodème
 * @date 12.03.19
 */

package Renderer;

import java.awt.*;

import Bouncer.Bouncable;

/**
 * Singleton qui gère le rendu de forme pleine
 */
public class FilledRenderer extends BouncerRenderer {
    private static FilledRenderer instance;

    private FilledRenderer() {

    }

    public static FilledRenderer getInstance(){
        if(instance == null){
            instance = new FilledRenderer();
        }
        return instance;
    }

    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.fill( b.getShape());
    }


}
