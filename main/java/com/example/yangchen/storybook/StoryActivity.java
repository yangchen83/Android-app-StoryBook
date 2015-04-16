package com.example.yangchen.storybook;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.TintImageView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yangchen.storybook.model.Page;
import com.example.yangchen.storybook.model.Story;


public class StoryActivity extends ActionBarActivity {
    private Story story = new Story();
    private ImageView imageView;
    private TextView textView;
    private Button choice1;
    private Button choice2;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        if (name == null) name = "Mike";

        imageView = (ImageView) findViewById(R.id.storyImageView);
        textView = (TextView) findViewById(R.id.storyTextView);
        choice1 = (Button) findViewById(R.id.button1);
        choice2 = (Button) findViewById(R.id.button2);

        loadPage(0);
    }

    private void loadPage(int choice){
        final Page page = story.getPage(choice);

        Drawable drawable = getResources().getDrawable(page.imageId());
        imageView.setImageDrawable(drawable);
        String pageText = page.text();
        pageText = String.format(pageText, name);

        textView.setText(pageText);

        if (page.isEndOfStory()) {
            choice1.setVisibility(View.INVISIBLE);
            choice2.setText("Read the book again");

            choice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        } else {
            choice1.setText(page.choice1().text());
            choice2.setText(page.choice2().text());
            choice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPage(page.choice1().nextPage());
                }
            });

            choice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPage(page.choice2().nextPage());
                }
            });
        }
    }


}
