package hu.javalife.heroesofempire.species;


public class Species {
private String name,secs;

    public Species() {
    }

    public Species(String name, String secs) {
        this.name = name;
        this.secs = secs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecs() {
        return secs;
    }

    public void setSecs(String secs) {
        this.secs = secs;
    }
}
