/*
 ? Problem: 01 Matrix
 * Time Complexity : O(m*n)
 * Space Complexity : O(m*n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <vector>
#include <queue>

class Solution {
public:
    std::vector<std::vector<int>> updateMatrix(std::vector<std::vector<int>>& mat) {
        std::queue<std::pair<int, int>> q; // row, column
        int n = mat.size();
        int m = mat[0].size();
        std::vector<std::pair<int, int>> dirs = {{1,0}, {0,1}, {0,-1}, {-1, 0}};
        std::vector<std::vector<int>> distance(n, std::vector<int>(m, -1));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.push({i, j});
                    distance[i][j] = 0;
                }
            }
        }

        while (!q.empty()) {
            auto [r, c] = q.front();
            q.pop();

            for (auto [dr, dc] : dirs) {
                int nr = dr + r;
                int nc = dc + c;
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && distance[nr][nc] == -1) {
                    q.push({nr, nc});
                    distance[nr][nc] = distance[r][c] + 1;
                }
            }
        }

        return distance;
    }
};