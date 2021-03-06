import java.util.*;
public class BlackBox
{
    public static char box[][]; // The matrix for the game.
    public static int size;       // to store the number of rows and columns.
    public static int numball=3;
    public static int numlink=1;
    public static boolean end=true;
    public static int score=0;
    public static int high_score=10000;

    public static int a1=0;
    public static int a2=0;
    public static int b1=0;
    public static int b2=0;
    public static int c1=0;
    public static int c2=0;


    public BlackBox()
    {
        this.size=0;
        this.numball=0;
        this.numlink=0;
        this.end=false;
        this.score=0;
        box=new char[0][0];
    }

    public BlackBox(int size, int numball, int numlink,boolean end,int score)
    {
        this.size=size;
        this.numball=numball;
        this.numlink=numlink;
        this.end=end;
        this.score=score;

        box=new char[size+2][size+2];
    }

    public char[][] getbox()
    {
        return box;
    }

    public static int getscore()
    {
        return score;
    }

    public static int getNumball()
    {
        return numball;
    }

    public int getNumlink()
    {
        return this.numlink;
    }

    public boolean getend()
    {
        return this.end;
    }

    public int getSize()
    {
        return this.size;
    }

    public void setbox(char box[][])
    {
        this.box=box;
    }

    public void setSize(int size)
    {
        this.size=size;
    }

    public void setNumball(int Numball)
    {
        this.numball=Numball;
    }

    public void setNumlink(int Numlink)
    {
        this.numlink=Numlink;
    }

    public void setEnd(boolean end)
    {
        this.end=end;
    }

    public void setScore(int score)
    {
        this.score=score;
    }


    public static void initialize()
    {
        box=new char[size+2][size+2];
        for(int i=0;i<box.length;i++)
        {
            for(int j=0;j<box.length;j++)
            {
                box[i][j]=' ';
            }
        }
        for(int i=0;i<box.length;i++)
        {
            for(int j=0;j<box.length;j++)
            {
//                if((i==0||i==box.length-1)&&(j==0||j==box.length-1))
//                {
//                    box[i][j]='X';
//                }
//                else if(((i==0||i==box.length-1)&&(j!=0&&j!=box.length-1)||(j==0||j==box.length-1)&&(i!=0&&i!=box.length-1)))
//                {
//                    box[i][j]='#';
//                }
                box[0][0]='X';
                box[0][box.length-1]='X';
                box[box.length-1][0]='X';
                box[box.length-1][box.length-1]='X';
                if(((i==0)||(i==box.length-1))&&box[i][j]!='X')
                {
                    box[i][j]='#';
                }
                if(j==0||j==box.length-1)
                {
                    if(!(i==0||i==box.length-1))
                    {
                        box[i][j]='#';
                    }
                }
//                if((i==0||i==box.length-1)&&(j!=0)&&(j!=box.length-1))
//                {
//                    box[i][j]='#';
//                }
//                if((j==0||j==box.length-1)&&(i!=0)&&(i!=box.length-1))
//                {
//                    box[i][j]='#';
//                }
//                else
//                {
//                    box[i][j]=' ';
//                }
            }
        }
        Random LetsRandomize=new Random();
        int pehla=2+LetsRandomize.nextInt(box.length-2);
        int dosra=2+LetsRandomize.nextInt(box.length-2);
        box[pehla-1][dosra-1]='0';
        int pehlaPart2=0;
        int dosraPart2=0;
        do
        {
            pehlaPart2=2+LetsRandomize.nextInt(box.length-2);
            dosraPart2=2+LetsRandomize.nextInt(box.length-2);
            box[pehlaPart2-1][dosraPart2-1]='0';
        }while(pehlaPart2==pehla&&dosraPart2==dosra);

        int pehlaPart3=0;
        int dosraPart3=0;
        do
        {
            pehlaPart3=2+LetsRandomize.nextInt(box.length-2);
            dosraPart3=2+LetsRandomize.nextInt(box.length-2);
            box[pehlaPart3-1][dosraPart3-1]='0';
        }while((pehlaPart3==pehla&&dosraPart3==dosra)||(pehlaPart3==pehlaPart2&&dosraPart3==dosraPart2));

        a1=pehla;
        a2=dosra;
        b1=pehlaPart2;
        b2=dosraPart2;
        c1=pehlaPart3;
        c2=dosraPart3;
//        int pehlaek=pehla;
//        int dosraek=dosra;
//        int pehlado=0;
//        int dosrado=0;
//        while(LetsRandomize.nextInt(box.length)!=pehlaek)
//        {
//            pehla=LetsRandomize.nextInt(box.length);
//            while(LetsRandomize.nextInt(box.length)!=dosraek)
//            {
//                dosra=LetsRandomize.nextInt(box.length);
//                box[pehla][dosra]='0';
//                pehlado=pehla;
//                dosrado=dosra;
//            }
//        }

    }

