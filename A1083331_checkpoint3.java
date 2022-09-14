import java.io.*;
import java.util.*;
public class A1083331_checkpoint3 {

    public static void main(String[] args) {

        //Description :  Specify the file to read in.
        String EBOOKS=args[0];
        //Description : To store the data of csv, we provide an variable of dataSet.
        ArrayList<String[]> dataSet=new ArrayList<>();


        /*********************************The TODO This Time (Checkpoint3) ********************************
         * 
         * TODO(1): This time, you have to query datas from the target txt file, storing them to the arraylist called "dataSet", then export as a csv file. After exporting file, remember to check answer.
         * Hint: e.g: Use "dataSet=importFromTxt(EBOOKS)" to query data from the txt file. 
         * Hint: e.g: Use "exportToCsv(dataSet)" to export as a csv file.
         * Hint: e.g: Use "checkAnswer(dataSet)" to check answer.
         * 
         **********************************The End of the TODO**************************************/

        /********************************************************************************************
         START OF YOUR CODE
         ********************************************************************************************/ 
        dataSet=importFromTxt(EBOOKS);
        exportToCsv(dataSet);
        checkAnswer(dataSet);
        /********************************************************************************************
         END OF YOUR CODE
         ********************************************************************************************/


    }
    
    //Query unstructured data from txt file.
    private static ArrayList<String[]> importFromTxt(String EBOOKS){
        /*********************************The TODO This Time (Checkpoint3) ********************************
         * 
         * TODO(2): Here you have to read in the unstructured data with file path passed in as "EBOOKS", extracting the indexs of every books and storing the data to a Arraylist. Last, return the Arraylist. You can check the target file for detailed patterns.
         * Hint: If the target file doesn't exist, you should print "Oops!Tricks on you!".
         * Hint: Indexs of a book are Title,Author,Release Date,#EBook,Edition,Language, and Character set encoding.
         * Hint: Data stored in the ArrayList should be arranged in the order of indexs. e.g: You can get a book by "ArrayList.get(0)", and for more information you could get the Title by "ArrayList.get(0)[0]", Author by "ArrayList.get(0)[1]" , Release Date by "ArrayList.get(0)[2]", etc.
         * Hint: Noted that a book are composed of indexs and other datas, and a book always starts with the "Title" index and ends with the "Character set encoding" index.
         * Hint: Be awared of that the indexs of a book may be incomplete. e.g: A book may only composed of Title,Author,Release Date,#EBook,Language, and Character set encoding, which the "Edition" index is missiing. For the incomplete index, you should record it as "None".
         * Hint: Also, the contents of indexs may be more than one line, you should integrate multiple lines with a period("."). e.g: Supposed a Title index is "helloworld\n byebyeworld", then you should store it as "helloworld. byebyeworld".
         * Hint: You have to replace every commas in indexs with periods. e.g: "Title: Hello,World" --> "Title: Hello.World"
         * Hint: For the #EBook index, you should only record the number. e.g: "[EBook #10040]" will be recorded as "10040".
         * Hint: We provide the following methods you may use ---> substring(), startsWith(), replaceAll(), strip().
         * Hint: You can check if a line is empty or not by using the method "isEmpty()".
         **********************************The End of the TODO**************************************/

        /********************************************************************************************
         START OF YOUR CODE
         ********************************************************************************************/ 
        try{
        String name = ""+EBOOKS+"";
        FileReader fileReader = new FileReader(name);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Scanner fileScanner = new Scanner(bufferedReader);
        ArrayList<String[]> datafind=new ArrayList<>();
        ArrayList<String[]> data_title=new ArrayList<>();
        ArrayList<String[]> data_author=new ArrayList<>();
        ArrayList<String[]> data_release_date=new ArrayList<>();
        ArrayList<String[]> data_language=new ArrayList<>();
        ArrayList<String[]> data_ebooksnum=new ArrayList<>();
        ArrayList<String[]> data_code=new ArrayList<>();
        ArrayList<String[]> datano=new ArrayList<>();
        while(fileScanner.hasNextLine()) {  
        String[] readline= {fileScanner.nextLine()};

        if (readline[0].startsWith("Title")) { 
            readline[0]=readline[0].substring(7);
            readline[0]=readline[0].replaceAll(",",".");    
            String temp="";
            temp=temp+readline[0];
            for(;;){
            String[] readline2= {fileScanner.nextLine()};
            if(readline2[0].length()!=0){
            temp=temp+"."+readline2[0];   
                continue;
            }
            if(readline2[0].length()== 0){
                String[] id3= {temp};
                if(id3[0].length()!=0){
                    id3[0]=id3[0].replaceAll(",",".");
                    data_title.add(id3);
                break;}
            data_title.add(readline);   
            break;}
            }    
         }
        if (readline[0].startsWith("Author:")) {
            readline[0]=readline[0].substring(8);
             data_author.add(readline);
         }
        if (readline[0].startsWith("Release Date:")) {
            if(readline[0].length()==46){
            String[] readline2={""};  
            readline2[0]=readline[0].substring(40,45);
            data_ebooksnum.add(readline2);  
            readline[0]=readline[0].substring(14,31);
            readline[0]=readline[0].replaceAll(",",".");
            data_release_date.add(readline);
            }
            if(readline[0].length()==45){
            String[] readline2={""};  
            readline2[0]=readline[0].substring(39,44);
            data_ebooksnum.add(readline2); 
            readline[0]=readline[0].substring(14,30);
            readline[0]=readline[0].replaceAll(",",".");
            data_release_date.add(readline);
            }   
         }
        if (readline[0].startsWith("Language:")) {
            readline[0]=readline[0].substring(10);
            data_language.add(readline);
         }
        if (readline[0].startsWith("Character set encoding:")) {
            readline[0]=readline[0].substring(24);
            data_code.add(readline);
            String[] none={""};
            none[0]="None";
            datano.add(none);
         }
         }
         fileScanner.close();
         for(int q=0;q<data_code.size();q++){
         String[] datasetall={data_title.get(q)[0],data_author.get(q)[0],data_release_date.get(q)[0],data_ebooksnum.get(q)[0],datano.get(q)[0],data_language.get(q)[0],data_code.get(q)[0]};
         datafind.add(datasetall);
        }
        return datafind;
        }              
         catch(FileNotFoundException e){
            ArrayList<String[]> dataSet2=new ArrayList<>();
            System.out.println("Oops!Tricks on you!");
            System.exit(0);
            return dataSet2;
        }
         
        /********************************************************************************************
         END OF YOUR CODE
         ********************************************************************************************/
        }
    //Export structured data as csv file
    private static void exportToCsv(ArrayList<String[]> dataSet){
        /*********************************The TODO This Time (Checkpoint3) ********************************
         * 
         * TODO(3): Here you need to export the structured data as "學號(capital)_checkpoint3_ebooks_structured.csv", based on the 2D arraylist. The first row has to be indexs.
         * Hint: The order of indexs are Title,Author,Release Date,#EBook,Edition,Language, and Character set encoding.
         * Hint: Every time you export the new csv file, you have to overwrite the old one.
         * 
         **********************************The End of the TODO**************************************/

        /********************************************************************************************
         START OF YOUR CODE
         ********************************************************************************************/ 
                try { 
         String filename = "A1083331_checkpoint3_ebooks_structured.csv"; 
         boolean append = false; 
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, append)); 
         String[] index = { "Title","Author","Release Date","#EBook","Edition","Language","Character set encoding"}; 
         for(int i2=0;i2<7;i2++){
         bufferedWriter.write(""+index[i2]+",");
         }
         bufferedWriter.newLine();
         for (String[] element : dataSet) { 
         for(int i=0;i<7;i++){   
         bufferedWriter.write(""+element[i]+","); 
         }
         bufferedWriter.newLine(); 
         } 
         bufferedWriter.flush(); 
         bufferedWriter.close(); 
         System.out.println("Results can be found at: " + filename); 
         } catch (IOException e) { 
         System.out.println(e.getMessage()); 
         System.exit(0);
         } 
          
        /********************************************************************************************
         END OF YOUR CODE
         ********************************************************************************************/
        
    }

    //Check if the String is empty or not
    private static boolean isEmpty(String str){
        /*********************************The TODO This Time (Checkpoint3) ********************************
         * 
         * TODO(4): Here you have to check if the input String is empty or not. If the String is empty then return true. 
         * Hint: Be aware of that "null" is not equal to "".
         * 
         **********************************The End of the TODO**************************************/

        /********************************************************************************************
         START OF YOUR CODE
         ********************************************************************************************/ 
        if(str.length()== 0){
        return true;
        } 
        return false;
        /********************************************************************************************
         END OF YOUR CODE
         ********************************************************************************************/
    }
    //Initialize the default value of array
    private static String[] initArray(String[] ary){
            /*********************************The TODO This Time (Checkpoint3) ********************************
         * 
         * TODO(5): Here you have to initialize an array with every elements' value sets to "None"
         * Hint: "None" is a string, it's not equal to null.  
         * 
         **********************************The End of the TODO**************************************/

        /********************************************************************************************
         START OF YOUR CODE
         ********************************************************************************************/ 
        for(int count=0;count<ary.length;count++){
            ary[count]="None";
        }
        return ary;        
        /********************************************************************************************
         END OF YOUR CODE
        ********************************************************************************************/
    }
        
    //Check answer
    private static void checkAnswer(ArrayList<String[]> dataSet){   
        A1083331_checkpoint3_check ck=new A1083331_checkpoint3_check(dataSet);
        ck.answerCheck();
    }

}
