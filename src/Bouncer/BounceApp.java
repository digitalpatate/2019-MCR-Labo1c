/**
 * @file BounceApp.java
 * @author Page Didier & Stalder Nicodème
 * @date 12.03.19
 */
package Bouncer;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import java.util.LinkedList;

import Displayer.*;
import Factory.*;

/**
 * Class principale du laboratoire
 */
public class BounceApp
{
    private LinkedList<Bouncable> bouncers;
    private Displayer displayer;

    private ActionListener mainAction;

    private final int MAXSHAPESIZE;
    private final int NBSHAPETOGENERATE;

    //Constructeur
    public BounceApp(int MAXSHAPESIZE) {

        this.MAXSHAPESIZE=MAXSHAPESIZE;
        this.NBSHAPETOGENERATE =10;

        bouncers = new LinkedList<>();
        displayer = BouncerDisplayer.getInstance();

        // On ajoute un keyListener pour gérer l'appuie du clavier
        displayer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {

                //Récupère le caractère tapé au clavier
                char keyChar = keyEvent.getKeyChar();

                switch (keyChar){
                    case 'e':
                        // On vide la liste des forme, ce qui as pour effet de vider l'ecran
                        // car la boulce d'affichage ne va pas trouver de formes
                        bouncers.clear();
                        break;
                    case 'b':
                        // On créer des forme vide en appelant l'instance de la factory des formes vides
                        for(int i = 0; i < NBSHAPETOGENERATE; i++){
                            bouncers.add(EmptyBouncerFactory.getInstance().createCircle(displayer.getWidth(),displayer.getHeight(),MAXSHAPESIZE));
                            bouncers.add(EmptyBouncerFactory.getInstance().createSquare(displayer.getWidth(),displayer.getHeight(),MAXSHAPESIZE));
                        }
                        break;
                    case 'f':
                        // On créer des forme plein en appelant l'intance de la factory des formes pleines
                        for(int i = 0; i < NBSHAPETOGENERATE; i++){
                            bouncers.add(FilledBouncerFactory.getInstance().createCircle(displayer.getWidth(),displayer.getHeight(),MAXSHAPESIZE));
                            bouncers.add(FilledBouncerFactory.getInstance().createSquare(displayer.getWidth(),displayer.getHeight(),MAXSHAPESIZE));
                        }
                        break;
                    case 'q':
                        // On quitte le programe
                        System.exit(0);
                        break;
                }

            }
        });

        // On créer un objet qui contient la méthode qui va s'occuper de faire bouger les formes et de les afficher
        this.mainAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(Bouncable s : bouncers) {
                    s.move();
                    s.draw();
                }
                displayer.repaint();
            }
        };
    }
    public void loop(int TIMEBEFOREMOVE) {

        // https://docs.oracle.com/javase/7/docs/api/javax/swing/.html
        /*
         *   Sur la documentation de java, ils disent qu'un exemple d'utilisation est justement
          *  un ou plusrieurs objets qui doivent être animé selon un timer.
          *  C'est exactement ce qu'on a besoin dans ce laboratoire
          *
          *  On execute l'action principale à savoir faire bouger les formes et les afficher, tout les x temps.
          *
         */
        new Timer(TIMEBEFOREMOVE, mainAction).start();
    }
    public static void main(String ... args) {

        final int TIMEBEFOREMOVE=10;
        final int MAXSHAPESIZE=20;

        new BounceApp(MAXSHAPESIZE).loop(TIMEBEFOREMOVE);
    }
}