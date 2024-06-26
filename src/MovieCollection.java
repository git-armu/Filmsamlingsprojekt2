import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
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

    public void displayMovies(String sortBy, String sortByTwo) {
        if (moviesArrayList.isEmpty()) {
            System.out.println("No movies in collection.");
            return;
        }

        Comparator<Movie> comparator = null;
        Comparator<Movie> comparatorTwo = null;
        switch (sortBy) {
            case "title":
                comparator = Comparator.comparing(Movie::getTitle);
                break;
            case "director":
                comparator = Comparator.comparing(Movie::getDirector);
                break;
            case "year":
                comparator = Comparator.comparing(Movie::getYearCreated);
                break;
            case "color":
                comparator = Comparator.comparing(Movie::getIsInColor);
                break;
            case "length":
                comparator = Comparator.comparing(Movie::getLengthInMinutes);
                break;
            case "genre":
                comparator = Comparator.comparing(Movie::getGenre);
                break;
            default:
                System.out.println("Invalid. Enter correct attribute.");
                return;
        }

        switch (sortByTwo) {
            case "title":
                comparatorTwo = Comparator.comparing(Movie::getTitle);
                break;
            case "director":
                comparatorTwo = Comparator.comparing(Movie::getDirector);
                break;
            case "year":
                comparatorTwo = Comparator.comparing(Movie::getYearCreated);
                break;
            case "color":
                comparatorTwo = Comparator.comparing(Movie::getIsInColor);
                break;
            case "length":
                comparatorTwo = Comparator.comparing(Movie::getLengthInMinutes);
                break;
            case "genre":
                comparatorTwo = Comparator.comparing(Movie::getGenre);
                break;
            default:
                System.out.println("Invalid. Enter correct attribute.");
                return;
        }

        Comparator<Movie> comparatorsTogether = comparator.thenComparing(comparatorTwo);
        moviesArrayList.sort(comparatorsTogether);

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
                System.out.println(movie.toString());
                System.out.println("#########################################################");
                return movie;
            }
        }
        System.out.println("Movie not found!");
        return null;
    }

    public boolean editMovie(String title) {
        if (moviesArrayList.isEmpty()) {
            System.out.println("No movies found in the collection!");
            return false;
        }
        Movie movieToEdit = searchMovie(title);
        if (movieToEdit == null) {
            return false;
        }
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
                    System.out.println("Invalid. Enter a number between 1 and 7.");
            }
        }
        return true;
    }

    public void deleteMovie(String title) {
        for (int i = 0; i < moviesArrayList.size(); i++) {
            Movie movie = moviesArrayList.get(i);
            if (movie.getTitle().equalsIgnoreCase(title)) {
                moviesArrayList.remove(i);
                System.out.println("Movie deleted successfully.");
                return;
            }
        }
        System.out.println("Movie not found!");
    }

    public void saveMovieCollection(String filename) {
        try {
            PrintStream output = new PrintStream(new File(filename));
            for (Movie movie : moviesArrayList) {
                output.println(movie.getTitle());
                output.println(movie.getDirector());
                output.println(movie.getYearCreated());
                output.println(movie.getIsInColor());
                output.println(movie.getLengthInMinutes());
                output.println(movie.getGenre());
            }
            System.out.println("Movie collection saved to " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public void loadMovieCollection() {
        System.out.println("Enter the name of the file to load the movie collection from:");
        String filename = scanner.nextLine();

        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String title = fileScanner.nextLine();
                String director = fileScanner.nextLine();
                int yearCreated = Integer.parseInt(fileScanner.nextLine());
                boolean isInColor = Boolean.parseBoolean(fileScanner.nextLine());
                int lengthInMinutes = Integer.parseInt(fileScanner.nextLine());
                String genre = fileScanner.nextLine();

                addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
            }

            System.out.println("Movie collection loaded from " + filename + ".");
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file '" + filename + "' was not found.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in the file.");
        }
    }
}