    public static void playgame()
    {
        Scanner Aditya=new Scanner(System.in);
        String userInput="Time to play BlackBox";
        while(!((numball==0)&&(userInput.equals("submit")))) {
            if (numball == 0) {
                System.out.println("You cannot place any other balls");
            }
//            System.out.println(a1+" "+a2+" "+b1+" "+b2+" "+c1+" "+c2);
                System.out.println("Choose the new coodinates (row,column) to play the next step or say submit/quit the game: ");
                userInput = Aditya.nextLine();
                while (userInput.toLowerCase().equals("submit") && numball != 0)
                {
                    System.out.println("Please place all your guesses and your numball is " + numball);
                    userInput = Aditya.nextLine();
                }
                if (userInput.toLowerCase().equals("quit"))
                {
                    System.exit(0);
                }

                if (userInput.toLowerCase().equals("submit"))
                {
                    break;
                }

//        while((userInput.charAt(1)!=',')||(userInput.charAt(2)!=',')||userInput.equals("1,1")||(userInput.equals("1,"+(size+2)))||(userInput.equals((size+2)+",1"))||(userInput.equals((size+2)+","+(size+2))))
//        {
//            System.out.println("Wrong input please choose a block which is open");
//            printbox();
//            System.out.println("Choose the new coodinates (row,column) to play the next step or say submit/quit the game: ");
//            userInput=Aditya.nextLine();
//        }
                while (!userInput.contains(","))
                {
                    System.out.println("Wrong input please choose a block which is open");
                    printbox();
                    System.out.println("Choose the new coodinates (row,column) to play the next step or say submit/quit the game: ");
                    userInput = Aditya.nextLine();
                }
                String arr[] = userInput.split(",");
                int a = Integer.parseInt(arr[0]);
                int b = Integer.parseInt(arr[1]);

                while(a>box.length||a<1||b>box.length||b<1)
                {
                    System.out.println("Coordinates out of bounds, please enter a valid input");
                    userInput = Aditya.nextLine();
                    String arrNew[] = userInput.split(",");
                    a = Integer.parseInt(arrNew[0]);
                    b = Integer.parseInt(arrNew[1]);
                }
            while((a==1||a==box.length)&&(b==1||b==box.length))
            {
                System.out.println("Wrong input please choose a block which is open");
                printbox();
                System.out.println("Choose the new coodinates (row,column) to play the next step or say submit/quit the game: ");
                userInput = Aditya.nextLine();

                String arr1[] = userInput.split(",");
                a=Integer.parseInt(arr1[0]);
                b=Integer.parseInt(arr1[1]);
            }
            if (userInput.contains(",")) {
                check(a, b);
                printbox();
            }

        }
        int count=0;
        boolean ALLCORRECT=true;
        for(int i=0;i<box.length;i++)
        {
            for(int j=0;j<box.length;j++)
            {
                if(box[i][j]=='*')
                {
                    if(!((a1==i+1&&a2==j+1)||(b1==i+1)&&(b2==j+1)||(c1==i+1)&&c2==j+1))
                    {
                        ALLCORRECT=false;
//                        System.out.println("TRUE HO GAYA");
                    }
                    count++;
                }
            }
        }
        if(count!=3)
        {
            ALLCORRECT=false;
        }


        if(getscore()<high_score&&ALLCORRECT)
        {
            high_score=getscore();
        }
        if(ALLCORRECT)
        {

            System.out.println("Thank you for playing the game! Your score is "+high_score);
        }
        if(!ALLCORRECT)
        {
//            for(int i=0;i<box.length-1;i++)
//            {
//                for(int j=0;j<box.length-1;j++)
//                {
//                    if(box[i][j]=='*')
//                    {
//                        System.out.println((i+1)+" HAHAH "+(j+1));;
//                    }
//
//                }
//            }
            System.out.println("You failed the game:(");
        }
    }
   
