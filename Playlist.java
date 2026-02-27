package musicplayer;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements Playable {

    private int playlistId;
    private String playlistName;
    private List<Song> songs = new ArrayList<>();

    public Playlist(int playlistId, String playlistName) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void addSong(Song song) {
        songs.add(song);
        System.out.println("Song added to playlist.");
    }

    public void removeSong(int songId) {
        songs.removeIf(song -> song.getSongId() == songId);
        System.out.println("Song removed from playlist.");
    }

    public void displaySongs() {
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            songs.forEach(System.out::println);
        }
    }

    private Song findSongById(int songId) {
        return songs.stream()
                .filter(s -> s.getSongId() == songId)
                .findFirst()
                .orElse(null);
    }

    private Song findSongByTitle(String title) {
        return songs.stream()
                .filter(s -> s.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    // Polymorphism (Overriding)

    @Override
    public void play(String title) {
        Song song = findSongByTitle(title);
        if (song != null)
            System.out.println("Playing: " + song.getTitle());
        else
            System.out.println("Song not found.");
    }

    @Override
    public void play(int songId) {
        Song song = findSongById(songId);
        if (song != null)
            System.out.println("Playing: " + song.getTitle());
        else
            System.out.println("Song not found.");
    }

    @Override
    public void pause(String title) {
        System.out.println("Paused: " + title);
    }

    @Override
    public void pause(int songId) {
        System.out.println("Paused song ID: " + songId);
    }

    @Override
    public void stop(String title) {
        System.out.println("Stopped: " + title);
    }

    @Override
    public void stop(int songId) {
        System.out.println("Stopped song ID: " + songId);
    }
}