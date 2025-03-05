public class CommanEx {
    public static void main(String[] args) {
        if (args.length<2){
            System.out.println("Console");
            return;
        }
        String username = args[0];
        String password = args[1];
        System.out.println("username"+ username);
        System.out.println("password"+password);
    }
}