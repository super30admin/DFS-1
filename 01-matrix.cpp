// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : yes

#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    int m;
    int n;

public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        m = matrix.size();

        // Edge case
        if (matrix.empty() || m == 0)
            return matrix;

        n = matrix[0].size();

        vector<vector<int>> result(m, vector<int>(n, 0));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = dfs(matrix, result, i, j);
            }
        }

        return result;
    }

private:
    int dfs(const vector<vector<int>>& matrix, vector<vector<int>>& result, int i, int j) {
        // Base case
        if (i < 0 || i >= m || j < 0 || j >= n)
            return 9999;

        if (matrix[i][j] == 0)
            return 0;

        if (i > 0 && matrix[i - 1][j] == 0)
            return 1;

        if (j > 0 && matrix[i][j - 1] == 0)
            return 1;

        if (i < m - 1 && matrix[i + 1][j] == 0)
            return 1;

        if (j < n - 1 && matrix[i][j + 1] == 0)
            return 1;

        // No neighboring zero
        int top, left, right, bottom;
        top = left = 9999; // Declare them as infinity

        if (i > 0 && result[i - 1][j] != 0) {
            top = result[i - 1][j];
        }

        if (j > 0 && result[i][j - 1] != 0) {
            left = result[i][j - 1];
        }

        bottom = dfs(matrix, result, i + 1, j);
        right = dfs(matrix, result, i, j + 1);

        return min(min(left, right), min(top, bottom)) + 1;
    }
};
