package adventofcode2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.Iterables;


public class Day9 {

	public static void main(String[] args) {
		int players = 464;
		int lastMarble = 71730 * 100;
		List<Integer> input = new LinkedList<>();
		int[] playerPoints = new int[players];
		Arrays.fill(playerPoints, 0);
		int highScore = 0;

		input.add(0);

		int pointer = 0;
		for (int i = 1; i <= lastMarble; i++) {

			if(i %10000 == 0)
			  System.out.println(i);
			int currentPlayer = i % players;

			if (i % 23 == 0) {
				playerPoints[currentPlayer] += i;

				int deletionIndex = (pointer - 7 + input.size()) % input.size();

				playerPoints[currentPlayer] += input.remove(deletionIndex + 1);

				if (playerPoints[currentPlayer] > highScore) {
					highScore = playerPoints[currentPlayer];
				}

				pointer = deletionIndex;

			} else {

				pointer = (pointer + 2) % input.size();
				input.add(1 + pointer, i);
			}

			// System.out.println(Iterables.toString(input));
			// System.out.println(Arrays.toString(playerPoints));
		}
		System.out.println(highScore);
	}
}
