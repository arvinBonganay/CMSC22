
public class Rule30Threaded {
    int size;
    String rule30 = "";
    final static int THREAD_COUNT = 10;

    public Rule30Threaded(int size){
        this.size = size;
        int seed = size / 2;
        for (int i = 0; i < size; i++){
            if (i == seed){
                rule30 += "1";
            } else {
                rule30 += "0";
            }
        }
    }

    public void generation(){
        int numOfThreads = THREAD_COUNT;
        if (size < THREAD_COUNT){
            numOfThreads = size;
        }
        int rangePerThread = size / numOfThreads;
        String prevGen = rule30;
        System.out.println(prevGen);
        ThreadedGeneration[] threads = new ThreadedGeneration[numOfThreads];
        int start;
        for (int i = 0; i < size - 1; i++){
            start = 0;
            for (int t = 0; t < numOfThreads - 1; t++){
                  threads[t] = new ThreadedGeneration(prevGen, start, start + rangePerThread);
                    start = start + rangePerThread;
            }
            threads[numOfThreads - 1] = new ThreadedGeneration(prevGen, start, size);

            for (int s = 0; s < numOfThreads; s++){
                threads[s].start();
            }

            for (int j = 0; j < numOfThreads; j++){
                while (threads[j].isAlive()){
                    try{
                        threads[j].join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            prevGen = "";
            for (int r = 0; r < numOfThreads; r++){
                prevGen += threads[r].getResult();
            }
	    System.out.println(prevGen);
        }
    }

}