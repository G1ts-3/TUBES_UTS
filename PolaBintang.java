import java.util.Scanner;

public class PolaBintang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jumlah baris: ");
        int n = input.nextInt();

    for (int i = 1; i <= n; i++) {
            // untuk piramid biasa
            // for (int j = 1; j <= i; j++) {
            //     System.out.print("*");
            // }
            for (int j = i; j <= n; j++) {
                System.out.print(" ");
            }
            for (int j=1;j<=(2*i-1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
