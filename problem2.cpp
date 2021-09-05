//Time Complexity - O(M*N)
//Space Complexity - O(M*N)
class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        queue<pair<int,int>>q;
        for(int i=0;i<mat.size();i++){
            for(int j=0;j<mat[0].size();j++){
                if(mat[i][j]==1){
                    mat[i][j]=-1;
                }
                if(mat[i][j]==0){
                    q.push({i,j});
                }
            }
        }
        vector<vector<int>>dirs={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.empty()){
            int n=q.size();
            while(n--){
                int row = q.front().first;
                int col = q.front().second;
                for(vector<int> dir : dirs){
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if(nr>=0&&nr<mat.size()&&nc>=0&&nc<mat[0].size()&&mat[nr][nc]==-1)
                    {
                        q.push({nr,nc});
                        mat[nr][nc]=mat[row][col]+1;
                    }
                }
                q.pop();
            }
        }
        return mat;
    }
};