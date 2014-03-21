package uncategorized;
/*
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

   Only one letter can be changed at a time
   Each intermediate word must exist in the dictionary
   For example,

	Given:
	start = "hit"
	end = "cog"
	dict = ["hot","dot","dog","lot","log"]
	As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	return its length 5.
	
	Note:
	Return 0 if there is no such transformation sequence.
	All words have the same length.
	All words contain only lowercase alphabetic characters.
 * */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadderI {
	public int ladderLength(String start, String end, HashSet<String> dict) {
        int distance = 0;
        int count = 0;
        dict.add(start);
        dict.add(end);
        HashSet<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        HashMap<String, ArrayList<String>> nextMap = new HashMap<String, ArrayList<String>>();
        for (String s : dict) {
        	nextMap.put(s, new ArrayList<String>());
        }
        getAllAdj(nextMap, dict);
        visited.add(start);
        queue.add(start);
        count++;
        // BFS to solve this problem
        // Use two times count here
        while (count > 0) {
        	// this while is for just one level
        	while (count > 0) {
        		String word = queue.remove();
        		count--;
        		ArrayList<String> nextWords = nextMap.get(word);
        		for (int i = 0; i < nextWords.size(); ++i) {
        			String nextWord = nextWords.get(i);
        			if (nextWord.equals(end)) {
        				
        				return distance+2;
        			}
        			if (!visited.contains(nextWord)) {
        				visited.add(nextWord);
        				queue.add(nextWord);
        			}
        		}
        	}
        	distance++;
        	count = queue.size(); // Be careful
        }
        return 0;
    }
	
	private void getAllAdj(HashMap<String, ArrayList<String>> nextMap, HashSet<String> dict) {
		for (String word : dict) {
			for (int i = 0; i < word.length(); ++i) {
				char c = word.charAt(i);
				for (char j = 'a'; j < 'z'; ++j) {
					if (c != j) {
						StringBuilder sb = new StringBuilder(word);
						sb.setCharAt(i, j);
						String nextWord = sb.toString();
						if (dict.contains(nextWord)) {
							nextMap.get(word).add(nextWord);
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadderI w = new WordLadderI();
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(w.ladderLength("hit", "loy", dict));
	}

}
