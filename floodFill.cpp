// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

//Approach 1: BFS

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        if(image.size() == 0 || image[sr][sc] == color) return image;
        int m = image.size();
        int n = image[0].size();
        queue<pair<int,int>> q;
        int originalColour = image[sr][sc];
        q.push({sr,sc});
        vector<vector<int>> dirs ({{-1, 0}, {1, 0}, {0, -1}, {0, 1}});


        while(!q.empty()){
            auto node = q.front();
            q.pop();
            image[node.first][node.second] = color;
            for(auto dir:dirs){
                int new_row = node.first + dir[0];
                int new_col = node.second + dir[1];
                if(new_row >= 0 && new_col >= 0 && new_row < m && new_col < n && image[new_row][new_col] == originalColour){
                    image[new_row][new_col] = color;
                    q.push({new_row, new_col});
                }
            }
        }
        return image;
    }
};


//Approach 2: DFS

class Solution {
public:
    int originalColour;
    vector<vector<int>> dirs;
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        if(image.size() == 0 || image[sr][sc] == color) return image;
        originalColour = image[sr][sc];
        dirs = vector<vector<int>> ({{-1, 0}, {1, 0}, {0, -1}, {0, 1}});

        dfs(image, sr, sc, color);

        return image;
    }
private:
    void dfs(vector<vector<int>>& image, int row, int column, int color){
        if(row < 0 || column < 0 || row>=image.size() || column>=image[0].size() || image[row][column] != originalColour)
            return;
        image[row][column] = color;

        for(auto dir:dirs){
            int new_row = row + dir[0];
            int new_col = column + dir[1];
            dfs(image, new_row, new_col, color);
        }
    }
};