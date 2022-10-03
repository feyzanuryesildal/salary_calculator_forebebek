package ebebek_case;
public class Main {
    public static void main(String[] args) {
        EmployeeModel employeeModel=new EmployeeModel();
        EmployeeManager employeeManager=new EmployeeManager(employeeModel);
        employeeModel.set_name("Feyzanur");
        employeeModel.set_salary(10000);
        employeeModel.set_workHours(50);
        employeeModel.set_hireYear(2019);
        
        employeeManager.raiseSalary();
        employeeManager.toString();




    }
}