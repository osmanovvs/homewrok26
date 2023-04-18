import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MoviesCollection {

    private List<Movie> movies;

    public MoviesCollection() {
        movies = new ArrayList<>();
    }

    public void load(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            Gson gson = new GsonBuilder().create();
            // Определяем тип списка объектов, который мы ожидаем получить из файла JSON
            Type listType = new TypeToken<ArrayList<Movie>>() {}.getType();
            // Используем метод fromJson() для преобразования JSON-строки в список объектов класса Movie
            movies = gson.fromJson(reader, listType);
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }


    public void printMovies() {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public List<Movie> search(String query) {
        List<Movie> results = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(query.toLowerCase())) {
                results.add(movie);
            }
        }
        return results;
    }

    public void sortYearAsc() {
        movies.sort(Comparator.comparing(Movie::getYear));
    }

    public void sortYearDesc() {
        movies.sort(Comparator.comparing(Movie::getYear).reversed());
    }

    public void sortTitleAsc() {
        movies.sort(Comparator.comparing(Movie::getTitle));
    }

    public void sortTitleDesc() {
        movies.sort(Comparator.comparing(Movie::getTitle).reversed());
    }

    public void sortDirectorAsc() {
        movies.sort(Comparator.comparing(Movie::getDirector));
    }

    public void sortDirectorDesc() {
        movies.sort(Comparator.comparing(Movie::getDirector).reversed());
    }
}
