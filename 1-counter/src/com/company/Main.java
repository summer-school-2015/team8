package com.company;

import java.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner st= new Scanner(System.in);
        String[] a=new String[100];
        int i=0;
        while(st.nextLine().length()>0) {
            a[i] = st.nextLine();
            i++;
        }
        i=0;
        while(a[i]!=null) {
            System.out.println(a[i]);
            i++;
        }

    }
}
