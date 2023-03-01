package homework_1;

import java.util.ArrayList;
import java.util.Random;

public class Gryffindor extends Hogwarts {
    Random random = new Random();
    private int nobleness;
    private int bravery;
    private int honor;

    public Gryffindor(String fullName) {
        super(fullName);
        this.nobleness = random.nextInt(0, 33);
        this.bravery = random.nextInt(0, 33);
        this.honor = random.nextInt(0, 33);
    }

    public int getNobleness() {
        return nobleness;
    }

    public int getBravery() {
        return bravery;
    }

    public int getHonor() {
        return honor;
    }

    public static void comparePupilsGryffindor() {
        int max = Integer.MIN_VALUE; int count = 0;
        int bestPupil = 0;
        ArrayList<Gryffindor> gryffindor = Hogwarts.getGryffindor();
        System.out.println("Гриффиндор");
        for (int i = 0; i < gryffindor.size(); i++) {
            System.out.println(gryffindor.get(i));
            int sum = gryffindor.get(i).getNobleness()
                    + gryffindor.get(i).getBravery()
                    + gryffindor.get(i).getHonor();
            if (sum > max) {
                max = sum;
                bestPupil = i;
            } else {
                count = i;
            }
        }
        System.out.println("\n" + gryffindor.get(bestPupil).getFullName() + " лучший Гриффиндорец, чем "
                + gryffindor.get(count).getFullName() + "\n");
    }

    @Override
    public String toString() {
        return getFullName() + " благородство = " + nobleness +
                ", честь = " + honor +
                ", храбрость = " + bravery + ",\n уровень магии = " + getPower()
                + ", максимальное расстояние трансгрессии = " + getTransgressionRange();
    }
}
