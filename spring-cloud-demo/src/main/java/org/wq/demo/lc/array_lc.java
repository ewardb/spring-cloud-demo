package org.wq.demo.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 10:39 2019/5/20
 */
public class array_lc {

    //基本数据类型 byte:1b (-128, 127), Char:2B(16位无符号 unicode) , boolean:1B , Short:2B
    // int:4B , float:4B , long：8B , double:8B

    //1
    public int[] twoSum(int[] arr, int target) {
        int res[] = {0, 0};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            res[0] = i;
            if (map.containsKey(target - arr[i])) {
                res[1] = map.get(target - arr[i]);
                if (res[0] == res[1]) {
                    continue;
                }
                break;
            } else {
                map.put(arr[i], i);
            }
        }
        if (res[0] != res[1]) {
            System.out.println(res[0] + "   " + res[1]);
        }
        System.out.println();
        return res;
    }

    // 15
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);


        for(int i = 0 ; i < nums.length - 2 ; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);

            int min = nums.length -2;
            int max = nums.length -1;
            while(true){
                int temp_sum = nums[i] + nums[min] + nums[max];
                if(temp_sum > 0){

                }else if(temp_sum < 0){

                }else{
                    temp.add(nums[min]);
                    temp.add(nums[max]);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        array_lc array_lc = new array_lc();
//        byte a = 1;
//        boolean b = true;
//        char c = '中';
//        int i = (int)c;
//        System.out.println(c+ "  "+ i);

//        int arrs[] = {2,7,11,15};
//        int target = 9;
//        array_lc.twoSum(arrs, target);


//        int arr1[] = {1, 2, 3};
////        int arr2[] = {3, 4};
////        double res = array_lc.findMedianSortedArrays(arr1, arr2);

//        int arrs[] = {1,8,6,2,5,4,8,3,7};
//        int res = array_lc.maxArea(arrs);
//        System.out.println(res);
        String str = "abc";
        char []ar = {'a','b','c'};
        String s = new String(ar);
        System.out.println(str);
        System.out.println(s);
        System.out.println(str == s);
        System.out.println(str.hashCode()+ "     "+s.hashCode());
        System.out.println(str.equals(s));

        String ss = "abc";
        System.out.println(str == ss);

        String [] arrs = {"9995363_1"
                ,"9995165_1"
                ,"9990724_1"
                ,"9988154_1"
                ,"9980078_1"
                ,"9958617_1"
                ,"9958418_1"
                ,"9954936_1"
                ,"9950746_1"};
        for(int i = 0 ; i<arrs.length ; i++){
            System.out.println(arrs[i].hashCode());
        }
    }



    //4
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int res_length = nums1.length + nums2.length;
        int res_div_2 = res_length / 2;
        System.out.println(res_div_2);
        int[] ints = new int[res_length];
        int ints_index = 0;
        int index_nums1 = 0;
        int index_nums2 = 0;
        while (true) {
            if (ints_index > res_div_2 || index_nums1 == nums1.length && index_nums2 == nums2.length) {
                break;
            } else if (index_nums1 == nums1.length) {
                ints[ints_index] = nums2[index_nums2];
                index_nums2++;
            } else if (index_nums2 == nums2.length) {
                ints[ints_index] = nums1[index_nums1];
                index_nums1++;
            } else {
                if (nums1[index_nums1] < nums2[index_nums2]) {
                    ints[ints_index] = nums1[index_nums1];
                    index_nums1++;
                } else {
                    ints[ints_index] = nums2[index_nums2];
                    index_nums2++;
                }
            }
            ints_index++;
        }
        if (res_length % 2 == 0) {
            return (ints[res_div_2 - 1] + ints[res_div_2]) / 2.0d;
        } else {
            return ints[res_div_2];
        }
    }


    public int maxArea(int[] height) {
        int res = 0 ;
        int start = 0 ;
        int stop = height.length - 1;
        while(start < stop){
            int temp = 0;
            if(height[stop] > height[start]){
                temp = height[start] * (stop - start);
                start++;
            }else{
                temp = height[stop] * (stop - start);
                stop--;
            }
            if(temp > res){
                res = temp;
            }
        }
        return res;
    }







}
