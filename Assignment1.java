/**
 * Grace Zhuang
 * gpz68
 */

package Project1;

import java.util.ArrayList;

public class Assignment1 {

    // Part1: Implement a Brute Force Solution
    public static ArrayList<Integer> stableMatchBruteForce(Preferences preferences) {
    	
    	// reindex Professor and Student preferences
    	changePreferences(preferences);
    	
    	// make list to permute
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	for (int i = 0; i < preferences.getNumberOfProfessors(); i++) {
    		arr.add(i);
    	}
    	
    	// create matrix to store all possible permutations
    	ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
    	permute(0, arr, permutations);
    	
    	// parse through permutations and check if one is a stable matching
    	for (int i = 0; i < permutations.size(); i++) {
    		if (isStable(permutations.get(i), preferences)) {
    			return permutations.get(i);
    		}
    	}
    	
    	// never occurs because there will always be a stable matching
    	return new ArrayList<Integer>();
    }
    
    // recursive function to create permutations
    public  static void permute(int start, ArrayList<Integer> input, ArrayList<ArrayList<Integer>> permutations) {
        if (start == input.size()) {
        	ArrayList<Integer> matching = new ArrayList<Integer>();
            for(int x: input){
            	matching.add(x);
            }
            permutations.add(matching);
        return;
        }
	    for (int i = start; i < input.size(); i++) {
	        // swapping
	        int temp = input.get(i);
	        input.set(i, input.get(start));
	        input.set(start, temp);
	        
	        permute(start + 1, input, permutations);
	        
	        int temp2 = input.get(i);
	        input.set(i, input.get(start));
	        input.set(start, temp2);
	    }
    }

    // Part2: Implement Gale-Shapley Algorithm
    public static ArrayList<Integer> stableMatchGaleShapley(Preferences preferences) {
    	
    	// reindex Professor and Student preferences    	
    	changePreferences(preferences);
    	
    	int num = preferences.getNumberOfProfessors();
    	
    	ArrayList<Integer> freeProfs = new ArrayList<Integer>();
    	
    	// who each Professor is matched with
    	int[] prof = new int[num];
    	
    	// who each Student is matched with
    	int[] stud = new int[num];
    	
    	// how many times the Professor has "proposed"
    	int[] count = new int[num];
    	
    	// create inverse preference list for Students
    	ArrayList<ArrayList<Integer>> studInverse = new ArrayList<ArrayList<Integer>>();  	
    	for (int i = 0; i < num; i++) {
    		studInverse.add(new ArrayList<Integer>());
    		for (int j = 0; j < num; j++) {
    			studInverse.get(i).add(-1);
    		}
    	}
    	
    	// populating the pre-made lists
    	for (int i = 0; i < num; i++) {
    		freeProfs.add(i);
    		prof[i] = -1;
    		stud[i] = -1;
    		count[i] = 0;
    		
    		for (int j = 0; j < num; j++) {
    			int rankedProf = preferences.getStudents_preference().get(i).get(j);
    			studInverse.get(i).set(rankedProf, j);
    		}
    	}
    	
    	// loop while there are free Professors
    	while (freeProfs.size() > 0) {
    		
    		int currentProf = freeProfs.get(0);
    		int currentStud = preferences.getProfessors_preference().get(currentProf).get(count[currentProf]);
    		
    		// if Student is free
    		if (stud[currentStud] == -1) {
    			stud[currentStud] = currentProf;
    			prof[currentProf] = currentStud;
        		freeProfs.remove(0);
    		}
    		
    		// if Student is already matched
    		else {
    			
    			// if Student prefers current Professor the one they're currently matched to
    			if (studInverse.get(currentStud).get(currentProf) < studInverse.get(currentStud).get(stud[currentStud])) {
    				int previousProf = stud[currentStud];
    				stud[currentStud] = currentProf;
    				prof[currentProf] = currentStud;
    				freeProfs.remove(0);
    				freeProfs.add(previousProf);
    			}
    		}   
    		// increment number of itmes Professor has proposed
    		count[currentProf] += 1;
    	}
    	
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	for (int i = 0; i < prof.length; i++) {
    		result.add(prof[i]);
    	}
    	return result;
    }

    // Part3: Matching with Costs
    public static ArrayList<Cost> stableMatchCosts(Preferences preferences) {
    	
    	int num = preferences.getNumberOfProfessors();
    	
    	ArrayList<Integer> result = stableMatchGaleShapley(preferences);
    	ArrayList<Cost> answer = new ArrayList<Cost>();
    	
    	// populate ArrayList with Cost objects from the result
    	for (int i = 0; i < num; i++) {
    		int student = result.get(i);
    		Cost current = new Cost(i, student, preferences.getProfessors_preference().get(i).indexOf(student), preferences.getStudents_preference().get(student).indexOf(i));
    		answer.add(current);
    	}
    	return answer;
    }
    
    public static ArrayList<Cost> stableMatchCostsStudent(Preferences preferences) {
    	
    	int num = preferences.getNumberOfProfessors();
    	
    	// switch Student and Professor preferences, since current Gale-Shapley algorithm returns "Professor-optimal" 
    	ArrayList<ArrayList<Integer>> temp = preferences.getProfessors_preference();    	
    	preferences.setProfessors_preference(preferences.getStudents_preference());
    	preferences.setStudents_preference(temp);
    	
    	ArrayList<Integer> result = stableMatchGaleShapley(preferences);
    	ArrayList<Cost> answer = new ArrayList<Cost>();
    	
    	// populate ArrayList with Cost objects from the result    	
    	for (int i = 0; i < num; i++) {
    		int prof = result.get(i);
    		Cost current = new Cost(i, prof, preferences.getProfessors_preference().get(i).indexOf(prof), preferences.getStudents_preference().get(prof).indexOf(i));
    		answer.add(current);
    	}
    	return answer;
    }
    
    // determine if the matching given is a stable matching
    public static boolean isStable(ArrayList<Integer> matching, Preferences preferences) {
    	
    	int num = preferences.getNumberOfProfessors();
    	
    	// iterate through all pairs in the matching
    	for (int prof = 0; prof < num; prof++) {
    		int student = matching.get(prof);
    		for (int i = 0; i < preferences.getStudents_preference().get(student).indexOf(prof); i++) {
    			int betterProf = preferences.getStudents_preference().get(student).get(i);
    			if (preferences.getProfessors_preference().get(betterProf).indexOf(student) < preferences.getProfessors_preference().get(betterProf).indexOf(matching.get(betterProf))) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    // re-index all preference lists
    public static void changePreferences(Preferences preferences) {
    	int num = preferences.getNumberOfProfessors();
    	for (int i = 0; i < num; i++) {
    		for (int j = 0; j < num; j++) {    			
    			int current = preferences.getStudents_preference().get(i).get(j);
    			preferences.getStudents_preference().get(i).set(j, current - 1);
    			current = preferences.getProfessors_preference().get(i).get(j);
    			preferences.getProfessors_preference().get(i).set(j, current - 1);
    		}
    	}
    }
    
}
