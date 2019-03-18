package Renderer;

import java.awt.*;

import Bouncer.Bouncable;
public class FilledShapeRenderer implements Renderable {
    private static FilledShapeRenderer instance;

    public static FilledShapeRenderer getInstance(){
        if(instance == null){
            instance = new FilledShapeRenderer();
        }
        return instance;
    }

    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.fill( b.getShape());
    }


}
