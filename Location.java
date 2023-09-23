package eventorganizer;

public enum Location {
    HLL114 ("Hill Center", "Busch"),
    ARC103 ("Allison Road Classroom", "Busch"),
    BE_AUD ("Beck Hall", "Livingston"),
    TIL232 ("Tillett Hall", "Livingston"),
    AB2225 ("Academic Building", "College Avenue"),
    MU302 ("Murray Hall", "College Avenue");

    private final String building;
    private final String campus;

    Location(String building, String campus) {
        this.building = building;
        this.campus = campus;
    }

    @Override
    public String toString() {
        return this.name() + " (" + this.building + ", " + this.campus + ")";
    }
}

