// Time complexity O(m*n)
// Space complexity O(m*n)

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> ret(m, vector<int>(n, -1));

        queue<pair<int, int>> que;
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (mat[r][c] == 0) {
                    que.push({r, c});
                    ret[r][c] = 0;
                }
            }
        }

        vector<pair<int, int>> dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int distance = 0;
        while (!que.empty()) {
            int size = que.size();
            for (int i=0; i<size; i++) {
                auto [r, c] = que.front();
                que.pop();

                for (auto [dr, dc] : dirs) {
                    int nr = r+dr;
                    int nc = c+dc;

                    if (nr >=0 && nr<m && nc>=0 && nc<n && ret[nr][nc] == -1) {
                        que.push({nr, nc});
                        ret[nr][nc] = distance+1;
                    }
                }
            }
            distance++;
        }

        return ret;
    }
};