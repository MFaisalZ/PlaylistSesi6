import java.util.Scanner;

public class PlaylistSesi6 {
    private static final int MAX_SIZE = 200; //ukuran untuk max musik
    private String[] songs; //untuk string variabel songs
    private int top; // untuk integer variabel top

//public untuk Playlist dengan class yang mesti sama pada baris ke 3
    public PlaylistSesi6() {
        songs = new String[MAX_SIZE];
        top = -1;
    }
//untuk fungsi tambah antrian
    public void tambahAntrian(String song) {
        if (top < MAX_SIZE - 1) {
            top++;
            songs[top] = song;
            System.out.println(song + " telah ditambahkan ke dalam playlist.");
        } else {
            System.out.println("Playlist sudah penuh!");
        }
    }
//untuk fungsi hapus antrian
    public void hapusAntrian() {
        if (top >= 0) {
            String song = songs[top];
            top--;
            System.out.println(song + " telah dihapus dari playlist.");
        } else {
            System.out.println("Playlist sudah kosong!");
        }
    }
//untuk masukkan antrian
    public void insertTambah(String song, int index) {
        if (top < MAX_SIZE - 1) {
            if (index >= 0 && index <= top + 1) {
                for (int i = top; i >= index; i--) {
                    songs[i + 1] = songs[i];
                }
                songs[index] = song;
                top++;
                System.out.println(song + " telah ditambahkan ke dalam playlist pada posisi " + index + ".");
            } else {
                System.out.println("Indeks tidak valid!");
            }
        } else {
            System.out.println("Playlist sudah penuh!");
        }
    }
//untuk fungsi menghapus
    public void removeHapus(int index) {
        if (top >= 0) {
            if (index >= 0 && index <= top) {
                String song = songs[index];
                for (int i = index; i < top; i++) {
                    songs[i] = songs[i + 1];
                }
                top--;
                System.out.println(song + " telah dihapus dari playlist pada posisi " + index + ".");
            } else {
                System.out.println("Indeks tidak valid!");
            }
        } else {
            System.out.println("Playlist sudah kosong!");
        }
    }
//untuk fungsi menghapus pada playlist
    public void hapusSemua() {
        top = -1;
        System.out.println("Playlist sudah dihapus semua!");
    }
//untuk fungsi menampilkan playlist
    public void menampilkanAntrian() {
        if (top >= 0) {
            System.out.println("Playlist lagu:");
            for (int i = top; i >= 0; i--) {
                System.out.println((top - i + 1) + ". " + songs[i]);
            }
        } else {
            System.out.println("Playlist kosong!");
        }
    }
//script dibawah untuk membuat menu serta perulangannya menggunakan do while
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlaylistSesi6 urutanLagu = new PlaylistSesi6();

        int choice = 0;
        do {
            System.out.println("\nMenu Playlist:");
            System.out.println("1. Tampilkan Data Playlist");
            System.out.println("2. Tambah Data Playlist");
            System.out.println("3. Hapus Data Playlist");
            System.out.println("4. Tambah Data Playlist di urutan tertentu");
            System.out.println("5. Hapus Data Playlist di urutan tertentu");
            System.out.println("6. Hapus semua Playlist");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    urutanLagu.menampilkanAntrian();
                    break;
                case 2:
                    System.out.print("Masukkan judul lagu: ");
                    String song = scanner.nextLine();
                    urutanLagu.tambahAntrian(song);
                    break;
                case 3:
                    urutanLagu.hapusAntrian();
                    break;
                case 4:
                    System.out.print("Masukkan judul lagu: ");
                    String newSong = scanner.nextLine();
                    System.out.print("Masukkan posisi untuk menambahkan lagu: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    urutanLagu.insertTambah(newSong, index);
                    break;
                case 5:
                    System.out.print("Masukkan posisi untuk menghapus lagu: ");
                    int removeIndex = scanner.nextInt();
                    scanner.nextLine();
                    urutanLagu.removeHapus(removeIndex);
                    break;
                case 6:
                    urutanLagu.hapusSemua();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
