package homework_1;

import java.util.ArrayList;
import java.util.Random;

public class Hufflepuff extends Hogwarts {

    Random random = new Random();
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

    public static void comparePupilsHufflepuff() {
        int max = Integer.MIN_VALUE; int count = 0;
        int bestPupil = 0;
        ArrayList<Hufflepuff> hufflepuff = Hogwarts.getHufflepuff();
        System.out.println("Пуффендуй");
        for (int i = 0; i < hufflepuff.size(); i++) {
            System.out.println(hufflepuff.get(i));
            int sum = hufflepuff.get(i).getHard_working()
                    + hufflepuff.get(i).getLoyalty()
                    + hufflepuff.get(i).getHonesty();
            if (sum > max) {
                max = sum;
                bestPupil = i;
            } else {
                count = i;
            }
        }
        System.out.println("\n" + hufflepuff.get(bestPupil).getFullName() + " лучший Пуффендуец, чем "
                + hufflepuff.get(count).getFullName() + "\n");
    }

    @Override
    public String toString() {
        return getFullName() + " трудолюбие = " + hard_working +
                ", верность = " + loyalty +
                ", честность = " + honesty + ",\n уровень магии = " + getPower()
                + ", максимальное расстояние трансгрессии = " + getTransgressionRange();
    }
}
