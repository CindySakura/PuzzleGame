package ui;

import User.User;
import Util.CodeUtil;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener {
    static ArrayList<User> list = new ArrayList<User>();
    static{
        list.add(new User("amy","123"));
        list.add(new User("bob","234"));
    }
    JButton loginB = new JButton();
    JButton registerB = new JButton();
    JTextField uname = new JTextField();
    JTextField verificationCode = new JTextField();
    JTextField password = new JTextField();
    String code = CodeUtil.getCode();
    JLabel rightCode = new JLabel(code);


    public LoginJFrame(){
        initJFrame();
        initView();
        this.setVisible(true);
    }

    private void initView() {
        this.getContentPane().removeAll();
        //uname input icon
        JLabel unameText = new JLabel(new ImageIcon("image/login/用户名.png"));
        unameText.setBounds(120,135,47,17);
        this.getContentPane().add(unameText);

        //uname input place
        uname.setBounds(190,130,200,30);
        this.getContentPane().add(uname);

        JLabel pwText = new JLabel(new ImageIcon("image/login/密码.png"));
        pwText.setBounds(130,195,47,17);
        this.getContentPane().add(pwText);

        password.setBounds(190,190,200,30);
        this.getContentPane().add(password);

        //verification code
        JLabel verificationCodeText = new JLabel(new ImageIcon("image/login/验证码.png"));
        verificationCodeText.setBounds(120,250,50,30);
        this.getContentPane().add(verificationCodeText);

        verificationCode.setBounds(190,250,100,30);
        this.getContentPane().add(verificationCode);


        rightCode.setBounds(300,250,50,30);
        rightCode.addMouseListener(this);
        this.getContentPane().add(rightCode);

        //login button
        loginB.setBounds(123,310,128,47);
        loginB.setIcon(new ImageIcon("image/login/登录按钮.png"));
        loginB.setBorderPainted(false);
        loginB.setContentAreaFilled(false);
        loginB.addMouseListener(this);
        this.getContentPane().add(loginB);

        //register button

        registerB.setBounds(256,310,128,47);
        registerB.setIcon(new ImageIcon("image/login/注册按钮.png"));
        registerB.setBorderPainted(false);
        registerB.setContentAreaFilled(false);
        registerB.addMouseListener(this);
        this.getContentPane().add(registerB);

        JLabel bg = new JLabel(new ImageIcon("image/login/background.png"));
        bg.setBounds(10,0,470,390);
        this.getContentPane().add(bg);
        this.getContentPane().repaint();
    }

    public void initJFrame(){
        this.setSize(488,430);
        this.setTitle("Puzzle 1.0 Login");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
    }

    public void showJDialog(String content){
        JDialog jDialog = new JDialog();
        jDialog.setSize(250,150);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setModal(true);

        JLabel warning = new JLabel(content);
        warning.setBounds(0,0,200,150);
        jDialog.getContentPane().add(warning);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setModal(true);

        jDialog.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("clicked");
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        System.out.println("pressed");
        Object loginBPressed = mouseEvent.getSource();
        if(loginBPressed ==  loginB){
            loginB.setIcon(new ImageIcon("image/login/登录按下.png"));
        } else if (loginBPressed == registerB) {
            registerB.setIcon(new ImageIcon("image/login/注册按下.png"));
        }

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        Object loginReleased = mouseEvent.getSource();
        if(loginReleased ==  loginB){
            System.out.println("login released");
            loginB.setIcon(new ImageIcon("image/login/登录按钮.png"));
            String unameT = uname.getText();
            String pwT = password.getText();
            String veriT = verificationCode.getText();

            if(!veriT.equalsIgnoreCase(code)){
                System.out.println("wrong code");
                code = CodeUtil.getCode();
                rightCode.setText(code);
                return;
            } else{
                boolean result = compare(new User(unameT, pwT));
                if(result){
                    System.out.println("Login Successfully. Jump to Game page");
                    new GameJFrame();
                }else{
                    showJDialog("Wrong username or password");
                }
            }
        } else if (loginReleased == registerB) {
            System.out.println("register released");
            registerB.setIcon(new ImageIcon("image/login/注册按钮.png"));
        } else if (loginReleased == rightCode) {
            rightCode.setText(CodeUtil.getCode());
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        System.out.println("entered");
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        System.out.println("exited");
    }

    public boolean compare(User user){
        String uname = user.getUname();
        String upw = user.getPw();
        if(uname.equals("") || upw.equals("")){
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            User listU = list.get(i);
            if(listU.getUname().equals(uname) && listU.getPw().equals(upw)){
                return true;
            }
        }
        return false;
    }


}
