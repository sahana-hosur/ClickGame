import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
public class scorecard extends homepage {

    private static JLabel backimageLabel;
    private static JFrame frame1;
    private static JLabel pass, rat;
    private static JButton home;

    public scorecard(int hit, int miss) {

        //frame-Setting
        frame1 = new JFrame("HitMe");
        frame1.setSize(400, 500);
        frame1.setFont(new Font("Cooper Black", Font.BOLD, 18));
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        ImageIcon backIcon = new ImageIcon("Resources\\BACK.png");
        backIcon = RoundButton.resizeIcon(backIcon, 400, 500);
        backimageLabel = new JLabel(backIcon);
        backimageLabel.setLayout(new BorderLayout());
        frame1.setContentPane(backimageLabel);
        frame1.setLayout(null);

        //Hit-Miss Ratio Calculator
        int total = hit + miss;
        double ratio = ((double) hit / total) * 100;

        //Showing-Result
        pass = new JLabel();
        pass.setFont(new Font("Viner Hand ITC", Font.BOLD, 22));
        pass.setForeground(Color.RED);
        pass.setBounds(150, 50, 200, 50);
        //if game is never played
        if(hit+miss==0){
            pass.setText("Where Is Your Mind At");
            pass.setBounds(100, 50, 250, 50);
            ratio=0;
        }
        else if (ratio > 90) {
            pass.setText("Excellent");
        } else if (ratio >= 76 && ratio <= 90) {
            pass.setText("Good");
        } else if (ratio >= 60 && ratio <= 75) {
            pass.setText("Passed");
        } else if (ratio < 60) {
            pass.setText("Better Luck Next Time");
        }
        
        String str = String.format("%.2f%%", ratio);
        rat = new JLabel(str);
        rat.setFont(new Font("Cooper Black", Font.PLAIN, 38));
        rat.setForeground(Color.RED);
        rat.setBounds(120, 120, 200, 50);
        backimageLabel.add(pass);
        backimageLabel.add(rat);

        //Home-Button Setting
        home =new RoundButton("Home");
        home.setFont(new Font("Ravie",Font.BOLD,18));
        home.setBounds(120,290,180,45);
        home.setForeground(Color.BLACK);
        home.setBackground(new Color(166,166,166));
        home.addActionListener(this);
        home.setBorder(null);
        home.setOpaque(false);
        frame1.add(home);

        frame1.setVisible(true);
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         new scorecard(30, 12);
    //     });
    // }
    @Override
    public void actionPerformed(ActionEvent e){
        if((e.getSource())==home ){
            frame1.dispose();
            frame11.setVisible(true);
        }
    }
}
