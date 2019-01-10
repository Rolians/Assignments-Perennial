package Assignment;
/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */
import java.lang.*;
import java.io.*;
import java.util.*;
public class CandidateCode {
    private int[] treeHeight;

    //set reference to treeHeight array
    private void setTreeHeight(int[] treeHeight){
        this.treeHeight = treeHeight;
    }

    //Calculating maximum time
    private void maxTimeCalculate(){
        int maxTime = 0,tempDist,ClimbDist,finalDest, firstPos=-1,SecPos=-1,cnt =0;
        for(int i=0;i<treeHeight.length-1;i++){
            for (int j=i+1;j<treeHeight.length-1;j++){
//                if(i == j)
//                    continue;
                cnt++;
                ClimbDist = treeHeight[i]+treeHeight[j];
                tempDist = tempMin(treeHeight,i,j);
                finalDest = tempDist + ClimbDist;
                if(maxTime <= finalDest){
                    maxTime = max(maxTime,finalDest);
                    firstPos = i;
                    SecPos = j;
                }
            }
        }
        System.out.println("Maximum time for monkeys will be " + maxTime + " units with iterations "+cnt);
        System.out.println("Monkeys resides on trees " + firstPos + " and " + SecPos);
    }

    //Calculating minimum distance between two trees
    private int tempMin(int[] treeHeight,int init,int restNode){
        int FirstDist,SecDist,len;
        len = treeHeight.length-1;

        FirstDist = Math.abs(init - restNode);
        SecDist = init<restNode?Math.abs((len+init)-restNode):Math.abs((len+restNode)-init);
        return min(FirstDist,SecDist);
    }

    private int min(int num1,int num2){
        return (num1<num2?num1:num2);
    }

    private int max(int num1,int num2){
        return (num1>num2?num1:num2);
    }

    public static void main(String[] args ) throws Exception {
        //Scanner sc = new Scanner(System.in);
        int[] treeHeight = new int[]{8,6,2,3,5,3,1,1,1,4,8};
        int noOftrees,sumOftreeHeight=0;
        noOftrees = treeHeight.length-1;

        //Checking constraints about no of trees
        if(noOftrees > 30){
            System.out.println("No of trees must not be more than 30");
            System.exit(0);
        }

        //Checking constraints
        for (int i=0;i<treeHeight.length - 1;i++){
            sumOftreeHeight =+treeHeight[i];
        }
        if(sumOftreeHeight > 10000){
            System.out.println("Sum of height must not be more than 1000");
            System.exit(0);
        }

        CandidateCode obj = new CandidateCode();
        obj.setTreeHeight(treeHeight);
        obj.maxTimeCalculate();
    }
}
