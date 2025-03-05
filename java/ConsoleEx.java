import java.io.Console;

public class ConsoleEx {
    public static void main(String[]args){
        Console console=System.console();
        if (console==null){
            System.out.println("no console");
            return;
        }

        String username= console.readLine("enter name:");
        char[] passwordchars = console.readPassword("enter password:");
        String password=new String(passwordchars);
        System.out.println("username:"+username);
        System.out.println("Password entered"+password);

    }
}
