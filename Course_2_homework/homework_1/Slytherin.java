package homework_1;

import java.util.Random;

public class Slytherin extends Hogwarts {

    private Random random = new Random();
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

    private int strength() {
        return trickiness + resoluteness + ambition + readiness + authority_hunger;
    }

    public void comparePupilsSlytherin(Slytherin pupil) {
        int strength1 = strength();
        int strength2 = pupil.strength();
        if (strength1 > strength2) {
            System.out.println("Студент " + getFullName() + " общее количество очков которого равна " + strength1
                    + " лучший Слизероновец, чем " + pupil.getFullName() + " с общим количеством очков " + strength2);
        } else if (strength1 < strength2) {
            System.out.println("Студент " + pupil.getFullName() + " общее количество очков которого равна " + strength2
                    + " лучший Слизероновец, чем " + getFullName() + " с общим количеством очков " + strength1);
        } else {
            System.out.println("Студент " + pupil.getFullName() + " такой же Слизероновец, как и студент " + getFullName()
                    + ": общее количество очков равен у каждого равно " + strength1);
        }
    }
    
    @Override
    public String toString() {
        return getFullName() + ": сила магии = " + getPower() + "максимальное расстояние трансгрессии "
                + getTransgressionRange() + ", хитрость = " + trickiness +
                ", решительность = " + resoluteness +
                ", амбициозность = " + ambition +
                ", находчивость = " + readiness +
                ", жажда власти = " + authority_hunger + ",\n уровень магии = " + getPower()
                + ", максимальное расстояние трансгрессии = " + getTransgressionRange();
    }
}
