package eventorganizer;

public enum Department {
    CS ("Computer Science"),
    EE ("Electrical Engineering"),
    ITI ("Information Technology and Informatics"),
    MATH ("Mathematics"),
    BAIT ("Business Analytics and Information Technology");

    private final String name;

    Department(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
