/**
 * @file Renderable.java
 * @author Pier Donini
 */

package Renderer;

import java.awt.Graphics2D;

import Bouncer.Bouncable;
public interface Renderable
{
    void display(Graphics2D g, Bouncable b);
}