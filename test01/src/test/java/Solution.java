public class Solution {


    public static void main(String[] args) {
//        int[] arr = {0,1,2,3,4,5,6,0};
        int[] arr = {5,3,4,5};
        System.out.println(stoneGame(arr));
    }

    //动态代理
    public static boolean stoneGame(int[] ps) {
        int n = ps.length;
        int[][] f = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) { // 枚举区间长度
            for (int l = 1; l + len - 1 <= n; l++) { // 枚举左端点
                int r = l + len - 1; // 计算右端点
                int a = ps[l - 1] - f[l + 1][r];
                int b = ps[r - 1] - f[l][r - 1];
                f[l][r] = Math.max(a, b);
            }
        }
        return f[1][n] > 0;
    }


    //二分法
    public static int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int left = 1, right = len - 2, index = 0;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid+1]){
                right =  mid-1;
                index = mid;
            }else {
                left = mid+1;
            }
        }
        return index;
    }
}
