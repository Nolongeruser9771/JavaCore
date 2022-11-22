public class Student {
    private int id;
    private String name;
    private float scoreMath;
    private float scorePhysic;
    private float scoreChemistry;

    private float scoreAverage;
    private String rank;

    public Student(int id, String name, float scoreMath, float scorePhysic, float scoreChemistry, float scoreAverage, String rank) {
        this.id = id;
        this.name = name;
        this.scoreMath = scoreMath;
        this.scorePhysic = scorePhysic;
        this.scoreChemistry = scoreChemistry;
        this.scoreAverage = scoreAverage;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScoreMath() {
        return scoreMath;
    }

    public void setScoreMath(float scoreMath) {
        this.scoreMath = scoreMath;
    }

    public float getScorePhysic() {
        return scorePhysic;
    }

    public void setScorePhysic(float scorePhysic) {
        this.scorePhysic = scorePhysic;
    }

    public float getScoreChemistry() {
        return scoreChemistry;
    }

    public void setScoreChemistry(float scoreChemistry) {
        this.scoreChemistry = scoreChemistry;
    }

    public float getScoreAverage() {
        return scoreAverage;
    }

    public void setScoreAverage(float scoreAverage) {
        this.scoreAverage = scoreAverage;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scoreAverage=" + scoreAverage +
                ", rank='" + rank + '\'' +
                '}';
    }
}
