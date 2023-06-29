public class PrintUpperDiagonal extends MatrixMultiplication {
    public static void main(String[] args) {
        int[][] arr = input();
        for(int i = 0; i < arr.length; i++){
            for(int c = 0, j = i; j < arr.length; c++, j++){
                System.out.print(arr[c][j] + " ");
            }
        }
    }
}
