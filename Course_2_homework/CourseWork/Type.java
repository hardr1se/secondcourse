package CourseWork;

public enum Type {
    PERSONAL("личная"),
    WORK ("рабочая");

    private final String values;

    Type(String values) {
        this.values = values;
    }

    public String getValues() {
        return values;
    }
}
