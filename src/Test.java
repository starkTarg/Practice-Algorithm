import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

public class Test {
	
	public static void main(String[] args) {
		Optional<String> opt = Optional.of("asd");
		System.out.println(opt.get());
		
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();
	}

}
