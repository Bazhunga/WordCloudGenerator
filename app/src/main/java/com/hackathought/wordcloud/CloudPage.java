package com.hackathought.wordcloud;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class CloudPage extends Activity {
    Context ctxt = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final SentenceDB sdb = new SentenceDB();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloud_page);

        Button addButton = (Button) findViewById(R.id.AddToSDB);
        final EditText stringToAdd = (EditText) findViewById(R.id.sentence);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sentence = stringToAdd.getText().toString().trim();
                sdb.append(sentence);
                stringToAdd.setText("");
                Log.d("SentenceDatabase", sdb.getSentenceList().toString());
                Log.d("Entire Database as String", sdb.getKeySentence().toString());
                Log.d("Split up words", sdb.getKeyWordArray().toString());
            }
        });

        //Button listner to move to next activity. Sends the sentence
        Button gotoNext = (Button) findViewById(R.id.makeWordCloud);
        gotoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ourIntent = new Intent(ctxt, CloudOfWords.class);
                String sentence = sdb.getKeySentence();
                ourIntent.putExtra("Full Sentence", sentence);
                startActivity(ourIntent);
            }
        });

    }
}
