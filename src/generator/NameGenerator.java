package generator;

import entity.Gender;
import holder.NameHolder;

import java.util.Random;

public class NameGenerator {
    private Random random = new Random();

    public String generateFirstName(Gender gender) {
        if (gender == Gender.FEMALE) {
            return NameHolder.femaleFirstName[random.nextInt(NameHolder.femaleFirstName.length)];
        } else {
            return NameHolder.maleFirstName[random.nextInt(NameHolder.maleFirstName.length)];
        }
    }

    public String generateSecondName() {
        return NameHolder.secondName[random.nextInt(NameHolder.secondName.length)];
    }
}
