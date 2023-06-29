public class EndPoint extends MatrixMultiplication {
    public static void main(String[] args) {
        int[][] arr = input();
        int i = 0, j = 0, dir = 0;
        while(true){
            dir = (dir + arr[i][j]) % 4;
            if(dir == 0){
                j++;
            }
            else if(dir == 1){
                i++;
            }
            else if(dir == 2){
                j--;
            }
            else if(dir == 3){
                i--;
            }
            if(i < 0){
                i++;
                break;
            }
            else if(j < 0){
                j++;
                break;
            }
            else if(i == arr.length){
                i--;
                break;
            }
            else if(j == arr[0].length){
                j--;
                break;
            }
        }
        System.out.println(i);
        System.out.println(j);
    }
}
