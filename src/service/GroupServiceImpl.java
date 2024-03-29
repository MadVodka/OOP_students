package service;

import entity.Student;
import repository.Group;

public class GroupServiceImpl implements GroupService {

    @Override
    public int groupSize(Group group) {
        return group.getStudents().length;
    }

    @Override
    public double averageGroupMark(Group group, StudentMarksService studentMarksService) {
        Student[] students = group.getStudents();
        double sumOfGroupMarks = 0;
        for (Student student : students) {
            sumOfGroupMarks += studentMarksService.averageStudentMark(student.getStudentProgress());
        }
        return sumOfGroupMarks / groupSize(group);
    }

    @Override
    public int amountStudentsWithAllExcellentMarks(Group group, StudentMarksService studentMarksService) {
        Student[] students = group.getStudents();
        int count = 0;
        for (Student student : students) {
            if (studentMarksService.isExcellentProgress(student.getStudentProgress())) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int amountStudentsHavingUnsuccessfulMarks(Group group, StudentMarksService studentMarksService) {
        Student[] students = group.getStudents();
        int count = 0;
        for (Student student : students) {
            if (studentMarksService.hasUnsuccessfulMarks(student.getStudentProgress())) {
                count++;
            }
        }
        return count;
    }
}
