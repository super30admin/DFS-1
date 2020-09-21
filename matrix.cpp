// Time Complexity : O(n*n)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        
        // when input is null
        if(matrix.size() == NULL || matrix[0].size() == NULL) return matrix;
        
        
        int rows = matrix.size();
        int col = matrix[0].size();
        
        queue<vector<int>> myqueue;
        
        for(int i = 0; i <rows ; i++){
            for (int j = 0; j<col; j++){     // using all the 0 locations to my queue so that we can use them for travelling
                
                if(matrix[i][j] == 0)
                    myqueue.push({i,j});
                else if (matrix[i][j] == 1)
                    matrix[i][j] = INT_MAX;
            }
        }
        
        
        vector<vector<int>> directions = {{ 1,0},{-1,0},{0,1},{0,-1}};
        
        while(!myqueue.empty()){
            
            vector<int> temp = myqueue.front();
            myqueue.pop();
            
            int i = temp[0];
            int j = temp[1];
            
            
            for (auto dir:directions){ // checking in all the 4 possible directions to check for any possible min value
                
                int r = i + dir[0];
                int l = j + dir[1];
                
                if( r>=0 && r<rows && l>=0 && l <col && (matrix[i][j]+1 <matrix[r][l])){
                    matrix[r][l] = matrix[i][j] +1;
                    myqueue.push({r,l}); // adding new location to the queue when we have updated the value so that we can travel its neightbors as well
                }
            }
        }
        return matrix;
    }
};