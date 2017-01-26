/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lionel
 */
public class Mastermind {

     //static int[]  computerPlays = {9,5,3,8};
     static String[] displayCode = {"X","O","V"};
     
     static Scanner scan = new Scanner(System.in);
     
     
     private static int[] getComputerPlay(){
         Random rand = new Random();
         int[] play = new int[4];
         for (int i = 0; i < play.length; i++){
             
             play[i] = rand.nextInt(9)+1;
             
         }
        

        return play;
     }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        System.out.println("******Mastermind*****");
        System.out.println("Resultat: 'X'=> n'existe pas, 'O'=> existe mais n'est pas à la bonne place, 'V'=> bon chiffre et bon emplacement");
        System.out.println("Votre jeu (4 chiffres max entre 1 et 9):");
       
       
        int[] computerPlay = getComputerPlay();
        
        boolean found = false;
        int nbRound = 0;
        do{
            
           nbRound++; 
           String playRaw = scan.nextLine();
           if (playRaw.length()!=4){
               System.err.println("humm, j'ai besoin de 4 chiffres");
               continue;
           }
           try{
               
               Integer.parseInt(playRaw);
               
           }catch(NumberFormatException e){
               System.err.println("humm, j'ai besoin de 4 chiffres, stp");
           }
           
           
           String res = playRound(computerPlay, playRaw);
           System.out.println(res); 
           
           //found = isFound(res);
           
        }while(nbRound < 10 && !found);
        
   
        if (found){
            System.out.println("cool, trouvé!!!!!");
        }else{
            System.out.println("arf pas trouvé, la combinaison était:" +  Arrays.toString(computerPlay));
        }
        System.out.println("nb round" + nbRound);
        
        
    }
    

    
    public static String  playRound(int[] computerPlay, String userPlay){

        int[] userP = toIntArray(userPlay);
        

        int[] res = new int[computerPlay.length];
        
        int tmpPlay;
        for (int i=0; i < userP.length; i++){
            
            tmpPlay = userP[i];
            
            for (int j=0; j < computerPlay.length; j++){

                if (tmpPlay==computerPlay[j]){
                    if (i==j) { //meme place
                        res[i] = 2;
                    }else{
                        res[i] = 1;
                    }
                }
                
            }
        }
        
        //convert to string
        String resStr = "";
        for (int value : res){
            resStr+=displayCode[value];
        }
        return resStr;
    }
    
    
    private static int[] toIntArray(String play){
        int[] tblOut = new int[play.length()];
        
        for (byte b=0; b< tblOut.length; b++){
            tblOut[b] = Character.getNumericValue(play.charAt(b));
        }
        
        return tblOut;
    }
    
}
