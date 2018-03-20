package com.arnab.algos;


class LargestLand {
	
	int world[][];
	int row;
	int col;
	
	public LargestLand(int args[][]) {
		world = args;
		row = 4;
		col = 5;
	}
	
	public void findLargestLand() {
		boolean visited[][] = new boolean[row][col];
		for(int r = 0; r < row; r++) {
			for(int c  = 0; c< col; c++) {
				if(world[r][c] == 1 && !visited[r][c]) {
					int size = depthFirstSearch(visited, r, c, 0);
					System.out.println("Size:" + size);
				}
			}
		}
	}
	
	public int depthFirstSearch(boolean visited[][], int r, int c, int size) {
		int rowToVisit[] = {-1, -1, -1, 0, 0, 1, 1, 1};
		int colToVisit[] = {-1, 0, 1, -1, 1, -1, 0, 1};
		visited[r][c] = true;
		size++;
		System.out.println(r + ">" + c + "size:" + size);
		for(int i = 0; i < 8; i++) {
			boolean flag = isInsideMap(rowToVisit[i], colToVisit[i], r, c, visited);
			if (flag == true) {
				size = depthFirstSearch(visited, r + rowToVisit[i], c + colToVisit[i], size);
			}
		}
		return size;
	}
	
	public boolean isInsideMap(int vR, int vC, int r, int c, boolean visited[][]) {
		boolean flag = false;
		int tempR = vR + r;
		int tempC = vC + c;
		if((tempR >= 0 && tempR < this.row) && (tempC >= 0 && tempC < this.col) && world[tempR][tempC] == 1 
				&& !visited[tempR][tempC]) {
			return true;
		}
		return flag;
	}
}

public class LargestLandInWorld {

	public static void main(String[] args) {

		int world[][] = { 
				{1, 0, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1}};
		
		
		LargestLand land = new LargestLand(world);
		land.findLargestLand();
	}

}
