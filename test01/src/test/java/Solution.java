import com.test.entity.A;
import com.test.entity.B;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Solution {
//    1 2 3 5 8 13
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
//        int[] arr = {5,3,4,5};
//        System.out.println(stoneGame(arr));
        System.out.println(convertToTitle(99));
        findDisappearedNumbers(arr);
    }


    public int climbStairs(int n) {
        int x=0, y=0, z=1;
        for (int i=1; i<=n; i++){
            x=y;
            y=z;
            z=x+y;
        }
        return z;
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums){
            int tag = Math.abs(x);
            nums[tag-1]=-Math.abs(nums[tag-1]);
        }
        for (int i=0; i<nums.length; i++){
            if (nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }

    //动态规划
    public int maxSubArray(int[] nums) {
        int cur = 0, maxSum=nums[0];
        for (int x : nums){
            cur = Math.max(cur+x, x);
            maxSum = Math.max(maxSum, cur);
        }
        return maxSum;
    }
    public static String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            sb.append((char)(a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return sb.reverse().toString();
    }

    //动态规划
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
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left=0, right=len-1, index=0;
        while (right>=left){
            int mid = (left+right)/2;
            if (nums[mid]<target){
                left = mid+1;
                index = mid+1;
            }else {
                right = mid -1;
                index = mid;
            }
        }
        return index;
    }
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


    @Test
    public void fun1(){
        A a = new A();
        a.setA("a");
        a.setB("b");
        a.setName(null);
        B b = new B();
        b.setName("name");

        BeanUtils.copyProperties(a, b);
        System.out.println(b);

        List<Integer> list = new ArrayList<>();
        list.clear();
    }

    public <T extends A> T getClass(Class<T> c){
        A a = null;
        return (T) a;
    }




}

