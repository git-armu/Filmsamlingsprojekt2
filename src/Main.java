import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();

        while (true) {
            System.out.println("#############################################");
            System.out.println("# Welcome to your collection                #");
            System.out.println("# Press 1 to add a movie.                   #");
            System.out.println("# Press 2 to cancel.                        #");
            System.out.println("# Press 3 to view movies.                   #");
            System.out.println("# Press 4 to search movies.                 #");
            System.out.println("#############################################");
            int menu = scanner.nextInt();

            scanner.nextLine();

            if (menu == 1) {
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

                controller.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
                System.out.println("Movie " + title + "added!");

            } else if (menu == 2) { // tjekker hvis man taster 2 for cancel - så bruges break; for at stoppe det ellers uendelige loop
                System.out.println("Cancelled.");
                break;
            } else if (menu == 3) {
                controller.displayMovies();
            } else if (menu == 4) {
                System.out.println("What movie would you like to search for?");
                String search = scanner.nextLine();
                controller.searchMovie(search);
            }
        }







    }
}