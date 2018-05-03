import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeIntervals {

	public static void main(String[] args) {
		MergeIntervals mergeIntervals = new MergeIntervals();
		List<Interval> intervalList = Stream
				.of(mergeIntervals.new Interval(6, 8), mergeIntervals.new Interval(1, 9),
						mergeIntervals.new Interval(2, 4), mergeIntervals.new Interval(4, 7))
				.sorted(Comparator.comparing(Interval::getStart)).collect(Collectors.toList());

		intervalList.forEach(interval -> System.out.println("Start: " + interval.start + " End: " + interval.end));

		System.out.println("================= MERGED LIST ============");
		merge(intervalList);
		
	}

	private static void merge(List<Interval> intervalList) {
		
		Stack<Interval> stack = new Stack<Interval>();
		intervalList.forEach(interval -> {
			if(stack.isEmpty()) {
				stack.push(interval);
			}
			
			// if overlaps
			if(interval.start <= stack.peek().end) {
				Interval top = stack.pop();
				top.end = Integer.max(top.end, interval.end);
				stack.push(top);
			} else {
				// no overlapping
				stack.push(interval);
			}
		});
		
		stack.forEach(interval -> System.out.println("Start: " + interval.start + " End: " + interval.end));
		
	}

	public class Interval {

		int start;

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

}
