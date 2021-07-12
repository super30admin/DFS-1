// Time Complexity :O(M x N)
// Space Complexity : O(M x N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 0-1 Matrix 

#include<vector>
#include<iostream>
#include<queue>
using namespace std;

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        queue<pair<int,int>> q;
        int distance  = 1;
        for(int i = 0;i < mat.size(); i++){
            for(int j = 0;j < mat[0].size(); j++){
                if(mat[i][j] == 0) q.push(make_pair(i,j));
                else mat[i][j] = -1;
            }
        }
        int size,r=0,c=0;
        int dirs[4][2] = {{-1,0},{1,0},{0,1},{0,-1}};   //LRUD
        pair<int,int> curr;
        cout<<q.size()<<endl;
        while(!q.empty()){
            size = q.size();
            for(int i = 0; i<size;i++){
                curr = q.front();
                q.pop();
                for(auto dir : dirs){
                    r = dir[0] + curr.first;
                    c = dir[1] + curr.second;
                    if(r >=0 && r < mat.size() 
                       && c >=0 && c < mat[0].size() && mat[r][c] == -1){
                        mat[r][c] = distance;
                        q.push(make_pair(r,c));
                    }
                }
            }
            distance++;
        }
        return mat;
    }
};