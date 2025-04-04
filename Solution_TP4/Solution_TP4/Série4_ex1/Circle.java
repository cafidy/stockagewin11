/**
 * Titre :        Exercise 41
 * Description :  Figures géométriques
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class Circle extends GeomFig {

	double rad;

        public Circle(double rad)
	{
		this.rad=rad;
        }
        public double perimeter()
	{
		return rad*2.14;
        }
}