package modul2;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class kegiatan1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pilihan;

        Book[] bookList = new Book[3];

        // Mengisi array dengan objek buku
        bookList[0] = new Book("2005051305", "Daniel Goleman", "Emotional Intellingence","pengetahuan",4);
        bookList[1] = new Book("2005051224", "Almira Bastari", "Home Sweet Loan","novel",2);
        bookList[2] = new Book("2005053465", "Jane Austen", "Pride and Prejudice","sejarah",6);

        do {
            System.out.println("Welcome to Library System");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login");
            System.out.println("3. keluar");
            pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    Admin admin = new Admin();
                    admin.login();
                    break;
                case "2":
                    Student student = new Student();
                    student.login();
                    break;
                case "3":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!pilihan.equals("3"));

        scanner.close();
    }
}

class Book {
    private String id;
    private String penulis;
    private String judul;
    private String kategori;
    private int stok;


    public Book(String id, String penulis, String judul,String kategori, int stok) {
        this.id = id;
        this.penulis = penulis;
        this.judul = judul;
        this.kategori = kategori;
        this.stok = stok;

    }

    @Override
    public String toString() {
        return "ID: " + id + ", Penulis: " + penulis + ", Judul: " + judul + ", Kategori: " + kategori + ", Stok: " + stok;
    }
}

class Admin {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Admin Login ===");
        System.out.print("Username: ");
        String usernameInput = scanner.nextLine();
        System.out.print("Password: ");
        String passwordInput = scanner.nextLine();

        if (usernameInput.equals(ADMIN_USERNAME) && passwordInput.equals(ADMIN_PASSWORD)) {
            System.out.println("Login Berhasil.");
            menuAdmin();
        } else {
            System.out.println("Gagal Login cek kembali username dan password.");
        }
    }

    public void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        String pilihan;

        ArrayList<Mahasiswa1> daftarMahasiswa = loadMahasiswa();

        do {
            System.out.println("=== Admin Menu ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa");
            System.out.println("3. Simpan Data");
            System.out.println("4. keluarr...");
            pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    tambahDataMahasiswa(daftarMahasiswa);
                    break;
                case "2":
                    tampilkanDataMahasiswa(daftarMahasiswa);
                    break;
                case "3":
                    saveMahasiswa(daftarMahasiswa);
                    break;
                case "4":
                    System.out.println("Keluarrr...");
                    return;
                default:
                    System.out.println("Pilihan anda salah, masukan kembali.");
            }
        } while (!pilihan.equals("4"));
    }

    private static ArrayList<Mahasiswa1> loadMahasiswa() {
        ArrayList<Mahasiswa1> daftarMahasiswa = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mahasiswa.dat"))) {
            daftarMahasiswa = (ArrayList<Mahasiswa1>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File data mahasiswa tidak ditemukan. Membuat file baru.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return daftarMahasiswa;
    }

    private static void tambahDataMahasiswa(ArrayList<Mahasiswa1> daftarMahasiswa) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan Nama Mahasiswa:");
        String nama = scanner.nextLine();
        int i = 1;
        String nim;
        do {
            i = 1;
            System.out.println("Masukkan NIM Mahasiswa:");
            nim = scanner.nextLine();
            if (!nim.matches("\\d{15}")){
                System.out.println("NIM harus memiliki 15 digit dan hanya terdiri dari angka. Data tidak disimpan.");
                i = 0;
            }
        } while (i == 0);

        System.out.println("Masukkan Jurusan Mahasiswa:");
        String jurusan = scanner.nextLine();

        Mahasiswa1 mahasiswa = new Mahasiswa1(nama, nim, jurusan);
        daftarMahasiswa.add(mahasiswa);

        System.out.println("Data mahasiswa ditambahkan.");
    }

    private static void tampilkanDataMahasiswa(ArrayList<Mahasiswa1> daftarMahasiswa) {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa.");
        } else {
            System.out.println("Daftar Mahasiswa:");
            System.out.println("Universitas Muhammadiyah Malang");
            for (Mahasiswa1 mahasiswa : daftarMahasiswa) {
                System.out.println("Nama: " + mahasiswa.getNama() + ", NIM: " + mahasiswa.getNim() + ", Jurusan: " + mahasiswa.getJurusan());
            }
        }
    }

    private static void saveMahasiswa(ArrayList<Mahasiswa1> daftarMahasiswa) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mahasiswa.dat"))) {
            oos.writeObject(daftarMahasiswa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayStudents() {
    }
}

class Student {

    public void login() {
        ArrayList<Mahasiswa1> daftarMahasiswa = loadMahasiswa();

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Student Login ===");
        System.out.print("Enter student NIM: ");
        String nimInput = scanner.nextLine();

        for (Mahasiswa1 mahasiswa : daftarMahasiswa) {
            if(nimInput.equals(mahasiswa.getNim())){
                System.out.println("login student succses");
                menuStudent();
            }

        }

        System.out.println("wrong nim");

    }

    private static ArrayList<Mahasiswa1> loadMahasiswa() {
        ArrayList<Mahasiswa1> daftarMahasiswa = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mahasiswa.dat"))) {
            daftarMahasiswa = (ArrayList<Mahasiswa1>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File data mahasiswa tidak ditemukan. Membuat file baru.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return daftarMahasiswa;
    }

    public void menuStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== Student Menu =====");
        System.out.println("1. Buku terpinjam");
        System.out.println("2. pinjam Buku");
        System.out.println("3. logout");
        String option = scanner.nextLine();

        switch (option) {
            case "1":
                displayBuku();
                break;
            case "2":

                break;
            case "3":
                System.out.println("Logging out...");
                break;
        }
    }

    public void displayBuku(){

        Book[] bookList = new Book[3];

        // Mengisi array dengan objek buku
        bookList[0] = new Book("2005051305", "Daniel Goleman", "Emotional Intellingence","pengetahuan",4);
        bookList[1] = new Book("2005051224", "Almira Bastari", "Home Sweet Loan","novel",2);
        bookList[2] = new Book("2005053465", "Jane Austen", "Pride and Prejudice","sejarah",6);

        System.out.println("List of Books:");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

}

class Mahasiswa1 implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nama;
    private String nim;
    private String jurusan;

    public Mahasiswa1(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getJurusan() {
        return jurusan;
    }
}