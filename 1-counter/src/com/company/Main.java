package com.company;

import java.*;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner st= new Scanner(System.in);
        String[] a=new String[100];
        int i=0;
        int L=0;
        int blockCount =0;
        System.out.println("Enter text:");
        while(true)
        {
            a[i] =st.nextLine();
            L+=a[i].length();
            blockCount += a[i].split(" +").length;
            if(a[i].equals(""))
            {break;}
            i++;
        }

        blockCount--;

        for (int j = 0; j < i; j++) {
            System.out.println(a[j]);
        }
        System.out.println("There is "+L+" symbols");
        System.out.println("There is "+i+" strings");
        System.out.println("There is "+blockCount+" words");

    }
}
