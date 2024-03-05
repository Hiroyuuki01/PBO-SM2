import java.util.Scanner;
import java.util.ArrayList;

class Mahasiswa {
    public String nama;
    public String nim;
    public String jurusan;



    public void tambahMahasiswa(){
        Scanner input2 = new Scanner(System.in);
        System.out.print("Masukkan nama mahasiswa: ");
        nama = input2.next();

        System.out.print("Masukkan NIM mahasiswa: ");
        nim = input2.next();

        //kondisi ketika panjang nim tidak sama dengan 15
        while (nim.length() != 15) {
            System.out.println("Panjang NIM harus 15 angka. Silakan input kembali.");
            System.out.print("NIM: ");
            nim = input2.nextLine();
        }

        System.out.print("Masukkan Jurusan mahasiswa: ");
        jurusan = input2.next();

        System.out.println("Data berhasil ditambahkan");
    }

    public String tampilDataMahasiswa() {
        return "Nama: " + nama + "\nNIM: " + nim + "\nJurusan: " + jurusan;

    }

    public static String tampilUniversitas() {

        return "Universitas Muhammadiyah Malang\n";
    }



    public static class codelab1 {
        public static void main(String[] args) {

            ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>(); //deklarasi arraylist dengan nama daftarMahasiswa yang diambil dari class Mahasiswa

            Scanner input = new Scanner(System.in);
            int pilihan;
            boolean done = false;

            do{
                System.out.println("Menu:");
                System.out.println("1. Tambah Data Mahasiswa");
                System.out.println("2. Tampilkan Data Mahasiswa");
                System.out.println("3. Keluar");
                System.out.print("Pilihan anda: ");
                pilihan = input.nextInt();


                switch (pilihan) {
                    case 1:
                        Mahasiswa mhs = new Mahasiswa(); //membuat object baru di Mahasiswa
                        mhs.tambahMahasiswa(); // menjalankan method tambahMahasiswa dari class Mahasiswa dengan object yang barusan dibuat
                        daftarMahasiswa.add(mhs); //menambahkan data atau elemen baru yang diinput tadi ke daftarMahasiswa
                        break;

                    case 2:
                        System.out.print("\n==Data mahasiswa==\n\n");

                        //looping untuk menampilkan setiap data dari daftarMahasiswa dari input sebelumnya
                        for (Mahasiswa mahasiswa : daftarMahasiswa) {
                            System.out.println(mahasiswa.tampilDataMahasiswa());
                            System.out.println(Mahasiswa.tampilUniversitas());
                        }

                        break;

                    case 3:
                        System.out.println("Terima kasih!");
                        done = true;
                        break;

                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");

                }
            }while (!done);

            input.close();



        }

    }
}