// Approach 1 - BFS
// Time Complexity - O(m*n) - Since we are traversing all the nodes in the input image(Therefore I'll have to put all the nodes in to my queue in the worst case scenario.).
// Space Complexity - O(m*n)
// Problems Faced - No!
// It runs on leetcode.
class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;
        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int m = image.size();
        int n = image[0].size();
        int currColor = image[sr][sc];
        queue<int> q;
        q.push(sr);
        q.push(sc);
        image[sr][sc] = color;
        
        while(!q.empty()){
            int cr = q.front(); q.pop();
            int cc = q.front(); q.pop();
            // I can also change the color when I pop the current element rather than when I push it into the queue.
            for(vector<int> dir : dirs){
                int nr = cr + dir[0];
                int nc = cc + dir[1];
                
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == currColor){
                    q.push(nr);
                    q.push(nc);
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }
};

// Approach 1 - BFS
// Time Complexity - O(m*n) - Since we are traversing all the nodes in the input image(Therefore I'll have to put all the nodes in to my queue in the worst case scenario.).
// Space Complexity - O(m*n)
// Problems Faced - No!
// It runs on leetcode.
class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;
        vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int oldColor = image[sr][sc];
        int m = image.size();
        int n = image[0].size();
        queue<vector<int>> q;
        q.push({sr, sc});
        //image[sr][sc] = color;
        
        while(!q.empty()){
            vector<int> curr = q.front(); q.pop();
            image[curr[0]][curr[1]] = color;
            for(vector<int> dir : dirs){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor){
                    q.push({nr, nc});
                    //image[nr][nc] = color;
                }
            }
        }
        
        return image;
    }
};


// Approach 2 - DFS
// Time Complexity - O(m*n) - Since we are traversing all the nodes in the input image.
// Space Complexity - O(m*n)
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    vector<vector<int>> dirs;
    int prevColor;
    private:
    void dfs(vector<vector<int>>& image, int sr, int sc, int color, int m, int n){
        // base
        if(sr < 0 || sr == m || sc < 0 || sc == n || image[sr][sc] != prevColor)
            return;
        // logic
        image[sr][sc] = color;
        for(vector<int> dir : dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, color, m, n);
        }
    }
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;
        
        int m = image.size();
        int n = image[0].size();
        
        prevColor = image[sr][sc];
        dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        dfs(image, sr, sc, color, m, n);
        return image;
    }
};

// Approach - DFS(Just a variation)
class Solution {
    private:
    void dfs(vector<vector<int>>& image, int sr, int sc, int color, int m, int n, int currColor, vector<vector<int>> dirs){
        // can write a base case also
        image[sr][sc] = color;
        for(vector<int> dir : dirs){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] != color)
                if(image[nr][nc] == currColor)
                    dfs(image, nr, nc, color, m, n, currColor, dirs);
        }
    }
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int m = image.size();
        int n = image[0].size();
        int currColor = image[sr][sc];
        dfs(image, sr, sc, color, m, n, currColor, dirs);
        return image;
    }
};