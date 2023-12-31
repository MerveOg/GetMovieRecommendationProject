import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @file MyButton.java
 * @description A program that get recommendations according to the target user and movies.
 * @assignment Data Structures Project 3: Movie Recommendation
 * @date 26.05.2023
 * @author @beyza.yildizli@stu.fsm.edu.tr @merve.og@stu.fsm.edu.tr
 */

public class MyButton extends JButton {

    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private Color borderColor;
    private int radius = 0;

    public void setOver(boolean over) {
        this.over = over;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean isOver() {
        return over;
    }

    public Color getColor() {
        return color;
    }

    public Color getColorOver() {
        return colorOver;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public int getRadius() {
        return radius;
    }

    public MyButton() {
        setColor(Color.WHITE);
        colorOver = new Color(59,193,193);
        colorClick = new Color(110,225,225);
        borderColor = new Color(0,102,102);
        setContentAreaFilled(false);
        addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                setBackground(colorOver);
                over = true;
            }

            public void mouseExited(MouseEvent e) {
                setBackground(color);
                over = false;
            }

            public void mousePressed(MouseEvent e) {
                setBackground(colorClick);
            }

            public void mouseReleased(MouseEvent e) {
                if (over) {
                    setBackground(colorOver);
                } else {
                    setBackground(color);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());

        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(grphcs);
    }
}
