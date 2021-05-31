package edu.gcit.todo_18;

public class Sport {
    private String title;
    private String info;
    private final int sportsResource;

    public Sport(String title, String info, int sportsResource) {
        this.title = title;
        this.info = info;
        this.sportsResource= sportsResource;

    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getSportsResource() {
        return sportsResource;
    }
}
