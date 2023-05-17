// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// there are connected components, so we do dfs/bfs.
// in this case, as the starting point is given we can get optimal soln with both dfs and bfs.
// start dfs with given cell and change color by traversing in four directions.

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        if(image.empty() || image.size()==0 || image[sr][sc] == color) return image;
        int originalcolor = image[sr][sc];
        vector<pair<int,int>>dir = {{-1,0},{1,0},{0,-1},{0,1}}; // U D L R
        dfs(image,sr,sc,color,originalcolor,dir);
        return image;
    }
    void dfs(vector<vector<int>>& image, int sr, int sc, int color,int originalcolor,vector<pair<int,int>>&dir)
    {
        //base

        //logic
        image[sr][sc] = color;
        for(auto d: dir)
        {
            int nr = sr + d.first;
            int nc = sc + d.second;
            if(nr>=0 && nr< image.size() && nc>=0 && nc<image[0].size() &&image[nr][nc] == originalcolor){
                dfs(image,nr,nc,color,originalcolor,dir);
            }
        }
        
    }
};