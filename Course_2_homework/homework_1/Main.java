package homework_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Slytherin slytherin = new Slytherin("");
        slytherin.comparePupilsSlytherin();
        Gryffindor gryffindor = new Gryffindor("");
        gryffindor.comparePupilsGryffindor();
        Ravenclaw ravenclaw = new Ravenclaw("");
        ravenclaw.comparePupilsRavenclaw();
        Hufflepuff hufflepuff = new Hufflepuff("");
        hufflepuff.comparePupilsHufflepuff();
        Hogwarts hogwarts = new Hogwarts("");
        hogwarts.comparePupilsPower();
        hogwarts.comparePupilsTransgressionRange();
    }

    public static ArrayList<Hogwarts> fillHogwarts() {
        ArrayList<Hogwarts> hogwarts = new ArrayList<>();

        Gryffindor harry = new Gryffindor("Гарри Поттер");
        Gryffindor hermione = new Gryffindor("Гермиона Грейнджер");
        Gryffindor ron = new Gryffindor("Рон Уизли");
        Hufflepuff zaharia = new Hufflepuff("Захария Смит");
        Hufflepuff cedric = new Hufflepuff("Седрик Диггори");
        Hufflepuff justin = new Hufflepuff("Джастин Финч-Флетчли");
        Ravenclaw cho = new Ravenclaw("Чжоу Чанг");
        Ravenclaw padma = new Ravenclaw("Падма Патил");
        Ravenclaw marcus = new Ravenclaw("Маркус Белби");
        Slytherin draco = new Slytherin("Драко Малфой");
        Slytherin grachem = new Slytherin("Грэхэм Монтегю");
        Slytherin gregory = new Slytherin("Грегори Гойл");

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

        return hogwarts;
    }
    public static ArrayList<Gryffindor> fillGryffindor() {
        ArrayList<Gryffindor> gryffindor = new ArrayList<>();

        Gryffindor harry = new Gryffindor("Гарри Поттер");
        Gryffindor hermione = new Gryffindor("Гермиона Грейнджер");
        Gryffindor ron = new Gryffindor("Рон Уизли");

        gryffindor.add(harry);
        gryffindor.add(hermione);
        gryffindor.add(ron);

        return gryffindor;
    }
    public static ArrayList<Hufflepuff> fillHufflepuff() {
        ArrayList<Hufflepuff> hufflepuff = new ArrayList<>();

        Hufflepuff zaharia = new Hufflepuff("Захария Смит");
        Hufflepuff cedric = new Hufflepuff("Седрик Диггори");
        Hufflepuff justin = new Hufflepuff("Джастин Финч-Флетчли");

        hufflepuff.add(zaharia);
        hufflepuff.add(cedric);
        hufflepuff.add(justin);

        return hufflepuff;
    }
    public static ArrayList<Ravenclaw> fillRavenclaw() {
        ArrayList<Ravenclaw> ravenclaw = new ArrayList<>();

        Ravenclaw cho = new Ravenclaw("Чжоу Чанг");
        Ravenclaw padma = new Ravenclaw("Падма Патил");
        Ravenclaw marcus = new Ravenclaw("Маркус Белби");

        ravenclaw.add(cho);
        ravenclaw.add(padma);
        ravenclaw.add(marcus);

        return ravenclaw;
    }
    public static ArrayList<Slytherin> fillSlytherin() {
        ArrayList<Slytherin> slytherin = new ArrayList<Slytherin>();

        Slytherin draco = new Slytherin("Драко Малфой");
        Slytherin grachem = new Slytherin("Грэхэм Монтегю");
        Slytherin gregory = new Slytherin("Грегори Гойл");

        slytherin.add(draco);
        slytherin.add(grachem);
        slytherin.add(gregory);

        return slytherin;
    }
}
