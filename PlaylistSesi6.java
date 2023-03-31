import java.util.Scanner;

public class PlaylistSesi6 {
    private static final int MAX_SIZE = 100;
    private String[] songs;
    private int top;

    public Playlist() {
        songs = new String[MAX_SIZE];
        top = -1;
    }

    public void push(String song) {
        if (top < MAX_SIZE - 1) {
            top++;
            songs[top] = song;
            System.out.println(song + " telah ditambahkan ke dalam playlist.");
            System.out.println("\n");
        } else {
            System.out.println("Playlist sudah penuh!");
        }
    }

    public void pop() {
        if (top >= 0) {
            String song = songs[top];
            top--;
            System.out.println(song + " telah dihapus dari playlist.");
        } else {
            System.out.println("Playlist sudah kosong!");
        }
    }

    public void insert(String song, int index) {
        if (top < MAX_SIZE - 1) {
            if (index >= 0 && index <= top + 1) {
                for (int i = top; i >= index; i--) {
                    songs[i + 1] = songs[i];
                }
                songs[index] = song;
                top++;
                System.out.println(song + " telah ditambahkan ke dalam playlist pada posisi " + index + ".");
                System.out.println("\n");
            } else {
                System.out.println("Indeks tidak valid!");
            }
        } else {
            System.out.println("Playlist sudah penuh!");
        }
    }

    public void remove(int index) {
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

    public void removeAll() {
        top = -1;
        System.out.println("Playlist sudah dihapus semua!");
    }

    public void display() {
        if (top >= 0) {
            System.out.println("Playlist lagu:");
            for (int i = top; i >= 0; i--) {
                System.out.println((top - i + 1) + ". " + songs[i]);
            }
        } else {
            System.out.println("Playlist kosong!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();

        int choice = 0;
        do {
            System.out.println("\n");
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
                    playlist.display();
                    break;
                case 2:
                    System.out.print("Masukkan judul lagu: ");
                    String song = scanner.nextLine();
                    playlist.push(song);
                    break;
                case 3:
                    System.out.println("\n");
                    playlist.pop();
                    break;
                case 4:
                    System.out.print("Masukkan judul lagu: ");
                    String newSong = scanner.nextLine();
                    System.out.print("Masukkan posisi untuk menambahkan lagu: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    playlist.insert(newSong, index);
                    break;
                case 5:
                    System.out.print("Masukkan posisi untuk menghapus lagu: ");
                    int removeIndex = scanner.nextInt();
                    scanner.nextLine();
                    playlist.remove(removeIndex);
                    break;
                case 6:
                    playlist.removeAll();
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