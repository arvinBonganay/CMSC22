/**
 * Created by thegi on 07/12/2016.
 */
package mp;
public class Rule30NonThreaded {
    String rule30 = "";
    private int size;

    public Rule30NonThreaded(int size){
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

    public void generations(){
        String currentRow = rule30;
        for (int i = 0; i < size - 1; i++){
            String resultRow = "";
            for (int j = 0; j < size; j++){
                if (j == 0){
                    resultRow += rule("0" + currentRow.substring(j, j + 2));
                } else if (j == size - 1){
                    resultRow += rule(currentRow.substring(j - 1) + "0");
                } else {
                    resultRow += rule(currentRow.substring(j - 1, j + 2));
                }
            }
            currentRow = resultRow;
            rule30 += ("\n" + resultRow);
        }
    }

    public String getResult(){
        return rule30;
    }




}
