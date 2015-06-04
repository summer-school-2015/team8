package com.company;
import java.io.File;
import java.util.Scanner;

public class FileScan {

    public static void Scan(String[] args) {

        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter Filename: ");
            File file = new File(input.nextLine());

            input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}