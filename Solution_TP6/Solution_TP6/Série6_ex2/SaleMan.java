package exer62;


/**
 * Titre :        Série 6 exercice 2
 * Description :  Exceptions on employees
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class SaleMan extends Employee {

  private double turnover = -1.0,
                 fixed = -1.0;

  private static double totalTurnover;

  private static final double TurnoverPercent = 1.0;

  public SaleMan(String name, double fixed, double turnover) {
    super(name);
    this.fixed = fixed;
    this.turnover = turnover;
    totalTurnover += turnover;
  }

  public SaleMan(String name) {
    super(name);
  }

  public void setSalaryInfo(double fixed, double turnover) {
    this.fixed = fixed;
    if (this.turnover != -1) {
      totalTurnover += turnover - this.turnover;
    }
    else {
      totalTurnover += turnover;
    }
    this.turnover = turnover;
  }

  public double getSalary() {
    if (turnover != -1.0 && fixed != -1.0) {
      return Employee.getBonus() + fixed + (TurnoverPercent * turnover) / 100;
    }
    else {
      return -1.0;
    }
  }

  static double getTotalTurnover() {
    return totalTurnover;
  }
}


