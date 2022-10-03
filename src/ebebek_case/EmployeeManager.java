package ebebek_case;
public class EmployeeManager {
    EmployeeInfo employeeInfo=new EmployeeInfo();
    EmployeeModel employeeModel;

    EmployeeManager(EmployeeModel employeeModel) {
        this.employeeModel=employeeModel;
    }


    public double tax(EmployeeModel employeeModelVariable) { // maaşa uygulanan vergiyi hesaplar.
        if(employeeModelVariable.get_salary() < employeeInfo.MIN_SALARY) {
            employeeModel.set_salary(employeeModelVariable.get_salary());        
        }  else {
            employeeModel.set_salary((employeeModelVariable.get_salary() - ((employeeModelVariable.get_salary()*employeeInfo.MIN_SALARY_TAX)/100)));
        }
        return ((employeeModelVariable.get_salary()*employeeInfo.MIN_SALARY_TAX)/100);
    }

    public double bonus(EmployeeModel employeeModelVariable) {
        double shift;
        int bonusType=0;
        if(employeeModelVariable.get_workHours()>employeeInfo.WORKING_HOUR){
            shift=employeeModelVariable.get_workHours()-employeeInfo.WORKING_HOUR;
            shift=Math.round(shift);
            bonusType= (int) (shift*employeeInfo.WORKING_HOUR_MONEY_BONUS);
        }
        employeeModel.set_salary(employeeModel.get_salary()+bonusType);
        return bonusType;
    }

    public double raiseSalary(){
        bonus(employeeModel);
        tax(employeeModel);

        if((employeeInfo.NOW_YEAR-employeeModel.get_hireYear())<employeeInfo.UNDER_YEAR){
             employeeModel.set_salary(employeeModel.get_salary()+((employeeModel.get_salary()*employeeInfo.UNDER_YEAR_RAISE)/100));
             return ((employeeModel.get_salary()*employeeInfo.UNDER_YEAR_RAISE)/100);
        }
        else if((employeeInfo.NOW_YEAR-employeeModel.get_hireYear())>employeeInfo.BETWEEN_YEAR[0] && (employeeInfo.NOW_YEAR-employeeModel.get_hireYear())<employeeInfo.BETWEEN_YEAR[1] ){
             employeeModel.set_salary(employeeModel.get_salary()+((employeeModel.get_salary()*employeeInfo.BETWEEN_YEAR_RAISE)/100));
             return ((employeeModel.get_salary()*employeeInfo.BETWEEN_YEAR_RAISE)/100);

        }
        else{
             employeeModel.set_salary(employeeModel.get_salary()+((employeeModel.get_salary()*employeeInfo.MAX_YEAR_RAISE)/100));
             return ((employeeModel.get_salary()*employeeInfo.MAX_YEAR_RAISE)/100);

        }

    }

    public String toString() { 
        System.out.println("Employee Name: "+employeeModel.get_name());
        System.out.println("Employee Salary: "+employeeModel.get_salary());
        System.out.println("Employee Work Hours: "+employeeModel.get_workHours());
        System.out.println("Employee Hire Year: "+employeeModel.get_hireYear());
        System.out.println("Employee tax: "+tax(employeeModel));
        System.out.println("Employee bonus: "+ bonus(employeeModel));
        System.out.println("Employee salary increase: "+ (raiseSalary()));
        System.out.println("Employee bonus and tax with salary: "+ (employeeModel.get_salary() - raiseSalary()) );
        return " ";

    }



}
