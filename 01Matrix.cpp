// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
/* BFS Approach :- 
 *  Update the value 1 in given i/p matrix to -1 to indicate unvisited cell.
 *  Start BFS operation by inserting all the 0 cell value index to queue.
 *  While performing BFS operation:- check the neighbors of current cell, if it's within bounds of input array and value is -1.
 *  Then insert the neighboring cell index in BFS queue and change the neighboring cell value to current cell value + 1.
 */

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        queue<pair<int, int>> q;
        vector<vector<int>> dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        
        int m = mat.size();
        int n = mat[0].size();
        
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (mat[i][j] == 0)
                    q.push({i, j});
                else
                    mat[i][j] *= -1;
            }
        }
        
        int i, j, new_i, new_j;
        
        while (!q.empty())
        {
            i = q.front().first;
            j = q.front().second;
            
            q.pop();
            
            for (int k = 0; k < dir.size(); k++)
            {
                new_i = i + dir[k][0];
                new_j = j + dir[k][1];
                
                if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && mat[new_i][new_j] < 0)
                {
                    q.push({new_i, new_j});
                    mat[new_i][new_j] = mat[i][j] + 1;
                }
            }
        }
        
        return mat;
    }
};