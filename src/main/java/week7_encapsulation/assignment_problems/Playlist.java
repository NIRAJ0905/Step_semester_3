package week7_encapsulation.assignment_problems;

import java.util.Arrays;

public class Playlist {
    private final String[] songs; // Private internal array[cite: 7]
    private int songCount;        // Tracked count[cite: 7]

    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.songCount = 0;
    }

    public void addSong(String songTitle) {
        if (songCount < songs.length) {
            songs[songCount] = songTitle;
            songCount++;
        }
    }

    public String[] getSongs() {
        // Returns a safe copy of the active songs, preserving privacy[cite: 7]
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount; // Read-only count[cite: 7]
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked"; // Mutating the copy[cite: 7]

        System.out.println("Playlist Song 0: " + p.getSongs()[0]); // Still "Song A"[cite: 7]
        System.out.println("Song Count: " + p.getSongCount());     // 2[cite: 7]
    }
}