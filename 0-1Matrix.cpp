#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
First we set all 1s to a large value and leave 0s as they are
then we traverse the array first from top-left to bottom-right updating distances on top and left neighbors
finally we traverse back bottom-right to top-left, updating using bottom and right neighbors
*/
class Solution{
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int m = mat.size(), n= mat[0].size();
        vector<vector<int>> result(m,vector<int>(n,99999));

        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(mat[i][j] == 0) result[i][j] = 0;
            }
        }

        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(mat[i][j] == 1){
                    if(i>0 && j>0)
                        result[i][j] = min(result[i-1][j], result[i][j-1]) + 1;
                    else if(i>0)
                        result[i][j] = result[i-1][j] + 1;
                    else if(j>0)
                        result[i][j] = result[i][j-1] + 1;
                }
            }
        }

        for(int i=m-1;i>=0;--i){
            for(int j=n-1;j>=0;--j){
                if(mat[i][j] == 1){
                    if(i<m-1 && j<n-1)
                        result[i][j] = min(result[i][j], min(result[i+1][j], result[i][j+1]) + 1);
                    else if(i<m-1)
                        result[i][j] = min(result[i][j], result[i+1][j] + 1);
                    else if(j<n-1)
                        result[i][j] = min(result[i][j], result[i][j+1] + 1);
                }
            }
        }
        return result;
    }
};
