import java.util.HashMap;
import java.util.Map;

class Trie {

    Map<Character, Trie> children;
    boolean isEndOfWord;
    int wordCount;

    Trie() {
        children = new HashMap<>();
    }

    // wrapper (allows the user to call this functionality)
    public void addWord(String word) {		// cab, cat
        addWord(word, 0); // cab,0		cat,0
    }

    public boolean contains(String word) {
        return contains(word, 0);
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix, 0);
    }

    public int getWordCount(String prefix) {
        return getWordCount(prefix, 0);
    }

    private int getWordCount(String prefix, int index) {
        if (index == prefix.length()) {
            return wordCount;
        }

        char letter = prefix.charAt(index);
        Trie child = children.get(letter);
        if (child == null) {
            return 0;
        }

        return child.getWordCount(prefix, index + 1);
    }

    private boolean startsWith(String prefix, int index) {
        if (index == prefix.length()) {
            return true;
        }

        char letter = prefix.charAt(index);
        Trie child = children.get(letter);
        if (child == null) {
            return false;
        }

        return child.startsWith(prefix, index + 1);
    }

    private boolean contains(String word, int index) {
        if (index == word.length()) {
            return isEndOfWord;
        }

        char letter = word.charAt(index);
        Trie child = children.get(letter);
        if (child == null) {
            return false;
        }
        return child.contains(word, index + 1);
    }

    // dfs
	/*
		children={}
		c,0
		a,1
		b,2

		--
		children={c, {}}	children(c)={a, {}} 	children(a)={b, {} | t, {}}

	*/
    private void addWord(String word, int index) { // cab, 0, 1, 2, 3 		|	cat, 0, 1, 2, 3
        wordCount++;

        if (index == word.length()) {
            isEndOfWord = true;
            return;
        }

        char letter = word.charAt(index); // 0,c 	1,a 	2,b 		|	c, a, t
        Trie child = children.get(letter);
        if (child == null) {
            child = new Trie();
            children.put(letter, child); // children={c, {}}	children(c)={a, {}} 	children(a)={b, {}}
        }

        // recurse
        child.addWord(word, index + 1);
    }

    static void main() {
        Trie trie = new Trie();
        trie.addWord("cab");
        trie.addWord("cat");
        trie.addWord("car");
        trie.addWord("bob");
        trie.addWord("chat");
        System.out.println(trie.contains("cat")); // true
        System.out.println(trie.contains("cot")); // false
        System.out.println(trie.contains("ca")); // false

        System.out.println(trie.startsWith("ca")); // true
        System.out.println(trie.startsWith("cat")); // true
        System.out.println(trie.startsWith("catalin")); // false

        System.out.println(trie.getWordCount("ca")); // 3
        System.out.println(trie.getWordCount("cat")); // 1
        System.out.println(trie.getWordCount("catalin")); // 0
    }
}