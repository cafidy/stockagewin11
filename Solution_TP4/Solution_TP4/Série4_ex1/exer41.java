/**
 * Titre :        Exercise 41
 * Description :  Figures g�om�triques
 * Copyright :    Copyright (c) 2002
 * Soci�t� :
 * @author SN
 * @version 1.0
 */

public class exer41 {
        public static void main(String[] args)
	{
		Quadri q=new Quadri(1,2,3,4);
	        Rectangle r=new Rectangle(1,2);
	        Square s=new Square(4);
	        Circle c=new Circle(1.0);
	        System.out.println("perimeter quadr : "+q.perimeter());
	        System.out.println("perimeter rect : "+r.perimeter());
		System.out.println("perimeter square : "+s.perimeter());
		System.out.println("perimeter circle : "+c.perimeter());
        }
}