/**
 * Titre :        Exercice 33
 * Description :  Vectors
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

	public String toString()
	{
		return "x : "+x+" , y : "+y+" , z : "+z;
	}

	public static void swap(Vector v1, Vector v2)
	{
		Vector t=new Vector(v1.x,v1.y,v1.z);
		v1.x=v2.x; v1.y=v2.y; v1.z=v2.z;
		v2.x=t.x; v2.y=t.y; v2.z=t.z;
	}
}

public class exer33 {
        public static void main(String[] args) {
		Vector v1=new Vector(1,2,3);
		Vector v2=new Vector(4,5,6);
		System.out.println(v1);
		System.out.println(v2);
		Vector.swap(v1,v2);
		System.out.println(v1);
		System.out.println(v2);
        }
}