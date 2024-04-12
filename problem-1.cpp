// 733. Flood Fill
// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        vector<vector<int>> dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int m = image.size(), n = image[0].size(), nr, nc;
        if(image[sr][sc] == color)
            return image;
        int nw = image[sr][sc];
        image[sr][sc] = color;
        queue<int> q;
        q.push(sr);
        q.push(sc);
        while(!q.empty())
        {
            sr = q.front();
            q.pop();
            sc = q.front();
            q.pop();
            for(int i = 0; i < 4; i++)
            {
                nr = sr + dirs[i][0];
                nc = sc + dirs[i][1];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n)
                {
                    if(image[nr][nc] == nw)
                    {
                        image[nr][nc] = color;
                        q.push(nr);
                        q.push(nc);
                    }
                }
            }
        }
        return image;

    }
};
