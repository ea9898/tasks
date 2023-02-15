package jm.three.two;

public class Human {
    private byte age;
    private String name;
    private String secondName;
    private String favoriteSport;

    public Human() {
    }

    public Human(byte age, String name, String secondName, String favoriteSport) {
        this.age = age;
        this.name = name;
        this.secondName = secondName;
        this.favoriteSport = favoriteSport;
    }

    public Human(byte age, String name, String secondName) {
        this.age = age;
        this.name = name;
        this.secondName = secondName;
    }
}
