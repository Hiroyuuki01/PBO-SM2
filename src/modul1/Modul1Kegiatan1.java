package modul1;

import java.util.Scanner;

public class Modul1Kegiatan1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Library System ===");
        System.out.println("1. Login as student");
        System.out.println("2. Login as admin");
        System.out.println("3. Exit");

        System.out.print("Choose option (1-3) : ");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                Loginstudent();
                break;
            case 2:
                Loginadmin();
                break;
            case 3:
                keluar();
                break;
        }
    }
    public static void Loginstudent(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukan NIM :");
        String input = scanner.nextLine();

        if(input.length() != 15){
            System.out.println("Error, NIM harus terdiri dari 15 angka");
            return;
        }
        if(!input.matches("\\d+")){
            System.out.println("Error, NIM harus terdiri dari digit angka");
            return;
        }

        System.out.println("Successfull Login Student");
    }
    public static void Loginadmin(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukan Username : ");
        String Useradmin = scanner.nextLine();
        System.out.print("Masukan Password : ");
        String Passadmin = scanner.nextLine();

        String dataadmin = "admin";
        String Passdataadmin = "admin";

        if(Useradmin.equals(dataadmin) && Passadmin.equals(Passdataadmin)){
            System.out.println("Successfull Login Admin");
        } else {
            System.out.println("Error, Admin user not found ");
        }
    }
    public static void keluar(){
        System.out.print("Keluar dari System");
    }
}
