// Approach - Brute Force BFS
// Time Complexity - O(m^2*n^2) 
// Space Complexity - O(m*n) - If we reuse the queue at every instance of 1.
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    set<vector<int>> visited;
    vector<vector<int>> dirs; 
    private:
    int bfs(vector<vector<int>>& mat, vector<int> elem, int m, int n, queue<vector<int>> q){
        visited.clear();
        //queue<vector<int>> q;
        q = {};     // This is how you clear a queue in c++(I am basically re-initializing it at every instant);
        q.push(elem);
        visited.insert(elem);
        
        int dist = 0;
        while(!q.empty()){
            int size = q.size();
            dist++;
            for(int i = 0; i < size; i++){
                vector<int> curr = q.front(); q.pop();
                for(vector<int> dir:dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && !visited.count({nr, nc})){
                        if(mat[nr][nc] == 0)
                            return dist; 
                        q.push({nr, nc});
                        visited.insert({nr, nc});
                    }
                }
            }
        }
        return dist;
    }
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        vector<vector<int>> answer(mat);
        int m = mat.size();
        int n = mat[0].size();
        dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        queue<vector<int>> q;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    int dist = bfs(mat, {i, j}, m, n, q);
                    answer[i][j] = dist;
                }
            }
        }
        return answer;
    }
};


// Approach - Optimized BFS(with size variable)
// Time Complexity - O(m*n) 
// Space Complexity - O(m*n)
// Problems Faced - No!
// It runs on leetcode.
class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int m = mat.size();
        int n = mat[0].size();
        queue<vector<int>> q;
        vector<vector<int>> dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0)
                    q.push({i, j});
                else
                    mat[i][j] = -1;
            }
        }
        int dist = 1;
        while(!q.empty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                vector<int> curr = q.front(); q.pop();
                for(vector<int> dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                        mat[nr][nc] = dist;
                        q.push({nr, nc});
                    }
                }
            }
            dist++;
        }
        return mat;
    }
};