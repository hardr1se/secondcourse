package homework_1;

import java.util.ArrayList;
import java.util.Random;

public class Ravenclaw extends Hogwarts {
    Random random = new Random();
    private int wisdom;
    private int wit;
    private int creativity;

    public Ravenclaw(String fullName) {
        super(fullName);
        this.wisdom = random.nextInt(0, 33);
        this.wit = random.nextInt(0, 33);
        this.creativity = random.nextInt(0, 33);
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getWit() {
        return wit;
    }

    public int getCreativity() {
        return creativity;
    }

    public static void comparePupilsRavenclaw() {
        int max = Integer.MIN_VALUE; int count = 0;
        int bestPupil = 0;
        ArrayList<Ravenclaw> ravenclaw = Hogwarts.getRavenclaw();
        System.out.println("Когтевран");
        for (int i = 0; i < ravenclaw.size(); i++) {
            System.out.println(ravenclaw.get(i));
            int sum = ravenclaw.get(i).getWisdom()
                    + ravenclaw.get(i).getWit()
                    + ravenclaw.get(i).getCreativity();
            if (sum > max) {
                max = sum;
                bestPupil = i;
            } else {
                count = i;
            }
        }
        System.out.println("\n" + ravenclaw.get(bestPupil).getFullName() + " лучший Когтеврановец, чем "
                + ravenclaw.get(count).getFullName() + "\n");
    }

    @Override
    public String toString() {
        return getFullName() + " мудрость = " + wisdom +
                ", остроумие = " + wit +
                ", креативность = " + creativity + ",\n уровень магии = " + getPower()
                + ", максимальное расстояние трансгрессии = " + getTransgressionRange();
    }
}
