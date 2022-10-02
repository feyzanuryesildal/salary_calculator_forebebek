package projectntro;

public class employee {
	public String name;
	public int salary;
	public int workHours;
	public int hireYear;
	
	public void employee(String name , int salary,int workHours, int hireYear){
		name = this.name;
		salary = this.salary;
		workHours = this.workHours;
		hireYear = this.hireYear;
		
	}

	public int tax() { // maaşa uygulanan vergiyi hesaplar
		if(salary < 1000) {
			return salary;
		}  else {
			return (salary - salary%15);// vergi uygulanmış halde maaş ı döndür.
		}
		
	}
	
	public int bonus() {
		
			int bonus = workHours - 40;
			return bonus * 30;
		
		
	}
	
	public int raiseSalary(){
		if(2021 - hireYear < 10) {
			return salary = salary + salary%5;// %5 zam maaşına
		} else if (9 < (2021 - hireYear) && (2021 - hireYear) < 20) {
			return salary = salary + salary%10;// % 10 zam
		} else  {
			return salary = salary + salary%15;// % 15 zam
		}
		
	}
	
	public String toString() {
		System.out.println(name);
		System.out.println(salary);
		System.out.println(workHours);
		System.out.println(hireYear);
		return " ";
		
	}
	
	
}