    public static void printbox()
    {

        if(size==5)
        {
            System.out.println(" 1  2  3  4  5  6  7  ");
            System.out.println("======================");
            int a=1;
            for(int i=0;i<box.length;i++)
            {
                System.out.print(a+"|");
                for(int j=0;j<box.length;j++)
                {
                    if(box[i][j]!='0')
                    {
                      System.out.print(box[i][j]+" |");
                    }
                    if(box[i][j]=='0')
                    {
                        System.out.print("  |");
                    }
//                    else if(i!=0)
//                    {
//                        System.out.print("  |");
//                    }
                }
                System.out.println();
                a++;
            }
            System.out.println("======================");
        }
        if(size==7)
        {
            System.out.println(" 1  2  3  4  5  6  7  8  9  ");
            System.out.println("============================");
            int a=1;
            for(int i=0;i<box.length;i++)
            {
                System.out.print(a+"|");
                for(int j=0;j<box.length;j++)
                {
                    if(box[i][j]!='0')
                    {
                        System.out.print(box[i][j]+" |");
                    }
                    if(box[i][j]=='0')
                    {
                        System.out.print("  |");
                    }
                }
                System.out.println();
                a++;
            }
            System.out.println("============================");
        }
        if(size==8)
        {
            System.out.println("  1  2  3  4  5  6  7  8  9  10  ");
            System.out.println("=================================");
            int a=1;
            for(int i=0;i<box.length;i++)
            {
                if(a<10){
                System.out.print(a+" |");}
                if(a==10)
                {
                    System.out.print(a+"|");
                }

                for(int j=0;j<box.length;j++)
                {
                    if(box[i][j]!='0')
                    {
                        System.out.print(box[i][j]+" |");
                    }
                    if(box[i][j]=='0')
                    {
                        System.out.print("  |");
                    }
                }
                System.out.println();
                a++;
            }
            System.out.println("=================================");
        }

    }
    public static void check(int i,int j) {
        boolean letsHit=hitcheck(i,j);
        boolean letsReflect=false;
        boolean letsDeflect=false;
        boolean letsStraight=false;
        if(!letsHit)
        {
            letsReflect=reflectionCheck(i,j);
        }
        if(!letsHit&&!letsReflect)
        {
            letsDeflect=deflectionCheck(i,j);
        }
        if(!letsHit&&!letsReflect&&!letsDeflect)
        {
            letsStraight=straightRay(i,j);
        }
        if(letsHit||letsDeflect||letsReflect||letsStraight)
        {
            score++;
        }
        if(!(letsHit||letsReflect||letsDeflect||letsStraight))
        {
            if(numball==0)
            {
                System.out.println("You cannot place any other balls");
            }
            if(numball>0)
            {
                if(box[i-1][j-1]=='*')
                {
                    System.out.println("Ball is already placed at this location");
                }
                if(box[i-1][j-1]!='*'&&i>1&&i<box.length&&j>1&&j<box.length)
                {
                    box[i-1][j-1]='*';
                    numball--;
                    score++;
                }
            }
        }
    }

