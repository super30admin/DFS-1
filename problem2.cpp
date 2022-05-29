class Solution {
public:
    int m,n;
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
       
       if(mat.size() == 0) return mat;
        
        m = mat.size();
        n = mat[0].size();
        
        //direction
        vector<vector<int>> dirs{{0,-1},{0,1},{-1,0},{1,0}}; 
        
          queue<vector<int>> q;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 0){
                    q.push({i,j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        
        int lev = 1;
        while(!q.empty()){
            int size = q.size();
        
        for(int i = 0;i<size;i++) {
            vector<int> mr = q.front();
            q.pop();
            for(auto dir : dirs) {
                int nr = dir[0] + mr[0];
                int nc = dir[1] + mr[1];
                
     if(nr>=0 && nr < m && nc>=0 && nc<n && mat[nr][nc] == -1){
                    mat[nr][nc] = lev;
                    q.push({nr,nc});
                }
            }
        }
            lev++;
        }
        
        return mat;
    }
};