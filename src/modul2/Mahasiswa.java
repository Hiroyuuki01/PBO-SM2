package modul2;

import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {

    public String nama;
    public String nim;
    public String jurusan;

    public void tambahMS(){
        Scanner masuk1 = new Scanner(System.in);
        System.out.println("Masukan Nama : ");
        nama = masuk1.next();

        System.out.println("Masukan NIM : ");
        nim = masuk1.nextLine();

        while (nim.length() != 15){
            System.out.println("NIM harus 15 angka, Masukan kembali NIM");
            System.out.println("Masukan NIM : ");
            nim = masuk1.nextLine();
        }
        System.out.println("Masukan Jurusan : ");
        jurusan = masuk1.nextLine();

        System.out.println("Data Berhasil ditambahkan ");
    }

    public String TampilkanDataMS(){
        return "nama = " +nama + "\n NIM = " +nim +"\nJurusan = " +jurusan;
    }
    public static String TampilkanUniv(){
        return "Universitas Muhammadiyah Malang";
    }

    public static class Codelab1 {
        public static void main(String[] args) {
            ArrayList<Mahasiswa> daftarMS = new ArrayList<>();

            Scanner masuk = new Scanner(System.in);
            int pilihan;
            boolean sudah = false;

            do {
                System.out.println("==== MENU ====");
                System.out.println("1. Tambah Data Mahasiswa ");
                System.out.println("2. Tampilkan Data Mahasiswa ");
                System.out.println("3. Keluar ");
                pilihan = masuk.nextInt();

                switch (pilihan) {
                    case 1:
                        Mahasiswa MS1 = new Mahasiswa();
                        MS1.tambahMS();
                        daftarMS.add(MS1);
                        break;

                    case 2:
                        System.out.println("\n Data Mahasiswa \n");
                        for (Mahasiswa mahasiswa : daftarMS) {
                            System.out.println(mahasiswa.TampilkanUniv());
                            System.out.println(mahasiswa.TampilkanDataMS());
                        }
                        break;

                    case 3:
                        System.out.println("Terimakasih");
                        sudah = true;
                        break;

                    default:
                        System.out.println("Pilihan tidak valid");
                }
            }while (!sudah);
        }
    }
}