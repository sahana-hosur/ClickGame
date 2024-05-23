import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class level implements ActionListener{
    static JFrame frame12;
    static JLabel head,backimageLabel;
    static JButton easy,medium,expert;
    public level(){
        //Frame-Setting
        ImageIcon st=new ImageIcon("Resources\\hello.jpg");
        frame12=new JFrame("HitMe");
        frame12.setIconImage(st.getImage());
        frame12.setSize(400, 500);
        frame12.setFont(new Font("Cooper Black",Font.BOLD,18));
        frame12.setLocationRelativeTo(null);
        frame12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame12.setResizable(false);
        ImageIcon backIcon=new ImageIcon("Resources\\BACK.png");
        backIcon=RoundButton.resizeIcon(backIcon, 400, 500);
        backimageLabel=new JLabel(backIcon);
        backimageLabel.setLayout(new BorderLayout());
        frame12.setContentPane(backimageLabel);
        frame12.setLayout(null);

        //head-Label Setting
        head=new JLabel("Choose Difficulity...");
        head.setBounds(70,30,300,100);
        head.setFont(new Font("Ravie",Font.BOLD,20));
        head.setForeground(Color.WHITE);
        frame12.add(head);

        //Setting of easy Buttton
        easy=new RoundButton("Begginer");
        easy.setFont(new Font("Ravie",Font.BOLD,18));
        easy.setBounds(125,150,180,45);
        easy.setForeground(Color.BLACK);
        easy.setBackground(new Color(166,166,166));
        easy.addActionListener(this);
        easy.setBorder(null);
        easy.setOpaque(false);
        frame12.add(easy);

        //Setting of Intermediate Button
        medium=new RoundButton("Intermediate");
        medium.setFont(new Font("Ravie",Font.BOLD,18));
        medium.setBounds(125,220,180,45);
        medium.setForeground(Color.BLACK);
        medium.setBackground(new Color(166,166,166));
        medium.addActionListener(this);
        medium.setBorder(null);
        medium.setOpaque(false);
        frame12.add(medium);

        //Setting of Expert Button
        expert=new RoundButton("Expert");
        expert.setFont(new Font("Ravie",Font.BOLD,18));
        expert.setBounds(125,290,180,45);
        expert.setForeground(Color.BLACK);
        expert.setBackground(new Color(166,166,166));
        expert.addActionListener(this);
        expert.setBorder(null);
        expert.setOpaque(false);
        frame12.add(expert);
        frame12.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        frame12.dispose();
        //when easy button is called deplay between apperance and disapperance of the box is 1.5 seconds
        if(e.getSource()==easy){
            new game(15);
        }
        //when intermediate button is called deplay between apperance and disapperance of the box is 1 second
        else if(e.getSource()==medium){
            new game(10);
        }
        //when Expert button is called deplay between apperance and disapperance of the box is 0.5 seconds
        else{
            new game(7);
        }
    }
    public static void main(String[] args){
        new level();
    }
}
