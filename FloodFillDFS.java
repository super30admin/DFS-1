// Time Complexity : O(M*N) //all the nodes will be visited
// Space Complexity : O(M*N) //queue will have only one level elements that is max m*n/2 at leaf level.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Find the elements with nr,nc and add it to queue and update value to new
 * color. 2. then traverse and find all the 4 side elements which value is
 * previous value. 3. when adjacent 1 is found mark it to new color as it is
 * already visited and add it to queue. 4. it is BFS approach.
 */

public class FloodFillDFS {

	int actValue;
	int[][] adjArr;

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		actValue = image[sr][sc];

		if (actValue == newColor)
			return image;

		adjArr = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

		dfs(image, sr, sc, newColor);
		return image;
	}

	private void dfs(int[][] image, int sr, int sc, int newColor) {
		if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != actValue)
			return;

		image[sr][sc] = newColor;
		for (int m = 0; m < adjArr.length; m++) {
			int nr = sr + adjArr[m][0];
			int nc = sc + adjArr[m][1];

			dfs(image, nr, nc, newColor);
		}
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 0, 0, 0, }, { 0, 1, 1 } };
		new FloodFillDFS().floodFill(arr, 1, 1, 2);
	}
}
