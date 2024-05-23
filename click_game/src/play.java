import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class play extends homepage {
    private static JFrame frame; 
    private static JLabel head;
    private static RoundButton newGame,cont,Home;
    public play(){
        
        //frame setting
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

        //Heading
        head=new JLabel("Hello "+name.getText()+"!!!");
        head.setBounds(5,25,340,30);
        head.setFont(new Font("Ravie",Font.PLAIN,22));
        head.setForeground(Color.WHITE);
        frame.add(head);

        //emoji
        ImageIcon emoji=new ImageIcon("Resources\\emoji.jpg");
        emoji=RoundButton.resizeIcon(emoji, 100, 100);
        JLabel lab=new JLabel(emoji);
        lab.setBounds(290,20,100,100);
        frame.add(lab);


        //new Game Button
        newGame=new RoundButton("New Game");
        newGame.setFont(new Font("Ravie",Font.BOLD,18));
        newGame.setBounds(120,150,180,45);
        newGame.setForeground(Color.BLACK);
        newGame.setBackground(new Color(166,166,166));
        newGame.addActionListener(this);
        newGame.setBorder(null);
        newGame.setOpaque(false);
        frame.add(newGame);

        //continue Button
        cont=new RoundButton("Continue");
        cont.setFont(new Font("Ravie",Font.BOLD,18));
        cont.setBounds(120,220,180,45);
        cont.setForeground(Color.BLACK);
        cont.setBackground(new Color(166,166,166));
        cont.addActionListener(this);
        cont.setBorder(null);
        cont.setOpaque(false);
        frame.add(cont);

        //home-button
        Home=new RoundButton("Home");
        Home.setFont(new Font("Ravie",Font.BOLD,18));
        Home.setBounds(120,290,180,45);
        Home.setForeground(Color.BLACK);
        Home.setBackground(new Color(166,166,166));
        Home.addActionListener(this);
        Home.setBorder(null);
        Home.setOpaque(false);
        frame.add(Home);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==newGame){
            frame.setVisible(false);
            new level();
        }
        else if(e.getSource()==cont){

        }
        else if(e.getSource()==Home){
            frame.dispose();
            frame11.setVisible(true);
        }
    }

    
}
