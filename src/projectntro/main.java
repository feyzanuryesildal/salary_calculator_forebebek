package projectntro;

public class main {
public static void main(String[] args) {
        employee employee1= new employee();
        employee1.name = "ahmet";
        employee1.salary = 4000;
        employee1.workHours = 45;
        employee1.hireYear = 2020;
        System.out.println(employee1.tax());
        System.out.println(employee1.bonus());
        System.out.println(employee1.raiseSalary());
        
        employee1.toString();
       
    }
}
