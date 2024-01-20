// Time Complexity : O(M*N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: BFS using queue, first add all the 0's to queue,
//check vicinity for -1, if found dist+1. Once one BFS is over,
// increase the dist by 1.

//542. 01 Matrix

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        vector<pair<int,int>> dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int m = mat.size();
        int n = mat[0].size();
        queue<pair<int,int>> q;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    q.push({i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        int dist = 0;
        while(!q.empty()){
            int qSize = q.size();
            for(int i=0;i<qSize;i++){
                auto curr = q.front();
                q.pop();
                for(auto dir : dirs){
                    int nr = curr.first + dir.first;
                    int nc = curr.second + dir.second;
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n
                    && mat[nr][nc] == -1){
                        mat[nr][nc] = dist+1;
                        q.push({nr,nc});
                    }
                }  
            }
            dist++;
        }
        return mat;
    }
};