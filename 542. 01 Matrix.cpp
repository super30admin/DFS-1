class Solution {
public:
    //Time complexity:O(r⋅c)
    //Space complexity:O(r⋅c)
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        
        int m=mat.size();
        int n=mat[0].size();
        if(m==0)return mat;
        queue<pair<int,int>> q;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.push({i,j});
                }
                else{
                    mat[i][j]=mat[i][j]*-1;
                }
                }
        }
        int level=1;
        int dx[4]={1,-1,0,0};
        int dy[4]={0,0,-1,1};
        while(!q.empty()){
            int size=q.size();
            while(size--){
                auto x=q.front().first;
                auto y=q.front().second;
                q.pop();
                for(int i=0;i<4;i++){
                    int nx=x+dx[i];
                    int ny=y+dy[i];
                    if(nx>=0&&ny>=0&&nx<m&&ny<n&&mat[nx][ny]==-1){
                        mat[nx][ny]=level;
                        q.push({nx,ny});
                    }
                }
            }
           level++;
        }
        return mat;
    }
};