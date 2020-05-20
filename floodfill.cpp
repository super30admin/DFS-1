// Time Complexity : O(n); n is total number of pixels
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. BFS. Place the start pixel in the queue, change its color and mark as visited 
// 2. Iterate in all four directions, check if pixel is valid and change color

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image.size()==0)
            return image;
        queue<pair<int,int>> q;

        int m=image.size(), n=image[0].size();
        int oldColor = image[sr][sc];
        vector<vector<int>> dirs {{1,0},{-1,0},{0,1},{0,-1}};
        q.push({sr,sc});
        image[sr][sc] = newColor;
        while(!q.empty()){
            auto curr = q.front(); q.pop();
            for(auto dir: dirs){
                int r = curr.first+dir[0];
                int c = curr.second+dir[1];
                if(r>=0 && r<m && c>=0 && c<n && image[r][c] == oldColor){
                    image[r][c] = newColor;
                    q.push({r,c});
                }
            }
        }
        return image;
    }
};

// DFS
// Time Complexity : O(n); n is total number of pixels
// Space Complexity : O(n); worst case when all pixels are 1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. DFS. Recurse in all four directions
// 2. Base case is when cell is out of image or does not have old color

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(image.size()==0 || oldColor==newColor)
            return image;
        dfs(image, sr, sc, newColor, oldColor);
        return image;
    }
    
    void dfs(vector<vector<int>>& image, int sr, int sc, int newColor, int oldColor){
        int m=image.size(), n=image[0].size();
        vector<vector<int>> dirs {{1,0},{-1,0},{0,1},{0,-1}};
        // base
        if(sr<0 || sr>=m || sc<0 || sc>=n || image[sr][sc] != oldColor)
            return;
        // logic   
        image[sr][sc] = newColor;
        for(auto dir: dirs){
            int r = sr+dir[0];
            int c = sc+dir[1];
            dfs(image, r, c, newColor, oldColor);
        }   
    }
};
