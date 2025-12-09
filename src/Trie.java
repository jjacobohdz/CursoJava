import java.util.HashMap;
import java.util.Map;

class Trie {

    Map<Character, Trie> children;
    boolean isEndOfWord;

    Trie() {
        children = new HashMap<>();
    }

    // wrapper (allows the user to call this functionality)
    public void addWord(String word) {		// cab, cat
        addWord(word, 0); // cab,0		cat,0
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
        System.out.println(trie);
    }
}