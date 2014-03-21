package uncategorized;

import java.util.ArrayList;

public class RestoreIPAddress {
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> res = new ArrayList<String>();
		if (s == null || s.length() < 4 || s.length() > 12)
			return res;
		String oneResult = "";
		restoreIpAddresses(res, s, 0, oneResult);
		return res;
	}

	private void restoreIpAddresses(ArrayList<String> res, String s,
			int position, String oneResult) {
		if (position == 4) {
			if (s.equals("")) {
				res.add(oneResult.substring(0, oneResult.length() - 1));
			}
		} else {
			for (int i = 1; i <= 3; ++i) {
				if (s.length() >= i) {
					int part = Integer.parseInt(s.substring(0, i));
					int remainLen = s.substring(i).length();
					if (part <= 255 && part >= 0
							&& remainLen <= (3 - position) * 3
							&& remainLen >= 3 - position) {
						if (i>1 && (part == 0 || s.substring(0, i).startsWith("0")))
							continue;
						String newResult = oneResult + s.substring(0, i) + ".";
						restoreIpAddresses(res, s.substring(i), position + 1,
								newResult);
					}
				}
			}
		}
	}

	public static void main(String args[]) {
		RestoreIPAddress r = new RestoreIPAddress();
		System.out.println(r.restoreIpAddresses("010010"));
	}
}
