public class TrieNode {
    public TrieNode[] children = new TrieNode[10];
    public int wordIndex = -1;
    public int[] ranks;
    public int minInv;
}