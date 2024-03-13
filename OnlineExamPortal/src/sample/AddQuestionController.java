package sample;

import database.DataSource;
import database.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.xml.crypto.Data;

/**
 * Created By: shubham singh
 * User ID: shubham410226
 * Package Name: main
 * Project Name: OnlineAssessmentFacultyPortal
 * Date: 07-03-2024
 */

public class AddQuestionController {
    @FXML
    private TextField question;
    @FXML
    private Button add;

    public AddQuestionController(){}

    public void addVivaQuestion(){
        String question1 = question.getText();
        DataSource.addVivaQuestion(DatabaseConnection.getConnection(), question1);
    }

    public void addQuestion(){
        String question1 = question.getText();
        DataSource.addQuestionToQuestionBank(DatabaseConnection.getConnection(), question1);
    }
}
