/*
Time: O(m*n)
Space: O(m*n)

Run bfs while maintaining levels. Initial nodes in the queue will be all the 0 cells. 
*/

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        const int inf = 1e9;
        int m = mat.size(), n = mat[0].size();
        
        int dr[4] = {1,-1,0,0};
        int dc[4] = {0,0,1,-1};

        queue<vector<int>> q;
        vector<vector<int>> level(m, vector(n, inf));
        
        for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
            
            if(mat[i][j]==0){
              level[i][j] = 0;
              q.push({i,j});
            }
          }
        }

        //bfs
        while(!q.empty()){
          auto node = q.front();
          q.pop();

          int x = node[0], y = node[1];
          int l = level[x][y];

          for(int i=0;i<4;i++){
            int _x = x+dr[i];
            int _y = y+dc[i];

            if(_x>=m || _x<0 || _y>=n || _y<0)  continue;
            if(level[x][y] + 1 < level[_x][_y])  {
              level[_x][_y] = level[x][y] + 1;
              q.push({_x,_y});
            }
          }
        }

        return level;
    }
};
