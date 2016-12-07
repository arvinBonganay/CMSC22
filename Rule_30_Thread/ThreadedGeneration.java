public class ThreadedGeneration extends Thread {
    String prevGen, result = "";
    int start, end;

    public ThreadedGeneration(String prevGeneration, int indexStart, int indexEnd){
        this.prevGen = prevGeneration;
        start = indexStart;
        end = indexEnd;
    }

    public String rule(String cond){
        if ((cond.charAt(0) == '1' && cond.charAt(1) == '0' && cond.charAt(2) == '0') ||
            (cond.charAt(0) == '0' && cond.charAt(1) == '1' && cond.charAt(2) == '1') ||
            (cond.charAt(0) == '0' && cond.charAt(1) == '1' && cond.charAt(2) == '0') ||
            (cond.charAt(0) == '0' && cond.charAt(1) == '0' && cond.charAt(2) == '1')
                ){
            return "1";
        } else {
            return "0";
        }
    }
    public void run(){
        for (int i = start; i < end; i++){
            if (i == 0){
                result += rule("0" + prevGen.substring(i, i + 2));
            } else if (i == prevGen.length() - 1){
                result += rule(prevGen.substring(i - 1) +  "0");
            } else {
                result += rule(prevGen.substring(i - 1, i + 2)) ;
            }			
        }
    }

    public String getResult(){
        return result;
    }
}
