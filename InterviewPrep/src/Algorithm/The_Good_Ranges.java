package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class The_Good_Ranges {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String input1 = br.readLine().trim();
        String[] input = input1.split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        minTillNow = -1;
        maxTillNow = -1;
        sumTillNow = 0;
        seen = new boolean[N+1];
        StringBuilder sb = new StringBuilder();
        while(M > 0){
            int X = Integer.parseInt(br.readLine().trim());
            if(seen[X])
                sb.append(sumTillNow + "\n");
            else{
                sb.append(getOutput(X) + "\n");
            }
            M--;
        }
        System.out.println(sb);
        wr.close();
        br.close();
    }

    static int maxTillNow;
    static int minTillNow;
    static long sumTillNow;
    static boolean[] seen;

    static long getOutput(int X){
        if(minTillNow == -1){
            sumTillNow = seen.length;
            minTillNow = maxTillNow = X;
        }else{
            if(X > maxTillNow){
                // sumTillNow += maxTillNow+1 + X-1;
                sumTillNow += maxTillNow + X;
                maxTillNow = X;
            }else if(X < minTillNow){
                // sumTillNow += minTillNow-1 + X+1;
                sumTillNow += minTillNow + X;
                minTillNow = X;
            }else
                sumTillNow += X*2;
        }
        seen[X] = true;
        return sumTillNow;
    }

}
