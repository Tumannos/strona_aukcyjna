import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetNextLine {
    String getNextLine (String login) throws IOException, IllegalStateException {
        final String passwordsFile = "Konta.txt";
        BufferedReader showLine = new BufferedReader(new FileReader(passwordsFile));
        IsLineExist isLineExist = new IsLineExist();
        if(isLineExist.isLineExist("LOGIN: " + login)) {
            this.moveToLoginLineInFile(login, showLine);
            String passwordForGivenLogin = showLine.readLine();
            showLine.close();
            return passwordForGivenLogin;
        } else {
            String exceptionMessage = String.format(
                    "Oczekiwano że istnieje konto z loginem %s ale nie znaleziono tego loginu w pliku haseł", login);
            throw new IllegalStateException(exceptionMessage);
        }

    }

    private void moveToLoginLineInFile(final String login, final BufferedReader showLine) throws IOException {
        String fileLine = showLine.readLine();
        while (fileLine != null) {
            if (fileLine.equals("LOGIN: " + login)) {
                return;
            }
            fileLine = showLine.readLine();
        }
        String exceptionMessage = String.format(
                "Oczekiwano że istnieje konto z loginem %s ale nie znaleziono tego loginu w pliku haseł", login);
        throw new IllegalStateException(exceptionMessage);
    }
}
