package homework_1;

import java.util.Random;

public abstract class Hogwarts {
    private Random random = new Random();
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

    private int strength() {
        return power + transgressionRange;
    }

    public void comparePupilsPower(Hogwarts pupil) {
            int strength1 = strength();
            int strength2 = pupil.strength();
            if (strength1 > strength2) {
                System.out.println("Студент " + getFullName() + " сила которого равна " + strength1
                        + " сильнее, чем " + pupil.getFullName() + " с силой " + strength2);
            } else if (strength1 < strength2) {
                System.out.println("Студент " + pupil.getFullName() + " сила которого равна " + strength2
                        + " сильнее, чем " + getFullName() + " с силой " + strength1);
            } else {
                System.out.println("Студент " + pupil.getFullName() + " по силе равен студенту " + getFullName()
                        + ": общий показатель силы равен" + strength1);
            }
    }

    @Override
    public String toString() {
        return getFullName() + " уровень магии = " + getPower()
                + ", максимальное расстояние трансгрессии = " + getTransgressionRange();
    }
}
