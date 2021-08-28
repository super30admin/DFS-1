// Time Complexity : O(M*N) where M represents the no.of rows and N represents the no.of columns
// Space Complexity : O(M*N) where M represents the no.of rows and N represents the no.of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/01-matrix/
// Submission Link: https://leetcode.com/submissions/detail/544254629/

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        vector<int> rows = {0, -1, 0, 1};
        vector<int> cols = {-1, 0, 1, 0};
        
        int row_size = mat.size();
        int col_size = mat[0].size();
        
        vector<vector<int> > visited(mat.size());
        queue<pair<int, pair<int, int> > > q;
        pair<int, int> temp;
    
        
        for(int i = 0; i < row_size; i++){
            visited[i] = vector<int>(col_size, 0);
            for(int j = 0; j < col_size; j++){
                if(mat[i][j] == 0){
                    temp = make_pair(i, j);
                    q.push(make_pair(0, temp));
                    visited[i][j] = 1;
                }
            }
        }
        
        int x, y, moves;
        
        while(!q.empty()){
            x = q.front().second.first;
            y = q.front().second.second;
            moves = q.front().first;
            q.pop();
            
            for(int i = 0; i < 4; i++){
                if(x + rows[i] >= 0 && x + rows[i] < row_size &&
                   y + cols[i] >= 0 && y + cols[i] < col_size && 
                   visited[x + rows[i]][y + cols[i]] == 0){
                    q.push(make_pair(moves + 1, make_pair(x + rows[i], y + cols[i])));
                    visited[x + rows[i]][y + cols[i]] = 1;
                    mat[x + rows[i]][y + cols[i]] = moves + 1;
                }
            }
        }
        return mat;
    }
};