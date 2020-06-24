package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Apartment_Hunting {

	public static void main(String[] args) {
		List<Map<String, Boolean>> blocks = new ArrayList<>();
		Map<String, Boolean> block1 = new HashMap<String, Boolean>();
		block1.put("gym", false);
		block1.put("school", true);
		block1.put("store", false);

		Map<String, Boolean> block2 = new HashMap<String, Boolean>();
		block2.put("gym", true);
		block2.put("school", false);
		block2.put("store", false);

		Map<String, Boolean> block3 = new HashMap<String, Boolean>();
		block3.put("gym", true);
		block3.put("school", true);
		block3.put("store", false);

		Map<String, Boolean> block4 = new HashMap<String, Boolean>();
		block4.put("gym", false);
		block4.put("school", true);
		block4.put("store", false);

		Map<String, Boolean> block5 = new HashMap<String, Boolean>();
		block5.put("gym", false);
		block5.put("school", true);
		block5.put("store", true);

		blocks.add(block1);
		blocks.add(block2);
		blocks.add(block3);
		blocks.add(block4);
		blocks.add(block5);

		String[] reqs = new String[] { "gym", "school", "store" };

		System.out.println(apartmentHunting1(blocks, reqs));
	}

//	O(b^2 * r) time | O(1) space
	public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
		int minMaxDist = Integer.MAX_VALUE;
		int minDistIdx = -1;
		for (int i = 0; i < blocks.size(); i++) {
			int maxTravelledDist = Integer.MIN_VALUE;
			for (String req : reqs) {
				int closestReqDist = Integer.MAX_VALUE;
				for (int j = 0; j < blocks.size(); j++) {
					if (blocks.get(j).get(req))
						closestReqDist = Math.min(closestReqDist, Math.abs(i - j));
				}
				maxTravelledDist = Math.max(closestReqDist, maxTravelledDist);
			}
			if (maxTravelledDist < minMaxDist) {
				minMaxDist = maxTravelledDist;
				minDistIdx = i;
			}
		}
		return minDistIdx;
	}

	
//	O(b*r) time | O(b*r) space
	public static int apartmentHunting1(List<Map<String, Boolean>> blocks, String[] reqs) {
		int[][] closestReqDist = new int[reqs.length][];

		for (int i = 0; i < reqs.length; i++) {
			closestReqDist[i] = getMinReqDist(blocks, reqs[i]);
		}
		
		return getMinMaxDistIdx(closestReqDist);
	}

	private static int getMinMaxDistIdx(int[][] closestReqDist) {
		int minMaxDistIdx = -1;
		int minMaxDist = Integer.MAX_VALUE;
		for(int i = 0; i<closestReqDist[0].length; i++) {
			int maxDistTravelled = Integer.MIN_VALUE;
			for(int j = 0; j<closestReqDist.length; j++) {
				maxDistTravelled = Math.max(maxDistTravelled, closestReqDist[j][i]);
			}
			if(maxDistTravelled < minMaxDist) {
				minMaxDist = maxDistTravelled;
				minMaxDistIdx = i;
			}
		}
		return minMaxDistIdx;
	}

	public static int[] getMinReqDist(List<Map<String, Boolean>> blocks, String req) {
		int[] minDist = new int[blocks.size()];

		int closestReqIdx = Integer.MAX_VALUE;

		// Iterate from left to right. Closest Distance from left to right.
		for (int i = 0; i < blocks.size(); i++) {
			if (blocks.get(i).get(req))
				closestReqIdx = i;
			minDist[i] = (closestReqIdx == Integer.MAX_VALUE) ? closestReqIdx : i - closestReqIdx;
		}
		
		// Iterate from right to left. Closest Distance.
		for (int i = blocks.size() - 1; i >= 0; i--) {
			if(blocks.get(i).get(req)) closestReqIdx = i;
			minDist[i] = Math.min(minDist[i], Math.abs(closestReqIdx-i));
		}
		
		return minDist;
	}

}
