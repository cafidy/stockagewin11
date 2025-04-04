package exer61;

/**
 * Titre :        S�rie 6 exercice 1
 * Description :  List of displayable objects
 * Copyright :    Copyright (c) 2002
 * Soci�t� :
 * @author SN
 * @version 1.0
 */

public class MixedList implements Displayable{

	Node head,current;

	void init()
	{
		current=head;
	}

	void next()
	{
		current=current.getNext();
	}

	Object getInfo()
	{
		return current.getInfo();
	}

	boolean end()
	{
		return current==null;
	}

	void add(Displayable i)
	{
		head=new Node(i, head);
	}

	public void display()
	{
		init();
		while (!end())
		{
			((Displayable) getInfo()).display();
			next();
		}
	}
}