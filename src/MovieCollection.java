import java.util.ArrayList;
import java.util.Scanner;

public class MovieCollection {
    private ArrayList<Movie> moviesArrayList;

    public MovieCollection() {
        moviesArrayList = new ArrayList<>();
    }

    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre) {
        Movie movie = new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
        moviesArrayList.add(movie);
    }

    public void displayMovies() {
        for (int i = 0; i < moviesArrayList.size(); i++) {
            Movie movie = moviesArrayList.get(i);
            System.out.println("#########################################################");
            System.out.println("# Title: " + movie.getTitle());
            System.out.println("# Director: " + movie.getDirector());
            System.out.println("# Year created: " + movie.getYearCreated());
            System.out.println("# In color : " + (movie.getIsInColor() ? "Yes" : "No"));
            System.out.println("# Length in minutes : " + movie.getLengthInMinutes());
            System.out.println("# Genre: " + movie.getGenre());
            System.out.println("#########################################################");
        }
    }

    public Movie searchMovie(String title) {
        boolean movieFound = false;
        for (Movie movie : moviesArrayList) {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("#########################################################");
                System.out.println("# Your movie has been found.");
                System.out.println("# Title: " + movie.getTitle());
                System.out.println("# Director: " + movie.getDirector());
                System.out.println("# Year created: " + movie.getYearCreated());
                System.out.println("# In color : " + (movie.getIsInColor() ? "Yes" : "No"));
                System.out.println("# Length in minutes : " + movie.getLengthInMinutes());
                System.out.println("# Genre: " + movie.getGenre());
                System.out.println("#########################################################");
                movieFound = true;
            }
        }
            if (!movieFound) {
                System.out.println("No movies found.");
            }
         // TODO - Lær om ToString
        return null;
    }

    public void editMovie(String title) { // har prøvet at implementere searchMovie her i stedet, men får errors jeg ikke forstår...
        boolean movieFound = false;
        for (Movie movie : moviesArrayList) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter title.");
                String newTitle = scanner.nextLine();

                System.out.println("Director");
                String newDirector = scanner.nextLine();

                System.out.println("Year created");
                int newYearCreated = Integer.parseInt(scanner.nextLine());

                System.out.println("Is in color?");
                boolean newIsInColor = Boolean.parseBoolean(scanner.nextLine());

                System.out.println("Length in minutes");
                int newLengthInMinutes = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter genre");
                String newGenre = scanner.nextLine();

                movie.setTitle(newTitle);
                movie.setDirector(newDirector);
                movie.setYearCreated(newYearCreated);
                movie.setIsInColor(newIsInColor);
                movie.setLengthInMinutes(newLengthInMinutes);
                movie.setGenre(newGenre);

                System.out.println("Your movie has been updated.");
                movieFound = true;
                break;
            }
        }
        if (!movieFound) {
            System.out.println("Movie not found!");
        }
    }
}

