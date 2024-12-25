package datastructer.trietree;
import java.util.HashMap;
import java.util.List;

public class TrieTree {
    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        int endOfWordCount = 0; // 表示以此节点为结尾的单词个数
        String s;//当前节点表示对字符串
        TrieNode(){
            s="";
        }
        TrieNode(String word){
            s=word;
        }
    }

    private final TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    public TrieTree(String[] strs) {
        root = new TrieNode();
        for (String s : strs) {
            insert(s);
        }
    }

    public TrieTree(List<String> strs) {
        root = new TrieNode();
        for (String s : strs) {
            insert(s);
        }
    }

    /**
     * 插入单词
     *
     * @param word
     */
    public void insert(String word) {
        TrieNode current = root;
        StringBuilder sb=new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(c);
            if(!current.children.containsKey(c)){
                current.children.put(c,new TrieNode(sb.toString()));
            }
            current=current.children.get(c);
        }
        current.endOfWordCount++;
    }

    /**
     * 查找单词出现的次数
     *
     * @param word
     * @return >0表示出现的次数，0表示没有
     */
    public int search(String word) {
        TrieNode node = getNode(word);
        return node != null ? node.endOfWordCount : 0;
    }

    /**
     * 判断是否是字典树中其他单词的前缀
     * @param word
     * @return
     */
    public boolean isPrefix(String word){
        TrieNode node = getNode(word);
        if(node==null)return false;
        return !node.children.isEmpty();
    }

    /**
     * 查找是否存在前缀s
     *
     * @param s
     * @return
     */
    public boolean startsWith(String s) {
        return getNode(s) != null;
    }

    /**
     * 删除单词
     *
     * @param word
     * @return false代表之前没有插入过这个单词
     */
    public boolean delete(String word) {
        if (search(word) == 0) return false;
        deleteHelper(root, word, 0);
        return false;
    }

    /**
     * 递归调用的从底向上删除节点
     *
     * @param current
     * @param word
     * @param index
     * @return 返回值表示current节点是否需要删除
     */
    private boolean deleteHelper(TrieNode current, String word, int index) {
        if (index == word.length()) {
            current.endOfWordCount--;
            return current.children.isEmpty() && current.endOfWordCount == 0; // 如果没有子节点且不再结尾，可以删除
        }
        char c = word.charAt(index);
        TrieNode childNode = current.children.get(c);
        boolean shouldDeleteChildNode = deleteHelper(childNode, word, index + 1);
        if (shouldDeleteChildNode) {
            current.children.remove(c);
            return current.children.isEmpty() && current.endOfWordCount == 0;
        }
        return false;
    }

    /**
     * 给定字符串，求在字典树中的最后节点
     *
     * @param word
     * @return null表示不存在这条路径
     */
    private TrieNode getNode(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.children.get(c);
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    /**
     * 求最长公共前缀
     * @return
     */
    public String longestCommonPrefix() {
        StringBuilder prefix = new StringBuilder();
        TrieNode current = root;
        while (current != null && current.children.size() == 1 && current.endOfWordCount == 0) {
            // 如果当前节点只有一个子节点，并且不是某个单词的结尾
            for (Character c : current.children.keySet()) {
                prefix.append(c);
                current = current.children.get(c);
            }
        }
        return prefix.toString();
    }
}
