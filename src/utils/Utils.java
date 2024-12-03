package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    /**
     * string转一维数组
     * @param str
     * @return
     */
    public static int[] changeS_nums_1(String str){
        // 去掉方括号
        str = str.replaceAll("[\\[\\]]", "");

        // 根据逗号分割字符串并转换为整型数组
        String[] stringArray = str.split(",");
        return Arrays.stream(stringArray)
                .map(String::trim)
                .mapToInt(Integer::parseInt) // 转换为 int
                .toArray(); // 转换为 int[]
    }

    /**
     * string转二维列表
     * @param str
     * @return
     */
    public static List<Integer> changeS_list_1(String str){
        // 去掉方括号
        str = str.replaceAll("[\\[\\]]", "");

        // 根据逗号分割字符串并转换为 List<Integer>
        return Arrays.stream(str.split(","))
                .map(Integer::parseInt) // 转换为 Integer
                .collect(Collectors.toList()); // 收集到 List
    }
    /**
     * string转二维数组
     * @param s
     * @return
     */
    public static int[][] changeS_nums_2(String s){
        s=s.substring(2,s.length()-2)+" ";
        List<String>nums_list=new LinkedList<>();
        int l=0,r=0;
        int len=s.length();
        while(l<len||r<len){
            while(r<len&&s.charAt(r)!=']'){
                r++;
            }
            nums_list.add(s.substring(l,r));
            l=r+3;
            r=l;
        }
        int n=nums_list.size();
        int[][]ans=new int[n][];
        for(int i=0;i<n;i++){
            String num=nums_list.get(i).trim();
            if(num.equals(""))ans[i]=new int[0];
            else{
                String[]nums=nums_list.get(i).trim().split(",");
                int m=nums.length;
                ans[i]=new int[m];
                for(int j=0;j<m;j++){
                    ans[i][j]=Integer.parseInt(nums[j]);
                }
            }
        }
        return ans;
    }

    /**
     * string转二维列表
     * @param s
     * @return
     */
    public static List<List<Integer>> changeS_list_2(String s){
        s=s.substring(2,s.length()-2)+" ";
        List<String>nums_list=new LinkedList<>();
        int l=0,r=0;
        int len=s.length();
        while(l<len||r<len){
            while(r<len&&s.charAt(r)!=']'){
                r++;
            }
            nums_list.add(s.substring(l,r));
            l=r+3;
            r=l;
        }
        int n=nums_list.size();
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
            String num=nums_list.get(i).trim();
            if(num.equals(""))continue;
            else{
                String[]nums=nums_list.get(i).trim().split(",");
                int m=nums.length;
                for (String string : nums) {
                    ans.get(i).add(Integer.parseInt(string));
                }
            }
        }
        return ans;
    }
}
