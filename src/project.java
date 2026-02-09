package javaProject3;

public class project {


	    //  We use Recursive function to find the top performer with  the Given Data
	    static int topRecursive(double percent[], int i, int best, int n) {
	        if (i == n)
	            return best;

	        if (percent[i] > percent[best])
	            best = i;

	        return topRecursive(percent, i + 1, best, n);
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of students: ");
	        int n = sc.nextInt();

	        String name[] = new String[n];

	        //  We use 2D arrays for : [][0] =  No.of classes attended, [][1] = Total no.of classes 
	        int attendance[][] = new int[n][2];

	        double percent[] = new double[n];
	        String remark[] = new String[n];

	        // Input
	        for (int i = 0; i < n; i++) {
	            System.out.print("\nEnter name of student " + (i + 1) + ": ");
	            name[i] = sc.next();
	            System.out.print(" Number of Classes attended: ");
	            attendance[i][0] = sc.nextInt();
	            System.out.print("Total Number of  classes: ");
	            attendance[i][1] = sc.nextInt();
	        }

	        System.out.println("\n--- Attendance Report ---");

	        int shortage = 0;

	        for (int i = 0; i < n; i++) {
	            percent[i] = (attendance[i][0] * 100.0) / attendance[i][1];

	            if (percent[i] >= 90)
	                remark[i] = "Excellent Attendance";
	            else if (percent[i] >= 75)
	                remark[i] = "Good Attendance";
	            else if (percent[i] >= 60)
	                remark[i] = "Average - Be Regular";
	            else {
	                remark[i] = "Poor - Warning Issued";
	                shortage++;
	            }

	            // Replaced printf with simple println
	            System.out.println(name[i] + " | " + percent[i] + "% | " + remark[i]);
	        }

	        System.out.println("\nNumber of students with attendance shortage (<75%): " + shortage);

	        // Find top performer using recursion
	        int top = topRecursive(percent, 0, 0, n);

	        System.out.println("\nTop Performer (Attendance): " + name[top] + " with " + percent[top] + "% attendance");
	        
	    }
}
}
