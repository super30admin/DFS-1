
// Time complexity O(mn)
// Space complexity O(mn)

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int m = image.size();
        if (m < 1) {
            return image;
        }
        int n = image[0].size();

        if (sr<0 || sr>=m || sc<0 || sc>=n) {
            return image;
        }

        vector<pair<int, int>> dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        queue<pair<int, int>> que;
        int original = image[sr][sc];
        if (original == color) {
            return image;
        }
        image[sr][sc] = color;
        que.push({sr, sc});
        while(!que.empty()) {
            auto [r, c] = que.front();
            que.pop();

            for (auto [dr, dc] : dirs)
            {
                int nr = r+dr;
                int nc = c+dc;
                if (nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc] == original) 
                {
                    image[nr][nc] = color;
                    que.push({nr, nc});
                }
            }
        }

        return image;
    }
};