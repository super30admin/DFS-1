// Time Complexity :O(N) bfs or dfs
// Space Complexity : O(N) queue or system stack size 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Flood Fill 

#include<vector>
#include<iostream>
#include<queue>
using namespace std;

//DFS

class Solution {
    int dirs[4][2] = {{-1,0}, {1,0}, {0,1}, {0,-1}}; // L-R-U-D
    int color;  // to keep the original color of the source node
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        
        if(image[sr][sc] == newColor)
            return image;
        
        color = image[sr][sc];  // stores the original color
        dfs(image, sr, sc, newColor);
        return image;
    }
    
    void dfs(vector<vector<int>>& image, int r, int c, int newColor){
        
        // base
        if(r < 0 || c < 0 || r == image.size() || c == image[0].size() || image[r][c] != color)
            return;
        
        // logic
        image[r][c] = newColor;
        for(auto dir : dirs){
            int i = r + dir[0];
            int j = c + dir[1];
            dfs(image, i, j, newColor);
        }
    }
};

// BFS

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        
        if(image.empty() || image[sr][sc] == newColor)
            return image;
        
        int color = image[sr][sc];   // store original color
            
        queue<vector<int>> q1;
        int dirs[4][2] = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        
        image[sr][sc] = newColor; // mark this as visited 
        
            q1.push({sr, sc});  // push first element in queue
        
        while(!q1.empty()){
            
            vector<int> curr = q1.front();  // curr has row and col index
            q1.pop();
            
            for(auto dir : dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                
                if(r < image.size() && c < image[0].size() && r >= 0 && c >=0 && image[r][c] == color){  // check boundary and original color
                    image[r][c] = newColor; // mark visited and push in queue 
                    q1.push({r,c});
                }
            }
        }
        
        return image;
    }
};