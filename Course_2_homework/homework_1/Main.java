package homework_1;

public class Main {
    public static void main(String[] args) {
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

        harry.comparePupilsPower(grachem);
        hermione.comparePupilsGryffindor(ron);
        zaharia.comparePupilsHufflepuff(cedric);
        cho.comparePupilsRavenclaw(marcus);
        draco.comparePupilsSlytherin(gregory);
    }
}
