//Time complexity : O(m * n)
//Space complexity : O(m * n)

//Approach :
            // Get the color of the source pixel
            // Change it to newColor
            // Start checking each neighbour of the source pixel and their neighbours using DFS
            // All the neighbours which have old color of source pixel should be changed to newColor

class Solution {
public:
    int m, n, color;
    vector<vector<int>> dirs;
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image.size() == 0 || image[0].size() == 0 || image[sr][sc] == newColor)
            return image;
        
        dirs = {{ 0 , 1 } , { 0, - 1 }, { 1 , 0 }, { -1 , 0 }};
        
        m = image.size();
        n = image[0].size();
        color = image[sr][sc];
        
        dfs(image, sr , sc, newColor);
        return image;
    }
    
    void dfs(vector<vector<int>>& image, int sr, int sc, int newColor)
    {

        image[sr][sc] = newColor;
        
        for(auto dir : dirs)
        {
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;
            
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == color)
            {
                dfs(image, nr, nc, newColor);
            }
        }
    }
};