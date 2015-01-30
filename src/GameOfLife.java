
public class GameOfLife {
	boolean[][]game;

    public GameOfLife(int rows, int cols) {
    	game= new boolean[rows][cols];
    }

    public int numberOfRows() {
    	return game.length;
    }

    public int numberOfColumns() {
    	return game[0].length;
    }

    public void growCellAt(int row, int col) {
    	if(row < game.length && col < game[0].length)
    	game[row][col]=true;
    }

    public boolean cellAt(int row, int col) {
    	if(game[row][col] == true)
    		return true;
        return false;
    }

    /**
     * Return one big string of cells to represent the current state of the
     * society of cells (see output below where '.' represents an empty space
     * and 'O' is a live cell. There is no need to test toString. Simply use it
     * to visually inspect if needed. Here is one sample output from toString:
     *
     * GameOfLife society = new GameOfLife(4, 14); society.growCellAt(1, 2);
     * society.growCellAt(2, 3); society.growCellAt(3, 4);
     * System.out.println(society.toString());
     *
     * Output .............. ..O........... ...O.......... ....O.........
     *
     * @return A textual representation of this society of cells.
     */
    @Override
    public String toString() {
    	String sub= new String("");
		for(int n=0; n<game.length; n++){

    	for(int i=0; i<game[0].length; i++){
    			if(game[n][i] == true)
    				sub+="0";
    			else{sub+=".";
    			}
    			
    		}
    	}
       return sub;
    }

    /**
     * Count the neighbors around the given location. Use wraparound. A cell in
     * row 0 has neighbors in the last row if a cell is in the same column, or
     * the column to the left or right. In this example, cell 0,5 has two
     * neighbors in the last row, cell 2,8 has four neighbors, cell 2,0 has four
     * neighbors, cell 1,0 has three neighbors. The cell at 3,8 has 3 neighbors.
     * The potential location for a cell at 4,8 would have three neighbors.
     *
     * .....O..O
     * O........
     * O.......O
     * O.......O
     * ....O.O..
     *
     *
     * The return values should always be in the range of 0 through 8.
     *
     * @return The number of neighbors around any cell using wrap around.
     */
    public int neighborCount(int row, int col){
    	int count = 0;
    	for(int r= -1; r < 2; r++){
    		for(int i= -1; i < 2; i++)
    			{if(r == 0 && i == 0)
    			{}
    			else{
    			if(game[(game.length + (row + i)) % game.length][(game[0].length + (col + r)) % game[0].length])
    				count +=1;
    			}
    			}
    	}
    	return count;
    	
    
    }
    
/*int count= 0;
if (row - 1 < 0 || col - 1 < 0 || row+1==game.length || col+1== game[0].length) {
for (int i = row - 1; i < row + 1; i++) {
for (int n = col - 1; n < col + 1; n++) {
if (i< 0 && n < 0) {
if (game[game.length - 1][game[0].length - 1])
count++;
} else if (i == game.length && n == game[0].length) {
	if (game[game.length - 1][0])
		count++;



}
 else if (i < 0) {
if (game[game.length - 1][n])
count++;
else if (n < 0) {
if (game[i][game[0].length - 1])
count++;

}
else if(game[i][n])
count++;
    	
    }
}
}
}
return count;
    }
    

    /**
     * Update the state to represent the next society. Typically, some cells
     * will die off while others are born.
     */
    public void update() {
     for(int i=0; i < game.length; i++){
      for(int n= 0; n< game[0].length; n++){
    	 int neighbors= neighborCount(i,n);
    	 if(neighbors == 3 && game[i][n]==false)
    		 growCellAt(i,n);
     }
     }
     for(int i=0; i < game.length; i++)
     { for(int n= 0; n< game[0].length; n++){
    	 if(game[i][n]==true && neighborCount(i,n) < 2)
    		 game[i][n]=false;
    	 if(game[i][n]==true && neighborCount(i,n) >3)
    		 game[i][n]=false;
     }
    }
    }
}
