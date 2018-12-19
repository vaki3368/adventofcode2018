package adventofcode2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;

import com.google.common.collect.Lists;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import com.google.common.graph.Traverser;

public class Day7 {
	
	
	private static class Worker {

		private int counter = 0;
		private String work;
		public void start(String l) {
			this.work = l;
			this.counter = l.charAt(0) - 4;
			
		}
		
		public boolean tick() {
			counter--;
			return counter == 0;
		}
	}
	
	private static class Dispatcher {
		private List<Worker> worker = new ArrayList<>();
		private int ticks = 0;
		
		public Dispatcher(int workerCount) {
			for (int i = 0; i < workerCount; i++) {
				worker.add(new Worker());
			}
		}
		
		private Worker getIdleWorker() {
			for (Worker w : worker) {
				if(w.counter == 0)
					return w;
			}
			return null;
		}
		
		public List<String> work(List<String> first) {
			Iterator<String> iterator = first.iterator();
			while (iterator.hasNext()) {
				String next = iterator.next();
				boolean alreadyQueued = false;
				for (Worker w : worker) {
					if (w.counter != 0 && w.work.equals(next)) {
						alreadyQueued = true;
					}
				} 
				
				if(!alreadyQueued)
				    getIdleWorker().start(next);
			}

			while (true) {
				ticks++;
				List<String> doneList = new ArrayList<>();
				for (Worker w : worker) {
					if (w.counter != 0) {
						if (w.tick()) {
							String result = w.work;
							w.work = "";
							doneList.add(result);
						}
					}
				} 
				if(!doneList.isEmpty()) {
					return doneList;
				}
			}
		}
	}

	public static void main(String[] args) {
		String[] lines = input.split("\\n");
		Map<String, List<String>> inputDeps = new HashMap<>();
		
		MutableGraph<String> graph = GraphBuilder.directed().build();
		
		for (int i = 0; i < lines.length; i++) {
			String[] inputLetters = lines[i].replace("Step ", "").replace(" must be finished before step", "")
					.replace(" can begin.", "").split(" ");
			
			inputDeps.putIfAbsent(inputLetters[1], new ArrayList<>());		
			inputDeps.get(inputLetters[1]).add(inputLetters[0]);					
			inputDeps.putIfAbsent(inputLetters[0], new ArrayList<>());
			
			graph.putEdge(inputLetters[0], inputLetters[1]);
		}

		String result = "";
		while(inputDeps.size() != 0) {
			List<String> first = new ArrayList<>();
			inputDeps.forEach( (k, v) -> {
				if (v.isEmpty()) {
					first.add(k);
				}
			});
			Collections.sort(first);
			String key = first.get(0);
			result += key;
			inputDeps.remove(key);
			inputDeps.forEach( (k, v) -> {
				v.remove(key);
			});
		}
		System.out.println(result);

		part2();
	}
	
	public static void part2() {
		String[] lines = input.split("\\n");
		Map<String, List<String>> inputDeps = new HashMap<>();
		
		for (int i = 0; i < lines.length; i++) {
			String[] inputLetters = lines[i].replace("Step ", "").replace(" must be finished before step", "")
					.replace(" can begin.", "").split(" ");
			
			inputDeps.putIfAbsent(inputLetters[1], new ArrayList<>());		
			inputDeps.get(inputLetters[1]).add(inputLetters[0]);					
			inputDeps.putIfAbsent(inputLetters[0], new ArrayList<>());
		}

		String result = "";
		Dispatcher dispatcher = new Dispatcher(5);
		
		while(inputDeps.size() != 0) {
			List<String> first = new ArrayList<>();
			inputDeps.forEach( (k, v) -> {
				if (v.isEmpty()) {
					first.add(k);
				}
			});
			Collections.sort(first);
			System.out.println(first);

			
			List<String> doneJobs = dispatcher.work(first);
			for (String key : doneJobs) {
				
				System.out.println("### " + key);
				result += key;
				inputDeps.remove(key);
				inputDeps.forEach( (k, v) -> {
					v.remove(key);
				});
			}
		}
		System.out.println(result);
		System.out.println(dispatcher.ticks);	
	}

	public static final String input = 
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
