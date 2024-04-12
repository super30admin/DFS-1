// 542. 01 Matrix
// Time Complexity : m*n
// Space Complexity :m*n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        vector<vector<int>> dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int m = mat.size(), n = mat[0].size();
        vector<vector<int>> matrix(m,vector<int>(n,0));
        queue<int> q;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(mat[i][j] == 0)
                {
                    q.push(i);
                    q.push(j);
                    matrix[i][j] = 1;
                }
            }
        }
        while(!q.empty())
        {
            int r = q.front();
            q.pop();
            int c = q.front();
            q.pop();
            for(int i = 0; i < 4; i++)
            {
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n)
                {
                    if(mat[nr][nc] != 0)
                    {
                        
                        if(matrix[nr][nc] != 1)
                        {
                            mat[nr][nc] = mat[r][c] + 1;
                            q.push(nr);
                            q.push(nc);
                            matrix[nr][nc] = 1;
                        }
                        else
                        {
                            if(mat[r][c] + 1< mat[nr][nc])
                                mat[nr][nc] = mat[r][c] + 1;

                        }
                    }
                }
            }
        }
        return mat;

    }
};
