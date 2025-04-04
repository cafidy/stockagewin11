

/**
 * Titre :        Exercise 22
 * Description :  Paire de Vectors
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

class Vector {
         int x, y, z;

         public Vector(int v1,int v2,int v3)
	{
	        x=v1;
	        y=v2;
	        z=v3;
	}

         public Vector(Vector v)
	{
	        x=v.x;
	        y=v.y;
	        z=v.z;
	}

	public void display()
	{
	        System.out.println(x+"  "+y+"  "+z);
	}
}

class PairVect
{
	Vector vector1, vector2;

	public PairVect(int a, int b, int c , int d, int e, int f)
	{
		vector1=new Vector(a,b,c);
		vector2=new Vector(a,b,c);
	}

	public PairVect(Vector v1,Vector v2)
	{
		vector1=new Vector(v1);
		vector2=new Vector(v2);
	}

	public void display()
	{
		vector1.display();
		vector2.display();
	}

	public Vector getFirst()
	{
		return vector1;
	}

	public Vector getSecond()
	{
		return vector2;
	}
}

public class exer22 {
        public static void main(String[] args) {
		PairVect pv= new PairVect(new Vector(1,2,3),new Vector(4,5,6));
		pv.display();
		pv.getFirst().display();
        }
}