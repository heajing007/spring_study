public class Solution {


    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,0};

        System.out.println(peakIndexInMountainArray(arr));
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
