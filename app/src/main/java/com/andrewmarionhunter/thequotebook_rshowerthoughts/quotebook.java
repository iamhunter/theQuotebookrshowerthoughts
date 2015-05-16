package com.andrewmarionhunter.thequotebook_rshowerthoughts;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;


public class quotebook extends ActionBarActivity {
    int count = 0;

    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotebook);

        setTitle("");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2054016110375376/5971318240");
        loadInterstitial();

        RelativeLayout touch = (RelativeLayout) findViewById(R.id.touch);
        final TextView quoteText = (TextView) findViewById(R.id.quote);
        final TextView personText = (TextView) findViewById(R.id.person);
        final ArrayList<Quote> quoteList = new ArrayList<Quote>();

        Quote quote1 = new Quote("Waterboarding at Guantanamo Bay sounds super rad if you don't know what either of those things are.", "/u/jgam7");
        quoteList.add(quote1);
        Quote quote2 = new Quote("When Sweden is playing Denmark, it is SWE-DEN. The remaining letters, not used, is DEN-MARK.", "/u/vestergaard92");
        quoteList.add(quote2);
        Quote quote3 = new Quote("Maybe 'Are You Smarter Than a 5th Grader?' isn't a show that displays how stupid grown adults can be, but rather, a show that depicts how much useless information we teach grade schoolers that won't be retained or applicable later in life.", "/u/YELLHEAH");
        quoteList.add(quote3);
        Quote quote4 = new Quote("Every time you upvote someone, you are making their day better, at the cost of nothing.", "/u/andrew688k");
        quoteList.add(quote4);
        Quote quote5 = new Quote("instead of all the prequel and sequel movies coming out, they should start making equels - films shot in the same time period as the original film, but from an entirely different perspective", "/u/equalfilms");
        quoteList.add(quote5);
        Quote quote6 = new Quote("X88B88 looks like the word voodoo reflecting off of itself.", "/u/roboccohurly");
        quoteList.add(quote6);
        Quote quote7 = new Quote("\"Go to bed, you'll feel better in the morning\" is the human version of \"Did you turn it off and turn it back on again?\"", "/u/W0rdN3rd");
        quoteList.add(quote7);
        Quote quote8 = new Quote("Your shadow is a confirmation that light has traveled nearly 93 million miles unobstructed, only to be deprived of reaching the ground in the final few feet thanks to you.", "/u/tectactoe");
        quoteList.add(quote8);
        Quote quote9 = new Quote("April Fool's Day is the one day of the year when people critically evaluate news articles before accepting them as true.", "/u/kellenbrent");
        quoteList.add(quote9);
        Quote quote10 = new Quote("The sinking of the Titanic must have been a miracle to the lobsters in the kitchen.", "/u/ElBretto");
        quoteList.add(quote10);
        Quote quote11 = new Quote("The person who would proof read Hitler's speeches was a grammar Nazi.", "/u/PhantomDukie");
        quoteList.add(quote11);
        Quote quote12 = new Quote("Apple has \"air.\" Amazon has \"fire.\" Google has \"earth.\" I think Microsoft should create something called \"water.\"", "/u/arbaminim");
        quoteList.add(quote12);
        Quote quote13 = new Quote("When you drink alcohol you are just borrowing happiness from tomorrow", "/u/benji9t3");
        quoteList.add(quote13);
        Quote quote14 = new Quote("The Google self-driving car should have an \"I'm Feeling Lucky\" button that drives you to a random location.", "/u/CerealFlakes");
        quoteList.add(quote14);
        Quote quote15 = new Quote("As a dishwasher, I come home after hours of work in which I get covered in filth, and I take a shower only to realize...I am the final dish", "/u/RandyJones");
        quoteList.add(quote15);

        touch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count < quoteList.size()) {
                    Quote q = quoteList.get(count);
                    quoteText.setText(q.getQuote());
                    personText.setText(q.getPerson());
                    count = count + 1;
                } else{
                    showInterstitial();
                    count = 0;
                    loadInterstitial();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quotebook, menu);
        return true;
    }

    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and reload the ad.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    private void loadInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }
}
