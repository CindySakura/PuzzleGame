package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class actionTest {
    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setSize(603,680);
        jframe.setTitle("event show");
        jframe.setAlwaysOnTop(true);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setLayout(null);

        JButton jtb = new JButton("button 1");
        jtb.setBounds(0,0,100,50);
        jtb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("clicked");
            }
        });

        jframe.getContentPane().add(jtb);



        jframe.setVisible(true);
    }

}
