package other;

/**
 * 打印回形数组
 */
public class RecursiveArray {

    public static void main(String[] args) {
        print(4,5);
    }


    // n行m列
    public static void print(int n,int m){
        // n行 m列
        int num[][]=new int[n][m];

        int i,j;
        i=j=0;
        int index=1;
        while(index<n*m){

            // 往右
            while(j<m&&num[i][j]==0){
                num[i][j++]=index++;
            }
            j--; // 回退一格
            i++;// 下移一行

            // 往下
            while(i<n&&num[i][j]==0){
                num[i++][j]=index++;
            }
            i--; //回退一格
            j--;//左移一行

            // 往左
            while(j>=0&&num[i][j]==0){
                num[i][j--]=index++;
            }
            j++;
            i--;//上移一行

            // 往上
            while(i>=0&&num[i][j]==0){
                num[i--][j]=index++;
            }
            i++;
            j++;//右移一行

        }

        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                System.out.print(num[i][j]+" ");
            }
            System.out.println();
        }

    }


}
