class Solution {
public:

 // DFS solution ////////
  vector<vector<int>> dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
    
            int m = mat.size();
            int n = mat[0].size();

          
            int dist = 0;
            for(int i = 0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][j]==1){
                        mat[i][j] = 999999;
                    }
                }
            }


            for(int i = 0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][j]==0){
                        dfs(mat,i,j,dist,m,n);
                    }
                }
            }
    
        return mat;
    }



    void dfs(vector<vector<int>>& mat, int i,int j, int dist,int m,int n){

            if(i<0 || j<0 || i==m||j==n||mat[i][j]< dist) return;

        mat[i][j] = dist;
        for(vector<int> dir: dirs){
            int r = i+dir[0];
            int c = j+dir[1];
        if(r>=0 && r<m && c>=0 && c<n){
            dfs(mat,r,c,dist+1,m,n);
        }
        }
    }
};

//    BFS Solution /// 

            
            int m = mat.size(); // row
            int n = mat[0].size(); // coloum;
  vector<vector<int>>dirs = {{0,1},{0,-1},{1,0},{-1,0}};
            queue<vector<int>> q;
                int dist = 1;
            for(int i = 0;i<m ; i++){
                for(int j = 0;j<n;j++){
                    if(mat[i][j] == 0){
                        q.push({i,j});
                    }
                    if(mat[i][j] == 1){
                        mat[i][j] = -1;
                    }
                }
            }

            while(!q.empty()){
                int size = q.size();
                for(int i=0;i<size;i++){
                    vector<int> front = q.front();
                    q.pop();
                   
                    for(vector<int> dir : dirs){
                        int r = front[0] + dir[0];
                        int c = front[1] + dir[1];
       
                        if(r>=0 && r<m && c>=0 && c<n && mat[r][c] == -1){
                            q.push({r,c});
                        
                            mat[r][c] = dist;

                        }
                    }
                }

                dist++;
            }

            return mat;

    }