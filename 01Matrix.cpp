//TC = O(MN)
//SC = O(MN)

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int m = mat.size();
        int n = mat[0].size();
        if(m==0) return {{}};
        vector<vector<int>> dirs= {{0,1},{0,-1},{1,0},{-1,0}};
        queue<pair<int,int>> q;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.push({i,j});
                }else{
                    mat[i][j]=-1;
                }
            }
        }
        int dist =1;
        while(!q.empty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                pair<int,int> p = q.front(); q.pop();
                for(auto dir: dirs){
                    int r = p.first + dir[0];
                    int c = p.second + dir[1];
                    if(r>=0 && c>=0 && r<m && c<n && mat[r][c]==-1){
                        mat[r][c]=dist;
                        q.push({r,c});
                    }
                }
            }
            dist++;
        }
        return mat;
    }
};
