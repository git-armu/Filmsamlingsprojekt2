public class Controller { // controller class (UML)

    private MovieCollection movieCollection;

    public Controller() {
        movieCollection = new MovieCollection();
    }

    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre) {
        movieCollection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
    }

    public void displayMovies() {
        movieCollection.displayMovies();
    }

    public void searchMovie(String title) {
        movieCollection.searchMovie(title);
    }

    public void editMovie(String title) {
        movieCollection.editMovie(title);
    }
}