package utils.inout;

import datastructer.STtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数据格式的转换
 */
public class DataUtils {
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

    /**
     * string转char[]
     * @param s
     * @return
     */
    public static char[] changeS_chararr_1(String s){
        // 移除字符串中的方括号、双引号、逗号和空格
        s = s.replaceAll("[\\[\\]\" ,]", "");

        // 将处理后的字符串转换为字符数组
        char[] charArray = s.toCharArray();
        return charArray;
    }

    /**
     * string转char[][]
     * @param s
     * @return
     */
    public static char[][] changeS_chararr_2(String s){
        // 先去掉字符串的多余的空格，方便后续处理
        s = s.replaceAll("\\s", "");

        // 通过 ", " 分割字符串，得到每一行的数据
        String[] rows = s.substring(1, s.length() - 1).split("],\\[");

        // 去掉每个部分的方括号和双引号
        char[][] charArray = new char[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            // 移除方括号和双引号后，拆分每个字符
            String row = rows[i].replaceAll("[\\[\\]\" ,]", "");
            // 将每一行字符串转换成字符数组
            charArray[i] = row.toCharArray();
        }

        return charArray;
    }

    public static List<String> changeS_strlist_1(String s){
        // 去掉前后中括号和空格
        s = s.substring(1, s.length() - 1).trim();

        // 用逗号分割并去掉引号
        String[] items = s.split(",\\s*");
        List<String> result = new ArrayList<>();

        for (String item : items) {
            result.add(item.replace("\"", ""));
        }

        return result;
    }

    public static List<List<String>> chanegS_strlist_2(String s){
        // 去掉最外层的中括号
        s = s.substring(1, s.length() - 1).trim();

        // 分割出每一个子数组的字符串
        String[] subArrays = s.split("\\],\\s*\\[");

        List<List<String>> result = new ArrayList<>();

        // 遍历每个子数组，处理成 List<String>
        for (String subArray : subArrays) {
            // 去掉多余的双引号和中括号
            subArray = subArray.replace("[", "").replace("]", "").trim();

            // 按照逗号分割每个元素
            String[] elements = subArray.split(",\\s*");

            // 将每个子数组的元素转换成 List<String>
            List<String> list = new ArrayList<>();
            for (String element : elements) {
                list.add(element.replace("\"", ""));
            }
            result.add(list);
        }

        return result;
    }

    public static String[] changeS_strarr_1(String s){
        // 去掉最外层的中括号
        s = s.substring(1, s.length() - 1).trim();

        // 用逗号分割并去掉每个元素的引号
        String[] items = s.split(",\\s*");

        // 去除每个元素的双引号，并存入数组
        for (int i = 0; i < items.length; i++) {
            items[i] = items[i].replace("\"", "");
        }
        return items;
    }
}
