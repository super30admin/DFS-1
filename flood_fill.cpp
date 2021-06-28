// Time Complexity : O(m+n)
// Space Complexity :  O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int new_color) {
        
        
        int ref_color = image[sr][sc];
        
        int m = image.size();
        int n = image[0].size();
        
        queue<pair<int, int>> q;
        
        int visited[m][n];
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                visited[i][j] = 0;
            }
        }
        
        q.push(pair(sr,sc));

        pair<int, int> temp;
        
        vector<pair<int, int>> dir;
        int i, r, c;
        
        dir.push_back(pair(-1, 0));
        dir.push_back(pair(1, 0));
        dir.push_back(pair(0, -1));
        dir.push_back(pair(0, 1));
    
        while(!q.empty())
        {
            temp = q.front();
            q.pop();
            
            image[temp.first][temp.second] = new_color;
            visited[temp.first][temp.second] = 1;
            
            for(i = 0; i < dir.size(); i++)
            {
                r = temp.first + dir[i].first;
                c = temp.second + dir[i].second;
                
                if(r >= 0 && c >= 0 && r < m && c < n)
                {
                    if(image[r][c] == ref_color && visited[r][c] == 0)
                    {
                        q.push(pair(r,c));
                    }
                }
            }
        }
        
        return image;
    }
};