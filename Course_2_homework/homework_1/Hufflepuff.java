package homework_1;

import java.util.Random;

public class Hufflepuff extends Hogwarts {

    private Random random = new Random();
    private int hard_working;
    private int loyalty;
    private int honesty;

    public Hufflepuff(String fullName) {
        super(fullName);
        this.hard_working = random.nextInt(0, 33);
        this.loyalty = random.nextInt(0, 33);
        this.honesty = random.nextInt(0, 33);
    }

    public int getHard_working() {
        return hard_working;
    }

    public int getLoyalty() {
        return loyalty;
    }

    public int getHonesty() {
        return honesty;
    }

    private int strength() {
        return hard_working + loyalty + honesty;
    }

    public void comparePupilsHufflepuff(Hufflepuff pupil) {
        int strength1 = strength();
        int strength2 = pupil.strength();
        if (strength1 > strength2) {
            System.out.println("Студент " + getFullName() + " общее количество очков которого равна " + strength1
                    + " лучший Пуффендуец, чем " + pupil.getFullName() + " с общим количеством очков " + strength2);
        } else if (strength1 < strength2) {
            System.out.println("Студент " + pupil.getFullName() + " общее количество очков которого равна " + strength2
                    + " лучший Пуффендуец, чем " + getFullName() + " с общим количеством очков " + strength1);
        } else {
            System.out.println("Студент " + pupil.getFullName() + " такой же Пуффендуец, как и студент " + getFullName()
                    + ": общее количество очков равен у каждого равно " + strength1);
        }
    }

    @Override
    public String toString() {
        return  getFullName() + ": сила магии = " + getPower() + "максимальное расстояние трансгрессии "
                + getTransgressionRange() + ", трудолюбие = " + hard_working +
                ", верность = " + loyalty +
                ", честность = " + honesty + ",\n уровень магии = " + getPower()
                + ", максимальное расстояние трансгрессии = " + getTransgressionRange();
    }
}
