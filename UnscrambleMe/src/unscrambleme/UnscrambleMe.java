/* This is a word scramble game
 * Read in file, assign variable to each word, scramble word (line by line), print to new file
 * Ask what is the word, give 5 tries, if within 5 tries the string input == string variable from first file print yay you did it
 * if the 5 tries runs out print sorry you're out of tries - the answer was (variable)
 */
package unscrambleme;

//import java.io.File;  // Import the File class
//import java.io.FileNotFoundException;  // Import this class to handle errors
//import java.util.Scanner; // Import the Scanner class to read text files
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author arisa
 */
public class UnscrambleMe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Main class here
   
        try
      {
         FileReader file = new FileReader( "scramble.txt" ) ;

         BufferedReader buffer = new BufferedReader( file );

         String line = "" ;
         String newline;

         while( ( line = buffer.readLine() ) != null )
         {
            newline = UnscrambleMe.Scramble( line ); //Scramble text
            System.out.print("You have five tries to unscramble: ");
            System.out.printf("'%s'\n", newline); //Scramble
            // scramble and try to figure out
            // loop five times
            for (int i=5; i>0; i--){
                Scanner sc = new Scanner(System.in);
                int count = i;
                System.out.printf("%s%d\n", "number of tries left: ", count);
                System.out.printf("%s\n", "Unscramble this word: ", newline);
                String str = sc.nextLine();
                
                    if (str.equals(line)){
                        System.out.println("Yes you got it! \n\n");
                        break;
                    }
                    else if(count == 1){
                        System.out.printf("%s%s\n\n", "Sorry, you're out of tries. The answer was: ", line);
                    }
            }
         }
         buffer.close() ;
      }
      catch( IOException e )
      {
         System.out.println( "A read error has occurred." ) ;
      }      
    }
    
    public static String Scramble(String s) {
        String[] scram = s.split("");
        List<String> letters = Arrays.asList(scram);
        Collections.shuffle(letters);
        StringBuilder sb = new StringBuilder(s.length());
        for (String c : letters) {
            sb.append(c);
        }
        return sb.toString();
    }
    
    
    
}
