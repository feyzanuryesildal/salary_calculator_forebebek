package ebebek_case;
public class EmployeeManager {
    EmployeeInfo employeeInfo=new EmployeeInfo();
    EmployeeModel employeeModel;
    double taxValue=0;
    double bonusValue=0;
    double salaryIncreaseValue=0;
    double firstSalary=0;

    EmployeeManager(EmployeeModel employeeModel) {
        this.employeeModel=employeeModel;
    }


    public void tax(EmployeeModel employeeModelVariable) { // maaşa uygulanan vergiyi hesaplar.
        firstSalary= employeeModel.get_salary();

        if(employeeModelVariable.get_salary() < employeeInfo.MIN_SALARY) {
            employeeModel.set_salary(employeeModelVariable.get_salary());
        }  else {
            employeeModel.set_salary((employeeModelVariable.get_salary() - ((employeeModelVariable.get_salary()*employeeInfo.MIN_SALARY_TAX)/100)));
            taxValue=employeeInfo.MIN_SALARY_TAX;
        }

    }

    public void bonus(EmployeeModel employeeModelVariable) {
        double shift;
        int bonusType=0;
        if(employeeModelVariable.get_workHours()>employeeInfo.WORKING_HOUR){
            shift=employeeModelVariable.get_workHours()-employeeInfo.WORKING_HOUR;
            shift=Math.round(shift);
            for(int i=0; i<shift; i++){
                bonusType+=employeeInfo.WORKING_HOUR_MONEY_BONUS;
            }
        }
        bonusValue=bonusType;
        employeeModel.set_salary(employeeModel.get_salary()+bonusType);
    }

    public void raiseSalary(){
        bonus(employeeModel);
        tax(employeeModel);
        if((employeeInfo.NOW_YEAR-employeeModel.get_hireYear())<employeeInfo.UNDER_YEAR){
             employeeModel.set_salary(employeeModel.get_salary()+((employeeModel.get_salary()*employeeInfo.UNDER_YEAR_RAISE)/100));
             salaryIncreaseValue=employeeModel.get_salary()-firstSalary;
        }
        else if((employeeInfo.NOW_YEAR-employeeModel.get_hireYear())>employeeInfo.BETWEEN_YEAR[0] && (employeeInfo.NOW_YEAR-employeeModel.get_hireYear())<employeeInfo.BETWEEN_YEAR[1] ){
             employeeModel.set_salary(employeeModel.get_salary()+((employeeModel.get_salary()*employeeInfo.BETWEEN_YEAR_RAISE)/100));
            salaryIncreaseValue=employeeModel.get_salary()-firstSalary;
        }
        else{
             employeeModel.set_salary(employeeModel.get_salary()+((employeeModel.get_salary()*employeeInfo.MAX_YEAR_RAISE)/100));
            salaryIncreaseValue=employeeModel.get_salary()-firstSalary;
        }
    }

    public String toString() {
        System.out.println("Employee Name:"+employeeModel.get_name());
        System.out.println("Employee First Salary:"+firstSalary);
        System.out.println("Employee Salary:"+employeeModel.get_salary());
        System.out.println("Employee Work Hours:"+employeeModel.get_workHours());
        System.out.println("Employee Hire Year:"+employeeModel.get_hireYear());
        System.out.println("Employee Salary Tax:"+taxValue);
        System.out.println("Employee Salary Bonus:"+bonusValue);
        System.out.println("Employee Salary Increase:"+salaryIncreaseValue);
        return " ";

    }



}
