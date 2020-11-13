// Time complexity is O(m*n) - m = #rows; n = #columns
// Space complexity is O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Using BFS
class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image.size() == 0) return image;
        
        queue<vector<int>> q;
        int strtClr = image[sr][sc]; // strtClr = starting pixel color
        if(strtClr == newColor) return image;
        image[sr][sc] = newColor;
        vector<int> temp = {{sr,sc}};
        q.push(temp);
        while(!q.empty()) {
            vector<vector<int>> directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
            vector<int> currCell = q.front();
            q.pop();
            for(auto dir : directions) {
                temp.clear();
                int neighborRow = currCell[0] + dir[0];
                int neighborCol = currCell[1] + dir[1];
                if(neighborRow >= 0 && neighborRow < image.size()
                  && neighborCol >= 0 && neighborCol < image[0].size()
                  && image[neighborRow][neighborCol] == strtClr) {
                    image[neighborRow][neighborCol] = newColor;
                    temp= {{neighborRow, neighborCol}};
                    q.push(temp);
                }
            }
            
        }
        return image;
    }
};


// Using DFS
class Solution {
public:
    int strtClr;
    void dfs(vector<vector<int>>& image, int i, int j, int newColor) {
        //base
        if(i < 0 || i == image.size() || j < 0 || j == image[0].size()
            || image[i][j] != strtClr) return;
        if(image[i][j] == strtClr)
            image[i][j] = newColor;
        //logic
        vector<vector<int>> directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(auto dir : directions) {
            int neighborRow = i + dir[0];
            int neighborCol = j + dir[1];
            dfs(image, neighborRow, neighborCol, newColor);
        }
    }
    
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image.size() == 0 || image[sr][sc] == newColor) return image;
        
        strtClr = image[sr][sc]; // strtClr = starting pixel color
        
        dfs(image, sr, sc, newColor);
    
        return image;
    }
};
