class TrieNode {
    char c;
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    TrieNode() {
        children = new HashMap<>();
    }
}
class WordDictionary {
    TrieNode trie;
    public WordDictionary() {
        trie = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = trie;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                TrieNode newNode = new TrieNode();
                newNode.c = c;
                node.children.put(c, newNode);
                node = newNode;
            }
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, trie);
    }

    private boolean dfs(String word, int index, TrieNode currNode) {
        //base case 
        if(index == word.length()) 
            return currNode.isEndOfWord;
        char c = word.charAt(index);
        if(c == '.') {
            for(TrieNode node : currNode.children.values()) {
                if(dfs(word, index+1, node)) 
                    return true;
            }
        } 

        if(!currNode.children.containsKey(c))
            return false;

        return dfs(word, index+1, currNode.children.get(c));
    }
}
