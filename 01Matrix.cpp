// Time Complexity : O(mn); 
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. BFS. Place coordinates of all 0s in queue and make all 1s to be -1 or INT_MAX
// 2. Iterate in all four directions, check if cell is inside matrix and equals -1 
// 3. If yes, make its value one greater than its parent

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        //own soln
        queue<pair<int, int>> q;
        if(matrix.size()==0)
            return {};
        int r=matrix.size();
        int c=matrix[0].size();
        // preprocess
        for (int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix[0].size();j++){
                if(matrix[i][j]==0)
                    q.push({i,j});
                else
                    matrix[i][j]=-1;
            }
        }
        vector<pair<int,int>> adj{{0,-1},{1,0},{0,1},{-1,0}};
        while(!q.empty()){
            auto curr = q.front(); q.pop();   
            for (auto dir : adj){
                int i=curr.first+dir.first; 
                int j=curr.second+dir.second;
                if(i>=0 && i<r && j>=0 && j<c && matrix[i][j]==-1)                 {
                    matrix[i][j] = matrix[curr.first][curr.second]+1;
                    q.push({i,j});
                }
            }
        }
        return matrix;
    }
};