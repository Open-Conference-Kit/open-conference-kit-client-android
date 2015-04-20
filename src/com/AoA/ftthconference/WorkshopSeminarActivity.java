package com.AoA.ftthconference;

import com.AoA.model.Floorplan;
import com.AoA.model.Previous;
import com.AoA.model.Previous_studies;
import com.AoA.utils.apidownloader;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WorkshopSeminarActivity extends BaseActivity {

	private LayoutInflater inflater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		logo.setImageResource(R.drawable.workshopseminarslogo);
		mainholder.setBackgroundResource(R.drawable.workshopsminarsback);
		initializesidebuttons(this);
		workshopseminarsbutton.setBackgroundResource(R.drawable.workshopseminarsselect);
		
//		setContentView(R.layout.activity_workshop_seminar);
		LinearLayout contentholder = (LinearLayout)findViewById(R.id.maincontentholder);		
		inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout.LayoutParams llpm = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		contentholder.addView(inflater.inflate(R.layout.activity_workshop_seminar,null,false),llpm);
		initiateworkshopseminarscreen(contentholder);
	}

	private void initiateworkshopseminarscreen(LinearLayout contentholder) {
		// TODO Auto-generated method stub
		TextView title,description;
		title = (TextView)contentholder.findViewById(R.id.workshoptitle);
		title.setText(Previous.previousholder.gettitle());
		
		description = (TextView)contentholder.findViewById(R.id.workshopdescription);
		description.setText(Previous.previousholder.getdescription());
		
		ImageView workshopimage = (ImageView)contentholder.findViewById(R.id.workshopimage);
		Bitmap b = BitmapFactory.decodeFile(Previous.previousholder.getpicture());
		workshopimage.setImageBitmap(b);
		Button detail = (Button)contentholder.findViewById(R.id.detailsbutton);
		detail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				String googleDocsUrl = "http://docs.google.com/viewer?url=";
//
//				Intent intent = new Intent(Intent.ACTION_VIEW);
//				intent.setDataAndType(Uri.parse(googleDocsUrl + "http://ftthapi.com/uploads/"+Previous.previousholder.getpdf() ), "text/html");
//				startActivity(intent);
				apidownloader.downloadpdf(WorkshopSeminarActivity.this,  "http://ftthapi.com/uploads/"+Previous.previousholder.getpdf());
			}
		});
	}



}