    public static boolean straightRay(int i,int j) {

//        if(!deflectionCheck(i,j)) {
//            System.out.println(numlink+" HAHAHA");
            if (i == 1) {
                for (int row = 2; row < box.length; row++) {
                    if ((a1 == row && a2 == j) || (b1 == row && b2 == j) || (c1 == row && c2 == j)) {
//                    box[i-1][j-1]='H';
//                    box[i-1][j-1]=(char)(numlink+48);
//                    box[box.length-1][j-1]=(char)(numlink+48);
//                    numlink++;
//                    System.out.println(box[i-1][j-1]+"Aditya Sharma");
                        return false;
                    }
                }
                box[i - 1][j - 1] = (char) (numlink + 48);
                box[box.length - 1][j - 1] = (char) (numlink + 48);
                numlink++;
                return true;
            }

            if (i == box.length) {
                for (int row = box.length - 1; row > 1; row--) {
                    if ((a1 == row && a2 == j) || (b1 == row && b2 == j) || (c1 == row && c2 == j)) {
//                    box[i-1][j-1]='H';
//                    box[i-1][j-1]=(char)(numlink+48);
//                    box[box.length-1][j-1]=(char)(numlink+48);
//                    numlink++;
//                    System.out.println(box[i-1][j-1]+"Aditya Sharma");
                        return false;
                    }
                }
                box[i - 1][j - 1] = (char) (numlink + 48);
                box[0][j - 1] = (char) (numlink + 48);
                numlink++;
                return true;
            }

            if (j == 1) {
                for (int column = 2; column < box.length; column++) {
                    if ((a1 == i && a2 == column) || (b1 == i && b2 == column) || (c1 == i && c2 == column)) {
//                    box[i-1][j-1]='H';
//                    box[i-1][j-1]=(char)(numlink+48);
//                    box[box.length-1][j-1]=(char)(numlink+48);
//                    numlink++;
//                    System.out.println(box[i-1][j-1]+"Aditya Sharma");
                        return false;
                    }
                }
                box[i - 1][j - 1] = (char) (numlink + 48);
                box[i - 1][box.length - 1] = (char) (numlink + 48);
                numlink++;
                return true;
            }

            if (j == box.length) {
                for (int column = box.length - 1; column > 1; column--) {
                    if ((a1 == i && a2 == column) || (b1 == i && b2 == column) || (c1 == i && c2 == column)) {
//                    box[i-1][j-1]='H';
//                    box[i-1][j-1]=(char)(numlink+48);
//                    box[box.length-1][j-1]=(char)(numlink+48);
//                    numlink++;
//                    System.out.println(box[i-1][j-1]+"Aditya Sharma");
                        return false;
                    }
                }
                box[i - 1][0] = (char) (numlink + 48);
                box[i - 1][box.length - 1] = (char) (numlink + 48);
                numlink++;
                return true;
            }
//        }
        return false;
    }

    public static boolean reflectionCheck(int i,int j) {
        if(i>1&&i<box.length&&j>1&&j<box.length)
        {
            return false;
        }

        if(i==1)
        {
            if(((a1==i+1&&a2==j+1)||(b1==i+1&&b2==j+1)||(c1==i+1&&c2==j+1))||((a1==i+1&&a2==j-1)||(b1==i+1&&b2==j-1)||(c1==i+1&&c2==j-1)))
            {
                box[i-1][j-1]='R';
//                System.out.println("R is HERE!!!!!!!!!!!!!!!!!");
                return true;
            }
            for(int row=2;row<box.length-1;row++)
            {
                if(((a1==row+1&&a2==j+1)||(b1==row+1&&b2==j+1)||(c1==row+1&&c2==j+1))&&((a1==row+1&&a2==j-1)||(b1==row+1&&b2==j-1)||(c1==row+1&&c2==j-1)))
                {
                    box[i-1][j-1]='R';
//                    System.out.println("R is HERE!!!!!!!!!!!!!!");
                    return true;
                }
            }
        }
        if(i==box.length)
        {
            if(((a1==i-1&&a2==j+1)||(b1==i-1&&b2==j+1)||(c1==i-1&&c2==j+1))||((a1==i-1&&a2==j-1)||(b1==i-1&&b2==j-1)||(c1==i-1&&c2==j-1)))
            {
                box[i-1][j-1]='R';
//                System.out.println("R is HERE!!!!!!!!!!!!!!!!!");
                return true;
            }
            for(int row=box.length-2;row>1;row--)
            {
                if(((a1==row-1&&a2==j+1)||(b1==row-1&&b2==j+1)||(c1==row-1&&c2==j+1))&&((a1==row-1&&a2==j-1)||(b1==row-1&&b2==j-1)||(c1==row-1&&c2==j-1)))
                {
                    box[i-1][j-1]='R';
//                    System.out.println("R is HERE!!!!!!!!!!!!!!");
                    return true;
                }
            }
        }
        if(j==1)
        {
            if(((a1==i+1&&a2==j+1)||(b1==i+1&&b2==j+1)||(c1==i+1&&c2==j+1))||((a1==i-1&&a2==j+1)||(b1==i-1&&b2==j+1)||(c1==i-1&&c2==j+1)))
            {
                box[i-1][j-1]='R';
//                System.out.println("R is HERE!!!!!!!!!!!!!!!!!");
                return true;
            }
            for(int column=2;column<box.length-1;column++)
            {
                if(((a1==i+1&&a2==column+1)||(b1==i+1&&b2==column+1)||(c1==i+1&&c2==column+1))&&((a1==i-1&&a2==column+1)||(b1==i-1&&b2==column+1)||(c1==i-1&&c2==column+1)))
                {
                    box[i-1][j-1]='R';
//                    System.out.println("R is HERE!!!!!!!!!!!!!!");
                    return true;
                }
            }
        }
        if(j==box.length)
        {
            if(((a1==i+1&&a2==j-1)||(b1==i+1&&b2==j-1)||(c1==i+1&&c2==j-1))||((a1==i-1&&a2==j-1)||(b1==i-1&&b2==j-1)||(c1==i-1&&c2==j-1)))
            {
                box[i-1][j-1]='R';
                return true;
            }
            for(int column=2;column<box.length-1;column++)
            {
                if(((a1==i+1&&a2==column-1)||(b1==i+1&&b2==column-1)||(c1==i+1&&c2==column-1))&&((a1==i-1&&a2==column-1)||(b1==i-1&&b2==column-1)||(c1==i-1&&c2==column-1)))
                {
                    box[i-1][j-1]='R';
                    return true;
                }
            }
        }

//        if(i==1)
//        {
//            if(box[i+1][j+1]=='0'||box[i+1][j-1]=='0')
//            {
//                box[i-1][j]='R';
//                return true;
//            }
//        }
//        if(i==box.length)
//        {
//            if(box[i-1][j+1]=='0'||box[i-1][j-1]=='0')
//            {
//                box[i-1][j-1]='R';
//                return true;
//            }
//        }
//        if(i==box.length)
//        {
//
//        }
//        if(j==1)
//        {
//
//        }
//        if(j==box.length)
//        {
//
//        }
        return false;
    }

