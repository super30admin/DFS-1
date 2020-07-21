// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//DFS
//1. Call dfs on all four directions
//2. Return if the color of the pixel is the newcolor or not the original color

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
       //edge case
        if(image.size()==0 || image[sr][sc] == newColor){
            return image;
        }
        //dfs
        int originalColor=image[sr][sc];
        dfs(image, sr, sc, newColor,originalColor);
        return image;
    }
    
    void dfs(vector<vector<int>>& image, int sr, int sc, int newColor, int originalColor) {
        //returning condition
        if(image[sr][sc] == newColor || image[sr][sc] != originalColor){
            return;
        }
        //logic
        if(image[sr][sc] == originalColor){
            image[sr][sc] = newColor;
        }
         //recursing condition
        vector<vector<int>> dir{{1,0},{0,-1},{-1,0},{0,1}};
        for(int i=0; i<dir.size(); i++){
            //up //down //front //back
            int row = sr+dir[i][0];
            int col = sc+dir[i][1];
            if(row<image.size() && row>=0 && col<image[0].size() && col>=0){
                 dfs(image, row, col, newColor, originalColor);
            }
                  
        }
     }
    
};


// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//BFS
//1. Create a queue with the elements of original Color
//2. Traverse in all four directions and do nothing if the color of the pixel is the newcolor or not the original color

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        //edge case
        if(image.size()==0 || image[sr][sc] == newColor){
            return image;
        }
        //bfs
        int originalColor=image[sr][sc];
        queue<pair<int,int>> myqueue;
        myqueue.push({sr,sc});
        vector<vector<int>> dir{{1,0},{0,-1},{-1,0},{0,1}};
        while(!myqueue.empty()){
            pair<int,int>temp = myqueue.front();
            myqueue.pop();
            image[temp.first][temp.second] = newColor;
            for(int i=0; i<dir.size(); i++){
                //up //down //front //back
                int row = temp.first+dir[i][0]; int col = temp.second+dir[i][1];
                if(row<image.size() && row>=0 && col<image[0].size() && col>=0){
                    if(image[row][col] == originalColor) myqueue.push({row,col});
                }
            }
        }
        
        return image;
    }
};
