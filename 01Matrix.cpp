// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

#include <iostream>
#include <stack>
class Solution {
public:
     vector<vector<int>> directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int m = mat.size(), n = mat[0].size();
        queue<pair<int, int>> q;
        for (int r = 0; r < m; ++r)
            for (int c = 0; c < n; ++c)
                if (mat[r][c] == 0) q.push({r, c});
                else mat[r][c] = -1; // Marked as not processed yet!

        while (!q.empty()) {
            auto [r, c] = q.front(); q.pop();
            for (int i = 0; i < 4; ++i) {
                int nr = r + directions[i][0], nc = c + directions[i][1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1) continue;
                mat[nr][nc] = mat[r][c] + 1;
                q.push({nr, nc});
            }
        }
        return mat;
    }
};