package test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class action3MouseFrame extends JFrame implements MouseListener {
    JButton jb1 = new JButton("button 1");
    JButton jb2 = new JButton("button 2");
    public action3MouseFrame(){
        this.setSize(603,380);
        this.setTitle("mouse listener show");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        jb1.setBounds(0,0,100,50);
        jb1.addMouseListener(this);

        jb2.setBounds(100,0,100,50);
        jb2.addMouseListener(this);

        this.getContentPane().add(jb1);
        this.getContentPane().add(jb2);

        this.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("clicked");
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        System.out.println("pressed");
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        System.out.println("released");
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        System.out.println("entered");
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        System.out.println("exited");
    }


}
