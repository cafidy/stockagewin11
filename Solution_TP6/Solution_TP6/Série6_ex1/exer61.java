package exer61;

/**
 * Titre :        Série 6 exercice 1
 * Description :  List of displayable objects
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class exer61 {
        public static void main(String[] args)
	{
        	MixedList lp=new MixedList();
		Point a=new Point(1,2), b=new Point(3,4), c=new Point(5,6), d=new Point(7,8);
		Vector v1=new Vector(1,2,3), v2=new Vector(4,5,6), v3=new Vector();
		lp.add(a);
		lp.add(b);
		lp.add(c);
		lp.add(d);
		lp.add(v1);
		lp.add(v2);
		lp.add(v3);
		lp.display();
	}
}