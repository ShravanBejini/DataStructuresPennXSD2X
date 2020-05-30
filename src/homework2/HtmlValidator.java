package homework2;


import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		/* IMPLEMENT THIS METHOD! */
		
		Stack<HtmlTag> result = new Stack<HtmlTag>();
		
		while(tags.peek() != null) {
			if(tags.peek().isSelfClosing()) {
				tags.poll();
				continue;
			}
			
			if(tags.peek().isOpenTag())
				result.push(tags.poll());
			else {
				try {
					if(tags.peek().element.equals(result.peek().element)) {
						tags.poll();
						result.pop();
					}
				
					else
						return (result.isEmpty() ? null : result);
				}
				catch(Exception e) {
					return null;
				}
			}
		
		}
		
		return result; 
	}
	
}
