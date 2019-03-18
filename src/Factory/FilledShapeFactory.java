package Factory;

import java.awt.*;

import Bouncer.*;
import Renderer.*;


public class FilledShapeFactory extends ShapeFactory {
    private static FilledShapeFactory instance;


    private FilledShapeFactory(){}


    public static FilledShapeFactory getInstance(){
        if(instance == null){
            instance = new FilledShapeFactory();
        }
        return instance;
    }


    @Override
    public Circle createCircle(int maxPosX, int maxPosY, int maxSize) {
        return new Circle(maxPosX,maxPosY,maxSize) {
            @Override
            public Renderable getRenderer() {

                return FilledShapeRenderer.getInstance();
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

                return FilledShapeRenderer.getInstance();
            }

            @Override
            public Color getColor() {

                return Color.ORANGE;
            }
        };

    }
}
