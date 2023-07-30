// Time Complexity :O(mxn)
// Space Complexity :O(mxn)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

//We first need to push in all 0's in the queue and mark any 1's encountered as -1. Then we try looking for -1's in the array and in place
//of -1's we change it to distance to the nearest 0 and push that element to the queue.

// Your code here along with comments explaining your approach.
class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        queue<vector<int>> q;
        vector<vector<int>> dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        int m=mat.size();
        int n=mat[0].size();
        
        

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.push({i,j});
                }
                else{
                    mat[i][j]=-1;
                }

            }
        }
        int dist=1 ;

        while(!q.empty()){
            int size = q.size();
            

            for(int i=0;i<size;i++){
                vector<int> curr = q.front();
                q.pop();
                

                for(vector<int> dir:dirs){
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc]==-1){
                        q.push({nr,nc});
                        mat[nr][nc]= dist;
                    }

                }



            }
            dist++;

        }

        return mat;
        
        
    }
};