

/**
 * Titre :        Exercise 1b1
 * Description :  Arguments de la ligne de commande
 * Copyright :    Copyright (c) 2002
 * Société :
 * @author SN
 * @version 1.0
 */

public class exer1b1 {
   public static void main(String[] args) {

        for(int i = args.length-1; i >= 0; i--) {
            for(int j=args[i].length()-1; j>=0; j--) {
                System.out.print(args[i].charAt(j));
            }
            System.out.print(" ");
       }

    }
}