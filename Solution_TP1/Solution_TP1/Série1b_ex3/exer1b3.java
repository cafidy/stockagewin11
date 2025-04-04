

/**
 * Titre :        Exercise 1b3
 * Description :  Jour suivant
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class exer1b3 {

	static String month(int m){
	    String s=null;
            switch (m)
	    {
                case 1:  s= "January" ; break;
                case 2:  s= "February" ;break;
                case 3:  s= "March" ;break;
                case 4:  s= "April" ;break;
				case 5:  s= "May" ;break;
                case 6:  s= "June" ;break;
				case 7:  s= "July" ;break;
				case 8:  s= "August" ;break;
				case 9:  s= "September" ;break;
				case 10: s= "October" ;break;
				case 11: s= "November" ;break;
                case 12: s= "December" ;break;
	    }
	    return s;
	}

        public static void main(String[] args) {

		int d=31, m=12 ,y=2002;
		System.out.println("Today : "+d+" "+month(m)+" "+y);
		if (d==31
			|| d==30 && (m==4 || m==6||m==9 ||m==11)
			|| d==29 && m==2
			|| d==28 && m==2 &&!(y%4==0 && y%100 !=0))
		{
			d=1;
			if (m==12)
			{
				m=1;
				y++;
			}
			else
				m++;
		}
		else
			d++;
		System.out.println("Tomorrow :  "+d+" "+month(m)+" "+y);
	}

}