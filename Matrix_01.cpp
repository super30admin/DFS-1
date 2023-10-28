//BFS Solution - Time: O(mxn) and space - maximum size of queue - O(mxn){worst case scenario}
// if we would have selected 1's instead of 0's we would have to go to each 1 and perform bfs which would result in a time of O(mxn) x O(mxn);
class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        if(matrix.size()==0)return matrix;
        int m = matrix.size(), n = matrix[0].size();
        queue<int>q;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    q.push(i);
                    q.push(j);
                }
                else{
                    matrix[i][j]=-1;
                }
            }
        }
        int dir[4][2]= {{0,1}, {0,-1}, {1,0}, {-1, 0}};
        while(!q.empty()){
            int cr = q.front();
            q.pop();
            int cc = q.front();
            q.pop();
            for(int i=0;i<4;i++){
                int nr = dir[i][0] + cr;
                int nc = dir[i][1] + cc;
                if(nr>=0 && nc>=0 && nr<m && nc<n && matrix[nr][nc]==-1){
                    q.push(nr);
                    q.push(nc);
                    matrix[nr][nc]= matrix[cr][cc] + 1;
                }
            }
        }
       return matrix; 
    }
};
