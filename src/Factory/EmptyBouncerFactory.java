/**
 * @file EmptyBouncerFactory.java
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
public class EmptyBouncerFactory extends BouncerFactory {

    private static EmptyBouncerFactory instance;

    // Rend le constructeur privé
    private EmptyBouncerFactory(){}

    // Fonction qui fait office de constructeur
    public static EmptyBouncerFactory getInstance(){
        if(instance == null){
            instance = new EmptyBouncerFactory();
        }
        return instance;
    }


    @Override
    public Circle createCircle(int maxPosX, int maxPosY, int maxSize) {

        // On redéfini ce qu'est un cercle dans cette factory
        return new Circle(maxPosX,maxPosY,maxSize) {
            @Override
            public Renderable getRenderer() {
                // Comme on constuit des forme vide, on utilise le render de forme vide
                return EmptyRenderer.getInstance();
            }

            @Override
            public Color getColor() {
                return Color.GREEN;
            }
        };
    }

    @Override
    public Square createSquare(int maxPosX, int maxPosY, int maxSize) {
        return new Square(maxPosX,maxPosY,maxSize) {
            @Override
            public Renderable getRenderer() {
                return EmptyRenderer.getInstance();
            }

            @Override
            public Color getColor() {
                return Color.RED;
            }
        };

    }
}
