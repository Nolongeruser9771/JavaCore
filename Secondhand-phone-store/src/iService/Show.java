package iService;

import java.util.ArrayList;

public class Show <E> {
    public void listShow(ArrayList<E> lists) {
        lists.forEach(System.out::println);
    }
    public void elementShow(E e) {
        System.out.println(e);
    }
}
