//Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
public:
    //BFS solution with O(m*n) solution and O(m*n) space
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        if(matrix.size()==0) return matrix;
        queue<vector<int>> q;
        int dist =1;
        
        int m=matrix.size(); int n = matrix[0].size();
        
        //changing all 1's to -1 and add all zeros in queue
        for(int i=0;i<m; i++){
            for(int j=0; j<n; j++){
                vector<int> temp;
                if(matrix[i][j]==1)
                    matrix[i][j]=-1;
                else{
                    temp.push_back(i);
                    temp.push_back(j);
                    q.push(temp);
                }
                
            }
        }
        int  dirs[4][2] ={{0,1},{0,-1},{-1,0},{1,0}};
        //level by level processing
        while(q.empty()==false){
            int size=q.size();
            for(int i=0; i<size; i++){
                vector<int> temp = q.front(); q.pop();
                for(int j=0; j<4; j++){
                    int r = dirs[j][0]+temp[0];
                    int c=dirs[j][1]+temp[1];
                    vector<int> arr;
                    if(r>=0 && r<m && c>=0 && c<n && matrix[r][c]==-1) {
                        matrix[r][c]=dist;
                        arr.push_back(r);
                        arr.push_back(c);
                        q.push(arr);
                    }
                }
                
            }
            dist++;
            
        }
        
        return matrix;
        
    }
};