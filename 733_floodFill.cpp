// Time Complexity : O(M*N)
// Space Complexity :O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//BFS
class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image.empty() || image.size() == 0 || newColor == image[sr][sc])
            return image;
        int m = image.size();
        int n = image[0].size();
        queue<vector<int>> q;
        q.push({sr,sc});
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        vector<vector<int>> dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!q.empty()){
            vector<int> val = q.front();
            q.pop();
            for(vector<int> dir: dirs){
                int r = dir[0] + val[0];
                int c = dir[1] + val[1];
                if(r>=0 && r<m && c>=0 && c<n && image[r][c] == color){
                    q.push({r,c});
                    image[r][c] = newColor;
                }
            }
        }
        return image;
    }
};


// Time Complexity : O(M*N)
// Space Complexity :O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//DFS
class Solution {
public:
    int m, n, color;
    vector<vector<int>> dirs;
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image.empty() || image.size() == 0 || newColor == image[sr][sc])
            return image;
        m = image.size();
        n = image[0].size();
        color = image[sr][sc];
        dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        dfs(image, sr, sc, newColor);
        return image;
    }
    void dfs(vector<vector<int>>& image, int r, int c, int newColor){
        //base
        if(r<0 || r>=m || c<0 || c>=n || image[r][c] != color){
            return;
        }
        //logic
        image[r][c] = newColor;
        for(vector<int> dir: dirs){
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            dfs(image, nr, nc, newColor);
        }
        
    }
};
