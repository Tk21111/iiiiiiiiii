
import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;
public class Storygame {

    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String WHITE = "\u001B[37m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLACK = "\u001B[30m";

    //---------- insert -------------------
 

    static int[] decrpyt(int[] arrInit){


        int[] encrpyt = new int[arrInit.length]; 

        for(int i = 0 ; i < arrInit.length ; i++){
            Random r = new Random();
            encrpyt[i] =  r.nextInt(9) +1;
        }

        return encrpyt;

    }


    public static boolean decrpytGame(int[] decrpytArrInit , Scanner sc) {


        //user update
        int[] decrpytArr = decrpyt(decrpytArrInit);
        System.out.println(WHITE + Arrays.toString(decrpytArr));
        


        //Tmp
        int[] decrpytArrUserIn = new int[decrpytArrInit.length];

       
        for (int f = 0; f < decrpytArrUserIn.length ; f++) {

            decrpytArrUserIn[f] = sc.nextInt();

        }
        //collect user input in arr
        for (int i = 0; i < decrpytArr.length ; i++) {

            //System.out.println(decrpytArrUserIn[i] + decrpytArr[i]);
            if(decrpytArrUserIn[i] + decrpytArr[i] > 9){
                //System.out.println("asdsa");
                decrpytArr[i] = decrpytArrUserIn[i] + decrpytArr[i] -9;
            } else {
                decrpytArr[i] = decrpytArrUserIn[i] + decrpytArr[i];
            }
        }

        System.out.println(Arrays.toString(decrpytArr));

        int winI = 0;
        for(int f = 0 ; f < decrpytArr.length ; f++){
            if(decrpytArr[f] == decrpytArrInit[f]){
                System.out.println(RED + "crack");
                System.out.print(WHITE);
                winI++;
            } else {
                System.out.println(RED + "...");
            }
        }

        if(winI == decrpytArr.length){
            return true;
        }


        return false;



    }


    //---------- end insert -----------

    static Scanner sc(){
        return new Scanner(System.in);
    }

    static boolean checkBreak(int point){
        if(point == -10){
            return true;
        } else {
            return false;
        }
    }


    public static void main (String[] args) throws InterruptedException {
        while (true) {
            int point = 0 ;
            int Tmp = 0;
            int END = 3;
            System.out.println(WHITE + "~~~~~~~~~~~~~~~~~~~~");
            System.out.println(BLACK + "*  Black Centaura  *");
            System.out.println(WHITE + "~~~~~~~~~~~~~~~~~~~~");

            //-------------------------
            Story1();
            Tmp = mission1();
            if(checkBreak(Tmp)){
                break;
            } else {
                point += Tmp;
                Tmp = 0;
            }
            //--------------------------
            
            Story2();
            Tmp = mission2();
            if(checkBreak(Tmp)){
                break;
            } else {
                point += Tmp;
                Tmp = 0;
            }

            //----------------------
            Stroy3();
            Tmp = mission3();
            if(checkBreak(Tmp)){
                break;
            } else {
                point += Tmp;
                Tmp = 0;
            }

            //ending story
            Story4();
            System.out.println(CYAN + "What your choise");
            System.out.println(WHITE + "1. Dad!! It’s me Michael.");
            System.out.println(WHITE + "2. Dad!! I am Michael ");
            while (END > 2 || END < 1) {
                System.out.println(WHITE +"===================");
                System.out.print(CYAN +"Your answer : ");
                END = sc().nextInt();
                if (END==1){
                    System.out.println(WHITE +"===================");
                    GoodEndStory();
                    point +=GoodEnd();
                } else if (END==2){
                    System.out.println(WHITE +"===================");
                    BadEndStory();
                    point +=BadEnd();
                }
            }
            
            System.out.println(WHITE +"===================");
            System.out.println(YELLOW + "Point : " + Integer.toString(point));
            System.out.println(CYAN + "Thank you for playing :3");
            System.out.println(WHITE + "===================");
        }
        
    }
    //end main

    static int mission1(){
        int i = 0;
        int correct = 2 ;
        int p = 10;

        System.out.println(WHITE + "example :");
        System.out.println(WHITE + "[ 9 , 7 , 3 , 4]");
        System.out.println(WHITE + "0 1 4 8");
        System.out.println(WHITE + "[ 9 , 8 , 7 , 3 ]");

        while (i<10){
            System.out.print("");
            
            System.out.println(WHITE + "===================");
            Scanner sc = new Scanner(System.in);
            boolean answerCorrect = decrpytGame(new int[]{ 1 , 9 , 2 , 2  } , sc);
            System.out.println(WHITE + "===================");//20
            
            if (answerCorrect){
                System.out.println(GREEN +"+++ CORRECT +++");
                System.out.println(WHITE +"===================");
                correct = 1;
                return p;
            }else{
                System.out.println(RED + "!!! NOT CORRECT !!!");
                correct = 0;
                p=p-1;
            }
            i = i+1;
            System.out.println(WHITE + "===================");
        }
        if(correct==0){
            System.out.println(PURPLE +"MISSION FAILED");
            System.out.println(WHITE + "===================");
            return -10;
        }
        return p;
    }
    //end mission1

    static int mission2(){
        int correct = 2 ;
        int p = 20;

        for (int i =0;i<20;i++){
            System.out.print(BLUE +"Enter PassWord : ");
            String PC = sc().nextLine().toUpperCase();
            System.out.println(WHITE +"===================");//20
            if (PC.equals("KGB")){
                System.out.println(GREEN + "+++ CORRECT +++");
                System.out.println(WHITE +"===================");
                correct = 1;
                return p;
            }else{
                System.out.println(RED + "!!! NOT CORRECT !!!");
                correct = 0;
                p=p-1;
            }
            System.out.println(WHITE + "===================");
        }
        if(correct==0){
            System.out.println(PURPLE +"MISSION FAILED");
            System.out.println(WHITE + "===================");
            return -10;
        }
        return p;
    }

    static int mission3(){
        int i = 0;
        int correct = 2 ;
        int p = 50;

        do{
            System.out.print(BLUE + "Enter PassWord : ");
            String PC = sc().nextLine().toLowerCase();
            System.out.println(WHITE +"===================");//20
            if (PC.equals("lvs1924")){
                System.out.println(GREEN + "+++ CORRECT +++");
                System.out.println(WHITE +"===================");
                correct = 1;
                return p;
            }else{
                System.out.println(RED + "!!! NOT CORRECT !!!");
                correct = 0;
                p=p-15;
            }
            System.out.println(WHITE + "===================");
        
        i=i+1;
        } while (i<10);
        if(correct==0){
            System.out.println(PURPLE +"MISSION FAILED");
            System.out.println(WHITE + "===================");
            return -10;
        }
        return p;
    }
    //end mission3

    static void Story1() throws InterruptedException{
        System.out.println(WHITE + "In 1943, in the middle of World War II, The Soviet boy name Michael Macros was captured by the Nazi army during a raid on a border village. \nHis family was killed in front of him, leaving Michael feeling hopeless at the loss of everything.");
        Thread.sleep(7000);
        System.out.println(WHITE + "\nThe Nazi brainwashed Michael and trained him to be a strong, sharp and human-sense soldier, \nbut the depths of his mind still left a fragment of old memories.");
        Thread.sleep(7000);
        System.out.println(WHITE + "\nAfter Michael brainwashing, he was one of the most trusted Nazi spy until he has an important mission by \nhaving to infiltrate the Soviet command centre and steal high-level secret documents.");
        Thread.sleep(6000);
        System.out.println(WHITE + "\nAfter Michael successfully infiltrated, he had to go through both walls before entering the secret documents storage room.");
        Thread.sleep(3500);
        System.out.println(WHITE + "\nDeciphering the wall 1 by the code from the year the Soviet Union was founded,");
        Thread.sleep(3500);
        System.out.println(BLACK + "with the clue that there are two numbers: [1 , ... , 2 , ...] ");
        Thread.sleep(3500);
        System.out.println(WHITE + "===================");
    }

    static void Story2() throws InterruptedException{
        System.out.println(WHITE + "After deciphering the 1st wall, Michael explored the 2nd wall and found a secret door that had to be coded in three English letters.");
        Thread.sleep(3500);
        System.out.print(BLACK + "that had to be coded in three English letters");
        Thread.sleep(3500);
        System.out.println(WHITE + " which has a hint as the initials of the Soviet State Security Committee");
        Thread.sleep(3500);
        System.out.println(WHITE + "===================");
    }

    static void Stroy3() throws InterruptedException{
        
        System.out.println(WHITE + "When he passed by, he found a secret filing room. The detective decided to open the door. But it turned out that the door could not be opened. So he tried to explore around the room. Found many picture frames. But there is one picture that the detective saw and felt majestic. It is a picture of a general with a child. Which he felt that the child looked like him when he was a child. In these pictures, he saw a boy who playing with a father in a ground.");
        Thread.sleep(7000);
        System.out.println(WHITE + "\nSo he suspicious of the picture,but the mission must keep going so he had to decode it in that room. To clear doubts about the picture By the code is letters and numbers Which this code comes from the Soviet leader who ascended the throne in 1924, which has 7 characters, consisting of the first part is three English abbreviations and the second part is numbers.");        System.out.println(WHITE + "===================");
        Thread.sleep(7000);
    }

    static void Story4() throws InterruptedException{
        System.out.println(GREEN + "After successfully stealing documents,");
        Thread.sleep(3500);
        System.out.println(RED +"but while he escaped, he was captured by Soviet troops.");
        Thread.sleep(3500);
        System.out.println(WHITE + "\nMichael was dragged to the interrogation room. Amidst the tension and death is approaching, he met General Alexei Makrov, a general who was famous for his cruelty.");
        Thread.sleep(3500);
        System.out.println(WHITE + "\nAnd in the split second he saw the general’s face, the sealed memories broke. His father’s face, the warm hands that once held him, the laughter of the days when the village was still lively.");
        Thread.sleep(3500);
        System.out.println(WHITE + "\nMichael immediately realised that this was his father, a father who was killed in front of his eyes but was still alive and standing in front of him.");
        Thread.sleep(3500);
        System.out.println(WHITE + "As General Alexey aims his gun at Michael, Michael shouts at the top of his lungs.");
        Thread.sleep(3500);
        System.out.println(WHITE + "===================");
    }


    static void GoodEndStory() throws InterruptedException{
        System.out.println(WHITE + "That voice was deeply in the heart of the general. Old memories come back. That’s the son who disappeared in the war!");
        Thread.sleep(3000);
        System.out.println(BLACK + "His gun fell out of his hand from then.");
        Thread.sleep(2000);
        System.out.println(WHITE + "The father and son approached and hugged each other. And he say“Let’s go home... my son”");

    }


    static void BadEndStory() throws InterruptedException{
        System.out.println("But General Alexei was silent. His face was as hard as a stone. He aimed the gun with his hand without hesitation. “My son Michael ... Died since the day he was captured by the Nazi animals.The sound of gunfire sounded. The bullet pierced Michael chest who was standing still. Tears welled. He fell down with smiles and tears... Before dying, Michael muttered softly, “Sorry... That I came home late...” The last image he saw was the figure of his father standing with his back. Ready to walk away without looking again.");
       
    }

    static int GoodEnd(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println(GREEN + "/+/+/ Good END /+/+/");
        System.out.println(WHITE + "~~~~~~~~~~~~~~~~~~~~");
        return 25;
    }

    static int BadEnd(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println(RED + "|-|-| Bad END |-|-|");
        System.out.println(WHITE +"~~~~~~~~~~~~~~~~~~~~");
        return -25;
    }
}
