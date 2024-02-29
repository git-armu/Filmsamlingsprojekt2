import java.util.Scanner;

public class UserInterface {

    Controller controller = new Controller();

    Scanner scanner = new Scanner(System.in);

    public UserInterface() {
    }

    public void startMenu() {
        while (true) {
            System.out.println("#############################################");
            System.out.println("# Welcome to your collection                #");
            System.out.println("# Press 1 to add a movie.                   #");
            System.out.println("# Press 2 to cancel.                        #");
            System.out.println("# Press 3 to view movies.                   #");
            System.out.println("# Press 4 to search movies.                 #");
            System.out.println("# Press 5 to edit a movie.                  #");
            System.out.println("#############################################");
            int menu = scanner.nextInt();

            scanner.nextLine();
            if (menu == 1) {
                menu1();
            } else if (menu == 2) { // tjekker hvis man taster 2 for cancel - så bruges break; for at stoppe det ellers uendelige loop
                menu2();
            } else if (menu == 3) {
                menu3();
            } else if (menu == 4) {
                menu4();
            } else if (menu == 5) {
                controller.displayMovies();
                System.out.println("What movie would you like to edit?");
                String moveToEdit = scanner.nextLine();
            }
        }
    }

    public void menu1() {
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
        System.out.println("Movie " + title + " added!");
    }

    public void menu2() {
        System.out.println("Cancelled.");
    }

    public void menu3() {
        controller.displayMovies();
    }

    public void menu4() {
        System.out.println("What movie would you like to search for?");
        String search = scanner.next();
        controller.searchMovie(search);
    }
}