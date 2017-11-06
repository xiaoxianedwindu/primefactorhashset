/*
 * HW4_104403016 資管3A 杜孝顯
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;


public class PrimeFactorCalc {

	public static void main(String[] args){
		int stopFlag = 0;
		int primeCount = 1;
		
		do{
		
			try{
				String entryString = JOptionPane.showInputDialog(null, "Enter a positive whole number","Finding Prime Numbers", JOptionPane.PLAIN_MESSAGE);
				if (entryString == null){
					//when user presses cancel or exit
					JOptionPane.showMessageDialog(null, "See ya!", "Goodbye", JOptionPane.PLAIN_MESSAGE);
					stopFlag = 1;
					System.exit(0);
				}
				int entryInt = Integer.parseInt(entryString);					//turn entry string into int
				int numberCheck = Integer.signum(entryInt);						//check if it is a positive whole integer
				if (numberCheck <= 0){											//if check returns 0 (zero) or -1 (negative number), prompt again
					JOptionPane.showMessageDialog(null, "Whoa! " +  entryInt +" is not a positive whole number!", "Not a positive whole number dude!", JOptionPane.WARNING_MESSAGE);
				} else {
					//when entry is a whole positive integer, the following happens
					HashSet<Integer> primeFac = new HashSet<Integer>();
					primeFac = primeFactor(entryInt);							//sends to primeFactor() for calculation and saves the returning HashSet to primeFac
					
					Set<Integer> primeSorted = new TreeSet<Integer>(primeFac);	//treeSet automatically sorts the factors in ascending order
					
					Iterator<Integer> primeSet = primeSorted.iterator();		//iterator calls the TreeSet data structure
					
					if (primeFac.size() == 1){
						if (entryInt == 1) {
							JOptionPane.showMessageDialog(null, " 1 is excluded as a prime number ", "ONE!", JOptionPane.PLAIN_MESSAGE);
						} else {
							//when the number is a prime number, this happens
							JOptionPane.showMessageDialog(null, primeSet.next() +" is a prime number.", "Prime Number!", JOptionPane.PLAIN_MESSAGE);
						}
						
						} else {
							//when the number has multiple prime factors, this happens
							while(primeSet.hasNext()){
								JOptionPane.showMessageDialog(null, primeSet.next() + " is a prime factor of " + entryInt, "Prime factor " + primeCount +" of " + primeFac.size(), JOptionPane.PLAIN_MESSAGE);
								primeCount++;
							}
					}
					primeCount = 1;												//resets primeCount for next input
					
				}
			
			} catch (NumberFormatException e) {
				//catch when entry is not a integer
				JOptionPane.showMessageDialog(null, "Oops! Not an integer!", "Yo! Not an integer!", JOptionPane.PLAIN_MESSAGE);
			}
			
		} while (stopFlag == 0);
	}

	public static HashSet<Integer> primeFactor(int n){
		HashSet<Integer> primes = new HashSet<Integer>();
        long copyOfInput = n;

        if (n == 1){
        	//when the entry is one
        	primes.add(n);
        } else {
        	//when the entry is not one, get all prime factors
        	for (int i = 2; i <= copyOfInput; i++) {
        		if (copyOfInput % i == 0) {
        			primes.add(i); 												//adds prime factor to HashSet
        			copyOfInput /= i;
        			i--;
        		}
        	}
        }
        
		return primes;
		
	}
	
}
