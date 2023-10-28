//BFS Approach
class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        if(image.size()==0 )return image;
        int oldColor = image[sr][sc];
        if(image[sr][sc]==color)return image;
        int m=image.size(), n=image[0].size();
        queue<int> q;
        q.push(sr);
        q.push(sc);
        image[sr][sc]=color;
        int dir[4][2]={{0,1}, {0,-1}, {1,0}, {-1, 0}};
        while(!q.empty()){
            int cr=q.front();
            q.pop();
            int cc=q.front();
            q.pop();
            for(int i=0;i<4;i++){
                int nr = dir[i][0] + cr;
                int nc = dir[i][1] + cc;
                if(nr>=0 && nr< m && nc>=0 && nc<n && image[nr][nc]==oldColor){
                    q.push(nr);
                    q.push(nc);
                    image[nr][nc]=color;
                }

            }
        }
        return image;
    }
};
///////////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
private:
    int dir[4][2]={{0,1}, {0,-1}, {1,0}, {-1,0}};
    int oldColor;

public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        if(image.size()==0 )return image;
        oldColor = image[sr][sc];
        if(image[sr][sc]==color)return image;
        int m=image.size(), n=image[0].size();
        dfs(image, sr, sc, color, m, n);
        return image;
    }
private:
    void dfs(vector<vector<int>>& image, int sr, int sc, int color, int m, int n){
        //base case
        if(sr<0 || sr==m || sc==n || sc<0 || image[sr][sc]!=oldColor){
            return;
        }

        //logic
        image[sr][sc]=color;
        for(int i=0;i<4;i++){
            int nr = dir[i][0] + sr; 
            int nc = dir[i][1] + sc;
            dfs(image, nr, nc, color, m, n);
        }

    }    
};
