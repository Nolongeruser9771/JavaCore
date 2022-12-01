package entities;

public class Member extends Person{

    private static int AUTO_REWARD;
    private int rewardPoint;
    private String username;
    private String password;

    public Member(String name, String phone, String address, String email, String username, String password) {
        super(name, phone, address, email, "MEMBER");
        this.rewardPoint = ++AUTO_REWARD;
        this.username = username;
        this.password = password;
    }

    public int getRewardPoint() {
        return rewardPoint;
    }

    public void setRewardPoint(int rewardPoint) {
        this.rewardPoint = rewardPoint;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
