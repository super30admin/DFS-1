//Time Complexity: O(m*n)
//Space Complexity: O(m*n)

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        vector<vector<int>> dist(mat.size(), vector<int>(mat[0].size(), INT_MAX));
        deque<vector<int>> q;

        for(int i = 0; i < mat.size(); i++) {
            for(int j = 0; j < mat[0].size(); j++) {
                if(mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.push_back({i,j});
                }
            }
        }

        int dir[4][2] = { {-1,0}, {1,0}, {0, -1}, {0,1} };
        
        while(!q.empty()) {
            int r = q.front()[0];
            int c = q.front()[1];
            q.pop_front(); 
            
            for(int i = 0; i < 4; i++) {
                int new_row = r + dir[i][0];
                int new_col = c + dir[i][1];
                if(new_row >= 0 && new_row < mat.size() && new_col >= 0 && new_col < mat[0].size()) {
                    if(dist[new_row][new_col] > dist[r][c]+1) {
                        dist[new_row][new_col] = dist[r][c]+1; 
                        q.push_back({new_row, new_col});
                    }
                }
            }
        }


        return dist;    
    }
};