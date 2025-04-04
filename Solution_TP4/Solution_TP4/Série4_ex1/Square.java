/**
 * Titre :        Exercise 41
 * Description :  Figures géométriques
 * Copyright :    Copyright (c) 2002
 * Société :
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