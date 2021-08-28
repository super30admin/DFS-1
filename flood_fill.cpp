// Time Complexity : O(M*N) where M represents the no.of rows and N represents the no.of columns
// Space Complexity : O(M*N) where M represents the no.of rows and N represents the no.of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/flood-fill/
// Submission Link: https://leetcode.com/submissions/detail/543188374/

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor)
            return image;
        
        int row_size = image.size();
        int col_size = image[0].size();
        
        queue<pair<int, int> > q;
        q.push(make_pair(sr, sc));
        
        int original_color = image[sr][sc];
        image[sr][sc] = newColor;
        
        vector<int> rows = {0, -1, 0, 1};
        vector<int> cols = {-1, 0, 1, 0};
        int x, y;
        
        
        while(!q.empty()){
            x = q.front().first;
            y = q.front().second;
            q.pop();
            
            for(int i = 0; i < 4; i++){
                if(x + rows[i] >= 0 && x + rows[i] < row_size &&
                   y + cols[i] >= 0 && y + cols[i] < col_size &&
                   image[x + rows[i]][y + cols[i]] == original_color){
                    image[x + rows[i]][y + cols[i]] = newColor;
                    q.push(make_pair(x + rows[i], y + cols[i]));
                }
            }
        }
        
        return image;
    }
};