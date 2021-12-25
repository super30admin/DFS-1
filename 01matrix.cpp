//Time complexity : O(m * n)
//Space complexity : O(m * n)

//Approach: 
            // Start bfs with all the 0s
            // At every level, change the value of 1 to current level + 1
            // Return the matrix

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        if(mat.size() == 0 || mat[0].size() == 0)
            return mat;
        
        int m = mat.size();
        int n = mat[0].size();
        
        vector<vector<int>> dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        queue<vector<int>> q;
        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(mat[i][j] == 0)
                {
                    q.push({i,j});
                }
                else if(mat[i][j] == 1)
                {
                    mat[i][j] = -1;
                }
            }
        }
        
        while(!q.empty())
        {
            vector<int> curr = q.front();
            q.pop();
            
            for(auto dir : dirs)
            {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1)
                {
                    mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                    q.push({nr,nc});
                }
            }
        }
        return mat;
    }
};