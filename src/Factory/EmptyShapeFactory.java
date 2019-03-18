package Factory;

import java.awt.*;

import Bouncer.*;
import Renderer.*;


public class EmptyShapeFactory extends ShapeFactory {
    private static EmptyShapeFactory instance;

    private EmptyShapeFactory(){}


    public static EmptyShapeFactory getInstance(){
        if(instance == null){
            instance = new EmptyShapeFactory();
        }
        return instance;
    }


    @Override
    public Circle createCircle(int maxPosX, int maxPosY, int maxSize) {
        return new Circle(maxPosX,maxPosY,maxSize) {
            @Override
            public Renderable getRenderer() {

                return EmptyShapeRenderer.getInstance();
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

                return EmptyShapeRenderer.getInstance();
            }

            @Override
            public Color getColor() {
                return Color.RED;
            }
        };

    }
}
