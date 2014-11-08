package com.hackathought.wordcloud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class CloudOfWords extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_cloud);

        Intent intent = getIntent();
        String fullSentence = intent.getStringExtra("Full Sentence");
        final SentenceDB sdb = new SentenceDB(fullSentence);
        Log.d("Split up words array wtfbbq", sdb.getKeyWordArray().toString());
        ArrayList<String> words = new ArrayList<String>();
        words = sdb.getKeyWordArray();

        //Make an array of textViews to keep track of the tvs that hold the top 5 or 10 words in the word cloud
        final TextView[] wordTextViews = new TextView[words.size()];
        //Get number of words there are (size of words array which contains top 5-10 words)
        int max = words.size();
        //Find the relative layout in the activity_word_cloud.xml layout file
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.wcList);
        //Declare the parameters variable to be applied to each text view
        RelativeLayout.LayoutParams rlparams;

        //Iterate through the array of words to apply style to each textview
        for (int i = 0; i < max; i++ ){
            //Debug
            Log.d("Individual words", words.get(i));

            //Gen text views and set text in the textview to whatever is pulled from array
            TextView text = new TextView(this);
            text.setText(words.get(i));
            rlparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            //Set base margins
            rlparams.setMargins(20,0,0,0);
            //The first one will not have any additional margins
            if (i == 0){
                rlparams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
                //Set the layout parameters
                text.setLayoutParams(rlparams);
            }
            else{
                //Pads the top to put the words below the previous word
                int height = 25 * i;
                rlparams.setMargins(20,height,0,0);
                //Set the layout parameters
                text.setLayoutParams(rlparams);
            }
            //Add the textviews to the relative layout view dynamically
            rl.addView(text, rlparams);
            //Add the text to the array of textViews
            wordTextViews[i] = text;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.word_cloud, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
