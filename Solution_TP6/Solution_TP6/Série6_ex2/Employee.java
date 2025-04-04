package exer62;

/**
 * Titre :        Série 6 exercice 2
 * Description :  Exceptions on employees
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

 public class Employee {

  private String name;
  private static double bonus = -1;
  private Company company;

  public Employee(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public double getSalary() {
    return -1.0;
  }

  public void setSalaryInfo() {
  }

  public static void setBonus(double aBonus) {
    bonus = aBonus;
  }

  public static double getBonus() {
    return bonus;
  }

  public void setCompany(Company c)
	throws EmployeeException
  {
	if (company!=null)
		throw new EmployeeException("Already working for a company",this);
	this.company=c;
  }
  public Company getCompany()
  {
	return company;
  }

  public void leaveCompany()
  {
	company=null;
  }
}
