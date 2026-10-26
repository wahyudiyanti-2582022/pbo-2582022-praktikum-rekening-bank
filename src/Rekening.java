public class Rekening {
    // Semua field private: tidak bisa disentuh dari luar class
    private String nomor;
    private String pemilik;
    private int saldo;

    // Constructor: parameter bernama sama dengan field, diisi memakai this
    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    // Getter
    public String getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    // Saldo read-only: hanya ada getter, tidak ada setSaldo
    public int getSaldo() {
        return saldo;
    }

    // Menolak jumlah <= 0. Ditolak -> false, saldo tidak berubah.
    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            return false;
        }
        this.saldo += jumlah;
        return true;
    }

    // Menolak jumlah <= 0 dan jumlah yang melebihi saldo.
    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > this.saldo) {
            return false;
        }
        this.saldo -= jumlah;
        return true;
    }

    // Contoh keluaran: 001 | Ani    |    Rp120.000
    public void cetakInfo() {
        System.out.println(nomor + " | "
                + String.format("%-6s", pemilik) + " | "
                + String.format("%12s", formatRupiah(saldo)));
    }

    // Helper private: mengubah 120000 menjadi "Rp120.000"
    private String formatRupiah(int angka) {
        String digit = String.valueOf(angka);
        StringBuilder hasil = new StringBuilder();
        int hitung = 0;
        for (int i = digit.length() - 1; i >= 0; i--) {
            hasil.insert(0, digit.charAt(i));
            hitung++;
            if (hitung % 3 == 0 && i > 0) {
                hasil.insert(0, '.');
            }
        }
        return "Rp" + hasil;
    }
}