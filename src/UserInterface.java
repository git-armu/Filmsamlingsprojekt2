import java.util.Scanner;

public class UserInterface {
    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);

    public UserInterface() {
    }

    public void startMenu() {
        while (true) {
            controller.mainMenu();
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
                default:
                    System.out.println("Invalid. Please enter a number between 1 and 5.");
            }
        }
    }
}
