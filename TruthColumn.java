
public class TruthColumn {
	private boolean[] truthtable;
	
	public static void main(String args[]){
		TruthColumn myeval = new TruthColumn(4);
		boolean[] first = {true, true, false, false};
		boolean[] second = {true, false, true, false};
		System.out.println(printarr(myeval.and(first, second)));
		
	}
	
	/**
	 * Constructor that creates a boolean array with a certain length
	 * @param length the size of the truthtable boolean array
	 */
	public TruthColumn(int length){
		truthtable = new boolean[length];
	}
	
	/**
	 * Returns a boolean array as a truth table for conducting propositional analysis with the "and" propositional constant
	 * @param a the boolean array of possible values for the first propositional constant
	 * @param b the boolean array of possible values for the second propositional constant
	 * @return truthtable, the boolean array with the truth table values
	 */
	public boolean[] and(boolean[] a, boolean[] b){
		for (int i = 0; i < a.length; i++){
			if (a[i] && b[i]){
				truthtable[i] = true;
			} else {
				truthtable[i] = false;
			}	
		}
		return truthtable;
	}
	
	/**
	 * Evaluates and propagates a truth table of values after evaluating the values in "or" operator sentence
	 * @param a the boolean array of possible values for the first propositional constant
	 * @param b the boolean array of possible values for the second propositional constant
	 * @return
	 */
	public boolean[] or(boolean[] a, boolean[] b){
		for (int i = 0; i < a.length; i++){
			if (a[i] || b[i]){
				truthtable[i] = true;
			} else {
				truthtable[i] = false;
			}
		}
		return truthtable;
	}
	
	/**
	 * Evaluates the possible truth values of the negation statement
	 * @param a the boolean array of the values of the propositional constant being negated
	 * @return truthtable, the propagated truth table values of the evaluation
	 */
	public boolean[] negate(boolean[] a){
		for (int i = 0; i < a.length; i++){
			if(!a[i]){
				truthtable[i] = true;
			} else {
				truthtable[i] = false;
			}
		}
		return truthtable;
	}
	/**
	 * Evaluates and propagates a truth table of the value of an implication sentence
	 * @param a the values of the first propositional constant
	 * @param b the values of the second propositional constant
	 * @return truthtable, the propagated truth table with values of the implication
	 */
	public boolean[] imply(boolean[] a, boolean[] b){
		for (int i = 0; i < a.length; i++){
			if (a[i] && !b[i]){
				truthtable[i] = false;
			} else {
				truthtable[i] = true;
			}
		}
		return truthtable;
	}
	
	/**
	 * Evaluates and propagates a truth table of the values from a biconditional sentence
	 * @param a the values of the first propositional constant
	 * @param b the values of the second propositional constant
	 * @return truthtable, the boolean truth table with values from the evaluation of the biconditional
	 */
	public boolean[] biconditional(boolean[] a, boolean[] b){
		for (int i = 0; i < a.length; i++){
			if (a[i] == b[i]){
				truthtable[i] = true;
			} else {
				truthtable[i] = false;
			}
		}
		return truthtable;
	}
	
	/**
	 * Returns the logical property of validity of the statement based on the truth table values in truthtable
	 * @return true if the sentence if it is satisfied by every truth assignment
	 */
	public boolean valid(){
		boolean valid = true;
		for (boolean a:truthtable){
			if(!a) valid = false;
		}
		return valid;
	}
	
	/**
	 * Returns the logical property of unsatisfiablity of the statement by examining the truthtable
	 * @return true iff it is not satisfied by every truth assignment
	 */
	public boolean unsatisfiable(){
		boolean unsatisfiable = true;
		for (boolean a:truthtable){
			if(a) unsatisfiable = false;
		}
		return unsatisfiable;
	}
	
	/**
	 * Returns the logical property of unsatisfiability of the statement based on the truth table
	 * @return true iff there is some truth assignment that satisfies it and some truth assignment that falsifies
	 */
	public boolean contingent(){
		boolean tpresent = false;
		boolean fpresent = false;
		for (boolean a:truthtable){
			if (a) tpresent = true;
			if (!a) fpresent = true;
		}
		if (tpresent && fpresent) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Populates the truthtable with the values evaluated from the two sets of truth values based on equivalence
	 * @param a the set of truth values for first propositional constant
	 * @param b the set of truth values for second propositional constant
	 * @return truthtable, the boolean array with the truth values evaluated from the given arrays
	 */
	public boolean[] equivalent(boolean[] a, boolean[] b){
		for (int i = 0; i < a.length; i++){
			if (a[i] == b[i]){
				truthtable[i] = true;
			} else {
				truthtable[i] = false;
			}
		}
		return truthtable;
	}
	
	/**
	 * Returns logical entailment of the truthtable and the boolean[] a
	 * @param a the set of truth values in which entailment will be evaluated against
	 * @return true iff every truth assignment that satisfies truthtable also satisfies "a"
	 */
	public boolean entails(boolean[] a){
		boolean entails = true;
		for (int i = 0; i < a.length; i++){
			if (truthtable[i] && !a[i]) entails = false;
			if (a[i] && !truthtable[i]) entails = false;
		}
		return entails;
	}
	
	/**
	 * Evaluates logical consistency between "a" and the values in truthtable
	 * @param a the set of truth values
	 * @return true iff there is a truth assignment that satisfies both "a" and truthtable
	 */
	public boolean consistent(boolean[] a){
		boolean consistent = false;
		for (int i = 0; i < a.length; i++){
			if (truthtable[i] && a[i]) consistent = true;
		}
		return consistent;
	}
	
	/**
	 * Prints each element of boolean array with "true" and "false"
	 * 
	 * @param arr the boolean array to be printed
	 * @return the concatenated String of boolean values
	 */
	public static String printarr(boolean[] arr){
		String retval = "";
		for (boolean a:arr){
			if (a == false) retval += "false";
			if (a == true) retval += "true";
			retval += " ";
		}
		return retval;
	}

}
