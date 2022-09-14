import java.util.*;
    public class A1083331_checkpoint3_check extends A1083331_checkpoint3 {
    ArrayList<String[]> dataSet=new ArrayList<>();

    public A1083331_checkpoint3_check(ArrayList<String[]> dataSet){
        this.dataSet=dataSet;
    }
    public void answerCheck(){
        System.out.println("There are totally "+dataSet.size()+" books");
        for(String[] temp:dataSet){
            System.out.println("------------------------------------------------------------------------");
            System.out.println(temp[0]+","+temp[1]+","+temp[2]+","+temp[3]+","+temp[4]+","+temp[5]+","+temp[6]);
        }
    }
}
