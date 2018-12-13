package adventofcode2018;

public class Day11 {

	public static void main(String[] args) {
		final int serial = 7689; //7689;
		int[][] matrix = new int[301][301];
		
		for (int i = 1; i < matrix.length; i++) {
			// iterate over Y
			for (int j = 1; j < matrix[i].length; j++) {
				// iterate over X
				int rackId = j + 10;
				int i1 = rackId * i;
				int powerLevel = ((i1 + serial) * rackId) % 1000 / 100 - 5;
				matrix[i][j] = powerLevel;
			}
		}
		
		int maxValue = 0;
		int maxSquareSize  = 1;
		int x = 1;
		int y = 1;
		//int size = 3;
		
		
		
		for (int mSize = 1; mSize < 301; mSize++) {
			for (int i = 1; i < matrix.length - mSize - 1; i++) {
				// iterate over Y
				for (int j = 1; j < matrix[i].length - mSize - 1; j++) {

					int localPower = 0;

					for (int k = 0; k < mSize; k++) {
						for (int k2 = 0; k2 < mSize; k2++) {
							localPower += matrix[i + k][j + k2];
						}
					}

					if (localPower > maxValue) {
						maxValue = localPower;
						x = j;
						y = i;
						maxSquareSize = mSize;
					}
				}
			} 
		}
		System.out.println("value: " +maxValue + " maxSquare: " + maxSquareSize + " - " + x + "," + y);
	}

}
