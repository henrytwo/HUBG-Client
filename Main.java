// Main.java

import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.util.HashMap;

public class Main extends JFrame implements ActionListener, ComponentListener {

    public enum Pages {MENU, GAME, LOGIN}
    public static Timer masterTimer;
    public static int w = 1260;
    public static int h = 700;
    public static JPanel panel;
    public static Pages page = Pages.LOGIN;
    public static Session session;

    public static long prevFrame = 0;

    public Main() {
        super("HUBG - Henning's Unknown Battle Ground");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(w, h);
        setMinimumSize(new Dimension(1260, 700));
        setLayout(new BorderLayout());

        masterTimer = new Timer(5, this);
        masterTimer.start();

        getContentPane().addComponentListener(this);
        setVisible(true);

    }

    public void startPage(Pages page) {

        // Incase panel isn't there for whatever magic

        this.getContentPane().remove(this.panel);
        this.page = page;
        //this.panel = null;
        startGraphics();
    }

    public void startGraphics() {
        if (panel == null || !panel.getClass().getName().toUpperCase().equals(page.toString())) {

            System.out.println("Switch Pages " + page.toString());

            switch (page) {
                case LOGIN:
                    panel = new Login(this);
                    break;

                case MENU:
                    panel = new Menu(this);
                    break;

                case GAME:
                    panel = new Game(this);
                    break;

            }

            add(panel);
            panel.requestFocus();
            setVisible(true);
            panel.repaint();

        }
    }

    public void componentHidden(ComponentEvent ce) {

    }

    public void componentShown(ComponentEvent ce) {

    }

    public void componentMoved(ComponentEvent ce) {

    }

    public void componentResized(ComponentEvent ce) {
        w = getWidth();
        h = getHeight();

    }

    public void actionPerformed(ActionEvent evt) {
        startGraphics();


        this.repaint();


        //long currentTime = System.currentTimeMillis();

        //System.out.println(currentTime - prevFrame);

        //prevFrame = currentTime;

    }


    public static void main(String[] args) {
        Main frame = new Main();
    }

}