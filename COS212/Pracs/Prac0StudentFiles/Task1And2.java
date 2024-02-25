import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Task1And2 {

    public boolean containsGenZSlang(String bio) {
        return bio.contains("no cap");
    }

    public boolean isSpecialLength(String bio) {
        return bio.length() == 42;
    }

    // Assumes lowercase and spaces have been removed
    public boolean hasMoreThanOneDistinctCharacter(String str) {
        if (str.length() < 2) {
            return false;
        }

        char first = str.charAt(0);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != first) {
                return true;
            }
        }
        return false;
    }

    public boolean isPalindrome(String str) {
        // Ignore trivial palindromes
        if (str.length() == 1 || str.length() == 0) {
            return false;
        }

        // Remove spaces and ignore case
        String toCheck = str.replaceAll(" ", "");
        toCheck = toCheck.toLowerCase();

        if (!hasMoreThanOneDistinctCharacter(toCheck)) {
            return false;
        }

        // Getting the halfway value rounded up
        int strLen = toCheck.length();
        double halfway = (strLen * 1.0) / 2.0;
        halfway = Math.ceil(halfway);

        // Check if palindrome front vs back
        for (int i = 0; i < halfway; i++) 
        {
            char front = toCheck.charAt(i);
            char back = toCheck.charAt(strLen - i - 1);

            if (front != back) 
            {
                return false;
            }
        }
        return true;
    }

    public boolean containsPalindrome(String bio) {
        for (int i = 0; i < bio.length(); i++) 
        {
            for (int j = i; j < bio.length(); j++) 
            {
                String substringToCheck = bio.substring(i, j + 1);

                if (isPalindrome(substringToCheck)) 
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canAccept(String bio) {
        return containsGenZSlang(bio) || isSpecialLength(bio) || isPalindrome(bio);
    }

    // public String listApplicantStatuses(String fileName) {

    // }

}
