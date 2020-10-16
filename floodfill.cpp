// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newC) 
    {
        int originalColor = image[sr][sc];
                
        if(image[sr][sc] != newC)
        {
            dfs_helper(sr, sc, image, originalColor, newC);
        }
        
        return image;
        
        
    }
    
    void dfs_helper(int i, int j , vector<vector<int>>& image, int oldColor, int newColor)
    {
        if(i < 0 or i >= image.size() or j < 0 or j >= image[0].size())
        {
            return;
        }
        if(image[i][j] != oldColor)
        {
            return;
        }
        
        image[i][j] = newColor;
        dfs_helper(i+1, j, image, oldColor, newColor);
        dfs_helper(i, j+1, image, oldColor, newColor);
        dfs_helper(i-1, j, image, oldColor, newColor);
        dfs_helper(i, j-1, image, oldColor, newColor);
    }
    
    
};