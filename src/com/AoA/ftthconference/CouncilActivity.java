package com.AoA.ftthconference;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.AoA.holder.Committees;
import com.AoA.holder.Directors;
import com.AoA.holder.Team;
import com.AoA.model.About;
import com.AoA.utils.HttpRequest;
import com.AoA.utils.people_listviewrenderer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class CouncilActivity extends BaseActivity {

	private LayoutInflater inflater;
	public FrameLayout councilmainholder;
	Button directorsbutton,committeesbutton,teambutton,aboutbutton;
	private LinearLayout councilcontent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_council);
		logo.setImageResource(R.drawable.councilpagelogo);
		mainholder.setBackgroundResource(R.drawable.councilback);
		initializesidebuttons(this);
		councilbutton.setBackgroundResource(R.drawable.councilselect);
		LinearLayout contentholder = (LinearLayout)findViewById(R.id.maincontentholder);
		inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout.LayoutParams llpm = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		councilmainholder = (FrameLayout) inflater.inflate(R.layout.activity_council,null,false);
		contentholder.addView(councilmainholder,llpm);
		
		 councilcontent = (LinearLayout)councilmainholder.findViewById(R.id.councilcontent);
		
		directorsbutton = (Button)councilmainholder.findViewById(R.id.directorsbutton);
		directorsbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				councilcontent.removeAllViews();
				
				aboutbutton.setBackgroundResource(R.drawable.inactivetabbackleft);
				directorsbutton.setBackgroundResource(R.drawable.tabbackrightactive);
				committeesbutton.setBackgroundResource(R.drawable.inactivetabbackleft);
				teambutton.setBackgroundResource(R.drawable.inactivetabbackright);
				
				
				
				
				ListView directorlist = new ListView(CouncilActivity.this);
				directorlist.setSelector(android.R.color.transparent);
				directorlist.setCacheColorHint(Color.TRANSPARENT);
				directorlist.setDividerHeight(0);
				people_listviewrenderer plvr = new people_listviewrenderer(Directors.allDirectors, CouncilActivity.this,CouncilActivity.this);
				directorlist.setAdapter(plvr);
				plvr.notifyDataSetChanged();
				councilcontent.addView(directorlist);
			}
		});
		
		committeesbutton = (Button)councilmainholder.findViewById(R.id.committeebutton);
		committeesbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				councilcontent.removeAllViews();
				
				aboutbutton.setBackgroundResource(R.drawable.inactivetabbackleft);
				directorsbutton.setBackgroundResource(R.drawable.inactivetabbackright);
				committeesbutton.setBackgroundResource(R.drawable.tabbackleftactive);
				teambutton.setBackgroundResource(R.drawable.inactivetabbackright);
				
				
				
				ListView directorlist = new ListView(CouncilActivity.this);
				directorlist.setSelector(android.R.color.transparent);
				directorlist.setCacheColorHint(Color.TRANSPARENT);
				
				directorlist.setDividerHeight(0);
				people_listviewrenderer plvr = new people_listviewrenderer(Committees.all_committees, CouncilActivity.this,CouncilActivity.this);
				directorlist.setAdapter(plvr);
				plvr.notifyDataSetChanged();
				councilcontent.addView(directorlist);
			}
		});
		
		teambutton = (Button)councilmainholder.findViewById(R.id.teambutton);
		teambutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				councilcontent.removeAllViews();
				
				aboutbutton.setBackgroundResource(R.drawable.inactivetabbackleft);
				directorsbutton.setBackgroundResource(R.drawable.inactivetabbackright);
				committeesbutton.setBackgroundResource(R.drawable.inactivetabbackleft);
				teambutton.setBackgroundResource(R.drawable.tabbackrightactive);
				
				ListView directorlist = new ListView(CouncilActivity.this);
				directorlist.setSelector(android.R.color.transparent);
				directorlist.setCacheColorHint(Color.TRANSPARENT);
				
				directorlist.setDividerHeight(0);
				people_listviewrenderer plvr = new people_listviewrenderer(Team.allTeam, CouncilActivity.this,CouncilActivity.this);
				directorlist.setAdapter(plvr);
				plvr.notifyDataSetChanged();
				councilcontent.addView(directorlist);
			}
		});
		
		aboutbutton = (Button)councilmainholder.findViewById(R.id.aboutbutton);
		aboutbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setaboutview();
			}
		});
		setaboutview();
	}
	public void setaboutview(){
		councilcontent.removeAllViews();
		
		aboutbutton.setBackgroundResource(R.drawable.tabbackleftactive);
		directorsbutton.setBackgroundResource(R.drawable.inactivetabbackright);
		committeesbutton.setBackgroundResource(R.drawable.inactivetabbackleft);
		teambutton.setBackgroundResource(R.drawable.inactivetabbackright);
		LinearLayout.LayoutParams llpm = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		
		councilcontent.addView(aboutview(),llpm);
		
	}
	public View aboutview(){
		ScrollView scv = new ScrollView(this);
		final TextView abouttext = new TextView(this);
		abouttext.setTextColor(Color.WHITE);
		abouttext.setText(About.about.gettextaboutinfo());
		scv.addView(abouttext);
		return scv;
	}


}
