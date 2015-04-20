package com.AoA.ftthconference;

import java.util.ArrayList;

import com.AoA.model.Register;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class BecomeAmemberActivity extends BaseActivity {

	private LayoutInflater inflater;
	Dialog membershipchooser;
	private LinearLayout councilmainholder;
	EditText nameoforganization,organizationwebsite,contactperson,jobtitle,email,contactnumber;
	Button Typeofmembership;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		logo.setImageResource(R.drawable.becomememberlogo);
		mainholder.setBackgroundResource(R.drawable.becomememberback);
		initializesidebuttons(this);
		becomeamemberbutton.setBackgroundResource(R.drawable.becomememberselect);

		
		LinearLayout contentholder = (LinearLayout)findViewById(R.id.maincontentholder);
		inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout.LayoutParams llpm = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		councilmainholder = (LinearLayout) inflater.inflate(R.layout.activity_become_amember,null,false);
		contentholder.addView(councilmainholder,llpm);
		
		nameoforganization = (EditText)councilmainholder.findViewById(R.id.nameoforganization);
		organizationwebsite = (EditText)councilmainholder.findViewById(R.id.organizationwebsite);
		contactperson = (EditText)councilmainholder.findViewById(R.id.contactperson);
		jobtitle = (EditText)councilmainholder.findViewById(R.id.jobtitle);
		email = (EditText)councilmainholder.findViewById(R.id.email);
		contactnumber = (EditText)councilmainholder.findViewById(R.id.contactnumber);
		
		Button membershipinformation = (Button)councilmainholder.findViewById(R.id.membershipinformation);
		membershipinformation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse("http://ftthcouncilap.org/membership-information"));
				startActivity(i);
			}
		});
		
		
		Button apply = (Button)councilmainholder.findViewById(R.id.apply);
		apply.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				composeemail();
			}
		});

		ArrayList<String> spinnerArray = new ArrayList<String>();
		spinnerArray.add("Platinum");
		spinnerArray.add("Gold");
		spinnerArray.add("Silver");

		Typeofmembership = (Button)councilmainholder.findViewById(R.id.Typeofmembership);
		Typeofmembership.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				createmembeshipchoosingdialog();
			}
		});

	}


	protected void createmembeshipchoosingdialog() {
		// TODO Auto-generated method stub
		Button Platinum,Gold,Silver;
		Platinum = new Button(this);
		Gold = new Button(this);
		Silver = new Button(this);

		Platinum.setText("Platinum");
		Platinum.setGravity(Gravity.CENTER);
		Gold.setText("Gold");
		Gold.setGravity(Gravity.CENTER);
		Silver.setText("Silver");
		Silver.setGravity(Gravity.CENTER);

		Platinum.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Typeofmembership.setText("Platinum Membership");
				membershipchooser.dismiss();
			}
		});
		Gold.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Typeofmembership.setText("Gold Membership");
				membershipchooser.dismiss();
			}
		});
		Silver.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Typeofmembership.setText("Silver Membership");
				membershipchooser.dismiss();
			}
		});
		LinearLayout.LayoutParams llpm = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		LinearLayout dialogview = new LinearLayout(this);
		dialogview.setOrientation(LinearLayout.VERTICAL);
		dialogview.addView(Platinum, llpm);
		dialogview.addView(Gold, llpm);
		dialogview.addView(Silver, llpm);
		membershipchooser = new Dialog(this);
		membershipchooser.setContentView(dialogview);
		membershipchooser.show();
		
	}


	public void composeemail(){
		String emailcontents ="Type of Membership :" + Typeofmembership.getText()+"\n"
				
						+"Name of Organization :" + nameoforganization.getText().toString() +"\n"
						+ "Organization Website :" + organizationwebsite.getText().toString() +"\n"
						+ "Contact Person : "+  contactperson.getText().toString() +"\n"
						+ "Job Title : "+  jobtitle.getText().toString() +"\n"
						+ "Email : "+  email.getText().toString() +"\n"
						+ "Contact Number : "+  contactnumber.getText().toString() +"\n";
				
		String[] TO = {"munasir@ftthcouncilap.org"};
	      String[] CC = {"gm.office@ftthcouncilap.org"};
	      Intent emailIntent = new Intent(Intent.ACTION_SEND);
	      emailIntent.setData(Uri.parse("mailto:"));
	      emailIntent.setType("text/plain");


	      emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
	      emailIntent.putExtra(Intent.EXTRA_CC, CC);
	      emailIntent.putExtra(Intent.EXTRA_SUBJECT, "FTTH Council Become a Member");
	      emailIntent.putExtra(Intent.EXTRA_TEXT, emailcontents);

	      try {
	         startActivity(Intent.createChooser(emailIntent, "Send mail..."));
	       
	      } catch (android.content.ActivityNotFoundException ex) {
	         Toast.makeText(BecomeAmemberActivity.this, 
	         "There is no email client installed.", Toast.LENGTH_SHORT).show();
	      }
	}

}
