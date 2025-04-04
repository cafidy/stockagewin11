package exer62;

/**
 * Titre :        Série 6 exercice 2
 * Description :  Exceptions on employees
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class EmployeeException extends Exception{

        public EmployeeException(String s,Employee e) {
		super(s);
        }
}