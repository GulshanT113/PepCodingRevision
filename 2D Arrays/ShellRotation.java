public class ShellRotation extends MatrixMultiplication {
    public static void main(String[] args) {
        int[][] arr = input();
        int s = scn.nextInt();
        int r = scn.nextInt();
        shellRotation(arr, s, r);
        print(arr);
    }

    private static void shellRotation(int[][] arr, int s, int r) {
        int[] oneD = matrixToArray(arr, s);
        rotate(oneD, r);
        arrayToMatrix(arr, s, oneD);
    }

    private static void arrayToMatrix(int[][] arr, int s, int[] oneD) {
        int minRow = s - 1;
        int minCol = s - 1;
        int maxRow = arr.length - s;
        int maxCol = arr[0].length - s;
        int idx = 0;
        for(int i = minRow, j = minCol; i <= maxRow; i++) arr[i][j] = oneD[idx++];
        for(int i = maxRow, j = minCol + 1; j <= maxCol; j++) arr[i][j] = oneD[idx++];
        for(int i = maxRow - 1, j = maxCol; i >= minRow; i--) arr[i][j] = oneD[idx++];
        for(int i = minRow, j = maxCol - 1; j >= minCol + 1; j--) arr[i][j] = oneD[idx++];
//        return oneD;
    }

    private static int[] matrixToArray(int[][] arr, int s) {
        int minRow = s - 1;
        int minCol = s - 1;
        int maxRow = arr.length - s;
        int maxCol = arr[0].length - s;
        int size = 2 * (maxRow - minRow + maxCol - minCol);
        int[] oneD = new int[size];
        int idx = 0;
        for(int i = minRow, j = minCol; i <= maxRow; i++) oneD[idx++] = arr[i][j];
        for(int i = maxRow, j = minCol + 1; j <= maxCol; j++) oneD[idx++] = arr[i][j];
        for(int i = maxRow - 1, j = maxCol; i >= minRow; i--) oneD[idx++] = arr[i][j];
        for(int i = minRow, j = maxCol - 1; j >= minCol + 1; j--) oneD[idx++] = arr[i][j];
        return oneD;
    }

    public static void rotate(int[] arr, int r){
        r = r % arr.length;
        if(r < 0){
            r = r + arr.length;
        }
        reverse(arr, 0, arr.length - r - 1);
        reverse(arr, arr.length-r, arr.length-1);
        reverse(arr, 0, arr.length-1);
    }
    public static void reverse(int[] arr, int i, int j){
        while (i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
