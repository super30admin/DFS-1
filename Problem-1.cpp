/*
Time Complexity = O(M*N)
Space Complexity =O(M*N)
Where M is the number of rows and N is the number of columns in the matrix.
*/
class Solution {
public:
    int m,n;
    int color;
    void dfs(vector<vector<int>>& image, int r, int c, int newColor)
    {
        //base
        if(r<0 || r>=m || c<0 || c>=n || color!=image[r][c])
            return;
            
        //logic
        image[r][c] = newColor;
        dfs(image, r+0, c+1 , newColor);
        dfs(image, r+1, c+0 , newColor);
        dfs(image, r+0, c-1 , newColor);
        dfs(image, r-1, c+0 , newColor);
    }
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor)
            return image;
        color = image[sr][sc];
        m = image.size();
        n = image[0].size();
        dfs(image, sr, sc, newColor);
        return image;
    }
};
