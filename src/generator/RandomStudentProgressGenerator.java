package generator;

import entity.StudentProgress;

import java.util.Random;

public class RandomStudentProgressGenerator implements EntityGenerator<StudentProgress> {
    private static final int EXCELLENT_RATING = 0; // only 5 marks
    private static final int GOOD_RATING = 1; // marks between 4 and 5
    private static final int MIXED_RATING = 2; // marks between 2 and 5

    private Random random = new Random();

    @Override
    public StudentProgress generate() {
        int randomRating = random.nextInt(10);

        switch (randomRating) {
            case EXCELLENT_RATING:
                return new StudentProgress()
                        .setArtMark(5)
                        .setBiologyMark(5)
                        .setChemistryMark(5)
                        .setEconomicsMark(5)
                        .setMathematicsMark(5)
                        .setPhysicsMark(5)
                        .setPsychologyMark(5);
            case GOOD_RATING:
                return new StudentProgress()
                        .setArtMark(generateMark(4))
                        .setBiologyMark(generateMark(4))
                        .setChemistryMark(generateMark(4))
                        .setEconomicsMark(generateMark(4))
                        .setMathematicsMark(generateMark(4))
                        .setPhysicsMark(generateMark(4))
                        .setPsychologyMark(generateMark(4));
            case MIXED_RATING:
                return new StudentProgress()
                        .setArtMark(generateMark(2))
                        .setBiologyMark(generateMark(2))
                        .setChemistryMark(generateMark(2))
                        .setEconomicsMark(generateMark(2))
                        .setMathematicsMark(generateMark(2))
                        .setPhysicsMark(generateMark(2))
                        .setPsychologyMark(generateMark(2));
            default: // creates student progress with marks between 3 and 5
                return new StudentProgress()
                        .setArtMark(generateMark(3))
                        .setBiologyMark(generateMark(3))
                        .setChemistryMark(generateMark(3))
                        .setEconomicsMark(generateMark(3))
                        .setMathematicsMark(generateMark(3))
                        .setPhysicsMark(generateMark(3))
                        .setPsychologyMark(generateMark(3));
        }
    }

    /**
     * @param lowBound
     * @return mark between low bound and 5 inclusive
     */
    private int generateMark(int lowBound) {
        while (true) {
            int mark = random.nextInt(6);
            if (mark >= lowBound) {
                return mark;
            }
        }
    }
}
