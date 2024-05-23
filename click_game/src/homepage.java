import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

public class homepage  implements ActionListener{

    static JFrame frame11;
    static RoundButton play,settings,exit;
    static JLabel usrname,Hitme,backimageLabel;
    static JTextField name; 
    static musicthread m=new musicthread("Resources\\Sneaky-Snitch.mp3");

    public static void main(String[] args) {
        m.start();
        ImageIcon st=new ImageIcon("Resources\\hello.jpg");
        frame11=new JFrame("HitMe");
        frame11.setIconImage(st.getImage());
        frame11.setSize(400, 500);
        frame11.setFont(new Font("Cooper Black",Font.BOLD,18));
        frame11.setLocationRelativeTo(null);
        frame11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame11.setResizable(false);
        ImageIcon backIcon=new ImageIcon("Resources\\BACK.png");
        backIcon=RoundButton.resizeIcon(backIcon, 400, 500);
        backimageLabel=new JLabel(backIcon);
        backimageLabel.setLayout(new BorderLayout());
        frame11.setContentPane(backimageLabel);
        
         frame11.setLayout(null);
        //Head of the App
        Hitme=new JLabel("HitMe");
        Hitme.setBounds(150,0,90,40);
        Hitme.setFont(new Font("Cooper Black",Font.BOLD,28));
        Hitme.setForeground(new Color(255, 66, 11));
        frame11.add(Hitme);

        //username:
        usrname=new JLabel("Username:");
        usrname.setBounds(35,85,140,30);
        usrname.setFont(new Font("Ravie",Font.PLAIN,18));
        usrname.setForeground(Color.WHITE);
        frame11.add(usrname);

        //name of the user
        name = new TransparentTextField();
        name.setText("        Name");
        name.setFont(new Font("Cooper Black",Font.PLAIN,16));
        name.setForeground(Color.BLACK);
        name.setBorder(null);
        name.setBounds(170,85,200,30);
        name.addFocusListener(new FocusListener() {
            //Setting-A-Blur-Text
            @Override
            public void focusGained(FocusEvent f){
                if(name.getText().equals("        Name")){
                    name.setText("");
                    name.setFont(new Font("Cooper Black",Font.PLAIN,16));
                    name.setForeground(Color.WHITE);
                }
            }
            @Override
            public void focusLost(FocusEvent f){
                if(name.getText().isEmpty()){
                    name.setText("        Name");
                    name.setFont(new Font("Cooper Black",Font.PLAIN,16));
                    name.setForeground(new Color(255, 66, 11));
                }
            }        
        });
        frame11.add(name);

        //Play-Button
        ImageIcon playimg=new ImageIcon("Resources\\play-img.jpg");
        ImageIcon img=RoundButton.resizeIcon(playimg,20,15);
        play=new RoundButton(img,"Play");
        play.setFont(new Font("Ravie",Font.BOLD,18));
        play.setBounds(130,150,180,45);
        play.setForeground(Color.BLACK);
        play.setBackground(new Color(166,166,166));
        play.addActionListener(new homepage());
        play.setBorder(null);
        play.setOpaque(false);
        frame11.add(play);

        //Settings-Buttton
        ImageIcon settimg=new ImageIcon("Resources\\Settings.jpg");
        settimg=RoundButton.resizeIcon(settimg, 25, 18);
        settings=new RoundButton(settimg,"Settings");
        settings.setFont(new Font("Ravie",Font.BOLD,18));
        settings.setBounds(130,220,180,45);
        settings.setForeground(Color.BLACK);
        settings.setBackground(new Color(166,166,166));
        settings.setBorder(null);
        settings.addActionListener(new homepage());
        settings.setOpaque(false);
        frame11.add(settings);

        //Exit-Button
        exit=new RoundButton("Exit");
        exit.setFont(new Font("Ravie",Font.BOLD,18));
        exit.setBounds(130, 290, 180, 45);
        exit.setForeground(Color.BLACK);
        exit.setBackground(new Color(166,166,166));
        exit.setBorder(null);
        exit.setOpaque(false);
        exit.addActionListener(new homepage());
        frame11.add(exit);

        
        frame11.setVisible(true);
        frame11.requestFocusInWindow();
    }
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==play){
            //Play button is clicked
            frame11.setVisible(false);
            new play();

        }
        else if(e.getSource()==settings){
            frame11.setVisible(false);
            new setting_page();
        }

        else if(e.getSource()==exit){
            frame11.dispose();
            
        }

    }
}