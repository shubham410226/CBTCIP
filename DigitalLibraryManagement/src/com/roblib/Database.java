package com.roblib;

import java.awt.image.BufferedImage;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Database {

        private static final String DB_URL = "jdbc:mysql://localhost:3306/roblib";
        private static final String DB_USER = "root";
        private static final String DB_PASSWORD = "root";
    public class UserRegistrationException extends Exception {
        public UserRegistrationException(String message) {
            super(message);
        }
    }

    public void saveUser(String username, String password, String email, String gender, String birthdate, String cin, String imgPath) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO users (username, password, email, gender, birthdate, cin, imgPath) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, gender);
            pstmt.setDate(5, Date.valueOf(birthdate));
            pstmt.setString(6, cin);
            pstmt.setString(7, imgPath);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void saveUserWithExceptionHandling(String username, String password, String email, String gender, String birthdate, String cin, String imagePath) throws UserRegistrationException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO users (username, password, email, gender, birthdate, cin, imgPath) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, gender);
            pstmt.setDate(5, Date.valueOf(birthdate));
            pstmt.setString(6, cin);
            pstmt.setString(7, imagePath);
            pstmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            if (e.getErrorCode() == 1062) {
                String errorMessage = e.getMessage();
                if (errorMessage.contains("users.username")) {
                    throw new UserRegistrationException("Username is already in use.");
                } else if (errorMessage.contains("users.email")) {
                    throw new UserRegistrationException("Email is already in use.");
                } else if (errorMessage.contains("users.cin")) {
                    throw new UserRegistrationException("CIN is already in use.");
                } else {
                    e.printStackTrace();
                    throw new UserRegistrationException("An error occurred. Please try again later.");
                }
            } else {
                e.printStackTrace();
                throw new UserRegistrationException("An error occurred. Please try again later.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserRegistrationException("An error occurred. Please try again later.");
        }
    }




}
