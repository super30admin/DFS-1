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
        
        // set to track visited to help when old and newcolor are same 
        set<pair<int, int>> visited;

        int m=image.size(), n=image[0].size();
        int oldColor = image[sr][sc];
        vector<vector<int>> dirs {{1,0},{-1,0},{0,1},{0,-1}};
        q.push({sr,sc});
        while(!q.empty()){
            auto curr = q.front(); q.pop();
            image[curr.first][curr.second] = newColor;
            visited.insert({curr.first, curr.second});
            for(auto dir: dirs){
                int r = curr.first+dir[0];
                int c = curr.second+dir[1];
                if(r>=0 && r<m && c>=0 && c<n && image[r][c] == oldColor && visited.find({r,c}) == visited.end()){
                    // image[r][c] = newColor;
                    q.push({r,c});
                }
            }
        }
        return image;
    }
};