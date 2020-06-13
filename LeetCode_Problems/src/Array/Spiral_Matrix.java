package Array;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {
	
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length==0)
            return list;
        int sr = 0;
        int er = matrix.length-1;
        int sc = 0;
        int ec = matrix[0].length-1;
        int totalNos = (er+1)*(ec+1);
        int count = 1;
        while(count<=totalNos){
            for(int i = sc; i<=ec && count<=totalNos; i++){
                list.add(matrix[sr][i]);
                count++;
            }
            sr++;
            for(int i = sr; i<=er && count<=totalNos; i++){
                list.add(matrix[i][ec]);
                count++;
            }
            ec--;
            for(int i = ec; i>=sc && count<=totalNos; i--){
                list.add(matrix[er][i]);
                count++;
            }
            er--;
            for(int i = er; i>=sr && count<=totalNos; i--){
                list.add(matrix[i][sc]);
                count++;
            }
            sc++;
        }
        return list;
    }
	
}
