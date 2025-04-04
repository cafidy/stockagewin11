

/**
 * Titre :        Exercise 1b2
 * Description :  ax2+bx+c
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class exer1b2 {
        public static void main(String[] args) {

		int a=1,b=8,c=2,det;
		det=(b*b)-(4*a*c);
		if (det<0)
			System.out.println("No solution\n");
		else if (det==0)
			System.out.println("One solution : "+(-b/(2*a)));
		else
			System.out.println("Two solutions : "+(-b+Math.sqrt(det))/(2*a)+" and "+(-b-Math.sqrt(det))/(2*a));
	}
}