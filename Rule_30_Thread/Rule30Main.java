
import java.util.*;


public class Rule30Main {
    public static void main (String args[]){
        int gridSize;
        System.out.println("Enter grid size : ");
        Scanner s = new Scanner(System.in);
        gridSize = s.nextInt();
        long startTime1, startTime2, threadedTime, nonThreadedTime;

        Rule30NonThreaded r = new Rule30NonThreaded(gridSize);
        Rule30Threaded r1 = new Rule30Threaded(gridSize);

        // non Threaded
        startTime1 = System.currentTimeMillis();
        r.generations();
        nonThreadedTime = System.currentTimeMillis() - startTime1;
	//System.out.println(r.getResult());

        System.out.println();
        //Threaded
        startTime2 = System.currentTimeMillis();
        r1.generation();
        threadedTime = System.currentTimeMillis() - startTime2;
        //System.out.println(r1.getResult());


        System.out.println("\nThreaded Time : " + (threadedTime) + "ms");
        System.out.println("Non Threaded Time : " + (nonThreadedTime) + "ms");
        System.out.println("difference : " + (threadedTime - nonThreadedTime) + "ms");

    }

}
