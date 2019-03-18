package Bouncer;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import java.util.LinkedList;

import Displayer.*;
import Factory.*;


public class BounceApp
{
    private LinkedList<Bouncable> bouncers;
    private Displayer displayer;

    private ActionListener mainAction;

    private final int NB_CIRCLE;
    private final int NB_SQUARE;
    private final int MAXSHAPESIZE;
    public BounceApp(int NB_CIRCLE,int NB_SQUARE,int MAXSHAPESIZE) {

        this.NB_CIRCLE=NB_CIRCLE;
        this.NB_SQUARE=NB_SQUARE;
        this.MAXSHAPESIZE=MAXSHAPESIZE;

        bouncers = new LinkedList<>();
        displayer = BouncerDisplayer.getInstance();
        displayer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                char keyChar = keyEvent.getKeyChar();

                switch (keyChar){
                    case 'e':
                        bouncers.clear();
                        break;
                    case 'b':
                        for(int i = 0; i < 10; ++i){
                            bouncers.add(EmptyShapeFactory.getInstance().createCircle(displayer.getWidth(),displayer.getHeight(),MAXSHAPESIZE));
                            bouncers.add(EmptyShapeFactory.getInstance().createSquare(displayer.getWidth(),displayer.getHeight(),MAXSHAPESIZE));
                        }
                        break;
                    case 'f':
                        for(int i = 0; i < 10; ++i){
                            bouncers.add(FilledShapeFactory.getInstance().createCircle(displayer.getWidth(),displayer.getHeight(),MAXSHAPESIZE));
                            bouncers.add(FilledShapeFactory.getInstance().createSquare(displayer.getWidth(),displayer.getHeight(),MAXSHAPESIZE));
                        }
                        break;
                    case 'q':
                        System.exit(0);
                        break;
                }

            }
        });
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

        // https://docs.oracle.com/javase/7/docs/api/javax/swing/Timer.html
        /*
         *   Sur la documentation de java, ils disent qu'un exemple d'utilisation est justement
          *  un objet qui doit être animé après un timer.
         */
        new Timer(TIMEBEFOREMOVE, mainAction).start();
    }
    public static void main(String ... args) {

        final int NB_CIRCLE=10;
        final int NB_SQUARE=10;
        final int TIMEBEFOREMOVE=10;
        final int MAXSHAPESIZE=20;
        new BounceApp(NB_CIRCLE,NB_SQUARE,MAXSHAPESIZE).loop(TIMEBEFOREMOVE);
    }
}