import java.util.Scanner;

public class Gabut{
    static void tambah(){
        int a = 0;
        int hasil=0;
        int n;
        Scanner in =new Scanner(System.in);
        System.out.print("Berapa jumlah angka yg ingin dijumlahkan: ");
        n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Masukkan angka ke-"+i+": ");
            a = in.nextInt();
            hasil=hasil+a;
        }
        
        System.out.println("Hasil penambahan: "+hasil);
        System.out.println(" ");
    }
    static void kurang(){
        int a = 0;
        int hasil=0;
        int n;
        Scanner in =new Scanner(System.in);
        System.out.print("Berapa jumlah angka yg ingin dikurangkan: ");
        n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Masukkan angka ke-"+i+": ");
            a = in.nextInt();
            hasil=hasil-a;
        }
        System.out.println("Hasil pengurangan: "+hasil);
        System.out.println(" ");
    }
    static void kali(){
        int a = 0;
        int hasil=0;
        int n;
        Scanner in =new Scanner(System.in);
        System.out.print("Berapa jumlah angka yg ingin dikalikan: ");
        n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Masukkan angka ke-"+i+": ");
            a = in.nextInt();
            hasil=hasil*a;
        }
        System.out.println("Hasil perkalian: "+hasil);
        System.out.println(" ");
    }
    static void bagi(){
        double a = 0;
        double hasil=0;
        int n;
        Scanner in =new Scanner(System.in);
        System.out.print("Berapa jumlah angka yg ingin dijumlahkan: ");
        n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Masukkan angka ke-"+i+": ");
            a = in.nextInt();
            hasil=hasil/a;
        }
        System.out.println("Hasil pembagian: "+hasil);
        System.out.println(" ");
    }
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int pilihan;
        do{
            System.out.println("==== KALKULATOR ====");
            System.out.println("1. Penambahan");
            System.out.println("2. Pengurangan");
            System.out.println("3. Perkalian");
            System.out.println("4. Pembagian");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = in.nextInt();
            System.out.println();
            
            switch(pilihan){
                case 0-> System.out.println("Terima kasih! Program selesai.");
                case 1-> tambah();
                case 2-> kurang();
                case 3-> kali();
                case 4-> bagi();
                default -> System.out.println("Pilihan tidak valid!");
            }
            
        } while (pilihan != 0);
        
    }
}