    public static boolean deflectionCheck(int i,int j) {
        if(!reflectionCheck(i,j)) {
            if (i > 1 && i < box.length && j > 1 && j < box.length) {
                return false;
            }
//        int a=0;
            if (i == 1) {
                for (int row = 2; row < box.length - 1; row++) {
                    if ((a1 == row + 1 && a2 == j + 1) || (b1 == row + 1 && b2 == j + 1) || (c1 == row + 1 & c2 == j + 1)) {

                        box[i - 1][j - 1] = (char) (numlink + 48);
                        box[row - 1][0] = (char) (numlink + 48);
//                        System.out.println("The deflect worked!");
                        numlink++;
                        return true;

                    }
                    if ((a1 == row + 1 && a2 == j - 1) || (b1 == row + 1 && b2 == j - 1) || (c1 == row + 1 & c2 == j - 1)) {

                        box[i - 1][j - 1] = (char) (numlink + 48);
                        box[row - 1][box.length - 1] = (char) (numlink + 48);
//                        System.out.println("The deflect worked!");
                        numlink++;
                        return true;

                    }
                }
            }

            if (i == box.length) {
                for (int row = box.length - 2; row > 1; row--) {
                    if ((a1 == row - 1 && a2 == j + 1) || (b1 == row - 1 && b2 == j + 1) || (c1 == row - 1 & c2 == j + 1)) {

                        box[i - 1][j - 1] = (char) (numlink + 48);
                        box[row - 1][0] = (char) (numlink + 48);
//                        System.out.println("The deflect worked!");
                        numlink++;
                        return true;

                    }
                    if ((a1 == row - 1 && a2 == j - 1) || (b1 == row - 1 && b2 == j - 1) || (c1 == row - 1 & c2 == j - 1)) {

                        box[i - 1][j - 1] = (char) (numlink + 48);
                        box[row - 1][box.length - 1] = (char) (numlink + 48);
//                        System.out.println("The deflect worked!");
                        numlink++;
                        return true;

                    }
                }
            }

            if (j == 1) {
                for (int column = 2; column < box.length - 1; column++) {
                    if ((a1 == i + 1 && a2 == column + 1) || (b1 == i + 1 && b2 == column + 1) || (c1 == i + 1 & c2 == column + 1)) {
                        box[i - 1][j - 1] = (char) (numlink + 48);
                        box[0][column - 1] = (char) (numlink + 48);
//                        System.out.println("The deflect worked!");
                        numlink++;
                        return true;
                    }
                    if ((a1 == i - 1 && a2 == column + 1) || (b1 == i - 1 && b2 == column + 1) || (c1 == i - 1 & c2 == column + 1)) {
                        box[i - 1][j - 1] = (char) (numlink + 48);
                        box[box.length - 1][column - 1] = (char) (numlink + 48);
//                        System.out.println("The deflect worked!");
                        numlink++;
                        return true;
                    }
                }
            }

            if (j == box.length) {
                for (int column = box.length - 2; column > 1; column--) {
                    if ((a1 == i + 1 && a2 == column - 1) || (b1 == i + 1 && b2 == column - 1) || (c1 == i + 1 & c2 == column - 1)) {
                        box[i - 1][j - 1] = (char) (numlink + 48);
                        box[0][column - 1] = (char) (numlink + 48);
//                        System.out.println("The deflect worked!");
                        numlink++;
                        return true;
                    }
                    if ((a1 == i - 1 && a2 == column - 1) || (b1 == i - 1 && b2 == column - 1) || (c1 == i - 1 & c2 == column - 1)) {
                        box[i - 1][j - 1] = (char) (numlink + 48);
                        box[box.length - 1][column - 1] = (char) (numlink + 48);
//                        System.out.println("The deflect worked!");
                        numlink++;
                        return true;
                    }
                }
            }


        }
        return false;
    }

