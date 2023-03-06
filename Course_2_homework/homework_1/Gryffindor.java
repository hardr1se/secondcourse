package homework_1;

import java.util.Random;

public class Gryffindor extends Hogwarts {
    private Random random = new Random();
    private int nobleness;
    private int honor;
    private int bravery;

    public Gryffindor(String fullName) {
        super(fullName);
        this.nobleness = random.nextInt(0,33);
        this.honor = random.nextInt(0,33);
        this.bravery = random.nextInt(0,33);
    }

    public int getNobleness() {
        return nobleness;
    }

    public int getHonor() {
        return honor;
    }

    public int getBravery() {
        return bravery;
    }

    private int strength() {
        return nobleness + honor + bravery;
    }

    public void comparePupilsGryffindor(Gryffindor pupil) {
        int strength1 = strength();
        int strength2 = pupil.strength();
        if (strength1 > strength2) {
            System.out.println("Студент " + getFullName() + " общее количество очков которого равна " + strength1
                    + " лучший Гриффиндорец, чем " + pupil.getFullName() + " с общим количеством очков " + strength2);
        } else if (strength1 < strength2) {
            System.out.println("Студент " + pupil.getFullName() + " общее количество очков которого равна " + strength2
                    + " лучший Гриффиндорец, чем " + getFullName() + " с общим количеством очков " + strength1);
        } else {
            System.out.println("Студент " + pupil.getFullName() + " такой же Гриффиндорец, как и студент " + getFullName()
                    + ": общее количество очков равен у каждого равно " + strength1);
        }
    }

    @Override
    public String toString() {
        return getFullName() + ": сила магии = " + getPower() + "максимальное расстояние трансгрессии "
                + getTransgressionRange() + ", благородство = " + getNobleness() +
                ", честь = " + getHonor() +
                ", храбрость = " + getBravery() + ",\n уровень магии = " + getPower()
                + ", максимальное расстояние трансгрессии = " + getTransgressionRange();
    }
}
