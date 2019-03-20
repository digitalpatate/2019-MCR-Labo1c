/**
 * @file FilledBouncerFactory.java
 * @author Page Didier & Stalder Nicodème
 * @date 12.03.19
 */
package Factory;

import java.awt.*;

import Bouncer.*;
import Renderer.*;

/**
 * Dans le cours, c'est dit qu'habituellement une seule instance d’une fabrique concrète est créée.
 * Donc, on a implementé la fabrique concrète comme un sigleton
 */
public class FilledBouncerFactory extends BouncerFactory {

    private static FilledBouncerFactory instance;

    // Rend le constructeur privé
    private FilledBouncerFactory(){}


    public static FilledBouncerFactory getInstance(){
        if(instance == null){
            instance = new FilledBouncerFactory();
        }
        return instance;
    }


    @Override
    public Circle createCircle(int maxPosX, int maxPosY, int maxSize) {
        return new Circle(maxPosX,maxPosY,maxSize) {
            @Override
            public Renderable getRenderer() {
                // on créer des formes pleines dans cet factory, donc on renvoie le renderer de forme pleine
                return FilledRenderer.getInstance();
            }

            @Override
            public Color getColor() {

                return Color.BLUE;
            }
        };
    }

    @Override
    public Square createSquare(int maxPosX, int maxPosY, int maxSize) {
        return new Square(maxPosX,maxPosY,maxSize) {
            @Override
            public Renderable getRenderer() {

                return FilledRenderer.getInstance();
            }

            @Override
            public Color getColor() {

                return Color.ORANGE;
            }
        };

    }
}
