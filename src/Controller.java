import java.util.Scanner;

public class Controller {

    private MovieCollection movieCollection;
    Scanner scanner = new Scanner(System.in);

    public Controller() {
        movieCollection = new MovieCollection();
    }

    public void mainMenu() {
        System.out.println("#############################################");
        System.out.println("# Welcome to your collection                #");
        System.out.println("# Enter 1 to add a movie.                   #");
        System.out.println("# Enter 2 to cancel.                        #");
        System.out.println("# Enter 3 to view movies.                   #");
        System.out.println("# Enter 4 to search movies.                 #");
        System.out.println("# Enter 5 to edit a movie.                  #");
        System.out.println("# Enter 6 to delete a movie.                #");
        System.out.println("#############################################");
    }

    public void menu1() {
        try {
            System.out.println("Title?");
            String title = scanner.nextLine();

            System.out.println("Director?");
            String director = scanner.nextLine();

            System.out.println("Year created?");
            int yearCreated = Integer.parseInt(scanner.nextLine());

            System.out.println("In color? (true/false)");
            boolean isInColor = Boolean.parseBoolean(scanner.nextLine());

            System.out.println("Length in minutes?");
            int lengthInMinutes = Integer.parseInt(scanner.nextLine());

            System.out.println("Genre?");
            String genre = scanner.nextLine();

            movieCollection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
            System.out.println("Movie " + title + " added!");
        }  catch (NumberFormatException nfe) {
            System.out.println("Invalid. Enter a number.");
        }
    }

    public void menu2() {
        System.out.println("Cancel.");
    }

    public void menu3() {
        movieCollection.displayMovies();
    }

    public void menu4() {
        System.out.println("What movie would you like to search for?");
        String search = scanner.next();
        movieCollection.searchMovie(search);
    }

    public void menu5() {
        System.out.println("Here's a display of the movies currently in your collection:");
        movieCollection.displayMovies();

        System.out.println("Which movie would you like to edit?");
        String title = scanner.nextLine();

        movieCollection.editMovie(title);
    }

    public void menu6() {
        System.out.println("What movie would you like to delete?");
        String titleToDelete = scanner.nextLine();
        movieCollection.deleteMovie(titleToDelete);
    }
}
