// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//Implemented using BFS

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {

        if(image.size()==0){
            return image;
        }
        queue<pair<int,int>> q;
        int m=image.size();
        int n=image[0].size();
        vector<pair<int,int>> dirs{pair(0,-1),pair(0,1),pair(-1,0),pair(1,0)};
        int oldcolor = image[sr][sc];
        if(image[sr][sc] != newColor){
            q.push(make_pair(sr,sc));
        }

        while(!q.empty()){
                int r=q.front().first;
                int c=q.front().second;
                q.pop();
                image[r][c] = newColor;
                for(auto it:dirs){
                    int nr = r + it.first;
                    int nc = c + it.second;
                    if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc] == oldcolor){
                        image[nr][nc] = newColor;
                        q.push(make_pair(nr,nc));
                    }
            }
        }
        return image;
    }
};
