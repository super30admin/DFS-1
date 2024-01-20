// Time Complexity : O(M*N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: BFS using queue, add the given cell index to queue,
// check its vicinity and add remaining elements if same as curr color
// and change to new color and return matrix.

//733. Flood fill

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int m = image.size();
        int n = image[0].size();
        vector<pair<int,int>> dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        queue<pair<int,int>> q;
        int currColor = image[sr][sc];
        if(image[sr][sc] == color) return image;
        q.push({sr,sc});
        image[sr][sc]=color;
        while(!q.empty()){
            int qSize = q.size();
            for(int i=0;i<qSize;i++){
                auto curr = q.front();
                q.pop();
                for(auto dir : dirs){
                    int nr = curr.first + dir.first;
                    int nc = curr.second + dir.second;
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n 
                    && image[nr][nc] == currColor){
                        image[nr][nc] = color;
                        q.push({nr,nc});
                    }
                }
            }
        }
        return image;
    }
};