/**
 * Titre :        Exercise 41
 * Description :  Figures géométriques
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class Triangle extends Polygon {

        public Triangle(double a, double b, double c)
	{
		super(3);
		lin[0]=a;
		lin[1]=b;
	        lin[2]=c;
        }
}