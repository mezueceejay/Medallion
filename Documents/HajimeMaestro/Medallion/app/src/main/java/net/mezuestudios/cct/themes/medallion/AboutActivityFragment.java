package net.mezuestudios.cct.themes.medallion;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


/**
 * A placeholder fragment containing a simple view.
 */
public class AboutActivityFragment extends Fragment {

    public AboutActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_about, container, false);
        //     Amazon OnClicklistener
        RelativeLayout amazon = (RelativeLayout) rootView.findViewById(R.id.amazon_layout);
        amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent amazonweb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com/Apps-Games-Mezue-Studios/s?ie=UTF8&field-brandtextbin=Mezue%20Studios&page=1&rh=n%3A2350149011"));
                startActivity(amazonweb);
            }
        });


        RelativeLayout email_developer = (RelativeLayout) rootView.findViewById(R.id.feedback_layout);
        email_developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email_developerweb = new Intent(Intent.ACTION_SEND);
                email_developerweb.setData(Uri.parse("email"));
                email_developerweb.setType("message/rfc822");
                email_developerweb.setType("text/plain");
                String s = "mezuestudios@gmail.com";
                email_developerweb.putExtra(Intent.EXTRA_EMAIL,s);
                email_developerweb.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
                email_developerweb.putExtra(Intent.EXTRA_TEXT, getString(R.string.email_text));
                Intent sender = Intent.createChooser(email_developerweb,getString(R.string.send_title));
                startActivity(sender);
            }
        });
        RelativeLayout fb = (RelativeLayout) rootView.findViewById(R.id.fb_layout);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fbweb = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.facebook_link)));
                startActivity(fbweb);
            }
        });
        RelativeLayout instagram = (RelativeLayout) rootView.findViewById(R.id.instagram_layout);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent instagramweb = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.instagram_link)));
                startActivity(instagramweb);
            }
        });
        RelativeLayout twitter = (RelativeLayout) rootView.findViewById(R.id.twitter_layout);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent twitterweb = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.twitter_link)));
                startActivity(twitterweb);
            }
        });
        CardView materialdrawer = (CardView) rootView.findViewById(R.id.libonecard);
        materialdrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mdweb = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.materialdrawer_web)));
                startActivity(mdweb);
            }
        });
        CardView materialdialog = (CardView) rootView.findViewById(R.id.libthreecard);
        materialdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mdialogweb = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.materialdialogs_web)));
                startActivity(mdialogweb);
            }
        });
        CardView fab = (CardView) rootView.findViewById(R.id.libtwocard);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fabweb = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.fab_web)));
                startActivity(fabweb);
            }
        });
        CardView pkrequest = (CardView) rootView.findViewById(R.id.libsevencard);
        pkrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pkrequestweb = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.pkrequestmanager_web)));
                startActivity(pkrequestweb);
            }
        });
        return rootView;
    }

}
