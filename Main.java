import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        MoviesCollection movieCollection = new MoviesCollection();
        movieCollection.load("movies.json");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Print all movies");
            System.out.println("2. Search for a movie");
            System.out.println("3. Sort by year (ascending)");
            System.out.println("4. Sort by year (descending)");
            System.out.println("5. Sort by title (ascending)");
            System.out.println("6. Sort by title (descending)");
            System.out.println("7. Sort by director (ascending)");
            System.out.println("8. Sort by director (descending)");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    movieCollection.printMovies();
                    break;
                case 2:
                    System.out.println("Enter search query:");
                    String query = scanner.nextLine();
                    List<Movie> results = movieCollection.search(query);
                    if (results.isEmpty()) {
                        System.out.println("No results found.");
                    } else {
                        System.out.println("Results:");
                        for (Movie movie : results) {
                            System.out.println(movie);
                        }
                    }
                    break;
                case 3:
                    movieCollection.sortYearAsc();
                    System.out.println("Sorted by year (ascending).");
                    break;
                case 4:
                    movieCollection.sortYearDesc();
                    System.out.println("Sorted by year (descending).");
                    break;
                case 5:
                    movieCollection.sortTitleAsc();
                    System.out.println("Sorted by title (ascending).");
                    break;
                case 6:
                    movieCollection.sortTitleDesc();
                    System.out.println("Sorted by title (descending).");
                    break;
                case 7:
                    movieCollection.sortDirectorAsc();
                    System.out.println("Sorted by director (ascending).");
                    break;
                case 8:
                    movieCollection.sortDirectorDesc();
                    System.out.println("Sorted by director (descending).");
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

}
