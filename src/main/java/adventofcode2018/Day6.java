package adventofcode2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 {
	
	private static class Coordinate {
		@Override
		public String toString() {
			return "Coordinate [id=" + id + ", x=" + x + ", y=" + y + ", isInfinite=" + isInfinite + ", counter="
					+ counter + "]";
		}
		public Coordinate(int id, int x, int y) {
			this.id = id;
			this.x = x;
			this.y = y;
		}
		private int id;
		private int x;
		private int y;
		private boolean isInfinite = false;
		private int counter = 0;
	}
	
    public static void main(String[] args) {
    	int maxX = 350; 
    	int maxY = 350;
    	int regionsLessThan10000 = 0;
    	List<Coordinate> coordinateList = new ArrayList<>();
    	String[] lines = input.split("\\n");
    	for (int i = 0; i < lines.length; i++) {
			String[] xyStrings = lines[i].split(", ");
    		coordinateList.add(new Coordinate(i, Integer.parseInt(xyStrings[0]), Integer.parseInt(xyStrings[1])));
		}
    	
    	// iterate grid and calculate closest distances
    	for (int i = 0; i < maxY; i++) {
			for (int j = 0; j < maxX; j++) {
				
				List<Integer> distances = new ArrayList<>();
				for (Coordinate coor : coordinateList) {
					distances.add(Math.abs(j - coor.x) + Math.abs(i - coor.y));
				}
				List<Integer> distancesCopy = new ArrayList<>(distances);
				Collections.sort(distancesCopy );
				if(distancesCopy.get(0) != distancesCopy.get(1)) {
					int index = distances.indexOf(distancesCopy.get(0));	
					coordinateList.get(index).counter++;
					
					if(i == 0 || j == 0 || i == maxY -1 || j == maxX - 1) {
						coordinateList.get(index).isInfinite = true;
					}
				}
				
				// part 2
				if( distances.stream().collect(Collectors.summingInt(Integer::intValue)) < 10_000) {
					regionsLessThan10000++;
				}
			}
		}
    	
    	coordinateList.sort((c1, c2) -> c1.counter - c2.counter);
    	coordinateList.stream().filter(c -> !c.isInfinite).forEach(System.out::println);
    	System.out.println(regionsLessThan10000);
    }

	 private final static String input = 
			"165, 169\n" + 
	 		"334, 217\n" + 
	 		"330, 227\n" + 
	 		"317, 72\n" + 
	 		"304, 232\n" + 
	 		"115, 225\n" + 
	 		"323, 344\n" + 
	 		"161, 204\n" + 
	 		"316, 259\n" + 
	 		"63, 250\n" + 
	 		"280, 205\n" + 
	 		"84, 282\n" + 
	 		"271, 158\n" + 
	 		"190, 296\n" + 
	 		"106, 349\n" + 
	 		"171, 178\n" + 
	 		"203, 108\n" + 
	 		"89, 271\n" + 
	 		"193, 254\n" + 
	 		"111, 210\n" + 
	 		"341, 343\n" + 
	 		"349, 311\n" + 
	 		"143, 172\n" + 
	 		"170, 307\n" + 
	 		"128, 157\n" + 
	 		"183, 315\n" + 
	 		"211, 297\n" + 
	 		"74, 281\n" + 
	 		"119, 164\n" + 
	 		"266, 345\n" + 
	 		"184, 62\n" + 
	 		"96, 142\n" + 
	 		"134, 61\n" + 
	 		"117, 52\n" + 
	 		"318, 72\n" + 
	 		"338, 287\n" + 
	 		"61, 215\n" + 
	 		"323, 255\n" + 
	 		"93, 171\n" + 
	 		"325, 249\n" + 
	 		"183, 171\n" + 
	 		"71, 235\n" + 
	 		"329, 306\n" + 
	 		"322, 219\n" + 
	 		"151, 298\n" + 
	 		"180, 255\n" + 
	 		"336, 291\n" + 
	 		"72, 300\n" + 
	 		"223, 286\n" + 
	 		"179, 257\n";
}
