import java.io.IOException;
import java.util.Scanner;

public class SignIn {
    String login;

    boolean getUserLogin() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj login: ");
        String login = scanner.nextLine();
        IsLineExist loginLine = new IsLineExist();
        if(loginLine.isLineExist("LOGIN: " + login)){
            this.login = login;
            return true;
        }
        else {
            System.out.println("Niepoprawny login");
            return false;
        }
    }

    boolean getUserPassword() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj hasło: ");
        String password = scanner.nextLine();
        GetNextLine passwordLine = new GetNextLine();
        return passwordLine.getNextLine(this.login).equals("HASŁO: " + password);
    }

    void signIn() throws IOException {
        System.out.println("ZALOGUJ SIĘ!");
        if(getUserLogin() && getUserPassword()){
            System.out.println("Udało ci się zalogować do systemu");
        }
        else {
            System.out.println("Spróbuj zalogować sie jeszcze raz");
            signIn();
        }
    }

}
