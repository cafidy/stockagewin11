/**
 * Titre :        Exercise 41
 * Description :  Figures géométriques
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class Polygon extends GeomFig{

	int num;
	protected double[] lin;

        public Polygon(int num) {
        	lin=new double[this.num=num];
	}

	public double perimeter()
	{
		double p=0.0;
	        for (int i=0;i<num;i++)
	        	p+=lin[i];
	        return p;
	}
}