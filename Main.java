package musicplayer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MusicPlayer player = new MusicPlayer();

        while (true) {

            System.out.println("== MUSIC PLAYER MENU ==");
            System.out.println("1. Add New Song");
            System.out.println("2. Delete Song");
            System.out.println("3. Display All Songs");
            System.out.println("4. Create Playlist");
            System.out.println("5. Add Song to Playlist");
            System.out.println("6. Display All Playlists");
            System.out.println("7. Display Songs in Playlist");
            System.out.println("8. Play Song in Playlist");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                sc.next();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Artist: ");
                    String artist = sc.nextLine();

                    System.out.print("Enter Duration: ");
                    double duration = sc.nextDouble();
                    sc.nextLine();

                    player.addSong(new Song(id, title, artist, duration));
                    break;

                case 2:
                    System.out.print("Enter Song ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    player.deleteSong(deleteId);
                    break;

                case 3:
                    player.displayAllSongs();
                    break;

                case 4:
                    System.out.print("Enter Playlist ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Playlist Name: ");
                    String pname = sc.nextLine();

                    player.createPlaylist(pid, pname);
                    break;

                case 5:
                    System.out.print("Enter Playlist Name: ");
                    String playlistName = sc.nextLine();

                    Playlist playlist = player.getPlaylist(playlistName);
                    if (playlist == null) break;

                    System.out.print("Enter Song ID to add: ");
                    int songIdToAdd = sc.nextInt();
                    sc.nextLine();

                    Song songToAdd = player.getSongById(songIdToAdd);
                    if (songToAdd != null) {
                        playlist.addSong(songToAdd);
                    }
                    break;

                case 6:
                    player.displayAllPlaylists();
                    break;

                case 7:
                    System.out.print("Enter Playlist Name: ");
                    String plName = sc.nextLine();

                    Playlist pl = player.getPlaylist(plName);
                    if (pl != null) {
                        pl.displaySongs();
                    }
                    break;

                case 8:
                    System.out.print("Enter Playlist Name: ");
                    String playListName = sc.nextLine();

                    Playlist playListObj = player.getPlaylist(playListName);
                    if (playListObj == null) break;

                    System.out.print("Enter Song ID to play: ");
                    int playSongId = sc.nextInt();
                    sc.nextLine();

                    playListObj.play(playSongId);
                    break;

                case 9:
                    sc.close();
                    return;

                default:
                    break;
            }
        }
    }
}