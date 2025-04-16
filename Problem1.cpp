// Time Complexity : O(N*M) . 
// Space Complexity : O(N*M) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : unable to figure out sub problem 


// Your code here along with comments explaining your approach:
// 1. Perform BFS starting with given(sr,sc) pair of row and column in queue.
// 2. In each traversing neighbours change its value to given color if it has same color as root of tree.
// 3. We can store color of root of given tree before it is changed to compare it with all neighbours.

class Solution {
public:
    //int srr,scc;
    vector<vector<int>> dfs(vector<vector<int>>& image, int sr, int sc, int color) {
        int t=image[sr][sc];
        image[sr][sc]=color;
        if(sr!=0 && image[sr-1][sc]==t){
            dfs(image,sr-1,sc,color);
        }
        if(sc!=0 && image[sr][sc-1]==t){
            dfs(image,sr,sc-1,color);
        }
        if(sr!=(image.size()-1) && image[sr+1][sc]==t){
            dfs(image,sr+1,sc,color);
        }
        if(sc!=(image[0].size()-1) && image[sr][sc+1]==t){
            dfs(image,sr,sc+1,color);
        }
        return image;
    }
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        //srr=sr;scc=sc;
        if(color==image[sr][sc]){
            return image;
        }
        return dfs(image,sr,sc,color);
    }
};
