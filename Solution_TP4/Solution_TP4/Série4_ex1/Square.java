/**
 * Titre :        Exercise 41
 * Description :  Figures g�om�triques
 * Copyright :    Copyright (c) 2002
 * Soci�t� :
 * @author SN
 * @version 1.0
 */

public class Square extends Rectangle {

        public Square(double a)
	{
		super(a,a);
        }

	public double perimeter()
	{
		System.out.print("Square ");
		return 4*lin[0];
	}
}