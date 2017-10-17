package Project1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Testing {
	
	ArrayList<ArrayList<Integer>> studentPreferences = new ArrayList<ArrayList<Integer>>();
	ArrayList<ArrayList<Integer>> professorPreferences = new ArrayList<ArrayList<Integer>>();

	ArrayList<Integer> studentX = new ArrayList<Integer>();
	ArrayList<Integer> studentY = new ArrayList<Integer>();
	ArrayList<Integer> studentZ = new ArrayList<Integer>();
	ArrayList<Integer> professorA = new ArrayList<Integer>();
	ArrayList<Integer> professorB = new ArrayList<Integer>();
	ArrayList<Integer> professorC = new ArrayList<Integer>();


	@Test
	public void testBasic() {
    	
    	studentX.add(2);
    	studentX.add(1);
    	studentX.add(3);
    	studentPreferences.add(studentX);
    	
    	studentY.add(2);
    	studentY.add(3);
    	studentY.add(1);
    	studentPreferences.add(studentY);
    	
    	studentZ.add(1);
    	studentZ.add(3);
    	studentZ.add(2);
    	studentPreferences.add(studentZ);
    	
    	professorA.add(3);
    	professorA.add(2);
    	professorA.add(1);
    	professorPreferences.add(professorA);
    	
    	professorB.add(2);
    	professorB.add(3);
    	professorB.add(1);
    	professorPreferences.add(professorB);
    	
    	professorC.add(1);
    	professorC.add(2);
    	professorC.add(3);
    	professorPreferences.add(professorC);
    	
    	Preferences preference = new Preferences(3, 3, professorPreferences, studentPreferences);
    	    	
    	assertEquals(true, Assignment1.isStable(Assignment1.stableMatchBruteForce(preference), preference));
   	}
	
	@Test
	public void testEmpty() {
    	studentPreferences.add(studentX);
    	studentPreferences.add(studentY);
    	studentPreferences.add(studentZ);

    	professorPreferences.add(professorA);
    	professorPreferences.add(professorB);
    	professorPreferences.add(professorC);

    	Preferences preference = new Preferences(0, 0, professorPreferences, studentPreferences);
    	ArrayList<Integer> empty = new ArrayList<Integer>();
    	assertEquals(empty, Assignment1.stableMatchBruteForce(preference));
	}
	
	@Test
	public void test4GaleShapley() {
    	ArrayList<ArrayList<Integer>> studentPreferences = new ArrayList<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> professorPreferences = new ArrayList<ArrayList<Integer>>();
    	
    	ArrayList<Integer> studentX = new ArrayList<Integer>();
    	studentX.add(3);
    	studentX.add(2);
    	studentX.add(4);
    	studentX.add(1);
    	studentPreferences.add(studentX);
    	
    	ArrayList<Integer> studentY = new ArrayList<Integer>();
    	studentY.add(2);
    	studentY.add(3);
    	studentY.add(1);
    	studentY.add(4);
    	studentPreferences.add(studentY);
    	
    	ArrayList<Integer> studentZ = new ArrayList<Integer>();
    	studentZ.add(3);
    	studentZ.add(1);
    	studentZ.add(2);
    	studentZ.add(4);
    	studentPreferences.add(studentZ);
    	
    	ArrayList<Integer> studentZ1 = new ArrayList<Integer>();
    	studentZ1.add(3);
    	studentZ1.add(2);
    	studentZ1.add(4);
    	studentZ1.add(1);
    	studentPreferences.add(studentZ1);
    	
    	ArrayList<Integer> professorA = new ArrayList<Integer>();
    	professorA.add(4);
    	professorA.add(3);
    	professorA.add(1);
    	professorA.add(2);
    	professorPreferences.add(professorA);
    	
    	ArrayList<Integer> professorB = new ArrayList<Integer>();
    	professorB.add(2);
    	professorB.add(1);
    	professorB.add(3);
    	professorB.add(4);
    	professorPreferences.add(professorB);
    	
    	ArrayList<Integer> professorC = new ArrayList<Integer>();
    	professorC.add(1);
    	professorC.add(3);
    	professorC.add(4);
    	professorC.add(2);
    	professorPreferences.add(professorC);
    	
    	ArrayList<Integer> professorD = new ArrayList<Integer>();
    	professorD.add(4);
    	professorD.add(3);
    	professorD.add(1);
    	professorD.add(2);
    	professorPreferences.add(professorD);
    	
    	ArrayList<Integer> matchings = new ArrayList<Integer>();
    	matchings.add(1);
    	matchings.add(0);
    	matchings.add(2);
    	
    	Preferences preference = new Preferences(4, 4, professorPreferences, studentPreferences);    	
   
    	ArrayList<Integer> expected = new ArrayList<Integer>();
    	expected.add(2);
    	expected.add(1);
    	expected.add(0);
    	expected.add(3);
    	
    	// assertEquals(expected, Assignment1.stableMatchBruteForce(preference));
    	assertEquals(expected, Assignment1.stableMatchGaleShapley(preference));
	}

	@Test
	public void test4Costs() {

    	ArrayList<ArrayList<Integer>> studentPreferences = new ArrayList<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> professorPreferences = new ArrayList<ArrayList<Integer>>();
    	
    	ArrayList<Integer> studentX = new ArrayList<Integer>();
    	studentX.add(3);
    	studentX.add(2);
    	studentX.add(4);
    	studentX.add(1);
    	studentPreferences.add(studentX);
    	
    	ArrayList<Integer> studentY = new ArrayList<Integer>();
    	studentY.add(2);
    	studentY.add(3);
    	studentY.add(1);
    	studentY.add(4);
    	studentPreferences.add(studentY);
    	
    	ArrayList<Integer> studentZ = new ArrayList<Integer>();
    	studentZ.add(3);
    	studentZ.add(1);
    	studentZ.add(2);
    	studentZ.add(4);
    	studentPreferences.add(studentZ);
    	
    	ArrayList<Integer> studentZ1 = new ArrayList<Integer>();
    	studentZ1.add(3);
    	studentZ1.add(2);
    	studentZ1.add(4);
    	studentZ1.add(1);
    	studentPreferences.add(studentZ1);
    	
    	ArrayList<Integer> professorA = new ArrayList<Integer>();
    	professorA.add(4);
    	professorA.add(3);
    	professorA.add(1);
    	professorA.add(2);
    	professorPreferences.add(professorA);
    	
    	ArrayList<Integer> professorB = new ArrayList<Integer>();
    	professorB.add(2);
    	professorB.add(1);
    	professorB.add(3);
    	professorB.add(4);
    	professorPreferences.add(professorB);
    	
    	ArrayList<Integer> professorC = new ArrayList<Integer>();
    	professorC.add(1);
    	professorC.add(3);
    	professorC.add(4);
    	professorC.add(2);
    	professorPreferences.add(professorC);
    	
    	ArrayList<Integer> professorD = new ArrayList<Integer>();
    	professorD.add(4);
    	professorD.add(3);
    	professorD.add(1);
    	professorD.add(2);
    	professorPreferences.add(professorD);
    	
    	ArrayList<Integer> matchings = new ArrayList<Integer>();
    	matchings.add(1);
    	matchings.add(0);
    	matchings.add(2);
    	
    	Preferences preference = new Preferences(4, 4, professorPreferences, studentPreferences);    	
//
//    	ArrayList<Cost> result = Assignment1.stableMatchCosts(preference);
//    	for (int i = 0; i < 4; i++) {
//    		System.out.print(result.get(i).getIndexOfProfessor());
//    		System.out.print(result.get(i).getIndexOfStudent());
//    		System.out.print(result.get(i).getCostToProfessor());
//    		System.out.println(result.get(i).getCostToStudent());    		
//    	}    	
	}

	@Test
	public void test4CostToStudent() {
    	ArrayList<ArrayList<Integer>> studentPreferences = new ArrayList<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> professorPreferences = new ArrayList<ArrayList<Integer>>();
    	
    	ArrayList<Integer> studentX = new ArrayList<Integer>();
    	studentX.add(3);
    	studentX.add(2);
    	studentX.add(4);
    	studentX.add(1);
    	studentPreferences.add(studentX);
    	
    	ArrayList<Integer> studentY = new ArrayList<Integer>();
    	studentY.add(2);
    	studentY.add(3);
    	studentY.add(1);
    	studentY.add(4);
    	studentPreferences.add(studentY);
    	
    	ArrayList<Integer> studentZ = new ArrayList<Integer>();
    	studentZ.add(3);
    	studentZ.add(1);
    	studentZ.add(2);
    	studentZ.add(4);
    	studentPreferences.add(studentZ);
    	
    	ArrayList<Integer> studentZ1 = new ArrayList<Integer>();
    	studentZ1.add(3);
    	studentZ1.add(2);
    	studentZ1.add(4);
    	studentZ1.add(1);
    	studentPreferences.add(studentZ1);
    	
    	ArrayList<Integer> professorA = new ArrayList<Integer>();
    	professorA.add(4);
    	professorA.add(3);
    	professorA.add(1);
    	professorA.add(2);
    	professorPreferences.add(professorA);
    	
    	ArrayList<Integer> professorB = new ArrayList<Integer>();
    	professorB.add(2);
    	professorB.add(1);
    	professorB.add(3);
    	professorB.add(4);
    	professorPreferences.add(professorB);
    	
    	ArrayList<Integer> professorC = new ArrayList<Integer>();
    	professorC.add(1);
    	professorC.add(3);
    	professorC.add(4);
    	professorC.add(2);
    	professorPreferences.add(professorC);
    	
    	ArrayList<Integer> professorD = new ArrayList<Integer>();
    	professorD.add(4);
    	professorD.add(3);
    	professorD.add(1);
    	professorD.add(2);
    	professorPreferences.add(professorD);
    	
    	ArrayList<Integer> matchings = new ArrayList<Integer>();
    	matchings.add(1);
    	matchings.add(0);
    	matchings.add(2);
    	
    	Preferences preference = new Preferences(4, 4, professorPreferences, studentPreferences);    	
   
    	// System.out.println(Assignment1.stableMatchBruteForce(preference));
    	// System.out.println(Assignment1.stableMatchGaleShapley(preference));
    	
//    	ArrayList<Cost> result = Assignment1.stableMatchCostsStudent(preference);
//    	for (int i = 0; i < 4; i++) {
//    		System.out.print(result.get(i).getIndexOfProfessor());
//    		System.out.print(result.get(i).getIndexOfStudent());
//    		System.out.print(result.get(i).getCostToProfessor());
//    		System.out.println(result.get(i).getCostToStudent());    		
//    	}
	}

	@Test
	public void test7() {
    	ArrayList<ArrayList<Integer>> studentPreferences = new ArrayList<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> professorPreferences = new ArrayList<ArrayList<Integer>>();
    	
    	ArrayList<Integer> studentT = new ArrayList<Integer>();
    	studentT.add(4);
    	studentT.add(5);
    	studentT.add(3);
    	studentT.add(7);
    	studentT.add(2);
    	studentT.add(6);
    	studentT.add(1);
    	studentPreferences.add(studentT);
    	
    	ArrayList<Integer> studentU = new ArrayList<Integer>();
    	studentU.add(5);
    	studentU.add(6);
    	studentU.add(4);
    	studentU.add(7);
    	studentU.add(3);
    	studentU.add(2);
    	studentU.add(1);
    	studentPreferences.add(studentU);
    	
    	ArrayList<Integer> studentV = new ArrayList<Integer>();
    	studentV.add(1);
    	studentV.add(6);
    	studentV.add(5);
    	studentV.add(4);
    	studentV.add(3);
    	studentV.add(7);
    	studentV.add(2);
    	studentPreferences.add(studentV);
    	
    	ArrayList<Integer> studentW = new ArrayList<Integer>();
    	studentW.add(3);
    	studentW.add(5);
    	studentW.add(6);
    	studentW.add(7);
    	studentW.add(2);
    	studentW.add(4);
    	studentW.add(1);
    	studentPreferences.add(studentW);
    	
    	ArrayList<Integer> studentX = new ArrayList<Integer>();
    	studentX.add(1);
    	studentX.add(7);
    	studentX.add(6);
    	studentX.add(4);
    	studentX.add(3);
    	studentX.add(5);
    	studentX.add(2);
    	studentPreferences.add(studentX);
    	
    	ArrayList<Integer> studentY = new ArrayList<Integer>();
    	studentY.add(6);
    	studentY.add(3);
    	studentY.add(7);
    	studentY.add(5);
    	studentY.add(2);
    	studentY.add(4);
    	studentY.add(1);
    	studentPreferences.add(studentY);
    	
    	ArrayList<Integer> studentZ = new ArrayList<Integer>();
    	studentZ.add(1);
    	studentZ.add(7);
    	studentZ.add(4);
    	studentZ.add(2);
    	studentZ.add(6);
    	studentZ.add(5);
    	studentZ.add(3);
    	studentPreferences.add(studentZ);
    	
    	ArrayList<Integer> professorA = new ArrayList<Integer>();
    	professorA.add(3);
    	professorA.add(4);
    	professorA.add(2);
    	professorA.add(1);
    	professorA.add(6);
    	professorA.add(7);
    	professorA.add(5);
    	professorPreferences.add(professorA);
    	
    	ArrayList<Integer> professorB = new ArrayList<Integer>();
    	professorB.add(6);
    	professorB.add(4);
    	professorB.add(2);
    	professorB.add(3);
    	professorB.add(5);
    	professorB.add(1);
    	professorB.add(7);
    	professorPreferences.add(professorB);
    	
    	ArrayList<Integer> professorC = new ArrayList<Integer>();
    	professorC.add(6);
    	professorC.add(3);
    	professorC.add(5);
    	professorC.add(7);
    	professorC.add(2);
    	professorC.add(4);
    	professorC.add(1);
    	professorPreferences.add(professorC);
    	
    	ArrayList<Integer> professorD = new ArrayList<Integer>();
    	professorD.add(1);
    	professorD.add(6);
    	professorD.add(3);
    	professorD.add(2);
    	professorD.add(4);
    	professorD.add(7);
    	professorD.add(5);
    	professorPreferences.add(professorD);
    	
    	ArrayList<Integer> professorE = new ArrayList<Integer>();
    	professorE.add(1);
    	professorE.add(6);
    	professorE.add(5);
    	professorE.add(3);
    	professorE.add(4);
    	professorE.add(7);
    	professorE.add(2);
    	professorPreferences.add(professorE);
    	
    	ArrayList<Integer> professorF = new ArrayList<Integer>();
    	professorF.add(1);
    	professorF.add(7);
    	professorF.add(3);
    	professorF.add(4);
    	professorF.add(5);
    	professorF.add(6);
    	professorF.add(2);
    	professorPreferences.add(professorF);
    	
    	ArrayList<Integer> professorG = new ArrayList<Integer>();
    	professorG.add(5);
    	professorG.add(6);
    	professorG.add(2);
    	professorG.add(4);
    	professorG.add(3);
    	professorG.add(7);
    	professorG.add(1);
    	professorPreferences.add(professorG);
    	
    	Preferences preference = new Preferences(7, 7, professorPreferences, studentPreferences);    	
   
//    	 System.out.println(Assignment1.stableMatchBruteForce(preference));
//    	 System.out.println(Assignment1.stableMatchGaleShapley(preference));
//    	
    	ArrayList<Cost> result = Assignment1.stableMatchCostsStudent(preference);
    	for (int i = 0; i < 7; i++) {
    		System.out.print(result.get(i).getIndexOfProfessor());
    		System.out.print(result.get(i).getIndexOfStudent());
    		System.out.print(result.get(i).getCostToProfessor());
    		System.out.println(result.get(i).getCostToStudent());    		
    	}
	}

}
