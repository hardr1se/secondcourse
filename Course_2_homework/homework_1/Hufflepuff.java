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

    public void comparePupilsHufflepuff() {
        int max = Integer.MIN_VALUE;
        int count = 0;
        int bestPupil = 0;
        ArrayList<Hufflepuff> hufflepuff = Main.fillHufflepuff();
        int[] twoPupils = new int[2];
        System.out.println("Пуффендуй");
        for (int i = 0; i < twoPupils.length; i++) {
            twoPupils[i] = random.nextInt(0, hufflepuff.size());
            System.out.println(hufflepuff.get(twoPupils[i]));
            int sum = hufflepuff.get(twoPupils[i]).getHard_working()
                    + hufflepuff.get(twoPupils[i]).getLoyalty()
                    + hufflepuff.get(twoPupils[i]).getHonesty();
            if (sum > max) {
                count = bestPupil;
                max = sum;
                bestPupil = twoPupils[i];
            } else {
                count = twoPupils[i];
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
