/**
 * Titre :        Exercise 41
 * Description :  Figures géométriques
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class Quadri extends Polygon {

        public Quadri(double a,double b,double c,double d)
	{
		super(4);
		lin[0]=a;
		lin[1]=b;
	        lin[2]=c;
		lin[3]=d;
	}
}