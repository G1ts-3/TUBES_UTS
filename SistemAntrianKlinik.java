import java.util.ArrayList;
import java.util.Scanner;

class Pasien {
    String nama;
    int umur;
    String asal;
    String tanggalLahir;
    String golonganRiwayat; 

    public Pasien(String nama, int umur, String asal, String tanggalLahir, String golonganRiwayat) {
        this.nama = nama;
        this.umur = umur;
        this.asal = asal;
        this.tanggalLahir = tanggalLahir;
        this.golonganRiwayat = golonganRiwayat;
    }

    @Override
    public String toString() {
        return String.format("%-15s | Umur: %-3d | Asal: %-10s | Lahir: %-10s | Riwayat: %-6s",
                nama, umur, asal, tanggalLahir, golonganRiwayat);
    }
}

public class SistemAntrianKlinik {
    static ArrayList<Pasien> daftarPasien = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    // === Data Dummy ===
    static void initDummyData() {
        daftarPasien.add(new Pasien("Andi", 30, "Bandung", "12-03-1995", "sedang"));
        daftarPasien.add(new Pasien("Budi", 45, "Jakarta", "05-07-1980", "berat"));
    }

    // === Pendaftaran Pasien ===
    static void tambahPasien() {
        System.out.print("Nama: ");
        String nama = input.nextLine();
        System.out.print("Umur: ");
        int umur = Integer.parseInt(input.nextLine());
        System.out.print("Asal: ");
        String asal = input.nextLine();
        System.out.print("Tanggal Lahir (dd-mm-yyyy): ");
        String tgl = input.nextLine();
        System.out.print("Golongan Riwayat Penyakit (ringan/sedang/berat): ");
        String riwayat = input.nextLine().toLowerCase();

        daftarPasien.add(new Pasien(nama, umur, asal, tgl, riwayat));
        System.out.println("Pasien berhasil didaftarkan!\n");
    }

    // === Pencarian Pasien ===
    static void cariPasien() {
        System.out.print("Cari berdasarkan (nama/riwayat): ");
        String mode = input.nextLine();
        System.out.print("Masukkan kata kunci: ");
        String keyword = input.nextLine().toLowerCase();
        boolean ditemukan = false;

        for (Pasien p : daftarPasien) {
            if ((mode.equalsIgnoreCase("nama") && p.nama.toLowerCase().contains(keyword)) ||
                (mode.equalsIgnoreCase("riwayat") && p.golonganRiwayat.equalsIgnoreCase(keyword))) {
                System.out.println(p);
                ditemukan = true;
            }
        }

        if (!ditemukan) System.out.println("Data pasien tidak ditemukan.\n");
    }

    // === Edit Pasien ===
    static void editPasien() {
        System.out.print("Masukkan nama pasien yang ingin diubah: ");
        String nama = input.nextLine();
        boolean ditemukan = false;

        for (Pasien p : daftarPasien) {
            if (p.nama.equalsIgnoreCase(nama)) {
                System.out.print("Ubah umur: ");
                p.umur = Integer.parseInt(input.nextLine());
                System.out.print("Ubah asal: ");
                p.asal = input.nextLine();
                System.out.print("Ubah tanggal lahir: ");
                p.tanggalLahir = input.nextLine();
                System.out.print("Ubah golongan riwayat (ringan/sedang/berat): ");
                p.golonganRiwayat = input.nextLine().toLowerCase();
                System.out.println("Data pasien berhasil diperbarui!\n");
                ditemukan = true;
                
            }
        }
        if (!ditemukan) System.out.println("Pasien tidak ditemukan.\n");
    }

    // === Hapus Pasien ===
    static void hapusPasien() {
        System.out.print("Masukkan nama pasien yang ingin dihapus: ");
        String nama = input.nextLine();
        for (int i = 0; i < daftarPasien.size(); i++) {
            if (daftarPasien.get(i).nama.equalsIgnoreCase(nama)) {
                daftarPasien.remove(i);
                System.out.println("Data pasien berhasil dihapus!\n");
                return;
            }
        }
        System.out.println("Pasien tidak ditemukan.\n");
    }

    // === Tampilkan Antrian (Prioritas) ===
    static void tampilkanAntrian() {
        if (daftarPasien.isEmpty()) {
            System.out.println("Belum ada data pasien.\n");
            return;
        }

        // Sort manual berdasarkan prioritas: berat > sedang > ringan
        for (int i = 0; i < daftarPasien.size() - 1; i++) {
            for (int j = 0; j < daftarPasien.size() - i - 1; j++) {
                if (getPrioritas(daftarPasien.get(j).golonganRiwayat)
                        < getPrioritas(daftarPasien.get(j + 1).golonganRiwayat)) {
                    Pasien temp = daftarPasien.get(j);
                    daftarPasien.set(j, daftarPasien.get(j + 1));
                    daftarPasien.set(j + 1, temp);
                }
            }
        }

        System.out.println("\n------------------- DAFTAR ANTRIAN PASIEN (BERDASARKAN PRIORITAS) -------------------");
        for (int i = 0; i < daftarPasien.size(); i++) {
            System.out.println((i + 1) + ". "+ daftarPasien.get(i));
        }
        System.out.println();
    }

    static int getPrioritas(String r) {
        if (r.equalsIgnoreCase("berat")) return 3;
        if (r.equalsIgnoreCase("sedang")) return 2;
        return 1;
    }

    // === Menu Utama ===
    public static void main(String[] args) {
        initDummyData(); // ← tambah dummy data di awal

        int pilihan;
        do {
            System.out.println("------------------ SISTEM ANTRIAN KLINIK ------------------");
            System.out.println("1. Daftar Pasien Baru");
            System.out.println("2. Cari Data Pasien");
            System.out.println("3. Edit Data Pasien");
            System.out.println("4. Hapus Data Pasien");
            System.out.println("5. Tampilkan Antrian (Prioritas)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = Integer.parseInt(input.nextLine());
            System.out.println();

            switch (pilihan) {
                case 1 -> tambahPasien();
                case 2 -> cariPasien();
                case 3 -> editPasien();
                case 4 -> hapusPasien();
                case 5 -> tampilkanAntrian();
                case 0 -> System.out.println("Terima kasih! Program selesai.");
                default -> System.out.println("Pilihan tidak valid!\n");
            }
        } while (pilihan != 0);
    }
}
