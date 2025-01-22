package string;

public class KMP {
    /**
     * 在文本串s中寻找模式串p，并返回匹配开始位置，失败则-1
     * @param str 文本串
     * @param pat 模式串
     * @return 匹配起始位置
     */
    public static int KMP(String str,String pat){
        int slen=str.length(),plen=pat.length();
        char[]s=str.toCharArray(),p=pat.toCharArray();
        /*
        相同前后缀长度
        a b a b c a b a a
        0 0 1 2 0 1 2 3 1
         */
        int[]pmt=new int[plen];
        pmt[0]=0;
        int i,j;
        /*
        构建pmt表
        也就是错开一位匹配，用相同串的后面匹配前面，j就是匹配长度
        a b a b c a b a a
          a b a b c a b a a -->
        i指上面，j指下面
         */
        for(i=1,j=0;i<plen;i++){
            while(j>0&&p[i]!=p[j])j=pmt[j-1];
            if(p[i]==p[j])j++;
            pmt[i]=j;
        }
        for(i=0,j=0;i<slen;i++){
            while (j>0&&s[i]!=p[j])j=pmt[j-1];
            if(s[i]==p[j])j++;
            if(j==plen){
                return i-j+1;
                /*
                如果继续匹配则：
                j=pmt[j-1];
                 */
            }
        }
        return -1;
    }
}
