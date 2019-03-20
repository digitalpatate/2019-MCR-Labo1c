/**
 * @file Bouncable.java
 * @author Piere Donini
 */

package Bouncer;

import Renderer.Renderable;

import java.awt.Color;
import java.awt.Shape;

public interface Bouncable
{
    void draw();
    void move();
    Renderable getRenderer();
    Color getColor();
    Shape getShape();
}