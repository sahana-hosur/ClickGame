import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
public class setting_page extends homepage{
    static int count=0;
    static JFrame frame;
    static JLabel set;
    static RoundButton sound,vibrate,home;
    public setting_page(){
    
        //Settings Frame
        frame=new JFrame("HitMe");
        frame.setSize(400, 500);
        frame.setFont(new Font("Cooper Black",Font.BOLD,18));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        ImageIcon backIcon=new ImageIcon("Resources\\BACK.png");
        backIcon=RoundButton.resizeIcon(backIcon, 400, 500);
        backimageLabel=new JLabel(backIcon);
        backimageLabel.setLayout(null);
        frame.setContentPane(backimageLabel);

        //Settings-Head
        set=new JLabel("Settings");
        set.setBounds(5,25,340,30);
        set.setFont(new Font("Ravie",Font.PLAIN,22));
        set.setForeground(Color.WHITE);
        frame.add(set);

        //Sound-Button
        ImageIcon img=new ImageIcon("Resources\\No-sound.png");
        img=RoundButton.resizeIcon(img, 25, 20);
        sound = new RoundButton(img,"Sound");
        sound.setFont(new Font("Ravie",Font.BOLD,18));
        sound.setBounds(120,150,180,45);
        sound.setForeground(Color.BLACK);
        sound.setBackground(new Color(166,166,166));
        sound.addActionListener(this);
        sound.setBorder(null);
        sound.setOpaque(false);
        frame.add(sound);

        //Vibrate-Button
        vibrate = new RoundButton("Vibrate");
        vibrate.setFont(new Font("Ravie",Font.BOLD,18));
        vibrate.setBounds(120,220,180,45);
        vibrate.setForeground(Color.BLACK);
        vibrate.setBackground(new Color(166,166,166));
        vibrate.addActionListener(this);
        vibrate.setBorder(null);
        vibrate.setOpaque(false);
        frame.add(vibrate);

        //Home-Button
        home = new RoundButton("home");
        home.setFont(new Font("Ravie",Font.BOLD,18));
        home.setBounds(120,290,180,45);
        home.setForeground(Color.BLACK);
        home.setBackground(new Color(166,166,166));
        home.addActionListener(this);
        home.setBorder(null);
        home.setOpaque(false);
        frame.add(home);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==home){
            frame.dispose();
            frame11.setVisible(true);
        }
        else if(e.getSource()==sound){
            if(count %2 == 0){
                m.play();
            }else
            m.pause();
        }
        else if(e.getSource()==vibrate){

        }

    }
    
}
