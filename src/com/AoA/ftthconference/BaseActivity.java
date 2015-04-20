package com.AoA.ftthconference;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class BaseActivity extends FragmentActivity {
	public ImageView logo;
	public LinearLayout mainholder;
	public Button conferencebutton;
	public Button councilbutton;
	public Button workshopseminarsbutton;
	public Button studiespresentationbutton;
	public Button membersbutton;
	public Button becomeamemberbutton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);
		logo = (ImageView)findViewById(R.id.logo);
		mainholder =(LinearLayout)findViewById(R.id.mainholder);
		FrameLayout sideiconholder = (FrameLayout)findViewById(R.id.sideiconholder);
//		sideiconholder.setVisibility(View.INVISIBLE);
		Animation RightSwipe = AnimationUtils.loadAnimation(BaseActivity.this, R.anim.leftbaranimate);
		sideiconholder.startAnimation(RightSwipe);
		LinearLayout contentholder = (LinearLayout)findViewById(R.id.maincontentholder);
		
		Animation leftAnimation = AnimationUtils.loadAnimation(this, R.anim.righttoleft);
		contentholder.startAnimation(leftAnimation);
		
	}

	public void initializesidebuttons(final Context con) {
		// TODO Auto-generated method stub
		Button navbutton = (Button)findViewById(R.id.nav);
		navbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(), MainMenuActivity.class);
				con.startActivity(intent);
				((Activity) con).finish();
			}
		});
		councilbutton = (Button)findViewById(R.id.councilbutton);
		councilbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(), CouncilActivity.class);
				con.startActivity(intent);
				((Activity) con).finish();
			}
		});
		
		
		conferencebutton = (Button)findViewById(R.id.conferencebutton);
		conferencebutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(), Conference_activity.class);
				con.startActivity(intent);
				((Activity) con).finish();
			}
		});
		
		
		
		
		
		
		
		workshopseminarsbutton = (Button)findViewById(R.id.workshopseminarsbutton);
		workshopseminarsbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(), WorkshopSeminarActivity.class);
				con.startActivity(intent);
				((Activity) con).finish();
			}
		});
		
		studiespresentationbutton = (Button)findViewById(R.id.studiespresentationbutton);
		studiespresentationbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(), StudiesPresentationActivity.class);
				con.startActivity(intent);
				((Activity) con).finish();
			}
		});
		
		membersbutton = (Button)findViewById(R.id.membersbutton);
		membersbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(), MembersActivity.class);
				con.startActivity(intent);
				((Activity) con).finish();
			}
		});
		
		becomeamemberbutton = (Button)findViewById(R.id.becomeamemberbutton);
		becomeamemberbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(), BecomeAmemberActivity.class);
				con.startActivity(intent);
				((Activity) con).finish();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.base, menu);
		return true;
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		System.gc();
		super.onDestroy();
	}

}
