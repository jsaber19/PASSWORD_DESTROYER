import java.util.Scanner;

public class Logic {
    private String password;
    public int count = 0;
    private int method;
    private char[] characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()".toCharArray(); // https://stackoverflow.com/questions/17575840/better-way-to-generate-array-of-all-letters-in-the-alphabet

    public Logic(){
        Scanner kb = new Scanner(System.in);
        System.out.println("Type in a password you want to break");
        password = kb.nextLine();
        System.out.println("Type '1' if you want to break via brute force. Type '2' if you want to break via common words. Type '3' if you want to break by ");
        method = kb.nextInt(); // temp until we set up button events
    }

    public void bruteForce(){
        for (int i = 0; i < password.length(); i++){
            for (int j = 0; j < characters.length; j++){
                count++;
                if (password.charAt(i) == characters[j]){  }
            }
        }
    }
}
