package com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class RoundedPasswordField extends JPasswordField {
    private Shape shape;
    private String placeholder;
    private Color placeholderColor = Color.GRAY;
    private boolean showingPlaceholder;
    public RoundedPasswordField(int size, String placeholder) {
        super(size);
        this.placeholder = placeholder;
        setOpaque(false);
        setEchoChar((char)0); // Set echo char to display dots (•)
        addFocusListener(new PlaceholderFocusListener());
        setForeground(placeholderColor);
        setHorizontalAlignment(JTextField.CENTER);
        showingPlaceholder = true;
        setPlaceholder();
    }

    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }
        return shape.contains(x, y);
    }

    private class PlaceholderFocusListener implements FocusListener {
        private Color originalTextColor; // Store the original text color

        public PlaceholderFocusListener() {
            originalTextColor = getForeground();
        }

        public void focusGained(FocusEvent e) {
            if (showingPlaceholder) {
                setText("");
                setEchoChar('\u2022');
                setForeground(originalTextColor); // Reset text color to the original color
                showingPlaceholder = false;
            }
        }

        public void focusLost(FocusEvent e) {
            if (new String(getPassword()).isEmpty()) {
                setPlaceholder();
            }
        }
    }
    private void setPlaceholder() {
        setText(placeholder);
        setForeground(placeholderColor);
        showingPlaceholder = true;
    }
}
