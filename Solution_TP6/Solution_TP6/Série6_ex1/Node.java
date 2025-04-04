package exer61;

/**
 * Titre :        S�rie 6 exercice 1
 * Description :  List of displayable objects
 * Copyright :    Copyright (c) 2002
 * Soci�t� :
 * @author SN
 * @version 1.0
 */

public class Node {

	Displayable info;
	Node next;

        public Node(Displayable i, Node n)
	{
	        info=i;
	        next=n;
	}

	Displayable getInfo()
	{
		return info;
	}

	Node getNext()
	{
	        return next;
	}
}