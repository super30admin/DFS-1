// Time complexity is O(m*n) - m = #rows; n = #columns
// Space complexity is O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        if(matrix.size() == 0) return {};
        queue<vector<int>> q;
        int rows = matrix.size();
        int columns = matrix[0].size();
        int dist = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(matrix[i][j] == 0) {
                    vector<int> temp = {{i,j}};
                    q.push(temp);
                }
                else {
                    matrix[i][j] = -1;
                }
            }
        }
        vector<vector<int>> directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        while(!q.empty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                vector<int> currCell = q.front();
                q.pop();
                for(auto dir : directions) {
                    int neighborRow = currCell[0] + dir[0];
                    int neighborCol = currCell[1] + dir[1];
                    if(neighborRow >= 0 && neighborRow < rows
                       && neighborCol >= 0 && neighborCol < columns
                       && matrix[neighborRow][neighborCol] == -1) {
                        matrix[neighborRow][neighborCol] = dist;
                        vector<int> temp = {{neighborRow,neighborCol}};
                        q.push(temp);
                    }
                }
            }
            dist++;
        }
        
        return matrix;
    }
};
