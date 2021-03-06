/**
 * Cost object for Assignment 1 - Part 3
 * This object helps you to return 4 fields at once.
 * The meaning of cost is described in the assignment.
 */

package Project1;

public class Cost {
    private int indexOfProfessor;
    private int indexOfStudent;
    private int costToProfessor;
    private int costToStudent;

    public Cost(int indexOfProfessor, int indexOfStudent, int costToProfessor, int costToStudent) {

        this.indexOfProfessor = indexOfProfessor;
        this.indexOfStudent = indexOfStudent;
        this.costToProfessor = costToProfessor;
        this.costToStudent = costToStudent;
    }

    public int getIndexOfProfessor() {
        return indexOfProfessor;
    }

    public void setIndexOfProfessor(int indexOfProfessor) {
        this.indexOfProfessor = indexOfProfessor;
    }

    public int getIndexOfStudent() {
        return indexOfStudent;
    }

    public void setIndexOfStudent(int indexOfStudent) {
        this.indexOfStudent = indexOfStudent;
    }

    public int getCostToProfessor() {
        return costToProfessor;
    }

    public void setCostToProfessor(int costToProfessor) {
        this.costToProfessor = costToProfessor;
    }

    public int getCostToStudent() {
        return costToStudent;
    }

    public void setCostToStudent(int costToStudent) {
        this.costToStudent = costToStudent;
    }
}
