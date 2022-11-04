package Exercise02;


public class Student {
   String id;
   String name;
   String Class;
   String schoolYear;

   public void showInfo() {
         System.out.printf("%10s %25s %10s %15s\n",id,name,Class,schoolYear);
      }

   public String getName() {
      return name;
   }

   public String getStudentClass() {
      return Class;
   }
}
