import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Represents an album with a list of songs.
 */
public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    /**
     * Constructs a new Album with the specified name and artist.
     *
     * @param name   the name of the album
     * @param artist the artist of the album
     */
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    /**
     * Gets the name of the album.
     *
     * @return the name of the album
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the artist of the album.
     *
     * @return the artist of the album
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Gets the list of songs in the album.
     *
     * @return the list of songs
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * Adds a song to the album.
     *
     * @param title    the title of the song
     * @param duration the duration of the song
     * @return true if the song was added, false if it already exists
     */
    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    /**
     * Adds a song to the playlist by track number.
     *
     * @param trackNumber the track number of the song in the album
     * @param playlist    the playlist to add the song to
     * @return true if the song was added, false otherwise
     */
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if (index >= 0 && index < this.songs.size()) {
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album doesn't have a track " + trackNumber);
        return false;
    }

    /**
     * Adds a song to the playlist by title.
     *
     * @param title    the title of the song
     * @param playlist the playlist to add the song to
     * @return true if the song was added, false otherwise
     */
    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song song = findSong(title);
        if (song != null) {
            playlist.add(song);
            return true;
        }
        System.out.println("This album doesn't have a song titled " + title);
        return false;
    }

    /**
     * Finds a song in the album by title.
     *
     * @param title the title of the song
     * @return the song if found, null otherwise
     */
    private Song findSong(String title) {
        for (Song song : this.songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }
        return null;
    }
}
