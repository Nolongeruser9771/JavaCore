package main;

import action.PetAction;
import constant.SexConstant;
import constant.TypeConstant;
import entities.Pet;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Pet> pets = new ArrayList<>();
        PetAction petAction = new PetAction();
        Scanner scanner = new Scanner(System.in);

        //Khởi tạo dữ liệu cho ArrayList entities.Pet.
        Pet pet1= new Pet(1,"Puppy", "Toy Doodle",5, SexConstant.M.value, "Cool", TypeConstant.DOG.value, "image1");
        Pet pet2= new Pet(2, "Julian", "Doggy",2, SexConstant.F.value, "Cute", TypeConstant.DOG.value, "image2");
        Pet pet3= new Pet(3, "Nalie", "British Cat",3, SexConstant.F.value, "Sometimes so smart", TypeConstant.CAT.value, "image3");
        Pet pet4= new Pet(4, "Danel", "Toy Doodle",5, SexConstant.F.value, "Cool", TypeConstant.DOG.value, "image4");
        Pet pet5= new Pet(5, "Sullie", "Domestic Cat",1, SexConstant.M.value, "Like a boss", TypeConstant.CAT.value, "image5");
        Pet pet6= new Pet(6, "Talo", "Toy Doodle",5, SexConstant.M.value, "Cool", TypeConstant.DOG.value, "image6");
        Pet pet7= new Pet(7, "Pollo", "Bristish Cat",2, SexConstant.F.value, "Don't like people", TypeConstant.CAT.value, "image7");
        Pet pet8= new Pet(8, "LuLu", "Phu Quoc dog",1, SexConstant.F.value, "Strong", TypeConstant.DOG.value, "image8");
        Pet pet9= new Pet(9, "Tidy", "Domestic Cat",2, SexConstant.F.value, "Lazy and like milk", TypeConstant.CAT.value, "image9");
        Pet pet10= new Pet(10, "Lord", "Akira Dog",2, SexConstant.F.value, "Adorable", TypeConstant.DOG.value, "image10");
        Pet pet11= new Pet(11, "Shiba", "Shiba Inu",5, SexConstant.F.value, "Adorable and love jogging", TypeConstant.DOG.value, "image11");
        Pet pet12= new Pet(12, "Jollie", "Blue-eye Cat",5, SexConstant.M.value, "Beautiful", TypeConstant.CAT.value, "image13");
        Pet pet13= new Pet(13, "Kiki", "Alaska",1, SexConstant.M.value, "Cool", TypeConstant.DOG.value, "image13");
        Pet pet14= new Pet(14, "Susu", "American Cat",5, SexConstant.F.value, "Don't like vegetables", TypeConstant.CAT.value, "image14");
        Pet pet15= new Pet(15, "Sakamoto", "Shiba",5, SexConstant.M.value, "Aggressive", TypeConstant.DOG.value, "image15");
        Pet pet16= new Pet(16, "Takoyaki", "Blue-eye Cat",2, SexConstant.F.value, "Like taking shower", TypeConstant.CAT.value, "image16");
        Pet pet17= new Pet(17, "Taro", "Toy Doodle",2, SexConstant.M.value, "So small", TypeConstant.DOG.value, "image17");
        Pet pet18= new Pet(18, "Lovely", "Domestic Cat",4, SexConstant.M.value, "Cool", TypeConstant.CAT.value, "image18");
        Pet pet19= new Pet(19, "Kira", "Domestic Cat",2, SexConstant.F.value, "Adorable", TypeConstant.CAT.value, "image19");
        Pet pet20= new Pet(20, "Shui", "Domestic Dog",4, SexConstant.M.value, "Cool", TypeConstant.DOG.value, "image18");

        pets.add(pet1);
        pets.add(pet2);
        pets.add(pet3);
        pets.add(pet4);
        pets.add(pet5);
        pets.add(pet6);
        pets.add(pet7);
        pets.add(pet8);
        pets.add(pet9);
        pets.add(pet10);
        pets.add(pet11);
        pets.add(pet12);
        pets.add(pet13);
        pets.add(pet14);
        pets.add(pet15);
        pets.add(pet16);
        pets.add(pet17);
        pets.add(pet18);
        pets.add(pet19);
        pets.add(pet20);

        do{
            showMenu(scanner, petAction, pets);
        } while (isLoopMenu(petAction, scanner));
    }

    private static void showMenu(Scanner scanner, PetAction petAction, ArrayList<Pet> pets) {
        System.out.println("===== CHÀO MỪNG TỚI CỬA HÀNG THÚ CƯNG =====");
        System.out.println("Bạn cần nhập thông tin pet để phối giống");
        Pet pet = petAction.inputInfo(scanner);

        System.out.println("===== KẾT QUẢ MATCHING =====");
        petAction.match(pet, scanner, pets);
    }
    private static boolean isLoopMenu(PetAction petAction, Scanner scanner) {
        String choiceInput;
        do {
            System.out.println("Bạn có muốn nhập thông tin thú cưng để matching lại không?");
            System.out.println("1. Có");
            System.out.println("2. Không. Tôi muốn thoát");
            choiceInput = scanner.nextLine();
        }while (!petAction.checkChoice(choiceInput));
        int choice = Integer.parseInt(choiceInput);
        return choice == 1;
    }
}