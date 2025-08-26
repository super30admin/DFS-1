#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use DFS to fill all connected cells with the same color as the start.
The recursive function visits each valid neighbor and changes its color.
It stops at boundaries or when the neighbor's color is different.
*/
class Solution{
public:
    int  m, n;
    vector<vector<int>> dirs;
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        m = image.size(); n = image[0].size();

        int oldColor = image[sr][sc]; 
        if(oldColor == color) return image;

        dfs(image, sr, sc, color, oldColor);
        return image;
    }
private:
    void dfs(vector<vector<int>>& image, int i, int j, int& color, int& oldColor){
        if(i<0 || j<0 || i==m || j==n || image[i][j] != oldColor) return;

        image[i][j] = color;
        for(vector<int> dir : dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            dfs(image, r, c, color, oldColor);
        }
    }
};
