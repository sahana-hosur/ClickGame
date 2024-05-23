import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HitMe extends JPanel {
    public static final int BOX_SIZE = 40; 
    static final int PANEL_WIDTH = 400; 
    static final int PANEL_HEIGHT = 400; 
    public static final int HIT_MISS_LABEL_WIDTH = 100; 
    public static final int HIT_MISS_LABEL_HEIGHT = 20; 
    public static final int MAX_BOX_POSITION_X = PANEL_WIDTH - BOX_SIZE;
    public static final int MAX_BOX_POSITION_Y = PANEL_HEIGHT - BOX_SIZE;
    public static final Color BOX_BORDER_COLOR = Color.BLACK;
    public static final Color BOX_FILL_COLOR = Color.RED;
    public static final Random RANDOM = new Random();

    public int boxPositionX;
    public int boxPositionY;
    public int hitCount;
    public int missCount;

    private Timer boxTimer;
    private boolean isBoxVisible = false;

    public HitMe(int x) {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point point = e.getPoint();
                if (point.x >= boxPositionX && point.x <= boxPositionX + BOX_SIZE
                        && point.y >= boxPositionY && point.y <= boxPositionY + BOX_SIZE) {
                    hitCount++;
                } else {
                    missCount++;
                }
                repaint();
            }
        });

        //Speed-Control 
        boxTimer = new Timer(x*100, e -> {
            if (isBoxVisible) {
                boxPositionX = 0;
                boxPositionY = 0;
            } else {
                moveBoxRandomly();
                isBoxVisible = !isBoxVisible;
            repaint();
            }
            
        });
        boxTimer.start();
    }

    public void moveBoxRandomly() {
        boxPositionX = RANDOM.nextInt(MAX_BOX_POSITION_X + 1);
        boxPositionY = RANDOM.nextInt(MAX_BOX_POSITION_Y + 1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the box
        if (boxPositionX == 0 && boxPositionY == 0) { // The box is not visible, so choose a new position
            boxPositionX = RANDOM.nextInt(MAX_BOX_POSITION_X + 1);
            boxPositionY = RANDOM.nextInt(MAX_BOX_POSITION_Y + 1);
        }
        g.setColor(BOX_BORDER_COLOR);
        g.drawRect(boxPositionX, boxPositionY, BOX_SIZE, BOX_SIZE);
        g.setColor(BOX_FILL_COLOR);
        g.fillRect(boxPositionX + 1, boxPositionY + 1, BOX_SIZE - 1, BOX_SIZE - 1);
    }

    @Override
    public void removeNotify() {
        super.removeNotify();
        boxTimer.stop();
    }

    // public static void main(String[] args) {
    //     JFrame frame = new JFrame("Hit-Miss Game");
    //     HitMe gamePanel = new HitMe();
    //     gamePanel.setPreferredSize(new java.awt.Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    //     frame.getContentPane().add(gamePanel);
    //     frame.pack();
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setVisible(true);
    // }
}
