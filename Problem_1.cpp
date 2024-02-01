/*
 ? Problem: Flood Fill
 * Time Complexity : O(n*m)
 * Space Complexity : O(n*m)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <vector>

class Solution {
    void dfs(std::vector<std::vector<int>>& image, int row, int col, int color, int prev_color, std::vector<std::vector<int>>& direction) {
        //base
        if (row < 0 || row >= image.size() || col < 0 || col >= image[0].size())
            return;

        // recursion
        if (image[row][col] == prev_color) {
            image[row][col] = color;

            for (std::vector<int> dir: direction) {
                dfs(image, row + dir[0], col + dir[1], color, prev_color, direction);
            }
        }
    }
public:
    std::vector<std::vector<int>> floodFill(std::vector<std::vector<int>>& image, int sr, int sc, int color) {
        std::vector<std::vector<int>> direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        if (image[sr][sc] != color) {
            dfs(image, sr, sc, color, image[sr][sc], direction);
        }
        return image;
    }
};