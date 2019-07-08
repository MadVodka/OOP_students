package generator;

import entity.Gender;
import entity.Student;
import entity.StudentProgress;

import java.util.Random;

public class RandomStudentGenerator implements EntityGenerator<Student> {
    private EntityGenerator<StudentProgress> randomStudentProgressGenerator;
    private Random random = new Random();

    public RandomStudentGenerator(EntityGenerator<StudentProgress> randomStudentProgressGenerator) {
        this.randomStudentProgressGenerator = randomStudentProgressGenerator;
    }

    @Override
    public Student generate() {
        Gender gender = Gender.values()[random.nextInt(Gender.values().length)];

        NameGenerator nameGenerator = new NameGenerator();
        String firstName = nameGenerator.generateFirstName(gender);
        String secondName = nameGenerator.generateSecondName();

        StudentProgress studentProgress = randomStudentProgressGenerator.generate();

        return new Student(firstName, secondName, gender, studentProgress);
    }
}
