package Renderer;

import java.awt.*;

import Bouncer.Bouncable;

public class EmptyShapeRenderer implements Renderable {
    private static EmptyShapeRenderer instance;

    public static EmptyShapeRenderer getInstance(){
        if(instance == null){
            instance = new EmptyShapeRenderer();
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
