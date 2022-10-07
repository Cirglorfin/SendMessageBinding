package com.example.sendmessagebinding.iu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sendmessagebinding.R;
import com.example.sendmessagebinding.SendMessageApplication;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        AboutView view = AboutBuilder.with(this)
                .setPhoto(R.mipmap.ic_launcher)

                .setName(((SendMessageApplication)getApplication()).getUser().getName())
                .setSubTitle(getResources().getString(R.string.app_name))
                .setBrief("I'm warmed of mobile technologies. Ideas maker, curious and nature lover.")
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGooglePlayStoreLink("8002078663318221363")
                .addGitHubLink("user")
                .addFacebookLink("user")
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();

        //addContentView(view, layoutParams);
        setContentView(view);
    }
}