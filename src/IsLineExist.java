import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IsLineExist {
    boolean isLineExist(String line) throws IOException {
        BufferedReader showLine = new BufferedReader(new FileReader("Konta.txt"));
        String fileLine = showLine.readLine();
        while (fileLine != null) {
            if(fileLine.equals(line)){
                return true;
            }
            fileLine = showLine.readLine();
        }
        showLine.close();
        return false;
    }
}
