package datastructer.trietree;

import java.util.HashMap;
import java.util.List;

/**
 *  自己构建的字典树map,可以之前前缀等的查询
 */
public class TrieMap {
    class TrieNode {
        int value;//值，仅当是单词结尾时有效
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false; // 表示以此节点为结尾的单词个数
    }

    private final TrieNode root;

    public TrieMap() {
        root = new TrieNode();
    }

    /**
     * 插入单词
     *
     * @param word
     */
    public void put(String word, int value) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.children.computeIfAbsent(c, k -> new TrieNode());
        }
        current.isEndOfWord = true;
        current.value = value;
    }

    /**
     * 查找单词出现的次数
     *
     * @param word
     * @return >0表示出现的次数，0表示没有
     */
    public Integer get(String word) {
        TrieNode node = getNode(word);
        if(node==null)return null;
        if (node.isEndOfWord) {
            return node.value;
        }
        return null;
    }

    /**
     * 前缀为word的所有键的值的和
     * @param word
     * @return
     */
    public Integer getPrefixValue(String word){
        TrieNode node = getNode(word);
        if(node==null)return null;
        return sumVal(node);
    }
    private Integer sumVal(TrieNode node){
        int tempVal=0;
        if(node.isEndOfWord)tempVal+=node.value;
        for(TrieNode tn:node.children.values()){
            tempVal+=sumVal(tn);
        }
        return tempVal;
    }

    /**
     * 删除单词
     *
     * @param word
     * @return false代表之前没有插入过这个单词
     */
    public boolean delete(String word) {
        if (get(word) == null) return false;
        deleteHelper(root, word, 0);
        return true;
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
            current.isEndOfWord=false;
            return current.children.isEmpty(); // 如果没有子节点且不再结尾，可以删除
        }
        char c = word.charAt(index);
        TrieNode childNode = current.children.get(c);
        boolean shouldDeleteChildNode = deleteHelper(childNode, word, index + 1);
        if (shouldDeleteChildNode) {
            current.children.remove(c);
            return current.children.isEmpty() && !current.isEndOfWord;
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
}
