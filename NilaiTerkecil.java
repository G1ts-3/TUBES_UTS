import java.util.Scanner;

public class NilaiTerkecil {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String namaTerendah1 = "";
        String namaTerendah2 = "";
        double nilaiTerendah1 = 0;
        double nilaiTerendah2 = 0;

        for (int i = 1; i <= 3; i++) {
            System.out.print("Masukkan nama siswa ke-" + i + ": ");
            String nama = input.nextLine();

            System.out.print("Masukkan nilai UAS " + nama + ": ");
            double nilai = input.nextDouble();
            input.nextLine(); // membersihkan buffer

            if (i == 1) {
                // data pertama otomatis jadi nilai terkecil sementara
                namaTerendah1 = nama;
                nilaiTerendah1 = nilai;
            } else if (i == 2) {
                // data kedua dibandingkan dengan pertama
                if (nilai < nilaiTerendah1) {
                    namaTerendah2 = namaTerendah1;
                    nilaiTerendah2 = nilaiTerendah1;
                    namaTerendah1 = nama;
                    nilaiTerendah1 = nilai;
                } else {
                    namaTerendah2 = nama;
                    nilaiTerendah2 = nilai;
                }
            } else {
                // data ketiga dibandingkan semua sebelumnya
                if (nilai < nilaiTerendah1) {
                    namaTerendah2 = namaTerendah1;
                    nilaiTerendah2 = nilaiTerendah1;
                    namaTerendah1 = nama;
                    nilaiTerendah1 = nilai;
                } else if (nilai < nilaiTerendah2) {
                    namaTerendah2 = nama;
                    nilaiTerendah2 = nilai;
                }
            }
        }

        System.out.print("\nSiswa dengan nilai terkecil pertama: ");
        System.out.println(namaTerendah1 + " - " + nilaiTerendah1);

        System.out.print("Siswa dengan nilai terkecil kedua: ");
        System.out.println(namaTerendah2 + " - " + nilaiTerendah2);
    }
}
