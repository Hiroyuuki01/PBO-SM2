package Modul3;

import java.util.Scanner;

public class AgeValidity {
    public static void main(String[] agrs){
        Scanner input = new Scanner(System.in);
        boolean drivingUnderAge = false;
        int umur;
        System.out.println("Masukan Umur");
        umur = input.nextInt();

        if(umur <= 18){
            drivingUnderAge = true;
        }else {
            drivingUnderAge = false;
        }
        System.out.println(drivingUnderAge);
    }
}
