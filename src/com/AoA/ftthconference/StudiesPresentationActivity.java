package com.AoA.ftthconference;

import com.AoA.model.Latest_studies;
import com.AoA.model.Previous_studies;
import com.AoA.utils.apidownloader;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class StudiesPresentationActivity extends BaseActivity {

	private LayoutInflater inflater;
	LinearLayout contentholder ;
	Button prevButton;
	private Button latestButton;
	int index;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		logo.setImageResource(R.drawable.studiesscreenlogo);
		mainholder.setBackgroundResource(R.drawable.studiesscreenback);
		initializesidebuttons(this);
		studiespresentationbutton.setBackgroundResource(R.drawable.studiesselect);
		
		contentholder = (LinearLayout)findViewById(R.id.maincontentholder);		
		inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout.LayoutParams llpm = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		contentholder.addView(inflater.inflate(R.layout.activity_studies_presentation,null,false),llpm);
		
		
		 prevButton = (Button)contentholder.findViewById(R.id.previousstudiesbutton);

		 latestButton = (Button)contentholder.findViewById(R.id.lateststudiesbutton);
		latestButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				createlateststudiescreen();
			}
		});
		createlateststudiescreen();
	}

	private void createlateststudiescreen() {
		// TODO Auto-generated method stub
		latestButton.setBackgroundResource(R.drawable.workshopheader);
		latestButton.setText("Latest Studies");
		latestButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		prevButton.setBackgroundResource(R.drawable.prevstudybutton);
		prevButton.setText("        Previous Studies");
		prevButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				createprevious_studiesscreen();
			}
		});
//		prevButton.setBackgroundResource(R.drawable.inactivetabbackright);
		LinearLayout content = (LinearLayout)contentholder.findViewById(R.id.content);
		content.removeAllViews();
		ScrollView scv = new ScrollView(this);
		TextView description = new TextView(this);
		description.setText(Latest_studies.lateststudyholder.getdescription());
		description.setTextColor(Color.WHITE);
		scv.addView(description);
		LinearLayout.LayoutParams llpm = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0);
		llpm.weight = 1;
		
		content.addView(scv,llpm);
		Button more = new Button(this);
		more.setBackgroundResource(R.drawable.morebackground);
		more.setText("click for further details");
		more.setTextColor(Color.WHITE);
		more.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String url = "http://"+Latest_studies.lateststudyholder.getfile();
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});
		LinearLayout.LayoutParams llpm2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		llpm2.bottomMargin = 30 ;
		content.addView(more,llpm2);

	}
	public void createprevious_studiesscreen(){
		latestButton.setBackgroundResource(R.drawable.prevstudybutton);
		latestButton.setText("        Previous Studies");
		prevButton.setBackgroundResource(R.drawable.morebackground);
		prevButton.setText("Latest Studies");
		prevButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				createlateststudiescreen();
			}
		});
		LinearLayout content = (LinearLayout)contentholder.findViewById(R.id.content);
		content.removeAllViews();
		for(int i = 0 ;i<Previous_studies.allpreviousStudies.size();i++){
			Button button = new Button(this);
			button.setText(Previous_studies.allpreviousStudies.get(i).getdescription());
			button.setBackgroundResource(R.drawable.morebackground);
			button.setTextColor(Color.WHITE);
			index = i;
			button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
//					String googleDocsUrl = "http://docs.google.com/viewer?url=";
//
//					Intent intent = new Intent(Intent.ACTION_VIEW);
//					intent.setDataAndType(Uri.parse(googleDocsUrl + "http://ftthapi.com/uploads/"+Previous_studies.allpreviousStudies.get(index).getfile() ), "text/html");
//					startActivity(intent);
					apidownloader.downloadpdf(StudiesPresentationActivity.this, "http://ftthapi.com/uploads/"+Previous_studies.allpreviousStudies.get(index).getfile());
				}
			});
			LinearLayout.LayoutParams llpm = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
			llpm.gravity = Gravity.CENTER;
			llpm.setMargins(5, 5, 5, 5);
			content.addView(button,llpm);
		}
		
	}



}
