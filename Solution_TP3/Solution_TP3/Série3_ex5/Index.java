/**
 * Titre :        Exercise 35
 * Description :  Annuaire téléphonique
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class Index {

	private int nMax,nSubsc;
	private Subscriber[] ind;

        public Index(int nMax)
	{
		this.nMax=nMax;
		ind=new Subscriber[nMax];
		nSubsc=0;
        }

	public boolean addSubscriber(Subscriber a)
	{
		if (nSubsc>=nMax)
			return false;
		ind[nSubsc]=a;
		nSubsc++;
		return true;
	}

	public int getNbSubscribers()
	{
		return nSubsc;
	}

	public Subscriber getSubscriber(int i)
	{
		return ind[i];
	}

	public String getNumber(String name)
	{
		for (int i=0; i<nSubsc; i++)
		        if (name.equals(ind[i].getName()))
				return ind[i].getNumber();
			return null;
	}

	public Subscriber[] getSortedSubscribers()
	{
		Subscriber[] sortedIndex=new Subscriber[nSubsc];
		for (int i=0; i<nSubsc; i++)
			sortedIndex[i]=ind[i];
		for (int i=0; i<nSubsc-1; i++)
			for (int j=i+1; j<nSubsc; j++)
				if ((sortedIndex[i].getName().compareTo(sortedIndex[j].getName()))>0)
				{
					Subscriber temp=sortedIndex[i];
					sortedIndex[i]=sortedIndex[j];
					sortedIndex[j]=temp;
				}
		return sortedIndex;
	}
}