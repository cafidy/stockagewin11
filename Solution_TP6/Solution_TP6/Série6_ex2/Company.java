package exer62;
import java.util.*;

/**
 * Titre :        Série 6 exercice 2
 * Description :  Exceptions on employees
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class Company {
  private String name;
  private ArrayList employees;
  private boolean alreadyDirected = false;

  // Total des CA des commerciaux
  private double totalTurnover;

  public Company(String name) {
    this.name = name;
    employees = new ArrayList();
  }

  public String getName() {
    return name;
  }

  public void ajouter(Employee emp) throws EmployeeException {
    // Vérification pour ne pas avoir de contradiction
    // entre l'entreprise d'un employé et la liste "employees"
    if (emp.getCompany() != this) {
      throw new EmployeeException("Anomalie avec entreprise de l'employé "
				 + emp.getName(),
				 emp);
    }
    // Traitement spécial pour n'avoir qu'un Director par entreprise
    if (emp instanceof Director) {
      if (! alreadyDirected) {
	employees.add(emp);
	alreadyDirected = true;
      }
      else { // Déjà un Director
	throw new EmployeeException("Pas possible d'ajouter un 2ème Director",
				   emp);;
      }
    }
    else { // ça n'est pas un Director
      employees.add(emp);
       if (emp instanceof SaleMan) {
	 totalTurnover += ((SaleMan)emp).getTotalTurnover();
       }
    }
  }

  public void enlever(Employee emp) throws EmployeeException {
    if (emp.getCompany() != null) {
      throw new EmployeeException("Anomalie avec entreprise de l'employé "
				 + emp.getName()
				 + " qui est dans entreprise "
				 + emp.getCompany(),
				 emp);
    }
    if (emp instanceof Director) {
      if (employees.remove(emp)) {
	alreadyDirected = false;
      }
      else { // ne devrait jamais arriver !
	throw new EmployeeException("Director " + emp.getName()
				   + " a disparu de la liste employés",
				   emp);
      }
    }
    else { // pas un Director
      employees.remove(emp);
      // Il faut mettre l'entreprise de l'employé à null

      if (emp instanceof SaleMan) {
	totalTurnover -= ((SaleMan)emp).getTotalTurnover();
      }
    }
  }

  public boolean alreadyDirected() {
    return alreadyDirected;
  }

  public Iterator getEmployees() {
    return employees.iterator();
  }

  public List getEmployees2() {
    return employees;
  }

  public double gettotalTurnover() {
    return totalTurnover;
  }

  public String toString() {
    StringBuffer sb = new StringBuffer(name);
    for (int i = 0; i < employees.size(); i++) {
      sb.append("\n   " + ((Employee) employees.get(i)).getName());
    }
    return sb.toString();
  }

  public String toStringDetails() {
    StringBuffer sb = new StringBuffer(name);
    sb.append(" ; Total CA = " + totalTurnover);
    for (int i = 0; i < employees.size(); i++) {
      sb.append("\n   " + employees.get(i));
    }
    return sb.toString();
  }


  public static void main(String[] args) throws EmployeeException {
    Company e1 = new Company("IBM");
    Company e2 = new Company("Sun");
    Employee emp1 = new SaleMan("Dupond", 5000, 50000);
    emp1.setCompany(e1);
    System.out.println(e1);
    System.out.println(e2);
    new Hourly("Poiret", 42, 75.00, .25).setCompany(e1);
    System.out.println(e1);
    System.out.println(e2);
    new SaleMan("Ravier", 6000, 40000).setCompany(e2);
    System.out.println(e1);
    System.out.println(e2);
    new Hourly("Burot", 45, 105.00, .1).setCompany(e2);
    System.out.println(e1);
    System.out.println(e2);
    new SaleMan("Terrice", 3000, 70000).setCompany(e2);
    System.out.println(e1);
    System.out.println(e2);
    new Hourly("Pernaut", 32, 125.00, .2).setCompany(e2);
    System.out.println("Ajout Director Leroy");
    Director d1 = Director.createDirector("Leroy", 5000, e1);
    System.out.println(e1);
    System.out.println(e2);
    System.out.println("Ajout Director Leprince");
    Director.createDirector("Leprince", e1);
    System.out.println(e1);
    System.out.println(e2);

    System.out.println("Enlever Director Leroy");
    d1.leaveCompany();
    System.out.println("Ajout Director Leprince");
    Employee d2 = Director.createDirector("Leprince", 8000, e1);
    System.out.println(e1);
    System.out.println(e2);

    System.out.println("SaleMan Dupond passe chez Sun");
    emp1.setCompany(e2);
    System.out.println(e1);
    System.out.println(e2);

    System.out.println("Director Leroy passe chez Sun");
    d1.setCompany(e2);
    System.out.println(e1);
    System.out.println(e2);

    System.out.println("Director Leprince essaie de passer chez Sun");
    try {
      d2.setCompany(e2);
    }
    catch(EmployeeException e) {
      System.err.println(e);
    }
    System.out.println(d2);
    System.out.println(e1);
    System.out.println(e2);

    // On affiche tous les salaires
    System.out.println(e1.toStringDetails());
    System.out.println(e2.toStringDetails());
  }
}


