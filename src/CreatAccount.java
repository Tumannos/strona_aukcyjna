import java.io.*;
import java.util.Scanner;

public class CreatAccount {
    String login;
    String password;

    private void setLogin () throws IOException {
        System.out.println("Podaj login: ");
        Scanner scanner = new Scanner(System.in);
        String newLogin = scanner.nextLine();
        IsLineExist loginLine = new IsLineExist();
        if(loginLine.isLineExist("LOGIN: " + newLogin)){
            System.out.println("Już istnieje taki login");
            setLogin();
        }
        else {
            System.out.println("Poprawny login");
            this.login = newLogin;
        }

    }

    private void setPassword(){
        System.out.println("Podaj hasło: ");
        Scanner scanner = new Scanner(System.in);
        String newPassword = scanner.nextLine();
        System.out.println("Podaj ponownie hasło: ");
        String confirmedPassword = scanner.nextLine();
        if (newPassword.equals(confirmedPassword)){
            if(isPasswordCorrect(newPassword)){
                System.out.println("Udało się utworzyć konto!");
                this.password = newPassword;
            }
            else {
                setPassword();
            }
        }
        else {
            System.out.println("Różne hasła!");
            setPassword();
        }
    }

    void saveToFile () throws IOException {
        FileWriter fileToWrite = new FileWriter("Konta.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileToWrite);
        bufferedWriter.write("LOGIN: " + this.login);
        bufferedWriter.newLine();
        bufferedWriter.write("HASŁO: " + this.password);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    boolean isPasswordCorrect(String password){
        if(password.isBlank()){
            System.out.println("Zostawiłeś puste pole");
            return false;
        }
        if(password.contains(this.login)){
            System.out.println("Hasło zbyt podobne do loginu");
            return false;
        }
        if(password.length()>=12){
            System.out.println("Hasło ma więcej niż 12 znaków");
            return false;
        }
        else {
            return true;
        }
    }

    void creatNewAccount () throws IOException {
        System.out.println("ZAREJESTRUJ SIĘ!");
        setLogin();
        setPassword();
        saveToFile();
    }
}
