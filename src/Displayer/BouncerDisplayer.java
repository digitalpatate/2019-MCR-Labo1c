/**
 * @file BouncerDisplayer.java
 * @author Page Didier & Stalder Nicodème
 * @date 12.03.19
 */
package Displayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
/**
 * Singleton, qui représente la fenêtre d'affichage
 */
public class BouncerDisplayer implements Displayer{

    private static BouncerDisplayer instance;

    private JFrame frame;
    private JPanel panel;

    private final static int panelWidth =350;
    private final static int panelHeight=350;

    private final static Color panelColor=Color.white;

    private Image image;


    private BouncerDisplayer(){
        frame  = new JFrame();
        panel  = new JPanel();

        panel.setPreferredSize(new Dimension(panelWidth, panelHeight));
        panel.setBackground(panelColor);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
        setTitle("Bouncer");
    }

    public static Displayer getInstance(){
        if(instance == null){
            instance = new BouncerDisplayer();
        }
        return instance;
    }

    @Override
    public int getWidth() {
        return panel.getWidth();
    }
    @Override
    public int getHeight() {
        return panel.getHeight();
    }
    @Override
    public Graphics2D getGraphics() {

        return (Graphics2D) image.getGraphics();
    }
    @Override
    public void repaint() {
        panel.getGraphics().drawImage(image, 0, 0, null);
        image = panel.createImage(panel.getWidth(), panel.getHeight());
    }
    @Override
    public void setTitle(String str) {
        frame.setTitle(str);
    }

    @Override
    public void addKeyListener(KeyAdapter keyAdapter) {
        frame.addKeyListener(keyAdapter);
    }
}
