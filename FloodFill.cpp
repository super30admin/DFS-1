
//Time Complexity O(m*n)
// Space Complexity O(m*n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
using namespace std;


class Solution {
public:
    int color;
    int dirs[4][2]={{-1,0},{1,0},{0,-1},{0,1}};
    vector<vector<int> > floodFill(vector<vector<int> >& image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor)
        {
            return image;
        }
        color=image[sr][sc];
        dfs(image,sr,sc,newColor);
        return image;
    }
    
    void dfs(vector<vector<int> >& image, int row, int col, int newColor)
    {
        int nr;
        int nc;
        image[row][col]=newColor;
        for(auto &dir:dirs)
        {
            nr=row+dir[0];
            nc=col+dir[1];
            if(nr>=0 && nr<image.size() && nc>=0 && nc<image[0].size() && image[nr][nc]==color)
            {
                dfs(image,nr,nc,newColor);
            }
        }
    }
};