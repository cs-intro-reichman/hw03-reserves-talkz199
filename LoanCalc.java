/**
* Computes the periodical payment necessary to re-pay a given loan.
*/
public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter;    // Monitors the efficiency of the calculation
	
    /** 
     * Gets the loan data and computes the periodical payment.
     * Expects to get three command-line arguments: sum of the loan (double),
     * interest rate (double, as a percentage), and number of payments (int).  
     */
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
	
	/**
	* Uses a sequential search method  ("brute force") to compute an approximation
	* of the periodical payment that will bring the ending balance of a loan close to 0.
	* Given: the sum of the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
    	double guess = loan / n; // Initial guess
		double increment = epsilon; // Increment
		iterationCounter = 0; // Reset iteration counter

		// Loop until the ending balance becomes non-positive
		while (endBalance(loan, rate, n, guess) > 0) {
			guess += increment; // Increment guess
			iterationCounter++; // Increment iteration counter
		}

		return guess; // Return the computed periodical payment
    }
    
    /**
	* Uses bisection search to compute an approximation of the periodical payment 
	* that will bring the ending balance of a loan close to 0.
	* Given: the sum of the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
	
		double lo = 0; 
		double hi = loan; 
		double guess = (lo + hi) / 2;
		
		iterationCounter = 0;
	
		while ((endBalance(loan, rate, n, guess)) > epsilon) {
			if (endBalance(loan, rate, n, guess) * endBalance(loan, rate, n, hi) > 0)
				hi = guess;
			else
				lo = guess; 
			guess = (lo + hi) / 2;
			iterationCounter++;
		}
		
		return guess;
	}
	
	/**
	* Computes the ending balance of a loan, given the sum of the loan, the periodical
	* interest rate (as a percentage), the number of periods (n), and the periodical payment.
	*/
	private static double endBalance(double loan, double rate, int n, double guess) {
		double endBalance = loan;
		for(int i = 0; i < n; i++){
			endBalance = (endBalance - guess) * (1 + rate / 100); // Update ending balance after payment and interest
		}
		
		return endBalance;
	}
}

