package com.company;

import java.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter Filename: ");
            File file = new File(input.nextLine());

            input = new Scanner(file);

            List<figure> list = new ArrayList<figure>();
            String a=new String();
            int k;
            k = input.nextInt();
            String[] z = new String[k];
            int i = 0;
            while (i < k) {
                a = input.next();
                if(a.equals("CIRCLE"))
                    list.add(new figure(input.nextInt()));
                else
                list.add(new figure(a,input.nextInt(),input.nextInt()));
                i++;
            }
            input.close();

           // list.add(new figure("RECT",5,6));
            //list.add(new figure(5));
            Collections.sort(list);

            for (int m = 0; m < list.size(); m++) {


                System.out.println(list.get(m).myType);
                System.out.println(list.get(m).S);
                System.out.println("===============================");


            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }
}
