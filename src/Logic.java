import java.util.Arrays;
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

    // http://prembharticodes.blogspot.com/2011/10/brute-force-algorithm-for-password.html
    public int bruteForce(){

        // initialize char array for guesses
        char[] guess = new char[0];
        Arrays.fill(guess, characters[0]);

        // make attempt to represent guess as a String
        String attempt = "";
        for (char c : guess) { attempt += c; }

        while(count < 5000){ // until you've reached 5000 attempts
            if (attempt.equals(password)){
                count++; // final increment
                return 1; // found it!
            }

            // set attempt to represent the current guess
            attempt = "";
            for (char c : guess) { attempt += c; }
            count++; // means the if branch wasn't activated but still need to track each attempt


            /**
             * Making new passwords
             */
            int index = guess.length - 1; // always start index from last index of current guess

            while (index >= 0){ // will make a new guess

                // if you've gone through every char in characters for the current index
                if (guess[index] == characters[characters.length-1]) {

                    // if the first element has also gone through every available char in characters
                    if (index == 0){
                        guess = new char[guess.length + 1]; // make a new guess that's one element longer
                        Arrays.fill(guess, characters[0]); // default every element the first element of characters
                        break; // try the password
                    }

                    // if you have not reached the first element yet
                    else {
                        guess[index] = characters[0]; // default the element back to the first element of characters
                        index--; // move on to the index one lower
                    }
                }

                // if you haven't gone through every available char for the current index
                else {
                    guess[index] = characters[Arrays.binarySearch(characters, guess[index]) + 1]; // try the next char at the current index
                    break; // try the password
                }

            } // end while loop for making passwords

        } // end while loop for guessing passwords

        return -1; // couldn't find it
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
