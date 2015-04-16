package com.example.yangchen.storybook.model;

/**
 * Created by yangchen on 4/16/15.
 */
public class Page {
    private int imageId;
    private String text;
    private Choice choice1;
    private Choice choice2;
    private boolean endOfStory = false;

    public Page(int id, String text, Choice choice1, Choice choice2){
        this.imageId = id;
        this.text = text;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public Page(int id, String text){
        this.imageId = id;
        this.text = text;
        this.choice1 = null;
        this.choice2 = null;
        this.endOfStory = true;
    }

    public int imageId(){ return imageId;}
    public String text() {return text;}
    public Choice choice1() {return choice1;}
    public Choice choice2() {return choice2;}
    public boolean isEndOfStory(){return endOfStory;}
}
