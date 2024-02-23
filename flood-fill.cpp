// Time Complexity :  O(M*N)
// Space Complexity :  O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    // // BFS, TC = O(M*N), SC = O(M*N) Queue
    // vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
    //     // null
    //     if(image.size() == 0 || image[sr][sc] ==color)return image;//handling same color special case
    //     int m = image.size();
    //     int n = image[0].size();
    //     vector<vector<int>> dirs{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    //     int oldColor = image[sr][sc];
    //     queue<int> q;
    //     q.push(sr); q.push(sc);
    //     image[sr][sc] = color;
    //     while(!q.empty()) {
    //         int cr = q.front(); q.pop();
    //         int cc = q.front(); q.pop();
    //         for(vector<int> dir: dirs) {
    //             int nr = cr + dir[0];
    //             int nc = cc + dir[1];
    //             // bound check
    //             if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == oldColor) {
    //                 q.push(nr); q.push(nc);
    //                 image[nr][nc] = color;
    //             }
    //         }
    //     }
    //     return image;
    // }

    // BFS, TC = O(M*N), SC = O(M*N) Recursive stack
    int oldColor; 
    vector<vector<int>> dirs{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        // null
        if(image.size() == 0 || image[sr][sc] == color) return image;
        int m = image.size();
        int n = image[0].size();
        oldColor = image[sr][sc];
        dfs(image, sr, sc, color, m, n);
        return image;
    }
    void dfs(vector<vector<int>>& image, int sr, int sc, int color, int m, int n) {
        // base
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != oldColor) return;
        // logic
        image[sr][sc] = color;
        for(vector<int> dir: dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, color, m, n);
        }
    }
};