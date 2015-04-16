package com.example.yangchen.storybook.model;

/**
 * Created by yangchen on 4/16/15.
 */
public class Choice {
    private String text;
    private int nextPage;

    public Choice(String text, int nextPage){
        this.text = text;
        this.nextPage = nextPage;
    }

    public String text() {return text;}
    public int nextPage() {return nextPage;}


}
