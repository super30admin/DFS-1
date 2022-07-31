class Solution {
public:
   void dfs(vector<vector<int>>& image,int sr,int sc,int newColor,int c1){
        if(sr>=0&&sc>=0&&sr<image.size()&&sc<image[0].size()&&image[sr][sc]==c1){
            
            image[sr][sc]=newColor;
           
                        dfs(image,sr+1,sc,newColor,c1);
                        dfs(image,sr-1,sc,newColor,c1);
                        dfs(image,sr,sc+1,newColor,c1);
                        dfs(image,sr,sc-1,newColor,c1);
          
        }
    }
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        // if(image[sr][sc]!=newColor){
        // dfs(image,sr,sc,newColor,image[sr][sc]);    
        // }
        
        if(image[sr][sc]==newColor||image.size()==0)return image;
        int m=image.size();
        int n=image[0].size();
        queue<pair<int,int>> q;
        q.push({sr,sc});
        int dx[4]={-1,1,0,0};
        int dy[4]={0,0,1,-1};
        int oldcolor=image[sr][sc];
        image[sr][sc]=newColor;
        
        while(!q.empty()){
            int k=q.size();
            while(k--){
                int x=q.front().first;
                int y=q.front().second;
                q.pop();
                for(int i=0;i<4;i++){
                    int nx=x+dx[i];
                    int ny=y+dy[i];
                    if(nx>=0&&nx<m&&ny>=0&&ny<n&&image[nx][ny]==oldcolor){
                        image[nx][ny]=newColor;
                        q.push({nx,ny});
                    }
                }
            }
        }
        return image;
    }
};