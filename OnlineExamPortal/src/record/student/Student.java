package record.student;

import javafx.beans.property.SimpleStringProperty;
import portalcredentialscreator.PortalCredentialCreator;
import record.password.Password;
import record.username.UserName;
import subjectandsubjectcode.Subject;
import subjectandsubjectcode.SubjectCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By: shubham singh
 * User ID: shubham410226
 * Package Name: main
 * Project Name: OnlineAssessmentFacultyPortal
 * Date: 07-03-2024
 */

public class Student implements Comparable<Student> {
    private SimpleStringProperty name = new SimpleStringProperty("");
    private int classRollNumber;
    private long universityRollNumber;
    private char section;
    private int currentYear;
    private SimpleStringProperty course = new SimpleStringProperty("");
    private UserName userName;
    private Password password;
    private Map<SubjectCode, Subject> subjectList;

    public Student() {
    }

    public Student(String name, byte classRollNumber, long universityRollNumber,
                   char section, byte currentYear, String course) {
        this.name.set(name);
        this.classRollNumber = classRollNumber;
        this.universityRollNumber = universityRollNumber;
        this.section = section;
        this.currentYear = currentYear;
        this.course.set(course);
        this.subjectList = new HashMap<SubjectCode, Subject>();
        this.userName = new UserName(PortalCredentialCreator.createUserNameForStudent(this));
        this.password = new Password(PortalCredentialCreator.createPassword());
    }

    public Student(String name, int classRollNumber, long universityRollNumber, char section, int currentYear,
                   String course, UserName userName, Password password) {
        this.name.set(name);
        this.classRollNumber = classRollNumber;
        this.universityRollNumber = universityRollNumber;
        this.section = section;
        this.currentYear = currentYear;
        this.course.set(course);
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%-30s%-30s%-30s%-20s%-20s%-20s%-20s%-20s", getName(), getClassRollNumber(), getUniversityRollNumber(),
                getSection(), getCurrentYear(), getCourse(), getUserName(), getPassword());
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public int getClassRollNumber() {
        return classRollNumber;
    }

    public long getUniversityRollNumber() {
        return universityRollNumber;
    }

    public char getSection() {
        return section;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public String getCourse() {
        return course.get();
    }

    public SimpleStringProperty courseProperty() {
        return course;
    }

    public UserName getUserName() {
        return userName;
    }

    public Password getPassword() {
        return password;
    }

    public Map<SubjectCode, Subject> getSubjectList() {
        return subjectList;
    }

    public void addNewSubject(SubjectCode subjectCode, Subject subject) {
        subjectList.put(subjectCode, subject);
    }

    @Override
    public int compareTo(Student o) {
        return Long.compare(this.getUniversityRollNumber(), o.getUniversityRollNumber());
    }
}
