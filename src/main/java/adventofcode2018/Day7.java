package adventofcode2018;

import java.util.LinkedHashSet;

public class Day7 {
	
    public static void main(String[] args) {
    	String[] lines = input.split("\\n");
    	LinkedHashSet<String> set = new LinkedHashSet<String>();
    	for (int i = 0; i < lines.length; i++) {
			String[] inputLetters = lines[i].replace("Step ", "").replace(" must be finished before step", "").replace(" can begin.", "").split(" ");
			
		}
    }

	private static final String input = 
			"Step V must be finished before step H can begin.\n" + 
			"Step U must be finished before step R can begin.\n" + 
			"Step E must be finished before step D can begin.\n" + 
			"Step B must be finished before step R can begin.\n" + 
			"Step W must be finished before step X can begin.\n" + 
			"Step A must be finished before step P can begin.\n" + 
			"Step T must be finished before step L can begin.\n" + 
			"Step F must be finished before step C can begin.\n" + 
			"Step P must be finished before step Y can begin.\n" + 
			"Step N must be finished before step G can begin.\n" + 
			"Step R must be finished before step S can begin.\n" + 
			"Step D must be finished before step C can begin.\n" + 
			"Step O must be finished before step K can begin.\n" + 
			"Step L must be finished before step J can begin.\n" + 
			"Step J must be finished before step H can begin.\n" + 
			"Step M must be finished before step I can begin.\n" + 
			"Step G must be finished before step K can begin.\n" + 
			"Step Z must be finished before step Q can begin.\n" + 
			"Step X must be finished before step Q can begin.\n" + 
			"Step H must be finished before step I can begin.\n" + 
			"Step K must be finished before step Y can begin.\n" + 
			"Step Q must be finished before step S can begin.\n" + 
			"Step I must be finished before step Y can begin.\n" + 
			"Step S must be finished before step Y can begin.\n" + 
			"Step C must be finished before step Y can begin.\n" + 
			"Step T must be finished before step S can begin.\n" + 
			"Step P must be finished before step S can begin.\n" + 
			"Step I must be finished before step S can begin.\n" + 
			"Step V must be finished before step O can begin.\n" + 
			"Step O must be finished before step Q can begin.\n" + 
			"Step T must be finished before step R can begin.\n" + 
			"Step E must be finished before step J can begin.\n" + 
			"Step F must be finished before step S can begin.\n" + 
			"Step O must be finished before step H can begin.\n" + 
			"Step Z must be finished before step S can begin.\n" + 
			"Step D must be finished before step Z can begin.\n" + 
			"Step F must be finished before step K can begin.\n" + 
			"Step W must be finished before step P can begin.\n" + 
			"Step G must be finished before step I can begin.\n" + 
			"Step B must be finished before step T can begin.\n" + 
			"Step G must be finished before step Y can begin.\n" + 
			"Step X must be finished before step S can begin.\n" + 
			"Step B must be finished before step K can begin.\n" + 
			"Step V must be finished before step A can begin.\n" + 
			"Step U must be finished before step N can begin.\n" + 
			"Step T must be finished before step P can begin.\n" + 
			"Step V must be finished before step D can begin.\n" + 
			"Step G must be finished before step X can begin.\n" + 
			"Step B must be finished before step D can begin.\n" + 
			"Step R must be finished before step J can begin.\n" + 
			"Step M must be finished before step Z can begin.\n" + 
			"Step U must be finished before step Z can begin.\n" + 
			"Step U must be finished before step G can begin.\n" + 
			"Step A must be finished before step C can begin.\n" + 
			"Step H must be finished before step Q can begin.\n" + 
			"Step X must be finished before step K can begin.\n" + 
			"Step B must be finished before step S can begin.\n" + 
			"Step Q must be finished before step C can begin.\n" + 
			"Step Q must be finished before step Y can begin.\n" + 
			"Step R must be finished before step I can begin.\n" + 
			"Step V must be finished before step Q can begin.\n" + 
			"Step A must be finished before step D can begin.\n" + 
			"Step D must be finished before step S can begin.\n" + 
			"Step K must be finished before step S can begin.\n" + 
			"Step G must be finished before step C can begin.\n" + 
			"Step D must be finished before step O can begin.\n" + 
			"Step R must be finished before step H can begin.\n" + 
			"Step K must be finished before step Q can begin.\n" + 
			"Step W must be finished before step R can begin.\n" + 
			"Step H must be finished before step Y can begin.\n" + 
			"Step P must be finished before step J can begin.\n" + 
			"Step N must be finished before step Z can begin.\n" + 
			"Step J must be finished before step K can begin.\n" + 
			"Step W must be finished before step M can begin.\n" + 
			"Step A must be finished before step Z can begin.\n" + 
			"Step V must be finished before step W can begin.\n" + 
			"Step J must be finished before step X can begin.\n" + 
			"Step U must be finished before step F can begin.\n" + 
			"Step P must be finished before step L can begin.\n" + 
			"Step W must be finished before step G can begin.\n" + 
			"Step T must be finished before step F can begin.\n" + 
			"Step R must be finished before step C can begin.\n" + 
			"Step R must be finished before step O can begin.\n" + 
			"Step Z must be finished before step C can begin.\n" + 
			"Step E must be finished before step S can begin.\n" + 
			"Step L must be finished before step I can begin.\n" + 
			"Step U must be finished before step O can begin.\n" + 
			"Step W must be finished before step K can begin.\n" + 
			"Step K must be finished before step I can begin.\n" + 
			"Step O must be finished before step M can begin.\n" + 
			"Step V must be finished before step M can begin.\n" + 
			"Step V must be finished before step Z can begin.\n" + 
			"Step A must be finished before step I can begin.\n" + 
			"Step F must be finished before step J can begin.\n" + 
			"Step F must be finished before step O can begin.\n" + 
			"Step M must be finished before step C can begin.\n" + 
			"Step Q must be finished before step I can begin.\n" + 
			"Step H must be finished before step S can begin.\n" + 
			"Step U must be finished before step A can begin.\n" + 
			"Step J must be finished before step S can begin.\n" + 
			"Step P must be finished before step Z can begin.\n";
}
