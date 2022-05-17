// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
/* DFS Approach: Store the color value of starting cell and new color value. 
 * Call the DFS operation on the given starting cell. 
 *  In DFS method, replace the current cell value to new color value. And check the neighboring cells, 
 *  if cell is within the bounds of given input matrix and cell value is same as starting cell color then call the DFS method by passing
 *  the neghboring cell index and new color. 
 * 
 */

class Solution {
public:
    vector<vector<int>> dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m, n;
    int color;
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        m = image.size();
        n = image[0].size();
        color = image[sr][sc];
        helper(image, sr, sc, newColor);
        return image;
    }
    
    void helper(vector<vector<int>>& image, int sr, int sc, int newColor)
    {
          image[sr][sc] = newColor;
            
            for (auto itr : dir)
            {
                int new_sr = sr + itr[0];
                int new_sc = sc + itr[1];
                
                if (new_sr >= 0 && new_sr < m && new_sc >= 0 && new_sc < n && image[new_sr][new_sc] == color
                   && image[new_sr][new_sc] != newColor)
                helper(image, new_sr, new_sc, newColor);
            }
    }
};