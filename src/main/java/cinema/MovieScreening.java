package cinema;

import java.time.LocalTime;
import java.util.Objects;

/**
 * Представляє показ фільму з такими деталями, як назва, жанр, тривалість, режисер і час початку.
 */
public class MovieScreening {
    private String title;
    private String genre;
    private int duration; // in minutes
    private String director;
    private LocalTime startTime;

    public MovieScreening(String title, String genre, int duration, String director, LocalTime startTime) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.director = director;
        this.startTime = startTime;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public String getDirector() {
        return director;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    @Override
    public String toString() {
        return "MovieScreening{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", director='" + director + '\'' +
                ", startTime=" + startTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieScreening that = (MovieScreening) o;
        return duration == that.duration &&
                Objects.equals(title, that.title) &&
                Objects.equals(genre, that.genre) &&
                Objects.equals(director, that.director) &&
                Objects.equals(startTime, that.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, duration, director, startTime);
    }
}
