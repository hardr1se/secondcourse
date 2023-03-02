package homework_1;

import java.util.ArrayList;
import java.util.Random;

public class Gryffindor extends Hogwarts {
    Random random = new Random();
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

    public void comparePupilsGryffindor() {
        int max = Integer.MIN_VALUE;
        int count = 0;
        int bestPupil = 0;
        ArrayList<Gryffindor> gryffindor = Main.fillGryffindor();
        int[] twoPupils = new int[2];
        System.out.println("Гриффиндор");
        for (int i = 0; i < twoPupils.length; i++) {
            twoPupils[i] = random.nextInt(0, gryffindor.size());
            System.out.println(gryffindor.get(twoPupils[i]));
            int sum = gryffindor.get(twoPupils[i]).getNobleness()
                    + gryffindor.get(twoPupils[i]).getHonor()
                    + gryffindor.get(twoPupils[i]).getBravery();
            if (sum > max) {
                count = bestPupil;
                max = sum;
                bestPupil = twoPupils[i];
            } else {
                count = twoPupils[i];
            }
        }
        System.out.println("\n" + gryffindor.get(bestPupil).getFullName() + " лучший Гриффиндорец, чем "
                + gryffindor.get(count).getFullName() + "\n");
    }

    @Override
    public String toString() {
        return getFullName() + " благородство = " + getNobleness() +
                ", честь = " + getHonor() +
                ", храбрость = " + getBravery() + ",\n уровень магии = " + getPower()
                + ", максимальное расстояние трансгрессии = " + getTransgressionRange();
    }
}
