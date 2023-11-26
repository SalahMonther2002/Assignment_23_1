package com.example.assignment_23_1;

public class Task {


    private String discription;
    private boolean isDone;


    public Task(String discription) {
        this.discription = discription;
        this.isDone = false;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }


    @Override
    public String toString(){
        //Since the listview takes the data from the testing() method, I use some regular expressions.
      return  discription.replaceAll("-.*-","");
    }
}
