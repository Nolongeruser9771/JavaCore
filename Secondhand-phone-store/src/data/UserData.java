package data;

import entities.User;

import java.util.ArrayList;

public class UserData {
    //Khởi tạo CSDL cho User
    public ArrayList<User> userData(ArrayList<User> users) {
        User user1 = new User("Nguyên", "0704690014", "BD", "nt@gmail.com", "Nguyen", "Nguyen@97", "MEMBER");
        User user2 = new User("Nguyên", "0704690014", "BD", "ntt@gmail.com", "NguyenNguyen", "Nguyen@97", "ADMIN");

        users.add(user1);
        users.add(user2);
        return users;
    }
}
