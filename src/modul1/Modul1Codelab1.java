package modul1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Modul1Codelab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukan Nama: ");
        String namaUser = scanner.nextLine();

        System.out.print("Pilih Jenis Kelamin (L/P): ");
        char kelaminUser = scanner.nextLine().charAt(0);

        System.out.print("Masukkan tanggal lahir (Format: yyyy-MM-dd): ");
        String tanggalLahirString = scanner.next();

        System.out.println("Nama : " + namaUser);
        if(kelaminUser == 'p' || kelaminUser == 'P'){
            System.out.println("Jenis Kelamin : Perempuan");
        }else if(kelaminUser == 'l' || kelaminUser == 'L'){
            System.out.println("Jenis Kelamin : Laki-Laki");
        }else{
            System.out.println("Jenis Kelamin : Tidak ditemukan");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate tanggalLahir = LocalDate.parse(tanggalLahirString, formatter);

        LocalDate hariIni = LocalDate.now();

        Period perbedaanUmur = Period.between(tanggalLahir, hariIni);


        System.out.println("Umur Anda adalah " + perbedaanUmur.getYears() + " tahun dan " + perbedaanUmur.getMonths() + " bulan.");

        scanner.close();
    }
}