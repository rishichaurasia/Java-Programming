package Backtracking;

import java.util.ArrayList;

// https://leetcode.com/problems/restore-ip-addresses/

import java.util.List;

public class Restore_IP_Addresses {

	public static void main(String[] args) {
//		String ip = "25525511135";
		String ip = "010010";
		System.out.println(restoreIpAddresses(ip));

	}
	
	public static List<String> restoreIpAddresses(String s) {
        List<String> main = new ArrayList<>();
        restoreIpAddesses(s, 0, main, new ArrayList<String>());
        return main;
    }

	private static void restoreIpAddesses(String s, int idx, List<String> main, ArrayList<String> temp) {
		if(temp.size() > 4)
			return;
		if(idx == s.length() && temp.size() == 4) {
			String ipAdd = "";
			for(int i = 0; i<4; i++) {
				ipAdd += temp.get(i);
				if(i<3)
					ipAdd += ".";
			}
			main.add(ipAdd);
			return;
		}
		for(int i = idx; i<s.length() && i<idx+3; i++) {
			String part = s.substring(idx, i+1);
			if(i > idx && part.charAt(0) == '0')
				continue;
			if(Integer.parseInt(part) <= 255) {
				temp.add(part);
				restoreIpAddesses(s, i+1, main, temp);
				temp.remove(temp.size()-1);
			}
		}
	}

}
