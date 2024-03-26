package Modul3Tugas;

import java.util.ArrayList;
import java.util.Scanner;

class Admin {
    private final String adminUsername;
    private final String adminPassword;
    private final ArrayList<Student> students;

    public Admin(String adminUsername, String adminPassword) {
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.students = new ArrayList<>();
    }


    public void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama mahasiswa: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan fakultas mahasiswa: ");
        String faculty = scanner.nextLine();
        int i = 1;
        String nim;
        do {
            i = 1;
            System.out.println("Masukkan NIM Mahasiswa:");
            nim = scanner.nextLine();
            if (!nim.matches("\\d{15}")){
                System.out.println("NIM harus memiliki 15 digit dan hanya terdiri dari angka.");
                i = 0;
            }
        } while (i == 0);
        System.out.print("Masukkan program studi mahasiswa: ");
        String program = scanner.nextLine();

        students.add(new Student(name, faculty, nim, program));
        System.out.println("Mahasiswa berhasil ditambahkan!");
    }

    public void displayRegisteredStudents() {
        System.out.println("\n===== Mahasiswa Terdaftar =====");
        System.out.printf("%-20s %-20s %-15s %-20s\n", "Nama", "Fakultas", "NIM", "Program Studi");
        for (Student student : students) {
            System.out.printf("%-20s %-20s %-15s %-20s\n", student.getName(), student.getFaculty(), student.getNim(), student.getProgram());
        }
    }

}