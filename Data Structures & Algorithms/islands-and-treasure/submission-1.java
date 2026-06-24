
class Solution {
    class Pair{
        int row;
        int col;
        int dis;
        Pair(int row,int col,int dis){
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int inf = 2147483647;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                if (grid[i][j]==0) {
                    
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};

        while(!q.isEmpty()){
            Pair p = q.remove();
            int r = p.row;
            int c = p.col;
            int d = p.dis;
            grid[r][c]=d;
            for(int k=0;k<4;k++){
                int nrow = r+drow[k];
                int ncol = c+dcol[k];
                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0&&grid[nrow][ncol]!=-1){
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,d+1));
                }
            }
        }

    }
}
