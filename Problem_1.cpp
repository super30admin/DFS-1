/**
 * Time Complexity:
 * O(N) as we are going through the entire matrix only once.
 * 
 */

/**
 * Space Complexity:
 * O(N) which  is the size of the stack and this size can be obtained 
 * by R*C
 * 
 */

/**
 * Approach:
 * It's a starightforward application of dfs. We are given a starting point and we have to 
 * look for the neighbors in four direction. So, first we have to make abound check and then
 * check if the neighbor has the same color as of the starting point or not. If it is then
 * we change it to new color, otherwise we skip that.
 */

class Solution {
    vector<vector<int>> dirs  {{0,1}, {0,-1}, {-1,0},{1,0}};
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image; 
        helper(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    private:
    void helper(vector<vector<int>>& image, int sr, int sc, int newColor, int color){
        //base
        if(sr <0 || sc <0 || sr>=image.size()|| sc >= image[0].size() || image[sr][sc] != color) return;
        //logic
        image[sr][sc] = newColor;
        
        for(auto d : dirs){
            int nr = sr + d[0];
            int nc = sc + d[1];
            helper(image, nr, nc, newColor, color);
        }