package ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    public RegisterJFrame(){
        initJFrame();

        initJMenuBar();

        this.setVisible(true);
    }

    private void initJFrame() {
        this.setSize(488,500);
        this.setTitle("Puzzle 1.0 Register");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initJMenuBar() {
        JMenuBar jmenubar = new JMenuBar();

        JMenu funcmenu = new JMenu();
        JMenu aboutmenu = new JMenu();

        JMenuItem restart = new JMenuItem();
        JMenuItem relogin = new JMenuItem();
        JMenuItem closegame = new JMenuItem();

        JMenuItem account  = new JMenuItem();

        funcmenu.add(restart);
        funcmenu.add(relogin);
        funcmenu.add(closegame);

        aboutmenu.add(account);

        jmenubar.add(funcmenu);
        jmenubar.add(aboutmenu);

        this.setJMenuBar(jmenubar);
    }
}
