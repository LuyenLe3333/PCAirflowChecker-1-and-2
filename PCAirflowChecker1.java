//lle00
//Luyen Le
//8/31/24
//PCAirflowChecker1

import java.util.Scanner;

public class PCAirflowChecker1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		//**********************************************************************************************		
		//      ===== ASKING FOR INTAKE INFO =====
		System.out.print("How many intakes do you have? -> ");
		int intakeInput = scan.nextInt();

		int intakes = intakeInput;
		double totalIntakeCFM = 0.00;

		for(int i = 1; i <= intakes; i++) {
			System.out.print("What is the CFM rate of intake fan #" + i + "? -> ");
			double intakeCFM = scan.nextDouble();
			totalIntakeCFM = calcCFM(totalIntakeCFM, intakeCFM);
		}

		System.out.printf("Total Intake CFM -> %.2f", totalIntakeCFM);
		System.out.println();
		System.out.println();

		//**********************************************************************************************		
		//      ===== ASKING FOR EXHAUST INFO =====
		System.out.print("How many exhausts do you have? -> ");
		int exhaustInput = scan.nextInt();

		int exhausts = exhaustInput;
		double totalExhaustCFM = 0.00;

		for(int e = 1; e <= exhausts; e++) {
			System.out.print("What is the CFM rate of exhaust fan #" + e + "? -> ");
			double exhaustCFM = scan.nextDouble();
			totalExhaustCFM = calcCFM(totalExhaustCFM, exhaustCFM);
		}

		System.out.printf("Total Exhaust CFM -> %.2f", totalExhaustCFM);
		System.out.println();
		System.out.println();

		//**********************************************************************************************		
		//      ===== DO YOU HAVE POSITIVE OR NEGATIVE PRESSURE =====
		double totalCFM = totalIntakeCFM - totalExhaustCFM;

		if(totalCFM < 0) {
			System.out.printf("Total Airflow CFM Negative Pressure of -> %.2f in your pc", totalCFM);
		} else if (totalCFM > 0) {
			System.out.printf("Total Airflow CFM Positive Pressure of -> %.2f", totalCFM);
		} else {
			System.out.printf("Total Airflow CFM Neutral Pressure of -> %.2f", totalCFM);
		}

		//**********************************************************************************************		
		scan.close();
	}

	public static double calcCFM(double numFans, double fanCFM) {
		return numFans += fanCFM;
	}
}