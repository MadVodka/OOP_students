package entity;

public class Student {

    private String firstName;
    private String secondName;
    private Gender gender;
    private StudentProgress studentProgress;

    public Student(String firstName, String secondName, Gender gender, StudentProgress studentProgress) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.studentProgress = studentProgress;
    }

    public void setStudentProgress(StudentProgress studentProgress) {
        this.studentProgress = studentProgress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Gender getGender() {
        return gender;
    }

    public StudentProgress getStudentProgress() {
        return studentProgress;
    }
}
