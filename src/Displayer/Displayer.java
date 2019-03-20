/**
 * @file Displayer.java
 * @author Pier Donini
 * @date 12.03.19
 */
package Displayer;

import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;

public interface Displayer
{
    int getWidth();
    int getHeight();
    Graphics2D getGraphics();
    void repaint();
    void setTitle(String s);
    void addKeyListener(KeyAdapter ka);
}