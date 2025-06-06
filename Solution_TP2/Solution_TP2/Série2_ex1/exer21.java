

/**
 * Titre :        Exercice 21
 * Description :  Vectors
 * Copyright :    Copyright (c) 2002
 * Soci�t� :
 * @author SN
 * @version 1.0
 */

class Vector {
        int x, y, z;
        static int total=0;

        public Vector()
	{
                total++;
	        x=y=z=0;
	}

        public Vector(int val)
	{
                total++;
	        x=y=z=val;
	}

        public Vector(int v1,int v2,int v3)
	{
                total++;
	        x=v1;
	        y=v2;
	        z=v3;
	}

	public void display()
	{
	        System.out.println(x+"  "+y+"  "+z);
	}

	public void multiply(int i)
	{
	        x*=i;
	        y*=i;
	        z*=i;
	}

	public int multiply(Vector v)
	{
	        return (int)(x*v.x + y*v.y + z*v.z);
	}

	public Vector sum(Vector v)
	{
		return new Vector(x+v.x,y+v.y,z+v.z);
	}

	public static int nbvect()
	{
	        return total;
	}

	public String toString()
	{
		return "x : "+x+" , y : "+y+" , z : "+z;
	}
}

public class exer21 {
        public static void main(String[] args) {
		Vector v=new Vector(1,2,3);
		v.multiply(6);
		v.sum(v).display();
		v.display();
		System.out.println(Vector.nbvect());
		System.out.println(v);
        }
}