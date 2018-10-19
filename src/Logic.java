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
        System.out.println("Type '1' if you want to break via brute force. Type '2' if you want to break via common passwords. Type '3' if you want to break by ");
        method = kb.nextInt(); // temp until we set up button events
    }

    public int bruteForce(){
        int length = 1; // current length testing

//        int check = 0;
//        int tracker = 0; // counts the number of attempts made
//        int level = 1; // the length of the password we're guessing
//        String saved = "";
//        while (check == 0){ // until we find the password
//            String guess = "";
//                int k = 0; // arbitrary int to track level
//                while (k < level){
//                    guess = "";
//                    for (int i = 0; i < characters.length; i++){
//                        guess+=characters[i];
//                        tracker++;
//                        if (guess.equals(password)) {
//                            check++;
//                            saved = guess;
//                        }
//                        else { guess = guess.substring(0, guess.length()-1); }
//                    }
//
//                }
//
//            tracker++;
//        }
        return 0;
    }

    public int commonPasswords(){
        int tracker = 0;
        String[] common = {"123456", "password", "12345678", "qwerty", "12345",
                "123456789", "letmein", "1234567", "football", "iloveyou", "admin",
                "welcome", "monkey", "login", "abc123", "starwars", "123123", "dragon",
                "passw0rd", "master", "hello", "freedom", "whatever", "qazwsx", "trustno1"};
        for (String s : common){
            tracker++;
            if (s.equals(password)){
                return 1;
            }
        }
        return -1;
    }
}
