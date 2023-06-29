import java.util.Scanner;
public class MatrixMultiplication {
    public static Scanner scn = new Scanner(System.in);
    public static int[][] input(){
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        return arr;
    }
    public static void print(int[][] arr){
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] matrixMultiplication (int[][] one, int[][] two) {
        int n = one.length, m = one[0].length, y = two[0].length;
        int[][] ans = new int[n][y];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < y; j++){
                // int mul = 0;
                for (int k = 0; k < m; k++) {
                    ans[i][j] += one[i][k] * two[k][j];
                }
                // ans[i][j] = mul;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] one = input();
        int[][] two = input();
        if(one[0].length != two.length){
            System.out.println("Invalid Input");
            return;
        }
        int[][] ans = matrixMultiplication(one, two);
        print(ans);
    }
}