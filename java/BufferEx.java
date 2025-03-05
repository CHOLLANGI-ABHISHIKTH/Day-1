import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferEx{
    public static void main(String[] args) throws IOException {
        InputStreamReader name = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(name);
        System.out.println("Enter your name");
        String myname = br.readLine();
        System.out.println("Hello"+ myname+"!");
        System.out.println("Enter a boolean (true/false):");
        boolean booth = Boolean.parseBoolean(br.readLine());
        System.out.println("Boolean: " + booth);
        System.out.println("Enter integer");
    }
}