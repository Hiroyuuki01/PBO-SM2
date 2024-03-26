package Modul3;

import java.util.Scanner;
public class StringEquality {
    public static void main(String[] args) {
        String nama;
        Scanner input = new Scanner(System.in);

        System.out.println("Masukan Nama");
        nama = input.next();

        if(nama.equals("Meo")){
            System.out.println("Aku Seorang Guy");
        } else {
            System.out.println("Aku Seorang Pria");
        }
    }
}
