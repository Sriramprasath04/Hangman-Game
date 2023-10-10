import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author srira
 */
public class HangMan {

    public static void main(String[] args) {
        //getting ip's
        Scanner sc = new Scanner(System.in);

        //finding the length
        Random rand = new Random();
        int rand_ind = rand.nextInt(10);
        String[] arr =  {"Pocket", "Socket", "Rocket", "Market", "Algorithm", "Argument", "Boolean", "Bug", "Character", "API"};
        String secretWord = arr[rand_ind];
        int secretWordLength = secretWord.length();
        String playerExpression = "-".repeat(secretWordLength);
        System.out.println(rand_ind);

        int chances = 5;

        while(chances>0){

            System.out.println(playerExpression);

            System.out.println("Enter your next guess:");
            char playerGuess = sc.next().charAt(0);

            if(secretWord.contains(playerGuess+"")){
//                System.out.println("Correct");

                String temp = "";
                for(int i=0; i<secretWordLength ;i++){
                    if(playerGuess == secretWord.charAt(i)){
                        temp = temp+playerGuess;
                    } else {
                        temp = temp+playerExpression.charAt(i);
                    }
                }
                playerExpression = temp;

                if(playerExpression.equals(secretWord.replaceAll(" ","-"))){
                    System.out.println("You Won!");
                    System.out.println("Secret Word: "+secretWord);
                    break;
                }

            } else {
                System.out.println("Incorrect");
                chances = chances - 1;
                System.out.println("Remaining chances:"+chances);
            }
        }

    }
}