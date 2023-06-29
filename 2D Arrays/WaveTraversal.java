public class WaveTraversal extends MatrixMultiplication{
    public static void main(String[] args) {
        int[][] arr = input();
        waveTravse(arr);
    }

    private static void waveTravse(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        for(int j = 0; j < m; j++){
            if(j % 2 == 0){
                for(int i = 0; i < n; i++){
                    System.out.print(arr[i][j] + " ");
                }
            }
            else {
                for(int i = n-1; i >= 0; i--){
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
