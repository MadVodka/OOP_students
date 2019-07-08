package demo;

import entity.Student;
import entity.StudentProgress;
import generator.EntityGenerator;
import generator.RandomStudentGenerator;
import generator.RandomStudentProgressGenerator;
import repository.Group;
import service.GroupService;
import service.GroupServiceImpl;
import service.StudentMarksService;
import service.StudentMarksServiceImpl;

public class DemoServiceImpl implements DemoService {
    private GroupService groupService;
    private StudentMarksService studentMarksService;
    private Group group;
    private EntityGenerator<StudentProgress> randomStudentProgressGenerator;
    private EntityGenerator<Student> randomStudentGenerator;

    public DemoServiceImpl() {
        groupService = new GroupServiceImpl();
        studentMarksService = new StudentMarksServiceImpl();
        randomStudentProgressGenerator = new RandomStudentProgressGenerator();
        randomStudentGenerator = new RandomStudentGenerator(randomStudentProgressGenerator);
    }

    @Override
    public void start() {
        System.out.println("------ Demo start ------");
        createGroup();
        showAverageGroupMark();
        showAverageStudentMark();
        showAmountExcellentStudents();
        showAmountUnsuccessfulStudents();
        System.out.println("------ Demo end ------");
    }

    private void createGroup() {
        System.out.println("Generating a group...");
        Student[] students = new Student[15]; // for example 15 students
        for (int i = 0; i < students.length; i++) {
            students[i] = randomStudentGenerator.generate();
        }
        group = new Group(students);
    }

    private void showAverageGroupMark() {
        double averageMark = groupService.averageGroupMark(group, studentMarksService);
        System.out.println("Average mark of group #" + group + " is " + averageMark);
        System.out.println();
    }

    private void showAverageStudentMark() {
        System.out.println("------ Average students' mark ------");
        for (Student student : group.getStudents()) {
            StudentProgress studentProgress = student.getStudentProgress();
            System.out.println(student.getFirstName() + " " + student.getSecondName() + " - "
                    + studentMarksService.averageStudentMark(studentProgress));
        }
        System.out.println();
    }

    private void showAmountExcellentStudents() {
        int amount = groupService.amountStudentsWithAllExcellentMarks(group, studentMarksService);
        System.out.println("Amount of excellent students is " + amount);
        System.out.println();
    }

    private void showAmountUnsuccessfulStudents() {
        int amount = groupService.amountStudentsHavingUnsuccessfulMarks(group, studentMarksService);
        System.out.println("Amount of unsuccessful students is " + amount);
        System.out.println();
    }
}
