/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.jsf.quiz;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author TICLAB1
 */
@Named(value = "quizBean")
@SessionScoped
public class QuizBean implements Serializable{
    private ArrayList<ProblemBean> problems = new ArrayList<ProblemBean>();
    private int currentIndex;
    private int score;
    /**
     * Creates a new instance of QuizBean
     */
    public QuizBean() {
        problems.add(new ProblemBean(new int[] {3,1,4,1,5}, 9));//pi
        problems.add(new ProblemBean(new int[]{1,1,2,3,5}, 8));//fobonacci
        problems.add(new ProblemBean(new int[]{1,4,9,16,25}, 36));//squares
        problems.add(new ProblemBean(new int[]{2,3,5,7,11}, 13));//primes
        problems.add(new ProblemBean(new int[]{1,2,4,8,16}, 32));//powers of 2
        
    }
    
    public void setProblem(ArrayList<ProblemBean> problems){
        this.problems = problems;
        currentIndex=0;
        score=0;
    }

    public int getScore() {
        return score;
    }

    public ProblemBean getCurrent() {
        return problems.get(currentIndex);
    }
    
    public String getAnswer(){
        return "";
    }
    
    public void setAnswer(String s){
        try {
            int answer = Integer.parseInt(s);
            if(getCurrent().getSolution() == answer){
                score++;
            }
            currentIndex = (currentIndex+1)%problems.size();
        } catch (NumberFormatException e) {
        }
    }
    
}
