package exer62;

/**
 * Titre :        Série 6 exercice 2
 * Description :  Exceptions on employees
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class Director extends Employee {

  private static final double percentage = 0.4;

  private double fixed = -1;

  private static boolean alreadyExists = false;

  public static Director createDirector(String name,
					Company company)
      throws EmployeeException {
    return createDirector(name, -1, company);
  }

  public static Director createDirector(String name, double fixed,
					Company company)
      throws EmployeeException {
    if (! company.alreadyDirected()) {
      Director director = new Director(name, fixed);
      director.setCompany(company);
      return director;
    }
    else {
      System.err.println("A director already exists in company "
			 + company.getName() + " !");
      return null;
    }
  }

  private Director(String name) {
    super(name);
  }

  private Director(String name, double fixed) {
    super(name);
    this.fixed = fixed;
  }

  public void setSalaryInfo(double fixed) {
    this.fixed= fixed;
  }

  public double getSalary() {
    if (fixed != -1) {
      return Employee.getBonus() + fixed + SaleMan.getTotalTurnover() * percentage / 100;
    }
    else {
      return -1;
    }
  }

  public String toString() {
    return "Director " + super.toString();
  }

}


