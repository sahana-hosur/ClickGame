import java.awt.*;
import javax.swing.JTextField;
class TransparentTextField extends JTextField {
        public TransparentTextField() {
            setOpaque(false); // Make the text field background transparent
        }

        @Override
        protected void paintComponent(Graphics g) {
            // Create a transparent background color
            Color backgroundColor = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue(), 0);

            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(backgroundColor);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            super.paintComponent(g2d);

            g2d.dispose();
        }
    }
    
