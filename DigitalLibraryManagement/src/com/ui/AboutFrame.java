package com.ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AboutFrame extends JFrame {
    private static final int width = 1960;
    private static final int height = 1080;
    AboutFrame() {
        setTitle("ROBLIB");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/com/Resources/Icon_Logo.png"));
        setIconImage(icon.getImage());

        //BACK TO LOGIN
        ImageIcon backButtonIcon = new ImageIcon(getClass().getResource("/com/Resources/back_button.png")); // Replace with your back button image
        JLabel backButton = new JLabel(backButtonIcon);
        backButton.setBounds(30, 30, backButtonIcon.getIconWidth(), backButtonIcon.getIconHeight());
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new LoginFrame().setVisible(true);
            }
        });
        add(backButton);

        //VERSION
        JLabel versionLabel = new JLabel("v 1.0");
        versionLabel.setForeground(Color.GRAY);
        Font versionFont = new Font("Arial", Font.PLAIN, 16);
        versionLabel.setFont(versionFont);
        int versionWidth = 100;
        int versionHeight = 30;
        versionLabel.setBounds(100, height - versionHeight - 100, versionWidth, versionHeight);
        add(versionLabel);

        // Create a JLabel for your text
        String labelText = "<html><div style='text-align: center; font-size: 20px; width: 100%;'>Application information:<br><br>Borrowing books<br><br>Keeping track of your favorit books<br><br>Precise statistics about the trending and most borrowed books<br><br>Providing mails to keep you updated of the last versions</div></html>";
        JLabel label = new JLabel(labelText);
        label.setVerticalAlignment(JLabel.TOP);

        // Set the bounds to center the label
        int labelWidth = 570; // Adjust the width as needed
        int labelHeight = 570; // Adjust the height as needed
        int x = (width - labelWidth) / 2;
        int y = (height - labelHeight) / 2;
        label.setBounds(x, y, labelWidth, labelHeight);

        // Add the label to the frame
        add(label);

        setVisible(true);
    }
}
