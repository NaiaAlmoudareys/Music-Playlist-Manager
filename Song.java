/**
 * Represents a song with a title and duration.
 */
public class Song {
    private String title;
    private double duration;

    /**
     * Constructs a new Song with the specified title and duration.
     *
     * @param title    the title of the song
     * @param duration the duration of the song
     */
    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    /**
     * Gets the title of the song.
     *
     * @return the title of the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the duration of the song.
     *
     * @return the duration of the song
     */
    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
