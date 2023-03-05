package homework_1;

import java.util.Random;

public class Ravenclaw extends Hogwarts {

    private Random random = new Random();
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

    private int strength() {
        return wisdom + wit + creativity;
    }

    public void comparePupilsRavenclaw(Ravenclaw pupil) {
        int strength1 = strength();
        int strength2 = pupil.strength();
        if (strength1 > strength2) {
            System.out.println("Студент " + getFullName() + " общее количество очков которого равна " + strength1
                    + " лучший Когтеврановец, чем " + pupil.getFullName() + " с общим количеством очков " + strength2);
        } else if (strength1 < strength2) {
            System.out.println("Студент " + pupil.getFullName() + " общее количество очков которого равна " + strength2
                    + " лучший Когтеврановец, чем " + getFullName() + " с общим количеством очков " + strength1);
        } else {
            System.out.println("Студент " + pupil.getFullName() + " такой же Когтеврановец, как и студент " + getFullName()
                    + ": общее количество очков равен у каждого равно " + strength1);
        }
    }

    @Override
    public String toString() {
        return getFullName() + ": сила магии = " + getPower() + "максимальное расстояние трансгрессии "
                + getTransgressionRange() + ", мудрость = " + wisdom +
                ", остроумие = " + wit +
                ", креативность = " + creativity + ",\n уровень магии = " + getPower()
                + ", максимальное расстояние трансгрессии = " + getTransgressionRange();
    }
}
