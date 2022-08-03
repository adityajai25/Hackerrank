import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
        int start=a.get(a.size()-1);
    int end = a.get(0);
    System.out.println(a.size());
    
    List<Integer> arr = new ArrayList<>();
    List<Integer> factors = new ArrayList<>();
    for(int i=start;i<end+1;i++){
        arr.add(i);
    }
    
    for(int x:arr){
        for(int y:a){
            System.out.println(y);
            if(x%y!=0){
                System.out.println(y);
                break;
            }
            System.out.println(y);
            System.out.println(a.size()-1);
            if(y==a.get(a.size()-1)){
                System.out.println(y);
                factors.add(x);
            }
            
        }
        
    }
    for(int fac : factors){
        for(int y: b){
            if(y%fac!=0){
                factors.remove(Integer.valueOf(y));
                break;
            }
            System.out.println(y);
            if(y==b.get(b.size()-1)){
                System.out.println(y);
                return factors.size();
            }
        }
    }
    return factors.size();

    }

    }



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
