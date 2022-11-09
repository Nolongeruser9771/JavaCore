package Exercise01;

import java.util.Scanner;

public class Reader extends Person {
    private int id;
    private String type;

    private static int AUTO_ID=0;

    public Reader() {
        if(AUTO_ID==0) {
            AUTO_ID=9999;
        }
        AUTO_ID++;
        this.id =AUTO_ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public void InputInfo() {
        super.InputInfo();
        System.out.println("To input reader type, please select options below: ");
        System.out.println("1. Student");
        System.out.println("2. Graduate Student");
        System.out.println("3. Graduate Student");

    int readerType;
    do {
        readerType = new Scanner(System.in).nextInt();
        if(readerType>=1 && readerType <=3) {
            break;
        }
        System.out.println("Wrong type. Please input type again: ");
    } while (true);

    switch (readerType) {
        case 1:
            this.type = ReaderConstantType.STUDENT;
            break;
        case 2:
            this.type = ReaderConstantType.GRADUATE;
            break;
        case 3:
            this.type = ReaderConstantType.LECTURER;
            break;
    }
}
}
