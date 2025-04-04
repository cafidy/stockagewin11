package exer71;

/**
 * Titre :        Série 7 exercice 1
 * Description :  Naturals
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class exer71 {
        public static void main(String[] args)
	{
		try
		{
			NaturalInt n1=new NaturalInt(20), n2=new NaturalInt(12);
			NaturalInt d;
			d=NaturalInt.diff(n1,n2);
			d=NaturalInt.diff(n2,n1);
		}
		catch(NatErr e)
		{
			System.out.println("***** Natural error *****");
		}
		try
		{
			NaturalInt n3=new NaturalInt(50000), n4=new NaturalInt(45000);
			NaturalInt d=NaturalInt.diff(n3,n4);
			NaturalInt s=NaturalInt.sum(n3,n4);
			NaturalInt p=NaturalInt.prod(n3,n4);
		}
		catch(ConstErr e)
		{
			System.out.println("***** Construction error with argument "+e.n);
		}
		catch(DiffErr e)
		{
			System.out.println("***** Difference error with values "+e.n1+"  "+e.n2);
		}
		catch(SumErr e)
		{
			System.out.println("***** Sum error with values "+e.n1+"  "+e.n2);
		}
		catch(ProdErr e)
		{
			System.out.println("***** Product error with values "+e.n1+"  "+e.n2);
		}
	}
}