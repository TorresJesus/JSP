/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.jsf.quiz;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author TICLAB1
 */
public class ProblemBean implements Serializable{
    private ArrayList<Integer> sequence;
    private int solution;
    
    public ProblemBean(){
        
    }

    public ProblemBean(int[] values, int solution) {
        sequence = new ArrayList<Integer>();
        for(int value : values){
            sequence.add(value);
        }
        this.solution=solution;
    }

    public ArrayList<Integer> getSequence() {
        return sequence;
    }

    public void setSequence(ArrayList<Integer> sequence) {
        this.sequence = sequence;
    }

    public int getSolution() {
        return solution;
    }

    public void setSolution(int solution) {
        this.solution = solution;
    }
    
    
    
    
    
}
