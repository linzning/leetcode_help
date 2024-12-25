package datastructer.trietree;

public class ArrayTireTree {
    int N = (int)1e5;
    int[][] trie;
    int[] endCount;// 记录某个格子被「被标记为结尾的次数」
    //int[] childCount;// 记录经过该节点的字符串数量
    int index; // index 来自增记录我们到底用了多少个格子（相当于给被用到格子进行编号）

    public ArrayTireTree() {
        trie = new int[N][26];
        endCount = new int[N];
        index = 0;
    }

    /**
     * 插入一个字符串
     * @param s
     */
    public void insert(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) trie[p][u] = ++index;
            p = trie[p][u];
        }
        endCount[p]++;
    }

    /**
     * 查找字符串
     * @param s
     * @return 返回2表示找到字符串，返回1找到前缀，返回-1表示没找到
     */
    private int find(String s){
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) return -1;
            p = trie[p][u];
        }
        return endCount[p]!=0?2:1;
    }

    /**
     * 查找一个字符串是否存在
     * @param s
     * @return
     */
    public boolean search(String s) {
        return find(s)==2;
    }

    /**
     * 查找所有字符串前缀之一是否有s
     * @param s
     * @return
     */
    public boolean startsWith(String s) {
        return find(s)>0;
    }
}
