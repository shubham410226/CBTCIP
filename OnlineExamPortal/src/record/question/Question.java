package record.question;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Objects;

/**
 * Created By: shubham singh
 * User ID: shubham410226
 * Package Name: main
 * Project Name: OnlineAssessmentFacultyPortal
 * Date: 07-03-2024
 */

public class Question {
    private final SimpleStringProperty serialNumber = new SimpleStringProperty("");
    private final SimpleStringProperty question = new SimpleStringProperty("");

    public Question(String serialNumber, String question) {
        this.serialNumber.set(serialNumber);
        this.question.set(question);
    }

    public String getSerialNumber() {
        return serialNumber.get();
    }

    public SimpleStringProperty serialNumberProperty() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber.set(serialNumber);
    }

    public String getQuestion() {
        return question.get();
    }

    public SimpleStringProperty questionProperty() {
        return question;
    }

    public void setQuestion(String question) {
        this.question.set(question);
    }

    @Override
    public String toString() {
        return "S.No.= " + serialNumber +
                "Question= " + question;
    }
}
