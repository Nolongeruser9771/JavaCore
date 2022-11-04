package Exercise01;


public class Student {
   String id;
   String name;
   String Class;
   String schoolYear;

   public void showInfo() {
      System.out.printf("%10s %20s %20s %20s\n","ID student","Student Name","Class", "School Year");
      System.out.printf("%10s %30s %10s %15s\n",id,name,Class,schoolYear);
   }
}
