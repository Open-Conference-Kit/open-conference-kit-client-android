package com.AoA.ftthconference;

import com.AoA.utils.apidownloader;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainMenuActivity extends Activity{

	private LayoutInflater inflater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu_activity);
		initializesidebuttons();
	}
	
	private void initializesidebuttons() {
		// TODO Auto-generated method stub
		Button councilbutton = (Button)findViewById(R.id.councilbutton);
		councilbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Button buutton5 = (Button)findViewById(R.id.Button05);
				Animation leftAnimation = AnimationUtils.loadAnimation(MainMenuActivity.this, R.anim.righttoleft);
				buutton5.startAnimation(leftAnimation);
				leftAnimation.setAnimationListener(new AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationEnd(Animation arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getBaseContext(), CouncilActivity.class);
						startActivity(intent);
					}
				});
				
			}
		});
		
		
		Button conferencebutton = (Button)findViewById(R.id.conferencebutton);
		conferencebutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Button buutton6 = (Button)findViewById(R.id.Button06);
				Animation leftAnimation = AnimationUtils.loadAnimation(MainMenuActivity.this, R.anim.righttoleft);
				buutton6.startAnimation(leftAnimation);
				leftAnimation.setAnimationListener(new AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationEnd(Animation arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getBaseContext(), Conference_activity.class);
						startActivity(intent);
					}
				});
			
			}
		});
		
		
		
		
		
		
		
		Button workshopseminarsbutton = (Button)findViewById(R.id.workshopseminarsbutton);
		workshopseminarsbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Button buutton7 = (Button)findViewById(R.id.Button07);
				Animation leftAnimation = AnimationUtils.loadAnimation(MainMenuActivity.this, R.anim.righttoleft);
				buutton7.startAnimation(leftAnimation);
				leftAnimation.setAnimationListener(new AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationEnd(Animation arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getBaseContext(), WorkshopSeminarActivity.class);
						startActivity(intent);
					}
				});
			
			}
		});
		
		Button studiespresentationbutton = (Button)findViewById(R.id.studiespresentationbutton);
		studiespresentationbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Button buutton8 = (Button)findViewById(R.id.Button08);
				Animation leftAnimation = AnimationUtils.loadAnimation(MainMenuActivity.this, R.anim.righttoleft);
				buutton8.startAnimation(leftAnimation);
				leftAnimation.setAnimationListener(new AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationEnd(Animation arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getBaseContext(), StudiesPresentationActivity.class);
						startActivity(intent);
					}
				});
	
			}
		});
		
		Button membersbutton = (Button)findViewById(R.id.membersbutton);
		membersbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Button buutton9 = (Button)findViewById(R.id.Button09);
				Animation leftAnimation = AnimationUtils.loadAnimation(MainMenuActivity.this, R.anim.righttoleft);
				buutton9.startAnimation(leftAnimation);
				leftAnimation.setAnimationListener(new AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationEnd(Animation arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getBaseContext(), MembersActivity.class);
						startActivity(intent);
					}
				});
				
			}
		});
		
		Button becomeamemberbutton = (Button)findViewById(R.id.becomeamemberbutton);
		becomeamemberbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Button buutton10 = (Button)findViewById(R.id.Button10);
				Animation leftAnimation = AnimationUtils.loadAnimation(MainMenuActivity.this, R.anim.righttoleft);
				buutton10.startAnimation(leftAnimation);
				leftAnimation.setAnimationListener(new AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationEnd(Animation arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getBaseContext(), BecomeAmemberActivity.class);
						startActivity(intent);
					}
				});
				
			}
		});
		
		
		
		Button facebook =(Button)findViewById(R.id.Button03);
		facebook.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				opensociallinks("https://www.facebook.com/pages/FTTH-Council-Asia-Pacific/233216600139960?ref=hl");
			}
		});
		Button twitter =(Button)findViewById(R.id.Button02);
		twitter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				opensociallinks("https://twitter.com/FTTHCOUNCILAPAC");
			}
		});
		Button blogger =(Button)findViewById(R.id.Button01);
		blogger.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				opensociallinks("http://ftthcouncilap.blogspot.com/");
			}
		});
		Button linkedin =(Button)findViewById(R.id.button1);
		linkedin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				opensociallinks("http://www.linkedin.com/company/ftth-council-asia-pacific");
			}
		});
	}
	
	public void opensociallinks(String url){
		
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
	}
}
