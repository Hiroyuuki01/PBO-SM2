package Modul5CL;

import java.util.ArrayList;
import java.util.Scanner;

public class Codelab1 {
    public static void main(String[] args) {
        ArrayList<String> namaMahasiswa = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int i = 1;

        while (true){
            System.out.print("Ketik 'selesai' untuk selesai input\n");
            System.out.print("Masukkan Nama Mahasiswa ke-" + i + ":");
            String nama = scanner.nextLine();

            if (nama.equalsIgnoreCase("selesai")){
                break;
            }

            if (nama.isEmpty()){
                try {
                    throw new IllegalArgumentException("Nama tidak boleh kosong!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                namaMahasiswa.add(nama);
                i++;
            }
        }
        System.out.println("\nDaftar Nama Mahasiswa:");

        for (String nama : namaMahasiswa){
            System.out.println(nama);
        }
    }
}
