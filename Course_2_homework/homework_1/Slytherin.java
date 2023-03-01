package homework_1;

import java.util.ArrayList;
import java.util.Random;

public class Slytherin extends Hogwarts {
    Random random = new Random();
    private int trickiness;
    private int resoluteness;
    private int ambition;
    private int readiness;
    private int authority_hunger;

    public Slytherin(String fullName) {
        super(fullName);
        this.trickiness = random.nextInt(0, 20);
        this.resoluteness = random.nextInt(0, 20);
        this.ambition = random.nextInt(0, 20);
        this.readiness = random.nextInt(0, 20);
        this.authority_hunger = random.nextInt(0, 20);
    }

    public int getTrickiness() {
        return trickiness;
    }

    public int getResoluteness() {
        return resoluteness;
    }

    public int getAmbition() {
        return ambition;
    }

    public int getReadiness() {
        return readiness;
    }

    public int getAuthority_hunger() {
        return authority_hunger;
    }

    public static void comparePupilsSlytherin() {
        int max = Integer.MIN_VALUE; int count = 0;
        int bestPupil = 0;
        ArrayList<Slytherin> slytherin = Hogwarts.getSlytherin();
        System.out.println("Слизерин");
        for (int i = 0; i < slytherin.size(); i++) {
            System.out.println(slytherin.get(i));
            int sum = slytherin.get(i).getTrickiness()
                    + slytherin.get(i).getResoluteness()
                    + slytherin.get(i).getAmbition()
                    + slytherin.get(i).getReadiness()
                    + slytherin.get(i).getAuthority_hunger();
            if (sum > max) {
                max = sum;
                bestPupil = i;
            } else {
                count = i;
            }
        }
        System.out.println("\n" + slytherin.get(bestPupil).getFullName() + " лучший Слизериновец, чем "
                + slytherin.get(count).getFullName() + "\n");
    }
    
    @Override
    public String toString() {
        return getFullName() + " хитрость = " + trickiness +
                ", решительность = " + resoluteness +
                ", амбициозность = " + ambition +
                ", находчивость = " + readiness +
                ", жажда власти = " + authority_hunger + ",\n уровень магии = " + getPower()
                + ", максимальное расстояние трансгрессии = " + getTransgressionRange();
    }
}
