package Displayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;


import java.awt.image.BufferedImage;

public class BouncerDisplayer implements Displayer{

    private static BouncerDisplayer instance;

    private JFrame frame;
    private JPanel panel;

    private final static int panelHeight=500;
    private final static int panelWidth =500;
    private final static Color panelColor=Color.white;

    private BufferedImage image;

    private BouncerDisplayer(){
        frame  = new JFrame();
        panel  = new JPanel();



        panel.setPreferredSize(new Dimension(panelHeight, panelWidth));
        panel.setBackground(panelColor);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);

        image = (BufferedImage) panel.createImage(panelHeight, panelWidth);


        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(image, null, panelHeight, panelWidth);
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
        image = (BufferedImage) panel.createImage(panel.getWidth(), panel.getHeight());
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
