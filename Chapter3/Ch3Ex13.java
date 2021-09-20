class Employee{
    private String firstName;
    private String lastName;
    private double salary;

    public Employee() {}

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        if(salary > 0)
            this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double raiseSalary(double salary){
        return salary * 1.1;
    }
}

public class Ch3Ex13 {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Name", "Surname", 400);
        Employee emp2 = new Employee("Name2", "Surname2", 500);
        Employee emp3 = new Employee();

        emp3.setFirstName("Name3");
        emp3.setLastName("Surname3");
        emp3.setSalary(1000);

        //Yearly salary
        System.out.printf("%n%s have yearly salary: %.2f", emp1.getFirstName(), emp1.getSalary() * 12);
        System.out.printf("%n%s have yearly salary: %.2f%n", emp2.getFirstName(), emp2.getSalary() * 12);
        System.out.printf("%n%s have yearly salary: %.2f%n", emp3.getFirstName(), emp3.getSalary() * 12);

        //Yearly salary with raised monthly salary
        System.out.printf("%n%s %s have yearly salary: %.2f", emp1.getFirstName(),
                emp1.getLastName(), emp1.raiseSalary(emp1.getSalary()) * 12);
        System.out.printf("%n%s %s have yearly salary: %.2f", emp2.getFirstName(),
                emp2.getLastName(), emp2.raiseSalary(emp2.getSalary()) * 12);
        System.out.printf("%n%s %s have yearly salary: %.2f", emp3.getFirstName(),
                emp3.getLastName(), emp3.raiseSalary(emp3.getSalary()) * 12);

    }
}
