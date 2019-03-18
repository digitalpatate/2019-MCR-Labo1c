package Renderer;

import java.awt.*;

import Bouncer.Bouncable;

public abstract class BouncerRenderer implements Renderable {

    @Override
    public abstract void display(Graphics2D g, Bouncable b);
}
