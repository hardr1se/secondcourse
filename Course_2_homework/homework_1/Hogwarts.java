package homework_1;

import java.util.ArrayList;
import java.util.Random;

public class Hogwarts {
    Random random = new Random();
    private String fullName;
    private int power;
    private int transgressionRange;

    public Hogwarts(String fullName) {
        this.fullName = fullName;
        this.power = random.nextInt(0,10);
        this.transgressionRange = random.nextInt(0,10_000);
    }

    public String getFullName() {
        return fullName;
    }

    public int getPower() {
        return power;
    }

    public int getTransgressionRange() {
        return transgressionRange;
    }

    public void comparePupilsPower() {
        ArrayList<Hogwarts> hogwarts = Main.fillHogwarts();
        int bestPower = Integer.MIN_VALUE;
        int bestPupil = 0;
        int count = 0;
        int[] twoPupils = new int[2];
        for (int i = 0; i < twoPupils.length; i++) {
            twoPupils[i] = random.nextInt(0,hogwarts.size());
            System.out.println(hogwarts.get(twoPupils[i]));
            if (hogwarts.get(twoPupils[i]).getPower() > bestPower) {
                count = bestPower;
                bestPower = hogwarts.get(twoPupils[i]).getPower();
                bestPupil = twoPupils[i];
            } else {
                count = twoPupils[i];
            }
        }
        System.out.println("\n" + hogwarts.get(bestPupil).getFullName()
                + " обладает большей мощностью магии, чем " + hogwarts.get(count).getFullName() + "\n");
    }

    public void comparePupilsTransgressionRange() {
        ArrayList<Hogwarts> hogwarts = Main.fillHogwarts();
        int bestTransgression = Integer.MIN_VALUE;
        int bestPupil = 0;
        int count = 0;
        int[] twoPupils = new int[2];
        for (int i = 0; i < twoPupils.length; i++) {
            twoPupils[i] = random.nextInt(0,hogwarts.size());
            System.out.println(hogwarts.get(twoPupils[i]));
            if (hogwarts.get(twoPupils[i]).getTransgressionRange() > bestTransgression) {
                count = bestPupil;
                bestTransgression = hogwarts.get(twoPupils[i]).getTransgressionRange();
                bestPupil = twoPupils[i];
            } else {
                count = twoPupils[i];
            }
        }
        System.out.println("\n" + hogwarts.get(bestPupil).getFullName()
                + " может трансгрессировать на большее растояние, чем "
                + hogwarts.get(count).getFullName() + "\n");
    }

    @Override
    public String toString() {
        return getFullName() + " уровень магии = " + getPower()
                + ", максимальное расстояние трансгрессии = " + getTransgressionRange();
    }
}
