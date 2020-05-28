import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class UserList {
        void showUserList () throws IOException {
            ArrayList<String> usersArray = new ArrayList<>();
            BufferedReader showLine = new BufferedReader(new FileReader("Konta.txt"));
            String fileLine = showLine.readLine();
            int i = 1;
            while (fileLine != null){
                if(fileLine.contains("HASŁO: ")){
                    fileLine = showLine.readLine();
                }
                else{
                    usersArray.add(i + " " + fileLine.substring(7,fileLine.length()));
                    Arrays.sort(new ArrayList[]{usersArray});
                    fileLine = showLine.readLine();
                    i++;
                }
            }
            for (String s : usersArray) {
                System.out.println(s);
            }
        }
}
