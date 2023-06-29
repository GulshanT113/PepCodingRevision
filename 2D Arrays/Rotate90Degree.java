public class Rotate90Degree extends MatrixMultiplication {
    public static void main(String[] args) {
        int[][] arr = input();
        transpose(arr);
        reverseCol(arr);
//        print(arr);
    }

    private static void reverseCol(int[][] arr) {
        for(int i = arr.length-1; i >= 0; i--){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void transpose(int[][] arr) {
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
}
