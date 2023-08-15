class Solution {
public:
// DFS solution ////

    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
   
            int m = image.size(); // row
            int n = image[0].size(); // coloum
            int orig = image[sr][sc];
            if(orig == color) return image;
             vector<vector<int>>dirs = {{0,1},{0,-1},{1,0},{-1,0}};
            dfs(image,sr,sc,orig,color,m,n,dirs);
           return image ; 
    }   

    void dfs(vector<vector<int>> image,int i,int j,int orig,int color,int m,int n, vector<vector<int>>dirs){

        if(i == m || j == n || i<0 || j<0 || image[i][j] != orig){
            return;
        }
        

        image[i][j]=color;
        cout<< "in dfs for I: "<< i << " and for J: " << j << "  " << image[i][j] << endl;
        for(vector<int> dir:dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(image,r,c,orig,color,m,n,dirs);
        }
    }
     
};



// BFS solution  /////

     
                  int m = image.size();
           int n = image[0].size(); // coloum
           int orig = image[sr][sc];
           if(image.size() == 0) return image;
            if(orig == color) return image;

        

       vector<vector<int>>dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        queue<int> q;

        q.push(sr);
        q.push(sc);
        image[sr][sc] = color;
         while(!q.empty()){
            int size = q.size();
            int k = size/2;
        for(int i=0;i<k;i++){
            int cr = q.front();
            q.pop();      
            int cc = q.front();
            q.pop(); 

            for(vector<int> dir:dirs){
                int r = cr + dir[0];
                int c = cc + dir[1];

                if(c>=0 && c<n && r>=0 && r<m && image[r][c] == orig ){
                        q.push(r);
                        q.push(c);
                        image[r][c] = color;
                   
                  }
                 }

             }

         }

     
    return image;
 }