// Time Complexity : O(M*N)
// Space Complexity :O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        if(mat.empty() || mat.size() == 0)
            return mat;
        int m = mat.size();
        int n = mat[0].size();
        queue<vector<int>> q;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0)
                    q.push({i,j});
                else
                    mat[i][j] = -1;
            }
        }
        vector<vector<int>> dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int lvl = 1;
        while(!q.empty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                vector<int> curr = q.front();
                q.pop();
                for(vector<int> dir: dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r>=0 && r<m && c>=0 && c<n && mat[r][c] == -1){
                        q.push({r,c});
                        mat[r][c] = lvl;
                    }
                }
            }
            lvl++;
        }
        return mat;
    }
};


class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        if(mat.empty() || mat.size() == 0)
            return mat;
        int m = mat.size();
        int n = mat[0].size();
        queue<vector<int>> q;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0)
                    q.push({i,j});
                else
                    mat[i][j] = -1;
            }
        }
        vector<vector<int>> dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int lvl = 1;
        while(!q.empty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                vector<int> curr = q.front();
                q.pop();
                for(vector<int> dir: dirs){
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r>=0 && r<m && c>=0 && c<n && mat[r][c] == -1){
                        q.push({r,c});
                        mat[r][c] = mat[curr[0]][curr[1]] + 1; // can also be done by adding the previous element distance with curr element distance.
                    }
                }
            }
            lvl++;
        }
        return mat;
    }
};
