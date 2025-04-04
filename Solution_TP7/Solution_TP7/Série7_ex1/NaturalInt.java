package exer71;

/**
 * Titre :        Série 7 exercice 1
 * Description :  Naturals
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class NaturalInt {

	private int n;

        public NaturalInt(int n)
		        throws ConstErr
	{
		if (n<0) throw new ConstErr(n);
		this.n=n;
        }

	public static NaturalInt sum(NaturalInt n1,NaturalInt n2)
		        throws SumErr,ConstErr
	{
		int op1=n1.n, op2=n2.n;
		long s=op1+op2;
		if (s>Integer.MAX_VALUE)
			throw new SumErr(op1,op2);
		return new NaturalInt((int) s);
	}

	public static NaturalInt prod(NaturalInt n1,NaturalInt n2)
		        throws ProdErr,ConstErr
	{
		int op1=n1.n, op2=n2.n;
		long p=(long)op1 * (long)op2;
		if (p>Integer.MAX_VALUE)
			throw new ProdErr(op1,op2);
		return new NaturalInt((int) p);
	}

	public static NaturalInt diff(NaturalInt n1,NaturalInt n2)
		        throws DiffErr,ConstErr
	{
		int op1=n1.n, op2=n2.n;
		int d=op1-op2;
		if (d<0)
			throw new DiffErr(op1,op2);
		return new NaturalInt(d);
	}

	public int getN()
	{
		return n;
	}
}

class NatErr extends Exception
{}

class ConstErr extends NatErr
{
	public int n;
	public ConstErr(int n)
	{
		this.n=n;
	}
}

class OpErr extends NatErr
{
	public int n1,n2;
	public OpErr(int n1,int n2)
	{
		this.n1=n1;
		this.n2=n2;
	}
}

class SumErr extends OpErr
{
	public SumErr(int n1,int n2)
	{
		super(n1,n2);
	}
}

class DiffErr extends OpErr
{
	public DiffErr(int n1,int n2)
	{
		super(n1,n2);
	}
}

class ProdErr extends OpErr
{
	public ProdErr(int n1,int n2)
	{
		super(n1,n2);
	}
}

