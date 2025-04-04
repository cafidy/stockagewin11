

/**
 * Titre :        Série 7 exercice 2
 * Description :  Numbered lines of a text file
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */
import java.io.*;
public class exer72 {
        public static void main(String[] args)
	{
	        final int lineNumLength=4;
		final int numCharPerLine=60;
		String line;
		char NumLine[]=new char[lineNumLength];
		try
		{
		        BufferedReader in=new BufferedReader(new FileReader("MyFile"));
			int lineNum=0;
			do
			{
				line=in.readLine();
				if (line==null)
					break;
				lineNum++;
				String ch=String.valueOf(lineNum);
				int i,j;
				for (i=0; i<lineNumLength-ch.length();i++)
					NumLine[i]=' ';
				for (j=0; i<lineNumLength;i++,j++)
					NumLine[i]=ch.charAt(j);
				for (i=0;i<lineNumLength;i++)
					System.out.print(NumLine[i]);
	        		System.out.print(' ');
				int n=0;
				while (n<line.length())
				{
					if ((n!=0) && (n%numCharPerLine == 0))
					{
						System.out.println();
						for (int k=0;k<lineNumLength+1;k++)
							System.out.print(' ');
		        		}
					System.out.print(line.charAt(n));
	        			n++;
	        		}
				System.out.println();
			}
			while (line!=null);
			in.close();
			System.out.println("*** End file list ***");
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
