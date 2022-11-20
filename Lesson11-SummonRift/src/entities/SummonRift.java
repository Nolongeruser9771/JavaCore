package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class SummonRift {
    private ArrayList<Team> teams;
    private LocalDate matchDate;

    public SummonRift(ArrayList<Team> teams, LocalDate matchDate) {
        this.teams = teams;
        this.matchDate = matchDate;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    @Override
    public String toString() {
        return "SummonRift{" +
                "teams=" + teams +
                ", matchDate=" + matchDate +
                '}';
    }
}
