package com.company;

/**
 * Created by User on 6/4/2015.
 */
public class figure implements Comparable<figure>{
    double S;
    String myType;

    figure(int radius)
    {
        //CIRCLE
        S=3.1415926*(radius*radius);
        myType="CIRCLE";

    }
    figure(String type,int xA,int xB)
    {
        //TRIANGLE,RECT
        if(type.equals("TRIANGLE"))
        {
            S=1/2*(xA*xB);
            myType="TRIANGLE";
        }
        else if(type.equals("RECT"))
        {
            S=xA*xB;
            myType="RECT";
        }
        else{S=0;}

    }

    public int compareTo(figure o)
    {
        if (this.S == ((figure) o).S)
            return 0;
        else if ((this.S) > ((figure) o).S)
            return 1;
        else
            return -1;
    }

}
