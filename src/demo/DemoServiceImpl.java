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
        createGroup();
        showAverageGroupMark();
    }

    private void createGroup() {
        System.out.println("Generating a group...");
        Student[] students = new Student[15];
        for (int i = 0; i < students.length; i++) {
            students[i] = randomStudentGenerator.generate();
        }
        group = new Group(students);
    }

    private void showAverageGroupMark() {
        double averageMark = groupService.averageGroupMark(group);
        System.out.println("Average mark of group #" + group + " is " + averageMark);
    }
}
