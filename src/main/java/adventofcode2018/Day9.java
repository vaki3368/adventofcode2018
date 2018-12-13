package adventofcode2018;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Day9 {

	public static void main(String[] args) {
		int players = 464; //464;//464;
		int lastMarble = 71730 * 100;// 71730 * 100;//71730 * 100;
		Deque<Integer> input = new ArrayDeque<>();
		long[] playerPoints = new long[players];
		Arrays.fill(playerPoints, 0);
		long highScore = 0;
		input.addFirst(0);
		for (int i = 1; i <= lastMarble; i++) {
			int currentPlayer = i % players;

			if (i % 23 == 0) {
				playerPoints[currentPlayer] += i;

				for (int j = 0; j < 6; j++) {
					input.addLast(input.remove());
				}
				
				playerPoints[currentPlayer] += input.pop();

				if (playerPoints[currentPlayer] > highScore) {
					highScore = playerPoints[currentPlayer];
				}
			} else {
				input.addFirst(input.removeLast());
				input.addFirst(input.removeLast());
				input.addLast(i);
			}
			//System.out.println(Iterables.toString(input));
			//System.out.println(Arrays.toString(playerPoints));
		}
		System.out.println(highScore);
	}
}
