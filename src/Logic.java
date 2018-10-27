import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Logic {
    private String password;
    public int count = 0;

    // available characters for use in password
    private char[] characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()".toCharArray(); // https://stackoverflow.com/questions/17575840/better-way-to-generate-array-of-all-letters-in-the-alphabet

    // constructor for logic object to store password and try an algorithm on
    public Logic(String password){
        this.password = password;
        Arrays.sort(characters);
    }

    // http://prembharticodes.blogspot.com/2011/10/brute-force-algorithm-for-password.html
    public int bruteForce(){
        count = 0; // reset count

        // initialize char array for guesses
        char[] guess = new char[1];

        Arrays.fill(guess, characters[0]);

        // make attempt to represent guess as a String
        String attempt = "";
        for (char c : guess) { attempt += c; }

        while(count < 5000000){ // until you've reached 5000 attempts
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
        count = 0; // reset count

        // array most common passwords
        String[] common = {"123456", "password", "12345678", "qwerty", "12345",
                "123456789", "letmein", "1234567", "football", "iloveyou", "admin",
                "welcome", "monkey", "login", "abc123", "starwars", "123123", "dragon",
                "passw0rd", "master", "hello", "freedom", "whatever", "qazwsx", "trustno1"};

        // tries each password in the list of most common passwords
        for (String s : common){
            count++; // track how many we've tried
            if (s.equals(password)){
                return 1; // if found
            }
        }
        return -1; // if not found
    }

    // unused random passwords algorithm because it's just brute force
    public int randomPasswords(){
        count = 0; // reset count
        while (count < 5000){
            int length = (int)(Math.random()*40 + .5);
            String guess = "";

            for (int i = 0; i < length; i++){
                guess+=characters[(int)(Math.random()*characters.length)];
            }

            count++;
            if (guess.equals(password)) {
                return 1;
            }

        }
        return -1;
    }

    public int commonCharacters(){
        count = 0; // reset count

        // initialize array that will store all the words in 1201_words
        String[] commonWords = new String[1201];

        // setting up access for 1201_words
        URL url = getClass().getResource("1201_words.txt");
        File wordsText = new File(url.getPath());

        // initialize scanner object
        Scanner words = null;

        // use scanner object to access 1201 words
        try{
            words = new Scanner(wordsText);
        }
        catch (Exception o){
            System.out.println("error");
        }

        // distinguish words by commas instead of spaces so setting array values works correctly
        words.useDelimiter(",");

        String s = ""; // temp string to set up array

        // sets up commonWords array
        for (int i = 0; i < 1201; i++){
            // accessing each word through scanner
            if (words.hasNext()){
                s = words.next();

                // replace common characters in the words to make them more like passwords
                if (s.contains("s")) {
                    s = s.replaceAll("s", "\\$");
                }
                if (s.contains("a")){
                    s = s.replaceAll("a", "@");
                }
                if (s.contains("i")){
                    s = s.replaceAll("i", "1");
                }
                if (s.contains("o")){
                    s = s.replaceAll("o", "0");
                }
                if (s.contains("e")){
                    s = s.replaceAll("e", "3");
                }
            }

            // set that element of the array equal to the more password-y version of the word
            commonWords[i] = s;
        }

        // try each password in commonWords and see if it matches password
        for (int i = 0; i < 1201; i++) {
            count++;
            if (commonWords[i].equals(password)){ return 1; } // found!

        }

        return -1; // couldn't find it
    }

    // getter for count
    public int getCount(){
        return count;
    }
}
