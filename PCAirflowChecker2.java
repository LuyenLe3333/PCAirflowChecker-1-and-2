//lle00
//Luyen Le
//8/31/24
//PCAirflowChecker2

import java.util.Scanner;

public class PCAirflowChecker2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		//**********************************************************************************************		
		//      ===== ASKING FOR INTAKE INFO =====
		System.out.print("How many intakes do you have? -> ");
		int numIntakeFans = scan.nextInt();

		int intakes = numIntakeFans;
		double totalIntakesCFM = 0.00;

		System.out.print("What is the CFM rate of each intake fan? -> ");
		double intakeFanCFM = scan.nextDouble();

		System.out.printf("Total Intake CFM -> %.2f", calcCFM(numIntakeFans, intakeFanCFM));
		System.out.println();
		System.out.println();

		//*********************************************************************************************
		//      ===== ASKING FOR EXHAUST INFO =====
		System.out.print("How many exhausts do you have? -> ");
		int numExhaustFans = scan.nextInt();

		int exhausts = numExhaustFans;
		double totalExhaustsCFM = 0.00;

		System.out.print("What is the CFM rate of each exhaust fan? -> ");
		double exhaustFanCFM = scan.nextDouble();

		System.out.printf("Total Intake CFM -> %.2f", calcCFM(numExhaustFans, exhaustFanCFM));
		System.out.println();
		System.out.println();

		//*********************************************************************************************
		//      ===== DO YOU HAVE POSITIVE OR NEGATIVE PRESSURE =====
		double totalCFM = calcCFM(numIntakeFans, intakeFanCFM) - calcCFM(numExhaustFans, exhaustFanCFM);

		if(totalCFM < 0) {
			System.out.printf("Total Airflow CFM Negative Pressure of -> %.2f in your pc", totalCFM);
		} else if (totalCFM > 0) {
			System.out.printf("Total Airflow CFM Positive Pressure of -> %.2f", totalCFM);
		} else {
			System.out.printf("Total Airflow CFM Neutral Pressure of -> %.2f", totalCFM);
		}

		//*********************************************************************************************
		scan.close();
	}

	public static double calcCFM(int numFans, double fanCFM) {
		return numFans * fanCFM;
	}
}