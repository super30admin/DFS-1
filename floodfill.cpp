// Time Complexity :O(N) where n is the size of pixels in the image
// Space Complexity : O(N)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int dirs[4][2] = {{-1,0},{1,0},{0,1},{0,-1}};
    int color;
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        queue<pair<int,int>> q;
        q.push({sr,sc});
        int color = image[sr][sc];
        if(color == newColor) return image;
        else image[sr][sc] = newColor;
        //else image[sr][sc] =
        pair<int,int> curr;
        while(!q.empty()){
            curr = q.front();
            q.pop();
            for(auto dir:dirs){
                int r = curr.first + dir[0];
                int c = curr.second + dir[1];
                if(r >=0 && c>=0 && r < image.size() && c < image[0].size() && image[r][c] == color){
                    image[r][c] = newColor;
                    q.push({r,c});
                }    
            }
        }
        return image;
    }
    
};