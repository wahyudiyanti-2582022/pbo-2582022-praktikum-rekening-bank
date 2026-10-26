import java.util.Scanner;

public class BankMini {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Rekening rekening = new Rekening("001", "Ani", 100000);

        // Percobaan akses langsung ke field private (dijadikan komentar):
        // rekening.saldo = 1000000;
        // Pesan error: saldo has private access in Rekening

        System.out.println("============ BANK MINI ============");
        System.out.println("Rekening " + rekening.getNomor() + " a.n. " + rekening.getPemilik());

        int menu;
        do {
            System.out.print("Menu (1 setor, 2 tarik, 3 info, 0 keluar): ");
            menu = input.nextInt();

            if (menu == 1) {
                System.out.print("Jumlah: ");
                int jumlah = input.nextInt();
                if (rekening.setor(jumlah)) {
                    System.out.println("  Berhasil");
                } else {
                    System.out.println("  Ditolak");
                }
            } else if (menu == 2) {
                System.out.print("Jumlah: ");
                int jumlah = input.nextInt();
                if (rekening.tarik(jumlah)) {
                    System.out.println("  Berhasil");
                } else {
                    System.out.println("  Ditolak");
                }
            } else if (menu == 3) {
                rekening.cetakInfo();
            } else if (menu != 0) {
                System.out.println("Menu tidak dikenal");
            }
        } while (menu != 0);

        System.out.println();
        System.out.println("=========== SALDO AKHIR ===========");
        rekening.cetakInfo();
    }
}