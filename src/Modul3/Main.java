package Modul3;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    public String title;
    public String author;
    public String id;
    public String category;
    public int stock;

    public Book(String title, String author, String id, String category, int stock) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.category = category;
        this.stock = stock;
    }
}

class Student {
    public String name;
    public String nim;
    public String faculty;
    public String program;

    public Student(String name, String nim, String faculty, String program) {
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.program = program;
    }
}

public class Main {
    private ArrayList<Book> bookList;
    private ArrayList<Student> userStudent;
    private Scanner scanner;
    static Scanner inputuser = new Scanner(System.in);

    static String adminusername = "admin", adminpassword = "admin";

    public Main() {
        bookList = new ArrayList<>();
        userStudent = new ArrayList<>();
        scanner = new Scanner(System.in);

        // Add some initial books
        bookList.add(new Book("Solo Leveling", "Chu Gong", "1", "Magic", 5));
        bookList.add(new Book("Dune", "Frank Herbert", "2", "Drama", 3));
        bookList.add(new Book("Star Wars", "George Lucas", "3", "Scifi", 2));
    }

    public void menu() {
        System.out.println("\n===== Library System =====");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                inputNim();
                break;
            case 2:
                loginadmin();
                menuAdmin();
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                menu();
        }
    }

    private void inputNim() {
        System.out.print("Enter your NIM: ");
        String nim = scanner.nextLine();
        if (checkNim(nim)) {
            menuStudent();
        } else {
            System.out.println("Invalid NIM. Please try again.");
            inputNim();
        }
    }

    private boolean checkNim(String nim) {
        // Cek jika nim terdapat dalam userStudent
        for (Student student : userStudent) {
            if (student.nim.equals(nim)) {
                return true;
            }
        }
        return false;
    }

    static void loginadmin(){
        int adminloop;
        do {
            System.out.println("\n==== Login ====");
            System.out.print("Masukkan Username: \n");
            String username = inputuser.nextLine();

            System.out.print("Massukkan password: \n");
            String password = inputuser.nextLine();

            if (username.equals(adminusername) && password.equals(adminpassword)) {
                System.out.println("==== Login berhasil ====\n");
                adminloop = 1;
            } else {
                System.out.println("==== Admin tidak ditemukan ====");
                adminloop = 0;
            }
        }while (adminloop == 0);
    }

    private void menuAdmin() {
        System.out.println("\n===== Admin Menu =====");
        System.out.println("1. Add Student");
        System.out.println("2. Display Registered Students");
        System.out.println("3. Logout");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                displayStudent();
                break;
            case 3:
                logout();
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                menuAdmin();
        }
    }

    private void menuStudent() {
        System.out.println("\n===== Student Dashboard =====");
        System.out.println("1. Tampilkan buku yang tersedia");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Borrowed Books");
        System.out.println("4. Logout");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                displayBooks();
                break;
            case 2:
                borrowBook();
                break;
            case 3:
                borrowedBook();
            case 4:
                logout();
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                menuStudent();
        }
    }

    private void displayBooks() {
        System.out.println("\n===== Available Books =====");
        System.out.printf("|| %-25s || %-25s || %-25s || %-20s || %-3s ||", "ID Buku", "Nama Buku", "Author", "Category", "Stock");
        System.out.println("\n================================================================================");
        for (Book book : bookList) {

            System.out.printf("|| %-25s || %-25s || %-25s || %-20s || %-3s ||", book.id, book.title, book.author, book.category, book.stock);
            System.out.println();
        }
        menuStudent();
    }

    void borrowBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID buku yang ingin dipinjam: ");
        String id = scanner.nextLine();
        boolean found = false;
        for (Book book : bookList) {
            if (book.id.equals(id)) {
                found = true;
                if (book.stock > 0) {
                    book.stock--;
                    System.out.println("Kamu telah meminjam Buku " + book.title + ".");
                } else {
                    System.out.println("Maaf, buku ini tidak tersedia.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Buku dengan ID tersebut tidak ditemukan.");
        }
        menuStudent();
    }

    private void borrowedBook() {
        System.out.println("\n===== Buku Terpinjam =====");

        // Create an ArrayList to store the borrowed books for the current student
        ArrayList<Book> borrowedBooks = new ArrayList<>();

        // Iterate through the bookList and find the books with stock less than the original stock
        for (Book book : bookList) {
            int originalStock = book.stock; // Assuming there's a way to get the original stock
            if (book.stock < originalStock) {
                borrowedBooks.add(book);
            }
        }

        // If there are no borrowed books, print a message
        if (borrowedBooks.isEmpty()) {
            System.out.println("Kamu belum meminjam buku apapun.");
        } else {
            // Display the borrowed books
            for (Book book : borrowedBooks) {
                System.out.println("Title: " + book.title);
                System.out.println("Author: " + book.author);
                System.out.println("ID: " + book.id);
                System.out.println("Category: " + book.category);
                System.out.println();
            }
        }

        menuStudent();
    }

    private void logout() {
        System.out.println("Logging out...");
        menu();
    }

    private void addStudent() {
        System.out.print("Masukkan Nama Mahasiswa: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        if (nim.length() != 15) {
            System.out.println("Invalid NIM. NIM harus panjang 15 angka.");
            addStudent();
            return;
        }
        System.out.print("Masukkan fakultas: ");
        String faculty = scanner.nextLine();
        System.out.print("Masukkan program studi: ");
        String program = scanner.nextLine();

        Student newStudent = new Student(name, nim, faculty, program);
        userStudent.add(newStudent);
        System.out.println("Mahasiswa Berhasil ditambahkan.");
        menuAdmin();
    }

    private void displayStudent() {
        System.out.println("\n===== Registered Students =====");
        for (Student student : userStudent) {
            System.out.println("Nama: " + student.name);
            System.out.println("NIM: " + student.nim);
            System.out.println("Fakultas: " + student.faculty);
            System.out.println("Program Studi: " + student.program);
            System.out.println();
        }
        menuAdmin();
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.menu();
    }
}