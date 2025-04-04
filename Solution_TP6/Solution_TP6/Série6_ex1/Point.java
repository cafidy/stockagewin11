package exer61;

/**
 * Titre :        Série 6 exercice 1
 * Description :  List of displayable objects
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class Point implements Displayable {

	int x,y;

        public Point(int a,int b)
	{
        	x=a;
	        y=b;
	}
	public void display()
	{
		System.out.println("x="+x+" , y="+y);
	}

}