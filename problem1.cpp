// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
public:
    void dfs(vector<vector<int>>& image,int i,int j,int color,int paint)
    {
        if(i<0 || j<0)
            return;
        if(i>=image.size() || j>=image[0].size())
            return;
        if(image[i][j]!=color)
        {
            return;
        }
        image[i][j]=paint;
        dfs(image,i+1,j,color,paint);
        dfs(image,i-1,j,color,paint);
        dfs(image,i,j+1,color,paint);
        dfs(image,i,j-1,color,paint);
    }
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image.size() && image[sr][sc]!=newColor)
        {
            dfs(image,sr,sc,image[sr][sc],newColor);
        }
        return image;
    }
};