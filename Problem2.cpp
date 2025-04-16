// Time Complexity : O(N*M) . 
// Space Complexity : O(N*M) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : unable to figure out sub problem 


// Your code here along with comments explaining your approach:
// 1. Perform BFS starting with all pair of row and column with value as 0 in queue.
// 2. While travesing each 0 if its neighbour is 1 change its value to current level of traversal + 1.
// 3. Traverse matrix again and decrease each element by 1 if its not 0.


class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        queue<pair<int,int>> q;
        int n=mat.size(),m=mat[0].size();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.push(make_pair(i,j));
                }
            }
        }
        int s=q.size(),p=2;
        if(s==(m*n)){return mat;}
        while(!q.empty()){
            s--;
            int i=q.front().first;int j=q.front().second;
            if(i!=0 && (mat[i-1][j]==1) ){
                mat[i-1][j]=p;q.push(make_pair(i-1,j));
            }
            if(j!=0 && (mat[i][j-1]==1) ){
                mat[i][j-1]=p;q.push(make_pair(i,j-1));
            }
            if(i!=(n-1) && (mat[i+1][j]==1) ){
                mat[i+1][j]=p;q.push(make_pair(i+1,j));
            }
            if(j!=(m-1) && (mat[i][j+1]==1) ){
                mat[i][j+1]=p;q.push(make_pair(i,j+1));
            }
            if(s==0){s=q.size()-1;p++;}
            q.pop();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]>1){
                    mat[i][j]--;
                }
            }
        }
        return mat;

    }
};