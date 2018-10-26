import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Logic {
    private String password;
    public int count = 0;
    private char[] characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()".toCharArray(); // https://stackoverflow.com/questions/17575840/better-way-to-generate-array-of-all-letters-in-the-alphabet

    public Logic(String password){
        this.password = password;
        Arrays.sort(characters);
    }

    // http://prembharticodes.blogspot.com/2011/10/brute-force-algorithm-for-password.html
    public int bruteForce(){

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

    public int randomPasswords(){
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
        String[] commonWords = new String[1201];


        Path currentRelativePath = Paths.get(""); // gets local path
        String relPath = currentRelativePath.toAbsolutePath().toString(); // adds the part of the file path at the end
        File wordsText = new File("/Users/philipholleb/Desktop/Semester_1/PASSWORD_DESTROYER/1201_words.txt");//TODO fix path

        Scanner words = null;

        try{
            words = new Scanner(wordsText);
        }
        catch (Exception o){
            System.out.println("error");
        }

        words.useDelimiter(",");
        String r = "";

        for (int i = 0; i < 1201; i++){
            String s = words.next();
            if (s.contains("s")) {
                r = s.replaceAll("s", "\\$");
            }
            if (s.contains("a")){
               r = s.replaceAll("a", "@");
            }
            if (s.contains("i")){
                r = s.replaceAll("i", "1");
            }
            if (s.contains("o")){
                r = s.replaceAll("o", "0");
            }
            if (s.contains("e")){
                r = s.replaceAll("e", "3");
            }
            commonWords[i] = r;
        }

        while (count<1201){
            if (commonWords[count].equals(password)){ return 1; }
            count++;
        }

        return -1;
    }

    public int getCount(){
        return count;
    }
}
