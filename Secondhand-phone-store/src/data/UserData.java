package data;

import entities.User;

import java.util.ArrayList;

public class UserData {
    //Khởi tạo CSDL cho User
    public ArrayList<User> userData(ArrayList<User> users) {
        User member1 = new User("Nguyên", "0704690014", "BD", "nt@gmail.com", "Nguyen", "Nguyen@97", "MEMBER");
        User admin1 = new User("Nguyên", "0539174684", "BD", "nguyennt@gmail.com", "NguyenNguyen", "Nguyen@97", "ADMIN");

        users.add(member1);
        users.add(admin1);
        return users;
    }
}
