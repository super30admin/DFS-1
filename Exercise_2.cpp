// Time Complexity                              :  O(N*M), where N is the number of rows in the matrix and M is the number of columns in the matrix.
// Space Complexity                             :  O(N*M), to store the visited array.
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/01-matrix/

class Solution {
private:
    vector<vector<int>> itr{{1,0},{-1,0},{0,1},{0,-1}};
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int n = mat.size();
        int m = mat[0].size();
        
        vector<vector<bool>> vis(n,vector<bool>(m,false));
        
        queue<pair<int,int>> q;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(mat[i][j] == 0) {
                    vis[i][j] = true;
                    q.push({i,j});
                }
            }
        }
        
        while(!q.empty()) {
            int sz = q.size();
            for(int k=0;k<sz;k++) {
                auto [i, j] = q.front();
                q.pop();
                int val = mat[i][j];
                for(auto it : itr) {
                    int ni = i + it[0];
                    int nj = j + it[1];
                    if(ni >= 0 and ni < n and nj >= 0 and nj < m) {
                        if(vis[ni][nj] == false) {
                            vis[ni][nj] = true;
                            mat[ni][nj] = val+1;
                            q.push({ni,nj});
                        }
                    }
                }
            }
        }
        return mat;   
    } 
};