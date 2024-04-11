import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);

    public void startMenu() {
        while (true) {
            controller.mainMenu();
            try {
                int menuOption = scanner.nextInt();
                scanner.nextLine();

                switch (menuOption) {
                    case 1:
                        controller.menu1();
                        break;
                    case 2:
                        controller.menu2();
                        return;
                    case 3:
                        controller.menu3();
                        break;
                    case 4:
                        controller.menu4();
                        break;
                    case 5:
                        controller.menu5();
                        break;
                    case 6:
                        controller.menu6();
                        break;
                    case 7:
                        controller.menu7();
                        break;
                    default:
                        System.out.println("Invalid. Enter enter a number between 1 and 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid. Enter a number between 1 and 7.");
                scanner.nextLine();
            }
        }
    }
}