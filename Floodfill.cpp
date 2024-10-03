//tc : O(n*m) sc : O(n*m)

class Solution {
public:
    vector<vector<int>> dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    void helper(vector<vector<int>>& image, int sr, int sc, int color, int startColor) {
        image[sr][sc] = color;
        for(auto &d : dir) {
            int newRow = sr + d[0];
            int newCol = sc + d[1];
            if(newRow >= 0 && newCol >= 0 && newRow < image.size() && newCol < image[0].size() && image[newRow][newCol] == startColor) {
                helper(image, newRow, newCol, color, startColor);
            }
        }
    }
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        if(image.size() == 0 || image[0].size() == 0) return image;
        int startColor = image[sr][sc];
        if(image[sr][sc] != color) {
            helper(image, sr, sc, color, startColor);
        }
        return image;
    }
};