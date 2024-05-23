import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class game {
    private static final int game_DURATION_SECONDS = 60; // Set the game duration in seconds
    private boolean gameActive = true; //  to track if the game is active
    private int remainingTime = game_DURATION_SECONDS;

    public game(int x) {
        //frame-Setting
        JFrame frame2 = new JFrame("Hit-Miss game");
        HitMe gamePanel = new HitMe(x);
        frame2.setSize(400, 600);
        frame2.setLayout(new BorderLayout());

        //creating- Score Panel
        JPanel emptyPanel = new JPanel(); 
        emptyPanel.setPreferredSize(new Dimension(400, 50)); 
        emptyPanel.setBackground(new Color(85, 168, 176));
        gamePanel.setBackground(new Color(56, 97, 105));


        JLabel score = new JLabel("Score Card");
        score.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));

        //initilizaing hit miss Label
        JLabel hitMissLabel = new JLabel("Hit: 0  Miss: 0"); 
        hitMissLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));

        //Setting the timer for the end of Game
        JLabel timerLabel = new JLabel("Time :" + game_DURATION_SECONDS);
        timerLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));

        emptyPanel.add(score); 
        emptyPanel.add(timerLabel);
        emptyPanel.add(hitMissLabel); 
        emptyPanel.setLayout(new GridLayout(1,3,0,0));

        frame2.add(emptyPanel, BorderLayout.NORTH); 
        frame2.add(gamePanel, BorderLayout.CENTER); 

        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);

        // Create a timer that updates the timer label
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remainingTime--;
                timerLabel.setText("Time: " + remainingTime);
                if (remainingTime == 0) {
                    gameActive = false; // game has ended
                    new scorecard(gamePanel.hitCount,gamePanel.missCount);
                    frame2.dispose();
                }
            }
        });
        timer.start(); // Start the timer

        //Game deployment by the thread
        Thread gameThread = new Thread(() -> {
            // Continue the game loop while the game is active
            while (gameActive) { 
                gamePanel.moveBoxRandomly();
                gamePanel.repaint();
                // Update the hit/miss label with the current counts
                hitMissLabel.setText("Hit: " + gamePanel.hitCount + "   Miss: " + gamePanel.missCount);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        gameThread.start();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new game(5);
        });
    }
}
