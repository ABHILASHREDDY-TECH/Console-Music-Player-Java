package musicplayer;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {

    private List<Song> allSongs = new ArrayList<>();
    private List<Playlist> playlists = new ArrayList<>();

    public void addSong(Song song) {
        allSongs.add(song);
        System.out.println("Song added successfully.");
    }

    public void deleteSong(int songId) {
        allSongs.removeIf(song -> song.getSongId() == songId);
        System.out.println("Song deleted.");
    }

    public void displayAllSongs() {
        if (allSongs.isEmpty())
            System.out.println("No songs available.");
        else
            allSongs.forEach(System.out::println);
    }

    public void createPlaylist(int id, String name) {
        playlists.add(new Playlist(id, name));
        System.out.println("Playlist created.");
    }

    public Playlist getPlaylist(String name) {
        return playlists.stream()
                .filter(p -> p.getPlaylistName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void displayAllPlaylists() {
        if (playlists.isEmpty())
            System.out.println("No playlists created.");
        else
            playlists.forEach(p -> System.out.println(p.getPlaylistName()));
    }

    public Song getSongById(int id) {
        for (Song song : allSongs) {
            if (song.getSongId() == id) {
                return song;
            }
        }
        return null;
    
	}
}