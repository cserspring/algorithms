package uncategorized;

import java.util.ArrayList;

public class TextJustification {
	private ArrayList<String> res;
	public ArrayList<String> fullJustify(String[] words, int L) {
		res = new ArrayList<String>();
		int start = 0;
		int len = 0;
		int i = 0;
        for (; i < words.length; ++i) {
        	if ((words[i].length() + ((i - start) != 0 ? 1 : 0) + len) > L) {
        		connect(words, start, i-1, len, L, false);
        		len = 0;
        		start = i;
        	}
        	len += words[i].length() + ((i - start) != 0 ? 1 : 0);
        }
        connect(words, start, i-1,len,L, true);
        return this.res;
    }
	
	private void connect(String[] words, int start, int end, int len, int L, boolean lastLine) {
		if (lastLine) {
			String str = words[start];
			L = L-words[start].length();
			for (int i = start+1;i<=end;++i) {
				str += " " + words[i];
				L = L-words[i].length()-1;
			}
			for (int i = 0; i < L; ++i)
				str+=" ";
			res.add(str);
		} else {
			String str = words[start];
			int n = end - start;
			int numSpaces = L - len;
			if (n==0) {
				for (int i = 0; i < numSpaces; ++i)
					str += " ";
				res.add(str);
				return;
			}
			int base = numSpaces/n;
			int rem = numSpaces%n;
			for (int i = start+1; i <= end; ++i) {
				str += (rem-- > 0 ? " ":"");
				for (int j = 0; j < base; ++j)
					str += " ";
				str += " " + words[i];
			}
			res.add(str);
		}
	}
	
	public static void main(String[] args) {
		//String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		String[] words = {"a","b","c","d","e"};
		TextJustification t = new TextJustification();
		System.out.println(t.fullJustify(words, 3));
	}

}
