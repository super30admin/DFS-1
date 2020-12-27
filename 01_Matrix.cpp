// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I need to practice a lot

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        if(matrix.empty()){
            return matrix;
        }
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix[0].size();j++){
                if(matrix[i][j]==1 && !hasNeighborZero(i, j, matrix)){
                    matrix[i][j] = matrix.size() + matrix[0].size() + 1;
                }
            }
        }
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix[0].size();j++){
                if(matrix[i][j]==1){
                    dfs(matrix,i,j,-1);
                }
            }
        }
        return matrix;
    }
    
    void dfs(vector<vector<int>>& matrix, int i, int j, int val){
        if(i<0||j<0||i>=matrix.size()||j>=matrix[0].size()||matrix[i][j]<=val){
            return;
        }
        if(val>0){
            matrix[i][j] = val;
        }
        dfs(matrix, i+1, j, matrix[i][j]+1);
        dfs(matrix, i, j+1, matrix[i][j]+1);
        dfs(matrix, i-1, j, matrix[i][j]+1);
        dfs(matrix, i, j-1, matrix[i][j]+1);
    }
    
    bool hasNeighborZero(int i, int j, vector<vector<int>>& matrix){
        if(i>0 && matrix[i-1][j]==0){
            return true;
        }
        if(j>0 && matrix[i][j-1]==0){
            return true;
        }
        if(i<matrix.size()-1 && matrix[i+1][j]==0){
            return true;
        }
        if(j<matrix[0].size()-1 && matrix[i][j+1]==0){
            return true;
        }
        
        return false;
    }
};
