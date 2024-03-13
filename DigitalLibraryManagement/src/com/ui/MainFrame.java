package com.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    public MainFrame() {
        int width = 1960;
        int height = 1080;
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

        //THE LOGO OF THE NEW ACCOUNT PAGE
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/com/Resources/LOGO2.png"));
        JLabel logoLabel = new JLabel(logoIcon);

        int logoWidth = 300;
        int logoHeight = 300;
        logoLabel.setBounds((width - logoWidth) / 2, 30, logoWidth, logoHeight);
        add(logoLabel);

        //SEARCH BAR
        RoundedTextField searchField = new RoundedTextField(20, "Search for books");
        searchField.setForeground(Color.BLACK);
        int searchBarWidth = 1000;
        int searchBarHeight = 40;
        searchField.setBounds((width - searchBarWidth) / 2, logoHeight + 20, searchBarWidth, searchBarHeight);
        Font searchFont = new Font("Arial", Font.PLAIN, 20);
        searchField.setFont(searchFont);
        searchField.setBackground(new Color(189, 237, 255));
        add(searchField);
        //SEARCH ICON
        ImageIcon searchIcon = new ImageIcon(getClass().getResource("/com/Resources/search_icon.png"));
        JLabel searchIconLabel = new JLabel(searchIcon);
        searchIconLabel.setBounds((width + 900) / 2 , logoHeight + 20, 40, 40);
        add(searchIconLabel);

        //VERSION
        JLabel versionLabel = new JLabel("v 1.0");
        versionLabel.setForeground(Color.GRAY);
        Font versionFont = new Font("Arial", Font.PLAIN, 16);
        versionLabel.setFont(versionFont);
        int versionWidth = 100;
        int versionHeight = 30;
        versionLabel.setBounds(100, height - versionHeight - 100, versionWidth, versionHeight);
        add(versionLabel);

        setVisible(true);
    }
}
