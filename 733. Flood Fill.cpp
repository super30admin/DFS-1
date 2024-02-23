/*
Time: O(m*n)
Space: O(m*n)

Run dfs traversing adjacent nodes having the same color as source
*/

class Solution {
public:
    vector<vector<int>> img;
    vector<vector<int>> vis;
    int rows, cols;

    void dfs(int r, int c, int orig_col, int col){
      if(r<0 || r>=rows || c<0 || c>=cols)  return;
      if(vis[r][c])  return;
      
      if(img[r][c] != orig_col)  return;

      vis[r][c] = 1;

      img[r][c] = col;

      dfs(r+1,c,orig_col,col);
      dfs(r-1,c,orig_col,col);
      dfs(r,c+1,orig_col,col);
      dfs(r,c-1,orig_col,col);
    }
    
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        img = image;
        rows = image.size(), cols = image[0].size();
        vis = vector(rows, vector(cols, 0));

        dfs(sr, sc, image[sr][sc], color);
        return img;
    }
};
