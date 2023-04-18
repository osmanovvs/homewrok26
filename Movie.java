import java.util.List;

public class Movie {
    private String title;
    private int year;
    private String director;
    private String description;
    private List<String> actors;

    public Movie(String title, int year, String director, String description, List<String> actors) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.description = description;
        this.actors = actors;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return String.format("Movie{title='%s' , year=%d, director='%s', description='%s', actors=%s}", title, year, director, description, actors);
    }
}
