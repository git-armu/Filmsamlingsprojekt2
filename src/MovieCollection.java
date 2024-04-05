import java.util.ArrayList;
import java.util.Scanner;

public class MovieCollection {
    private ArrayList<Movie> moviesArrayList;
    Scanner scanner = new Scanner(System.in);

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
            System.out.println(movie.toString());
            System.out.println("#########################################################");
        }
    }

    public Movie searchMovie(String title) {
        for (Movie movie : moviesArrayList) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                System.out.println("#########################################################");
                System.out.println("# Your movie has been found.");
                System.out.println("# Title: " + movie.getTitle());
                System.out.println("# Director: " + movie.getDirector());
                System.out.println("# Year created: " + movie.getYearCreated());
                System.out.println("# In color : " + (movie.getIsInColor() ? "Yes" : "No"));
                System.out.println("# Length in minutes : " + movie.getLengthInMinutes());
                System.out.println("# Genre: " + movie.getGenre());
                System.out.println("#########################################################");
                return movie;
            }
        }
        System.out.println("Movie not found!");
        return null;
    }

    public boolean editMovie(String title) {
        Movie movieToEdit = searchMovie(title);
        if (movieToEdit != null) {
            boolean continueEdit = true;

            while (continueEdit) {
                System.out.println("Select what you want to edit:");
                System.out.println("1. Title");
                System.out.println("2. Director");
                System.out.println("3. Year created");
                System.out.println("4. In color");
                System.out.println("5. Length in minutes");
                System.out.println("6. Genre");
                System.out.println("7. Exit editing");

                int editChoice = scanner.nextInt();
                scanner.nextLine();

                switch (editChoice) {
                    case 1:
                        System.out.println("Enter new title:");
                        String newTitle = scanner.nextLine();
                        movieToEdit.setTitle(newTitle);
                        break;
                    case 2:
                        System.out.println("Enter new director:");
                        String newDirector = scanner.nextLine();
                        movieToEdit.setDirector(newDirector);
                        break;
                    case 3:
                        System.out.println("Enter new year created:");
                        int newYearCreated = scanner.nextInt();
                        scanner.nextLine();
                        movieToEdit.setYearCreated(newYearCreated);
                        break;
                    case 4:
                        System.out.println("Is the movie in color? (true/false):");
                        boolean newIsInColor = scanner.nextBoolean();
                        scanner.nextLine();
                        movieToEdit.setIsInColor(newIsInColor);
                        break;
                    case 5:
                        System.out.println("Enter new length in minutes:");
                        int newLengthInMinutes = scanner.nextInt();
                        scanner.nextLine();
                        movieToEdit.setLengthInMinutes(newLengthInMinutes);
                        break;
                    case 6:
                        System.out.println("Enter new genre:");
                        String newGenre = scanner.nextLine();
                        movieToEdit.setGenre(newGenre);
                        break;
                    case 7:
                        continueEdit = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            }
            return true;
        } else {
            System.out.println("Movie not found!");
            return false;
        }
    }
}

