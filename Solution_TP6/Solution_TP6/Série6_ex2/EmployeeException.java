package exer62;

/**
 * Titre :        S�rie 6 exercice 2
 * Description :  Exceptions on employees
 * Copyright :    Copyright (c) 2002
 * Soci�t� :
 * @author SN
 * @version 1.0
 */

public class EmployeeException extends Exception{

        public EmployeeException(String s,Employee e) {
		super(s);
        }
}