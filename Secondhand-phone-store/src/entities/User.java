package entities;

import java.util.ArrayList;

public class User {

    private static int AUTO_ID;
    protected int id;
    protected String name;
    protected String phone;
    protected String address;
    protected String email;
    protected String username;
    protected String password;
    protected ArrayList<Order> orders;
    protected ArrayList<PreOrder> preOrders;
    protected int rewardPoint;
    protected String role;

    public User(String name, String phone, String address, String email, String username, String password,String role) {
        this.id = ++AUTO_ID;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
        this.rewardPoint = 0;
        this.orders = new ArrayList<>();
        this.preOrders = new ArrayList<>();
        this.role = role;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setRewardPoint(int rewardPoint) {
        this.rewardPoint = rewardPoint;
    }

    public int getRewardPoint() {
        return rewardPoint;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<PreOrder> getPreOrders() {
        return preOrders;
    }

    public void setPreOrders(ArrayList<PreOrder> preOrders) {
        this.preOrders = preOrders;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rewardPoint=" + rewardPoint +
                ", role='" + role + '\'' +
                '}';
    }
}
