package test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class action4KeyFrame extends JFrame implements KeyListener {
    public action4KeyFrame(){
        this.setSize(603,680);
        this.setTitle("event show");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.addKeyListener(this);

        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        System.out.println("key pressed");
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        System.out.println("key released");
        int keyCode = keyEvent.getKeyCode();
        System.out.println(keyCode);
    }
}
