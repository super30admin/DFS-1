//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
#include<iostream>
#include<vector>
#include<queue>
using namespace std;
class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        queue<pair<int,int>>q;
        vector<vector<int>>dir = {{-1,0},{1,0},{0,1},{0,-1}};
        int m = image.size(),n = image[0].size();
        int past = image[sr][sc];
        if(past == color)
            return image;
        image[sr][sc]=color;
        q.push({sr,sc});
        while(!q.empty()){
            pair<int,int>temp = q.front();
            q.pop();
            for(auto& x : dir){
                int r = temp.first+x[0];
                int c = temp.second+x[1];
                if(r>=0 && c>=0 && r<m && c<n && image[r][c]==past){
                    q.push({r,c});
                    image[r][c]=color;
                }
            }
        }
        return image;
    }
};