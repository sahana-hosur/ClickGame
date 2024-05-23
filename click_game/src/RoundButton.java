import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

class RoundButton extends JButton {
        private ImageIcon icon;
        private String text;

        public RoundButton(ImageIcon icon, String text) {
            this.icon = icon;
            this.text = text;
            setOpaque(false); // Make the button background transparent
        }
        public RoundButton(String text) {
            this.text = text;
            setOpaque(false); // Make the button background transparent
            this.icon = new ImageIcon("path/to/default/icon.png");
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();

            // Create a rounded rectangle shape with the same size as the button
            int arcWidth = 40;
            int arcHeight = 40;
            Shape shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

            g2d.setColor(getBackground());
            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
            // Set the shape as the clip region of the graphics object
            g2d.setClip(shape);

            // Call the original paintComponent method to paint the button background
            super.paintComponent(g2d);

            // Calculate the position to center the icon and text within the rounded rectangle shape
            int iconX = (getWidth() - icon.getIconWidth() - g2d.getFontMetrics().stringWidth(text)) / 2;
            int iconY = (getHeight() - icon.getIconHeight()) / 2;
            int textX = iconX + icon.getIconWidth();
            int textY = (getHeight() + g2d.getFontMetrics().getAscent()) / 2;

            // Draw the icon and text within the rounded rectangle shape
            g2d.setColor(getForeground());
            icon.paintIcon(this, g2d, iconX, iconY);
            g2d.drawString(text, textX, textY);

            g2d.dispose();
        }
        public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
            Image image = icon.getImage();
            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        }
    }