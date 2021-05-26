/*
Time complexity - O(MN)
Space complexity - O(MN)
*/
class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        if (mat.size() == 0 || mat[0].size() == 0) return mat;
        int rows = mat.size(), cols = mat[0].size();
        vector<vector<int>> dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        queue<vector<int>> q;
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < cols; ++j){
                if (mat[i][j] == 0) q.push({i,j});
                else mat[i][j] = -1;
            }
        }
        int dist = 1;
        while (!q.empty()){
            int cnt = q.size();
            while (cnt-- > 0){                
                vector<int> temp = q.front(); q.pop();
                for (auto dir:dirs){
                    int r = temp[0] + dir[0];
                    int c = temp[1] + dir[1];
                    if (r >= 0 && c >= 0 && r < rows && c < cols && mat[r][c] == -1){
                        mat[r][c] = dist;
                        q.push({r,c});
                    }
                }
            }
            ++dist;
        }
        return mat;
    }
};