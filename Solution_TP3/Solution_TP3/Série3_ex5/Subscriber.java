/**
 * Titre :        Exercise 35
 * Description :  Annuaire téléphonique
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class Subscriber {

	private String name,number;

        public Subscriber(String name,String number)
	{
                this.name=name;
                this.number=number;
	}
	public String getName()
	{
		return name;
	}
	public String getNumber()
	{
		return number;
	}
}