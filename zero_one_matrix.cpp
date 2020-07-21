// Time Complexity : O(mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//BFS
//1. Put all the 0 in the queue first
//2. Change the 1's to -1's to avoid storing the same elements again and again in the queue
//3. For each -1 encountered replace element with the level of processing.
class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        //edge case
        if(matrix.size()==0) return matrix;
        
        //logic
        queue<pair<int,int>> my_queue;
        for(int i=0; i<matrix.size(); i++){
            for(int j=0;j<matrix[0].size(); j++){
                if(matrix[i][j] ==0) my_queue.push({i,j});
                else  matrix[i][j] =-1;
            }
        }
        int size,  level=0 ;
        vector<vector<int>> dir{{1,0},{-1,0},{0,1},{0,-1}};
        while(!my_queue.empty()){
            size = my_queue.size();
            level++;
            while(size>0){
               pair<int,int> temp = my_queue.front();
               my_queue.pop(); 
               size--;
               for(int i=0;i<dir.size();i++){
                    int row = temp.first+dir[i][0];
                    int col = temp.second+dir[i][1];
                    if(row<matrix.size() && row>=0 && col<matrix[0].size() && col>=0 && matrix[row][col] == -1) {
                        matrix[row][col] = level; my_queue.push({row,col});
                    }
                     
               }
            } 
        }
        return matrix;
    }
};