    public static boolean hitcheck(int i,int j){                                                                        //DONE!!!
        if(i>1&&i<box.length&&j>1&&j<box.length)
        {
            return false;
        }
        if(i==1)
        {
            for(int row=2;row<box.length;row++)
            {
                if((a1==row&&a2==j)||(b1==row&&b2==j)||(c1==row&&c2==j))
                {
                    box[i-1][j-1]='H';
//                    box[i-1][j-1]=(char)(numlink+48);
//                    box[box.length-1][j-1]=(char)(numlink+48);
//                    numlink++;
//                    System.out.println(box[i-1][j-1]+"Aditya Sharma");
                    return true;
                }
            }
        }

        if(i==box.length)
        {
            for(int row=box.length;row>1;row--)
            {
                if((a1==row&&a2==j)||(b1==row&&b2==j)||(c1==row&&c2==j))
                {

                    box[box.length-1][j-1]='H';
//                    box[i-1][j-1]=(char)(numlink+48);
//                    box[0][j-1]=(char)(numlink+48);
//                    numlink++;
//                    System.out.println(box[i-1][j-1]+"Aditya Sharma");
                    return true;
                }
            }
        }

        if(j==box.length)
        {
            for(int column=box.length;column>1;column--)
            {
                if((a1==i&&a2==column)||(b1==i&&b2==column)||(c1==i&&c2==column))
                {

                    box[i-1][box.length-1]='H';
//                    box[i-1][j-1]=(char)(numlink+48);
//                    box[0][j-1]=(char)(numlink+48);
//                    numlink++;
//                    System.out.println(box[i-1][j-1]+"Aditya Sharma");
                    return true;
                }
            }
        }

        if(j==1)
        {
            for(int column=2;column<box.length;column++)
            {
                if((a1==i&&a2==column)||(b1==i&&b2==column)||(c1==i&&c2==column))
                {

                    box[i-1][j-1]='H';
//                    box[i-1][j-1]=(char)(numlink+48);
//                    box[0][j-1]=(char)(numlink+48);
//                    score++;
//                    System.out.println(box[i-1][j-1]+"Aditya Sharma");
                    return true;
                }
            }
        }
//        if(i==1)
//        {
//            for(int a=2;a<box.length;a++)
//            {
//                if((a1==a&&a2==j)||(b1==a&&b2==j)||(c1==a&&c2==j))
//                {
////                System.out.println(a1+" "+a2+" "+b1+" "+b2+" "+c1+" "+c2);
////                    box[i][j]='H';
//                    return true;
//                }
//            }
//        }
//        return false;

//        if(j==1)
//        {
//            for(int a=1;a<box.length;a++)
//            {
//                if((a1==i&&a2==j)||(b1==i&&b2==j)||(c1==i&&c2==j))
//                {
//                    box[i][j]='H';
//                    return true;
//                }
//            }
//        }
        return false;
    }



    public static void main(String[] args)
    {
        Scanner Aditya=new Scanner(System.in);
        while(end)
        {
            System.out.println("Welcome to the Blackbox Game. Please choose the difficulty level:easy/medium/hard or quit to end the game");
            String input = Aditya.nextLine().toLowerCase();

            if (input.equals("quit"))
            {
                end=false;
                System.exit(0);
            }

            if (input.equals("easy"))
            {
                size = 5;
            }

            if (input.equals("medium"))
            {
                size = 7;
            }

            if (input.equals("hard"))
            {
                size = 8;
            }
            BlackBox CS180=new BlackBox(size, 3, 1, end,0);
//            BlackBox(size, numball, numlink, end,score);
            initialize();
            printbox();
            playgame();
        }
    }
}
