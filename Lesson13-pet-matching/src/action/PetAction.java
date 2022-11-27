package action;

import constant.SexConstant;
import constant.TypeConstant;
import entities.Pet;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class PetAction {
    private int AUTO_ID = 20;

    public Pet inputInfo(Scanner scanner) {
        System.out.println("Mời nhập tên pet của bạn");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập giống pet");
        String species = scanner.nextLine();
        String ageInput;
        do {
            System.out.println("Mời bạn nhập tuổi");
            ageInput = scanner.nextLine();
        } while (!checkValidAge(ageInput));
        int age = Integer.parseInt(ageInput);

        String sexChoiceInput;
        do {
            System.out.println("Mời bạn nhập giới tính");
            System.out.println("1. Male");
            System.out.println("2. Female");
            sexChoiceInput = scanner.nextLine();
        } while (!checkChoice(sexChoiceInput));
        int sexChoice = Integer.parseInt(sexChoiceInput);
        String sex = sexReturn(sexChoice);

        System.out.println("Mời bạn nhập mô tả");
        String description = scanner.nextLine();

        String typeChoiceInput;
        do {
            System.out.println("Mời bạn chọn chủng loại pet");
            System.out.println("1. DOG");
            System.out.println("2. CAT");
            typeChoiceInput = scanner.nextLine();
        } while (!checkChoice(typeChoiceInput));
        int typeChoice = Integer.parseInt(typeChoiceInput);
        String type= typeReturn(typeChoice);

        System.out.println("Mời bạn nhập tên ảnh");
        String images = scanner.nextLine();

        AUTO_ID++;
        Pet pet = new Pet(AUTO_ID,name,species,age,sex,description,type,images);
        System.out.println("Thành công nhập thông tin pet");
        System.out.println(pet);
        return pet;
    }

    public void match(Pet petInput, Scanner scanner, ArrayList<Pet> pets) {
        int i = 0;
        Pet petInData = null;
        while (i < pets.size()) {
            if (pets.get(i).getTYPE().equals(petInput.getTYPE()) && !Objects.equals(pets.get(i).getSex(),petInput.getSex())) {
                petInData = pets.get(i);
                System.out.println(petInData);
                String choiceInput;
                do {
                    System.out.println("Bạn muốn match với pet này hay muốn tìm pet khác");
                    System.out.println("1. Match với pet này");
                    System.out.println("2. Tìm pet khác");
                    choiceInput = scanner.nextLine();
                } while (!checkChoice(choiceInput));
                int choice = Integer.parseInt(choiceInput);
                if (choice == 1) {
                    System.out.println("Pet của bạn sẽ được match với pet này");
                    System.out.println("Pet được match: \n" + petInData);
                    break;
                } else {
                    petInData = null;
                    i++;
                }
            }
            i++;
        }
        if (petInData==null) {
            System.out.println("Không có pet nào trong cửa hàng của chúng tôi phù hợp với pet của bạn");
        }
    }
    private static boolean checkValidAge(String ageInput) {
        int age;
        try {
            age = Integer.parseInt(ageInput);
            if (age<=0) {
                System.out.println("Tuổi không được là số âm");
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Sai định dạng tuổi");
            return false;
        }
    }

    public boolean checkChoice(String choiceInput) {
        try {
            int choice = Integer.parseInt(choiceInput);
            if (choice == 1 || choice == 2) {
                return true;
            }
            System.out.println("Không có lựa chọn " + choice);
            return false;
        } catch (Exception error) {
            System.out.println("Nhập sai định dạng");
            return false;
        }
    }

    private static String sexReturn(int choice) {
        String sex;
            if (choice == 1) {
                sex = SexConstant.M.value;
            } else {
                sex = SexConstant.F.value;
            }
        return sex;
    }

    private static String typeReturn(int choice) {
        String type;
            if (choice == 1) {
                type = TypeConstant.DOG.value;
            } else {
                type = TypeConstant.CAT.value;
            }
            return type;
        }
    }
