import java.io.*;

public class Start {

    public static void main(String args[]) throws IOException {
    CreatAccount test1 = new CreatAccount();
        test1.creatNewAccount();
    SignIn test2 = new SignIn();
        test2.signIn();
    UserList test3 = new UserList();
        test3.showUserList();
    }
}
