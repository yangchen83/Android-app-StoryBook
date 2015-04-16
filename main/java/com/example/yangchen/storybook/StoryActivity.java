package com.example.yangchen.storybook;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.TintImageView;
import android.view.Menu;
import android.view.MenuItem;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        if (name == null) name = "Mike";

        imageView = (ImageView) findViewById(R.id.storyImageView);
        textView = (TextView) findViewById(R.id.storyTextView);
        choice1 = (Button) findViewById(R.id.button1);
        choice2 = (Button) findViewById(R.id.button2);

        loadPage();


    }

    private void loadPage(){
        Page page = story.getPage(0);

        Drawable drawable = getResources().getDrawable(page.imageId());
        imageView.setImageDrawable(drawable);
        textView.setText(page.text());
        choice1.setText(page.choice1().text());
        choice2.setText(page.choice2().text());


    }


}
