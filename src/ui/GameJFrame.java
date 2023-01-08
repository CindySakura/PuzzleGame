package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    int[][] data = new int[4][4];
    int x;
    int y;
    int step = 0;
    String path = "image/animal/animal1/";
    int[][] win = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    Random r = new Random();
    JMenuItem girls = new JMenuItem("girl");
    JMenuItem animal = new JMenuItem("animal");
    JMenuItem sports = new JMenuItem("sports");
    JMenuItem restart = new JMenuItem("restart game");
    JMenuItem relogin = new JMenuItem("relogin");
    JMenuItem closegame = new JMenuItem("close game");
    JMenuItem account  = new JMenuItem("account");
    public GameJFrame(){
        initJFrame();

        initJMenuBar();

        initData();

        initImage();

        this.setVisible(true);
    }

    private void initData() {
        int[] testarr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        int index;
        int temp;
        for (int i = 0; i < testarr.length; i++) {
            index = r.nextInt(testarr.length);
            temp = testarr[i];
            testarr[i] = testarr[index];
            testarr[index] = temp;
        }

        for (int i = 0; i < testarr.length; i++) {
            data[i/4][i%4] = testarr[i];
        }
    }

    private void initJFrame() {
        this.setSize(603,680);
        this.setTitle("Puzzle 1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.addKeyListener(this);
    }

    private void initJMenuBar() {
        JMenuBar jmenubar = new JMenuBar();

        JMenu funcmenu = new JMenu("function");
        JMenu aboutmenu = new JMenu("about us");

        JMenu changePic = new JMenu("Change picture");

        changePic.add(girls);
        changePic.add(animal);
        changePic.add(sports);

        funcmenu.add(changePic);
        funcmenu.add(restart);
        funcmenu.add(relogin);
        funcmenu.add(closegame);

        aboutmenu.add(account);

        girls.addActionListener(this);
        animal.addActionListener(this);
        sports.addActionListener(this);
        restart.addActionListener(this);
        relogin.addActionListener(this);
        closegame.addActionListener(this);
        account.addActionListener(this);

        jmenubar.add(funcmenu);
        jmenubar.add(aboutmenu);

        this.setJMenuBar(jmenubar);
    }

    private void initImage() {
        this.getContentPane().removeAll();
        if(victory()){
            ImageIcon iconWin = new ImageIcon("image/win.png");
            JLabel jLabelWin = new JLabel(iconWin);
            //set location of icon
            jLabelWin.setBounds(200,250,197,73);
            this.getContentPane().add(jLabelWin);
        }

        JLabel count = new JLabel("count: " + step);
        count.setBounds(30,10,100,20);
        this.getContentPane().add(count);

        int number;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                number = data[i][j];
                if(number == 0){
                    y = j;
                    x = i;
                }
                //System.out.print(number + " ");
                ImageIcon icon = new ImageIcon(path+number+".jpg");
                JLabel jLabel = new JLabel(icon);
                //set location of icon
                jLabel.setBounds(105*j+83,105*i+100,105,105);
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(jLabel);
            }
        }

        ImageIcon icon = new ImageIcon("image/background.png");
        JLabel jLabel = new JLabel(icon);
        jLabel.setBounds(40,6,508,560);
        this.getContentPane().add(jLabel);

        this.getContentPane().repaint();
        //this.add(jlabel);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("pressed");
        if(victory()){
            return;
        }
        int keyCode = e.getKeyCode();
        if(keyCode == 65){
            this.getContentPane().removeAll();
            ImageIcon icon = new ImageIcon(path+"all.jpg");
            JLabel jLabel = new JLabel(icon);
            jLabel.setBounds(83, 100, 420,420);
            this.getContentPane().add(jLabel);

            ImageIcon iconbg = new ImageIcon("image/background.png");
            JLabel jLabelbg = new JLabel(iconbg);
            jLabelbg.setBounds(40,6,508,560);
            this.getContentPane().add(jLabelbg);

            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("released");

        if(victory()){
            return;
        }
        int keyCode = e.getKeyCode();
        if(keyCode == 37){
            if(y == data.length-1){
                return;
            }
            data[x][y] = data[x][y+1];
            data[x][y+1] = 0;
            y++;
            step++;
            initImage();
        }else if(keyCode == 38){
            if(x == data.length-1){
                return;
            }
            data[x][y] = data[x+1][y];
            data[x+1][y] = 0;
            x++;
            step++;
            initImage();
        }else if(keyCode == 39){
            if(y == 0){
                return;
            }
            data[x][y] = data[x][y-1];
            data[x][y-1] = 0;
            y--;
            step++;
            initImage();
        }else if(keyCode == 40){
            if(x == 0){
                return;
            }
            data[x][y] = data[x-1][y];
            data[x-1][y] = 0;
            x--;
            step++;
            initImage();
        } else if (keyCode == 65) {
            initImage();
        } else if (keyCode == 87) {
            data = new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            initImage();
        } else{
            return;
        }
    }
    
    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j] != win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj ==restart){
            System.out.println("restart");
            initData();
            step = 0;
            initImage();
        } else if (obj == relogin) {
            System.out.println("relogin");
            this.setVisible(false);
            new LoginJFrame();
        } else if (obj == closegame) {
            System.out.println("close game");
            System.exit(0);
        } else if (obj == account) {
            System.out.println("account");
            JDialog jdialog = new JDialog();
            JLabel jlabel = new JLabel(new ImageIcon("image/about.png"));
            jlabel.setBounds(0,0,258,258);
            jdialog.getContentPane().add(jlabel);
            jdialog.setSize(344,344);
            jdialog.setAlwaysOnTop(true);
            //set jdialog in the middle of the frame
            jdialog.setLocationRelativeTo(null);
            jdialog.setModal(true);
            jdialog.setVisible(true);
        } else if (obj == girls) {
            System.out.println("choosing girl");
            choosePic(girls);
        } else if (e.getSource()== animal) {
            System.out.println("choosing animal");
            choosePic(animal);
        }else if (e.getSource()== sports) {
            System.out.println("choosing sport");
            choosePic(sports);
        }
    }

    public void choosePic(JMenuItem jMenuItem){
        //girl animal sport
        int[] Pics = {13,8,10};
        if(jMenuItem == girls){
            int g = r.nextInt(Pics[0]);
            path = "image/girl/girl"+g+"/";
            initData();
            step = 0;
            initImage();
        } else if (jMenuItem == animal) {
            int a = r.nextInt(Pics[1]);
            path = "image/animal/animal"+a+"/";
            initData();
            step = 0;
            initImage();
        }else if (jMenuItem == sports) {
            int s = r.nextInt(Pics[2]);
            path = "image/sport/sport"+s+"/";
            initData();
            step = 0;
            initImage();
        }
    }
}
