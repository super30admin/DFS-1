// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;

        int color = image[sr][sc];
        dfs(image, sr, sc, newColor, color);

        return image;
    }

private:
    void dfs(vector<vector<int>>& image, int sr, int sc, int newColor, int color) {
        // Base case
        if (sr < 0 || sr >= image.size() || sc < 0 || sc >= image[0].size() || image[sr][sc] != color)
            return;

        // Logic
        image[sr][sc] = newColor;

        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (const auto& dir : dirs) {
            int r = sr + dir[0];
            int c = sc + dir[1];
            dfs(image, r, c, newColor, color);
        }
    }
};