import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> moviesArrayList = new ArrayList<>();

    public MovieCollection() {
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
            System.out.println("# In color : " + (movie.getisInColor() ? "Yes" : "No"));
            System.out.println("# Length in minutes : " + movie.getLengthInMinutes());
            System.out.println("# Genre: " + movie.getGenre());
            System.out.println("#########################################################");
        }
    }

    public void searchMovie(String title) {

        for (Movie movie : moviesArrayList) {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("#########################################################");
                System.out.println("# Your movie has been found.");
                System.out.println("# Title: " + movie.getTitle());
                System.out.println("# Director: " + movie.getDirector());
                System.out.println("# Year created: " + movie.getYearCreated());
                System.out.println("# In color : " + (movie.getisInColor() ? "Yes" : "No"));
                System.out.println("# Length in minutes : " + movie.getLengthInMinutes());
                System.out.println("# Genre: " + movie.getGenre());
                System.out.println("#########################################################");
            }
        }
        if (moviesArrayList.isEmpty()) {
            System.out.println("No movies found.");
        }
    }
}
