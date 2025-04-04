package exer62;

/**
 * Titre :        Série 6 exercice 2
 * Description :  Exceptions on employees
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

 public class Hourly extends Employee {

  private double nbHours = -1.0;
  private double hourRate = -1.0;
  private double ExtraHoursPercent = -1.0;
  private static final double DueHours = 39.0;

  public Hourly(String name) {
    super(name);
  }

   public Hourly(String name, double nbHours, double hourRate,
			 double ExtraHoursPercent) {
    super(name);
    this.nbHours = nbHours;
    this.hourRate = hourRate;
    this.ExtraHoursPercent = ExtraHoursPercent;
  }

  public void setSalaryInfo(double nbHours, double hourRate,
			      double ExtraHoursPercent) {
    this.nbHours = nbHours;
    this.hourRate = hourRate;
    this.ExtraHoursPercent = ExtraHoursPercent;
  }

  public double getNbHours() {
    return nbHours;
  }

  public double getHourRate() {
    return hourRate;
  }

  public double getExtraHoursPercent() {
    return ExtraHoursPercent;
  }

  public double getSalary() {
    if (nbHours != -1 && hourRate != -1 && ExtraHoursPercent != -1) {
      if (nbHours > DueHours) {
	return Employee.getBonus()
	  + hourRate * (DueHours +
			    (nbHours - DueHours)
			    * (1 + ExtraHoursPercent / 100));
      }
      else {
	return hourRate * nbHours;
      }
    }
    else {
      return -1;
    }
  }
}

