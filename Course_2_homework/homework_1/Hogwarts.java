package homework_1;

import java.util.ArrayList;
import java.util.Random;

public class Hogwarts {

    Random random = new Random();
    private String fullName;
    private int power;
    private int transgressionRange;

    public Hogwarts(String fullName) {
        this.fullName = fullName;
        this.power = random.nextInt(0,10);
        this.transgressionRange = random.nextInt(0,10_000);
    }

    public static void main(String[] args) {
        Hogwarts.comparePupilsTransgressionRange();
        Hogwarts.comparePupilsPower();
        Gryffindor.comparePupilsGryffindor();
        Hufflepuff.comparePupilsHufflepuff();
        Ravenclaw.comparePupilsRavenclaw();
        Slytherin.comparePupilsSlytherin();
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

    private static ArrayList<Gryffindor> gryffindor = new ArrayList<Gryffindor>();
    private static ArrayList<Hufflepuff> hufflepuff = new ArrayList<Hufflepuff>();
    private static ArrayList<Ravenclaw> ravenclaw = new ArrayList<Ravenclaw>();
    private static ArrayList<Slytherin> slytherin = new ArrayList<Slytherin>();
    private static ArrayList<Hogwarts> hogwarts = new ArrayList<Hogwarts>();

    static {
        Gryffindor harry = new Gryffindor("Гарри Поттер");
        Gryffindor hermione = new Gryffindor("Гермиона Грейнджер");
        Gryffindor ron = new Gryffindor("Рон Уизли");
        gryffindor.add(harry);
        gryffindor.add(hermione);
        gryffindor.add(ron);

        Hufflepuff zaharia = new Hufflepuff("Захария Смит");
        Hufflepuff cedric = new Hufflepuff("Седрик Диггори");
        Hufflepuff justin = new Hufflepuff("Джастин Финч-Флетчли");
        hufflepuff.add(zaharia);
        hufflepuff.add(cedric);
        hufflepuff.add(justin);

        Ravenclaw cho = new Ravenclaw("Чжоу Чанг");
        Ravenclaw padma = new Ravenclaw("Падма Патил");
        Ravenclaw marcus = new Ravenclaw("Маркус Белби");
        ravenclaw.add(cho);
        ravenclaw.add(padma);
        ravenclaw.add(marcus);

        Slytherin draco = new Slytherin("Драко Малфой");
        Slytherin grachem = new Slytherin("Грэхэм Монтегю");
        Slytherin gregory = new Slytherin("Грегори Гойл");
        slytherin.add(draco);
        slytherin.add(grachem);
        slytherin.add(gregory);

        hogwarts.add(harry);
        hogwarts.add(hermione);
        hogwarts.add(ron);
        hogwarts.add(zaharia);
        hogwarts.add(cedric);
        hogwarts.add(justin);
        hogwarts.add(cho);
        hogwarts.add(padma);
        hogwarts.add(marcus);
        hogwarts.add(draco);
        hogwarts.add(grachem);
        hogwarts.add(gregory);
    }
    public static ArrayList<Gryffindor> getGryffindor() {
        return gryffindor;
    }
    public static ArrayList<Hufflepuff> getHufflepuff() {
        return hufflepuff;
    }
    public static ArrayList<Ravenclaw> getRavenclaw() {
        return ravenclaw;
    }
    public static ArrayList<Slytherin> getSlytherin() {
        return slytherin;
    }

    public static void comparePupilsPower() {
        int bestPower = Integer.MIN_VALUE;
        int bestPupil = 0; int extraPupil = 0;
        for (int i = 0; i < hogwarts.size(); i++) {
            System.out.println(hogwarts.get(i));
            if (hogwarts.get(i).getPower() > bestPower) {
                bestPower = hogwarts.get(i).getPower();
                bestPupil = i;
            } else {
                extraPupil = i;
            }
        }
        System.out.println("\n" + hogwarts.get(bestPupil).getFullName()
                + " обладает большей мощностью магии, чем " + hogwarts.get(extraPupil).getFullName() + "\n");
    }

    public static void comparePupilsTransgressionRange() {
        int bestTransgression = Integer.MIN_VALUE;
        int bestPupil = 0; int extraPupil = 0;
        for (int i = 0; i < hogwarts.size(); i++) {
            System.out.println(hogwarts.get(i));
            if (hogwarts.get(i).getTransgressionRange() > bestTransgression) {
                bestTransgression = hogwarts.get(i).getTransgressionRange();
                bestPupil = i;
            } else {
                extraPupil = i;
            }
        }
        System.out.println("\n" + hogwarts.get(bestPupil).getFullName()
                + " может трансгрессировать на большее растояние, чем "
                + hogwarts.get(extraPupil).getFullName() + "\n");
    }
}
