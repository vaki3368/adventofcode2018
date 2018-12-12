package adventofcode2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.common.collect.Lists;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import com.google.common.graph.Traverser;

public class Day7 {
	
	private static class Dep implements Comparable<Dep> {
		@Override
		public String toString() {
			return "Dep [letter=" + letter + ", next=" + next + "]";
		}

		public Dep(String string) {
			letter = string;
		}
		private String letter;
		List<String> next = new LinkedList<>();
		
		@Override
		public int compareTo(Dep o) {
			return next.contains(o.letter) ? -1 : 1;
		}

	}
	
	
	
	public static void main(String[] args) {
		String[] lines = input.split("\\n");
		Arrays.sort(lines);
		

		final List<String> alphabet = IntStream.range('A', 'Z').mapToObj(i -> Character.toString((char) i))
				.collect(Collectors.toList());
		//recursive(new ArrayList<>(Arrays.asList(lines)), alphabet);

		Map<String, Dep> inputDeps = new HashMap<>();
		
		MutableGraph<String> graph = GraphBuilder.directed().build();
		
		for (int i = 0; i < lines.length; i++) {
			String[] inputLetters = lines[i].replace("Step ", "").replace(" must be finished before step", "")
					.replace(" can begin.", "").split(" ");
			
			
			inputDeps.putIfAbsent(inputLetters[0], new Dep(inputLetters[0]));
			
			inputDeps.get(inputLetters[0]).next.add(inputLetters[1]);
			

			
			System.out.println(inputLetters[0] + " -> " + inputLetters[1]);

			
			graph.putEdge(inputLetters[0], inputLetters[1]);

		}
		
		//list.forEach(System.out::print);
		
		//inputDeps.sort();
		//Collections.sort(inputDeps);
		//inputDeps.forEach(System.out::println);
		List<Dep> deps = new ArrayList<>(inputDeps.values());
		Collections.sort(deps);
		//deps.forEach(System.out::print);
		
		

		Set<String> found = new LinkedHashSet<>();
		
		//while (found == null) {
			
			alphabet.forEach(e -> {

				if (graph.successors(e).size() == 0) {

					found.add(e);
					//alphabet.addAll(graph.predecessors(e));
				}
				System.out.println(e + " - " + graph.predecessors(e) + " - " + graph.successors(e));

			});
		//}
		
		//graph.
		
		Traverser.forGraph(graph).breadthFirst(Arrays.asList("B","E", "U", "V")).forEach(System.out::print);
		System.out.println();
//		Traverser.forGraph(graph).depthFirstPreOrder(Arrays.asList("B","E", "U", "V")).forEach(System.out::print);
//		
//		System.out.println();
//		Traverser.forGraph(graph).depthFirstPostOrder(Arrays.asList("B","E", "U", "V")).forEach(System.out::print);
		
		List<String> proof = new ArrayList((Collection) Traverser.forGraph(graph).breadthFirst(Arrays.asList("B","E", "U", "V")));
		for (int i = 0; i < lines.length; i++) {
			String[] inputLetters = lines[i].replace("Step ", "").replace(" must be finished before step", "")
					.replace(" can begin.", "").split(" ");
			
		}
		
		
	}

	public static void recursive(List<String> _lines, List<String> _alphabet) {
		MutableGraph<String> graph = GraphBuilder.directed().build();
		
		List<String> lines = new ArrayList<>(_lines);
		List<String> alphabet = new ArrayList<>(_alphabet);

		for (String line : lines) {
			String[] inputLetters = line.replace("Step ", "").replace(" must be finished before step", "")
					.replace(" can begin.", "").split(" ");
			graph.putEdge(inputLetters[0], inputLetters[1]);

		}

		Set<String> found = new LinkedHashSet<>();

		alphabet.forEach(e -> {

			if (graph.predecessors(e).size() == 0) {

				found.add(e);
				System.out.println(e);
			}
		});
		
		alphabet.removeAll(found);

		found.forEach(e -> {
			System.out.println(lines.removeIf(l -> l.contains("Step " + e)));
		});
		recursive(lines, alphabet);

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
