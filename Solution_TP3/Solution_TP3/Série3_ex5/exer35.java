/**
 * Titre :        Exercise 35
 * Description :  Annuaire téléphonique
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class exer35 {
        public static void main(String[] args)
	{
		Index ind=new Index(10);
		System.out.println("There are "+ind.getNbSubscribers()+" subscribers");
		Subscriber a=new Subscriber("Bob","111");
		Subscriber b=new Subscriber("Bill","1121");
		ind.addSubscriber(a);
		ind.addSubscriber(b);
		ind.addSubscriber(new Subscriber("Jack","211"));
		ind.addSubscriber(new Subscriber("John","311"));
		System.out.println("There are "+ind.getNbSubscribers()+" subscribers");
		System.out.println("who are :");
		for (int i=0; i<ind.getNbSubscribers(); i++)
			System.out.println(ind.getSubscriber(i).getName()+" "+
			                   ind.getSubscriber(i).getNumber());
	}
}