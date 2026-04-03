class TrieNode {
    char c;
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    TrieNode() {
        children = new HashMap<>();   
    }
}
class PrefixTree {
    TrieNode trie;
    public PrefixTree() {
         trie = new TrieNode();
    }

    public void insert(String word) {
        char[] arr = word.toCharArray();
        TrieNode temp = trie;
        for(int i=0;i<arr.length;i++) {
            TrieNode node = null;
            if(!temp.children.containsKey(arr[i])) {
                node = new TrieNode();
                node.c = arr[i];
                temp.children.put(arr[i], node);
                temp = node;
            } else {
                temp = temp.children.get(arr[i]);
            }
        }
        temp.isEndOfWord = true;
    }

    public boolean search(String word) {
       char[] arr = word.toCharArray();
        TrieNode temp = trie;
        for(int i=0;i<arr.length;i++) {
            if(!temp.children.containsKey(arr[i])) return false;
            temp = temp.children.get(arr[i]);
        }
        return temp.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        TrieNode temp = trie;
        for(int i=0;i<arr.length;i++) {
            if(!temp.children.containsKey(arr[i])) return false;
            temp = temp.children.get(arr[i]);
        }
        return true;
    }
}
