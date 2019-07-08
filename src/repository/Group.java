package repository;

import entity.Student;

public class Group {
    private static int idCounter = 1;
    private final int groupId = idCounter++;
    private Student[] students;

    public Group(Student[] students) {
        this.students = students;
    }

    public int getGroupId() {
        return groupId;
    }

    public Student[] getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return String.valueOf(groupId);
    }
}
