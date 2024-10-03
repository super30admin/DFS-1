//tc : O(n*m) sc : O(n*m)

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        queue<pair<int,int>> q;
        for(int i=0;i<mat.size();i++) {
            for(int j=0;j<mat[0].size();j++) {
                if(mat[i][j] == 0) {
                    q.push({i,j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        
        vector<vector<int>> dir = {{-1,0}, {0,-1}, {1,0}, {0, 1}};
        while(!q.empty()) {
            pair<int,int> front = q.front();
            q.pop();
            
            for(auto &d : dir) {
                int newRow = front.first + d[0];
                int newCol = front.second + d[1];
                if(newRow >= 0 && newCol >= 0 && newRow < mat.size() && newCol < mat[0].size() && mat[newRow][newCol] == -1) {
                    mat[newRow][newCol] = mat[front.first][front.second]+1;
                    q.push({newRow, newCol});
                }
            }
        }
        
        return mat;
    }
};