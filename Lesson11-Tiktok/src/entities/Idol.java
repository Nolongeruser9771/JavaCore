package entities;

import java.util.ArrayList;

public class Idol {
    private String name;
    private int id;
    private String email;
    private String group;
    private ArrayList<Follower> followers;

    public Idol(String name, int id, String email, String group, ArrayList<Follower> followers) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.group = group;
        this.followers = followers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public ArrayList<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<Follower> followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "Idol{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", group='" + group + '\'' +
                ", followers=" + followers +
                '}';
    }
}
