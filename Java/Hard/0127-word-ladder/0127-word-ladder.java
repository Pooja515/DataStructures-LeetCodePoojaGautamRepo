class Pair {
    String word;
    int steps;
    
    Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        // Creating a queue for BFS storing object of Pair (word, steps)
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        // Push all values of wordList into a set for efficient O(1) lookups and deletions
        Set<String> st = new HashSet<>();
        for (String word : wordList) {
            st.add(word);
        }
        
        // Remove the starting word from the set if it exists to prevent visiting it again
        st.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.peek().word;
            int steps = q.peek().steps;
            q.remove();

            // If the target word is reached, return the number of steps taken
            if (word.equals(endWord)) {
                return steps;
            }

            // Try replacing every character of the current word from 'a' to 'z'
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    // If the newly formed word exists in the set, push it to the queue
                    if (st.contains(replacedWord)) {
                        st.remove(replacedWord); // Act as marking it visited
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        
        // Return 0 if no transformation sequence is possible
        return 0;
    }
}