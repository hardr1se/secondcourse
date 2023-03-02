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

    public void comparePupilsRavenclaw() {
        int max = Integer.MIN_VALUE;
        int count = 0;
        int bestPupil = 0;
        ArrayList<Ravenclaw> ravenclaw = Main.fillRavenclaw();
        int[] twoPupils = new int[2];
        System.out.println("Когтевран");
        for (int i = 0; i < twoPupils.length; i++) {
            twoPupils[i] = random.nextInt(0, ravenclaw.size());
            System.out.println(ravenclaw.get(twoPupils[i]));
            int sum = ravenclaw.get(twoPupils[i]).getWisdom()
                    + ravenclaw.get(twoPupils[i]).getWit()
                    + ravenclaw.get(twoPupils[i]).getCreativity();
            if (sum > max) {
                count = bestPupil;
                max = sum;
                bestPupil = twoPupils[i];
            } else {
                count = twoPupils[i];
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
