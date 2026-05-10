class Solution {
    public void islandsAndTreasure(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dist = new int[rows][cols];

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else if(grid[i][j] == -1){
                    dist[i][j] = -1;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            for(int[] dir: dirs) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                if(isValid(nextRow, nextCol, rows, cols)) {
                    if(grid[nextRow][nextCol] == Integer.MAX_VALUE && dist[nextRow][nextCol] > (1 + dist[currRow][currCol])) {
                        dist[nextRow][nextCol] = 1 + dist[currRow][currCol];
                        queue.add(new int[]{ nextRow, nextCol });
                    }
                }
            }
        }
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                grid[i][j] = dist[i][j];
            }
        }
    }

    private boolean isValid(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}
