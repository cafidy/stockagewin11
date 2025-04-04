/**
 * Titre :        Exercise 34
 * Description :  Tableaux de tableaux
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class DoubleArray {

	public static boolean regular(double[][] t)
	{
		int n=t[0].length;
		for (int i=1 ; i<t.length;i++)
			if (t[i].length != n)
				return false;
			return true;
	}

        public static double[] lineSum(double[][] t)
	{
	        int nLines=t.length;
		double[] res=new double[nLines];
		for (int i=0; i<nLines; i++)
		{
			res[i]=0.;
			for (int j=0;j<t[i].length;j++)
				res[i]+=t[i][j];
		}
		return res;
        }

        public static double[][] sum(double[][] t1,double[][] t2)
	{
		if (!regular(t1) || !regular(t2))
			return null;
		if (t1.length!=t2.length)
			return null;
		if (t1[0].length!=t2[0].length)
			return null;
		int nLin=t1.length; int nRow=t1[0].length;
		double[][] su=new double[nLin][nRow];
		for (int i=0;i<nLin;i++)
			for (int j=0;j<nRow;j++)
				su[i][j]=t1[i][j]+t2[i][j];
		return su;
	}

	public static void display(double[][] t)
	{
		for (int i=0;i<t.length;i++)
		{
			for (int j=0;j<t[i].length;j++)
				System.out.print(t[i][j]+" ");
			System.out.println();
		}
	}
}