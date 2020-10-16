// Time Complexity : O(N x M)
// Space Complexity : O(M x N) -> queue max size 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 
class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) 
    {
        int nrows = matrix.size();
        int ncols = matrix[0].size();
        queue<pair<int, int>> queue;
        vector<pair<int, int>> dirs {{0, 1}, {1, 0}, {-1, 0}, {0,-1}};
        
        
        for(int i = 0; i < nrows; i++)
        {
            for(int j = 0; j < ncols; j++)
            {
                if(matrix[i][j] == 0)
                {
                    queue.push(make_pair(i, j));
                }
                else if(matrix[i][j] == 1)
                {
                    matrix[i][j] = INT_MAX;
                }
            }
        }
        
        while(!queue.empty())
        {
            pair<int, int> curr = queue.front();
            queue.pop();
            int curr_x = curr.first;
            int curr_y = curr.second;
            for(auto d : dirs)
            {
                int new_x = curr_x + d.first;
                int new_y = curr_y + d.second;
                if(isValid(new_x, new_y, matrix) and matrix[new_x][new_y] > matrix[curr_x][curr_y] + 1)
                {
                    matrix[new_x][new_y] = matrix[curr_x][curr_y] + 1;
                    queue.push(make_pair(new_x, new_y));
                    
                }
            }
            
        }
        
        return matrix;
        
    }
    
    bool isValid(int i, int j, vector<vector<int>>& matrix)
    {
        int nrows = matrix.size();
        int ncols = matrix[0].size();
        if(i >= 0 and i < nrows and j >= 0 and j < ncols and matrix[i][j] != 0)
        {
            return true;
        }
        
        return false;
    }
};