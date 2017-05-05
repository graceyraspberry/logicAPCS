
public class TruthColumn {
	private boolean[] truthtable_;
	
	public static void main(String args[]){
		TruthColumn myeval = new TruthColumn(4);
		System.out.println("Testing AND");
		boolean[] first = {true, true, false, false};
		boolean[] second = {true, false, true, false};
		System.out.println(printarr(myeval.and(first, second)));
		
		System.out.println("******************************************");
		
		System.out.println("Testing OR");
		System.out.println(printarr(myeval.or(first, second)));
		
		System.out.println("******************************************");
		
		System.out.println("Testing NEGATE");
		System.out.println(printarr(myeval.negate(first)));
		
		System.out.println("******************************************");
		
		System.out.println("Testing IMPLY");
		System.out.println(printarr(myeval.imply(first, second)));
		
		System.out.println("******************************************");
		
		System.out.println("Testing BICONDITIONAL");
		System.out.println(printarr(myeval.biconditional(first, second)));
		
		System.out.println("******************************************");
		
		System.out.println("Testing VALID - should be false");
		printBool(myeval.valid());
		
		boolean[] allTrue = {true, true, true, true};
		myeval.setTruthTable(allTrue);
		
		System.out.println(printBool(myeval.valid()));
		
		System.out.println("Testing VALID - should be true");
		
		System.out.println("******************************************");
		
		System.out.println("Testing Entails - should be false"); 
		
		TruthColumn table1 = new TruthColumn(4);
		boolean[] a = {true, true, true, false};
		table1.setTruthTable(a);
		
		System.out.println("******************************************");
		
		System.out.println(printBool(myeval.entails(a)));
		
		System.out.println("Testing Unsatisfiable - should be false"); 
		boolean[] allFalse = {false, false, false, false};
		System.out.println(printBool(myeval.unsatisfiable()));
		
		System.out.println("Testing Unsatisfiable - should be false"); 
		
	}
	
	/**
	 * Constructor that creates a boolean array with a certain length
	 * @param length the size of the truthtable boolean array
	 */
	public TruthColumn(int length){
		truthtable_ = new boolean[length];
	}
	
	/**
	 * Mutator for ease of use in testing
	 * @param arr the boolean values to be assigned to the truthtable
	 */
	public void setTruthTable(boolean[] arr){
		truthtable_ = arr;
	}
	
	//LOGICAL OPERATORS ON A SINGLE SENTENCE WITH TWO PROPOSITIONAL CONSTANTS
	
	/**
	 * Returns a boolean array as a truth table for conducting propositional analysis with the "and" propositional constant
	 * @param a the boolean array of possible values for the first propositional constant
	 * @param b the boolean array of possible values for the second propositional constant
	 * @return truthtable, the boolean array with the truth table values
	 */
	public boolean[] and(boolean[] a, boolean[] b){
		for (int i = 0; i < a.length; i++){
			if (a[i] && b[i]){
				truthtable_[i] = true;
			} else {
				truthtable_[i] = false;
			}	
		}
		return truthtable_;
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
				truthtable_[i] = true;
			} else {
				truthtable_[i] = false;
			}
		}
		return truthtable_;
	}
	
	/**
	 * Evaluates the possible truth values of the negation statement
	 * @param a the boolean array of the values of the propositional constant being negated
	 * @return truthtable, the propagated truth table values of the evaluation
	 */
	public boolean[] negate(boolean[] a){
		for (int i = 0; i < a.length; i++){
			if(!a[i]){
				truthtable_[i] = true;
			} else {
				truthtable_[i] = false;
			}
		}
		return truthtable_;
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
				truthtable_[i] = false;
			} else {
				truthtable_[i] = true;
			}
		}
		return truthtable_;
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
				truthtable_[i] = true;
			} else {
				truthtable_[i] = false;
			}
		}
		return truthtable_;
	}
	
	//EVALUATES THE PROPERTIES OF TWO LOGICAL SENTENCES AND THE RELATIONSHIP OF THEIR TRUTH ASSIGNMENTS

	/**
	 * Evaluates the equivalence between truthTable and otherTruthTable
	 * @param otherTruthTable the set of truth values for a logical sentence
	 * @return true when otherTruthTable iff every assignment that satisfies otherTruthTable also satisfies TruthTable
	 */
	public boolean equivalent(boolean[] otherTruthTable){
		boolean equivalent = true;
		for (int i = 0; i < otherTruthTable.length; i++){
			if ((otherTruthTable[i] && !truthtable_[i]) || (!otherTruthTable[i] && truthtable_[i])){
				truthtable_[i] = true;
			} else {
				truthtable_[i] = false;
			}
		}
		return equivalent;
	}
	
	/**
	 * Returns logical entailment of the truthtable and the boolean[] otherTruthTable
	 * @param otherTruthTable the set of truth values in which truthTable will be evaluated against for entailment
	 * @return true if every truth assignment that satisfies truthtable also satisfies "a"
	 */
	public boolean entails(boolean[] otherTruthTable){
		boolean entails = true;
		for (int i = 0; i < otherTruthTable.length; i++){
			if (truthtable_[i] && !otherTruthTable[i]) entails = false;
		}
		return entails;
	}
	
	/**
	 * Evaluates logical consistency between "a" and the values in truthtable
	 * @param otherTruthTable the set of truth values
	 * @return true iff there is a truth assignment that satisfies both "otherTruthTable" and truthtable
	 */
	public boolean consistent(boolean[] otherTruthTable){
		boolean consistent = false;
		for (int i = 0; i < otherTruthTable.length; i++){
			if (truthtable_[i] && otherTruthTable[i]) consistent = true;
		}
		return consistent;
	}
	
	
	//TESTING LOGICAL PROPERTIES OF THE TRUTH TABLE (NO PARAMETERS)
	
	/**
	 * Returns the logical property of validity of the statement based on the truth table values in truthtable
	 * @return true if the sentence if it is satisfied by every truth assignment
	 */
	public boolean valid(){
		boolean valid = true;
		for (boolean a:truthtable_){
			if(!a) valid = false;
		}
		return valid;
	}
	
	/**
	 * Returns the logical property of unsatisfiablity of the statement by examining the truthtable
	 * @return true iff it is not satisfied by any truth assignment
	 */
	public boolean unsatisfiable(){
		boolean unsatisfiable = true;
		for (boolean a:truthtable_){
			if(a) unsatisfiable = false;
		}
		return unsatisfiable;
	}
	
	/**
	 * Returns the logical property of unsatisfiability of the statement based on the truth table
	 * @return true iff there is some truth assignment that satisfies it and some truth assignment that falsifies
	 */
	public boolean contingent(){
		boolean tpresent = false; //is there a true present
		boolean fpresent = false; //is there a false present
		for (boolean a:truthtable_){
			if (a) tpresent = true;
			if (!a) fpresent = true;
		}
		if (tpresent && fpresent) {
			return true;
		} else {
			return false;
		}
	}
	
	
	//HELPER METHODS THAT PRINT BOOLEAN ARRAYS OR SINGLE BOOLEAN VALUES
	
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
	
	/**
	 * Prints boolean as string "true" and "false"
	 * 
	 * @param bool the truth to be printed
	 * @return true or false
	 */
	public static String printBool(boolean bool){
		if (bool) {
			return "true";
		}
		else {
			return "false";
		}
	}

}
