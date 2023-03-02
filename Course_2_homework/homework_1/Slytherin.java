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

    public void comparePupilsSlytherin() {
        int max = Integer.MIN_VALUE;
        int count = 0;
        int bestPupil = 0;
        ArrayList<Slytherin> slytherin = Main.fillSlytherin();
        int[] twoPupils = new int[2];
        System.out.println("Слизерин");
        for (int i = 0; i < twoPupils.length; i++) {
            twoPupils[i] = random.nextInt(0, slytherin.size());
            System.out.println(slytherin.get(twoPupils[i]));
            int sum = slytherin.get(twoPupils[i]).getTrickiness()
                    + slytherin.get(twoPupils[i]).getResoluteness()
                    + slytherin.get(twoPupils[i]).getAmbition()
                    + slytherin.get(twoPupils[i]).getReadiness()
                    + slytherin.get(twoPupils[i]).getAuthority_hunger();
            if (sum > max) {
                count = bestPupil;
                max = sum;
                bestPupil = twoPupils[i];
            } else {
                count = twoPupils[i];
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
