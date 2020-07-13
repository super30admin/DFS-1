class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        queue<pair<int,int>>Q;
        for(int i=0; i<matrix.size();i++){
            for(int j=0; j<matrix.at(0).size();j++){
                if(matrix[i][j]==0) Q.push({i,j});
                else matrix[i][j]=-1;
            }
        }
        auto p1 = make_pair(0,1);
        auto p2 = make_pair(1,0);
        auto p3 = make_pair(-1,0);
        auto p4 = make_pair(0,-1);
        vector<pair<int,int>>dirs{p1,p2,p3,p4};
        int level = 1;
        while(!Q.empty()){
            int sz = Q.size();
            while(sz--){
                auto temp = Q.front();
                Q.pop();
                for(auto tmp:dirs){
                    int r = temp.first+tmp.first;
                    int c = temp.second+tmp.second;
                    if(r<matrix.size() && r>=0 && c<matrix.at(0).size() && c>=0 && matrix[r][c]==-1){
                        Q.push({r,c});
                        matrix[r][c] = level;   
                    }
                }
            }
            level++;
        }
        return matrix;
    }
};