
public class TruthColumn {
	private boolean[] representation;
	
	public static void main(String args[]){
		TruthColumn myeval = new TruthColumn(4);
		boolean[] first = {true, true, false, false};
		boolean[] second = {true, false, true, false};
		System.out.println(printarr(myeval.and(first, second)));
		
	}
	
	/**
	 * Constructor that creates a boolean array with a certain length
	 * @param length the size of the representation boolean array
	 */
	public TruthColumn(int length){
		representation = new boolean[length];
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean[] and(boolean[] a, boolean[] b){
		for (int i = 0; i < a.length; i++){
			if (a[i] && b[i]){
				representation[i] = true;
			} else {
				representation[i] = false;
			}
				
		}
		return representation;
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean[] or(boolean[] a, boolean[] b){
		for (int i = 0; i < a.length; i++){
			if (a[i] || b[i]){
				representation[i] = true;
			} else {
				representation[i] = false;
			}
		}
		return representation;
	}
	
	/**
	 * 
	 * @param a
	 * @return
	 */
	public boolean[] negate(boolean[] a){
		for (int i = 0; i < a.length; i++){
			if(!a[i]){
				representation[i] = true;
			} else {
				representation[i] = false;
			}
		}
		return representation;
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean[] imply(boolean[] a, boolean[] b){
		for (int i = 0; i < a.length; i++){
			if (a[i] && !b[i]){
				representation[i] = false;
			} else {
				representation[i] = true;
			}
		}
		return representation;
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean[] biconditional(boolean[] a, boolean[] b){
		for (int i = 0; i < a.length; i++){
			if (a[i] == b[i]){
				representation[i] = true;
			} else {
				representation[i] = false;
			}
		}
		return representation;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean valid(){
		boolean valid = true;
		for (boolean a:representation){
			if(!a) valid = false;
		}
		return valid;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean unsatisfiable(){
		boolean unsatisfiable = true;
		for (boolean a:representation){
			if(a) unsatisfiable = false;
		}
		return unsatisfiable;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean contingent(){
		boolean tpresent = false;
		boolean fpresent = false;
		for (boolean a:representation){
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
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean[] equivalent(boolean[] a, boolean[] b){
		for (int i = 0; i < a.length; i++){
			if (a[i] == b[i]){
				representation[i] = true;
			} else {
				representation[i] = false;
			}
		}
		return representation;
	}
	
	/**
	 * 
	 * @param a
	 * @return
	 */
	public boolean entails(boolean[] a){
		boolean entails = true;
		for (int i = 0; i < a.length; i++){
			if (representation[i] && !a[i]) entails = false;
			if (a[i] && !representation[i]) entails = false;
		}
		return entails;
	}
	
	/**
	 * 
	 * @param a
	 * @return
	 */
	public boolean consistent(boolean[] a){
		boolean consistent = false;
		for (int i = 0; i < a.length; i++){
			if (representation[i] && a[i]) consistent = true;
		}
		return consistent;
	}
	
	/**
	 * 
	 * 
	 * @param arr
	 * @return
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
