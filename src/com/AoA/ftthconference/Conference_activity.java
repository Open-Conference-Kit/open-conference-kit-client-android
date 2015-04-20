package com.AoA.ftthconference;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

import it.sephiroth.android.library.imagezoom.ImageViewTouch;

import com.AoA.holder.Conference_team;
import com.AoA.holder.Directors;
import com.AoA.holder.Speakers;
import com.AoA.model.Agenda;
import com.AoA.model.Conference_text;
import com.AoA.model.Floorplan;
import com.AoA.model.Members;
import com.AoA.model.Register;
import com.AoA.model.Sponsors;
import com.AoA.model.Venue;
import com.AoA.utils.apidownloader;
import com.AoA.utils.memberadapter;
import com.AoA.utils.people_listviewrenderer;
import com.AoA.utils.sponsoradapter;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CameraPositionCreator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mobsandgeeks.adapters.CircularListAdapter;

import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AbsListView.OnScrollListener;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;

public class Conference_activity extends BaseActivity {
//    private GoogleMap mMap;

	private LayoutInflater inflater;
	LinearLayout appconferencebuttonholder;
	LinearLayout contentholder;
	Button apconferencedrawer;
	public ImageView sponsorlogo;
	public TextView sponsortext;
	LinearLayout previousnextbuttonholder;
	LinearLayout conftextholder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		logo.setImageResource(R.drawable.annualconferencelogo);
		initializesidebuttons(this);
		conferencebutton.setBackgroundResource(R.drawable.annualconselect);
		
		contentholder = (LinearLayout)findViewById(R.id.maincontentholder);		
		inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout.LayoutParams llpm = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		contentholder.addView(inflater.inflate(R.layout.activity_conference_activity,null,false),llpm);
		
		appconferencebuttonholder = (LinearLayout)contentholder.findViewById(R.id.appconferencebuttonholder);
		previousnextbuttonholder = (LinearLayout)contentholder.findViewById(R.id.previousnextbuttonholder);
//		previousnextbuttonholder.setVisibility(View.GONE);
		conftextholder = (LinearLayout)contentholder.findViewById(R.id.conftextholder);
		conftextholderinit();
		createbuttons();
		
//		setContentView(R.layout.activity_conference_activity);
		// Show the Up button in the action bar.
//		setupActionBar();
	}
	public void conftextholderinit(){
		previousnextbuttonholder.setVisibility(View.GONE);
		conftextholder.setVisibility(View.VISIBLE);
		TextView textconf = (TextView)conftextholder.findViewById(R.id.conftextView);
		textconf.setText(Conference_text.conferencetext.gettext());
	}
	private void createbuttons() {
		previousnextbuttonholder = (LinearLayout)contentholder.findViewById(R.id.previousnextbuttonholder);
		conftextholder = (LinearLayout)contentholder.findViewById(R.id.conftextholder);
		conftextholderinit();
		
		// TODO Auto-generated method stub
		mainholder.setBackgroundResource(R.drawable.annualconferenceback1);
		Button conferenceteam = (Button)contentholder.findViewById(R.id.conference_team);
		conferenceteam.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				createview("conference team");
					
			}
		});
		
		Button speakers = (Button)contentholder.findViewById(R.id.speakersbutton);
		speakers.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				createview("speakers");
					
			}
		});
		Button venue = (Button)contentholder.findViewById(R.id.venuebutton);
		venue.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				createview("venue");
					
			}
		});
		
		Button sponsors = (Button)contentholder.findViewById(R.id.sponsors);
		sponsors.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				createview("sponsors");
					
			}
		});
		
		Button floorplan = (Button)contentholder.findViewById(R.id.floorplan);
		floorplan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				createview("floorplan");
					
			}
		});
		Button register = (Button)contentholder.findViewById(R.id.conferenceregisterbutton);
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(Register.register.getlink()));
				startActivity(i);
			}		
			
			
			
		});
		
		Button agenda = (Button)contentholder.findViewById(R.id.agendabutton);
		agenda.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				apidownloader.downloadpdf(Conference_activity.this,Agenda.agenda.getfile());
			}
		});
	}
	public void createview(final String screenname){
		Animation zoomout = AnimationUtils.loadAnimation(Conference_activity.this, R.anim.zoomout);
		appconferencebuttonholder.startAnimation(zoomout);
		zoomout.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				contentholder.removeAllViews();
				LinearLayout.LayoutParams llpm = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
				contentholder.addView(inflater.inflate(R.layout.conference_team_conference_activity,null,false),llpm);
				
				previousnextbuttonholder = (LinearLayout)contentholder.findViewById(R.id.previousnextbuttonholder);
				conftextholder = (LinearLayout)contentholder.findViewById(R.id.conftextholder);
			
				
				LinearLayout conferencecontent = (LinearLayout)contentholder.findViewById(R.id.conferencecontent);
				createscreen(conferencecontent, screenname);
				createappdrawerfunction();
			}
		});
		
	}
	public void createscreen(LinearLayout content,String screenname){
		
		if(screenname.equalsIgnoreCase("sponsors")){
			conftextholderinit();
			content.removeAllViews();
				LinearLayout sponsorscontent = (LinearLayout)inflater.inflate(R.layout.activity_sponsors,null,false);
				sponsorlogo = (ImageView)sponsorscontent.findViewById(R.id.sponsorlogo);
				sponsortext = (TextView)sponsorscontent.findViewById(R.id.sponsorcategory);
				sponsorscontent.addView(getsponsorlist(Conference_activity.this, Sponsors.allsponsors));
			content.addView(sponsorscontent);
		}
		if(screenname.equalsIgnoreCase("conference team")){
			conftextholderinit();
		content.removeAllViews();
		ListView peoplelist = new ListView(Conference_activity.this);
		peoplelist.setSelector(android.R.color.transparent);
		peoplelist.setCacheColorHint(Color.TRANSPARENT);
		peoplelist.setDividerHeight(0);
		people_listviewrenderer plvr = new people_listviewrenderer(Conference_team.all_conference_team, Conference_activity.this,Conference_activity.this);
		peoplelist.setAdapter(plvr);
		plvr.notifyDataSetChanged();
		TextView title = new TextView(Conference_activity.this);
		title.setText("Conference Team");
		title.setTextColor(Color.WHITE);
		title.setTextSize(25);
//		title.setText
		title.setGravity(Gravity.CENTER_HORIZONTAL);
		content.addView(title);
		content.addView(peoplelist);
		}
		if(screenname.equalsIgnoreCase("speakers")){
			conftextholderinit();
			content.removeAllViews();
			ListView peoplelist = new ListView(Conference_activity.this);
			peoplelist.setDividerHeight(0);
			people_listviewrenderer plvr = new people_listviewrenderer(Speakers.allspeakers, Conference_activity.this,Conference_activity.this);
			peoplelist.setAdapter(plvr);
			plvr.notifyDataSetChanged();
			TextView title = new TextView(Conference_activity.this);
			title.setText("Speakers");
			title.setTextColor(Color.WHITE);
			title.setTextSize(25);
//			title.setText
			title.setGravity(Gravity.CENTER_HORIZONTAL);
			content.addView(title);
			content.addView(peoplelist);
			}
		if(screenname.equalsIgnoreCase("floorplan")){
			conftextholderinit();
			content.removeAllViews();
			ImageViewTouch img = new ImageViewTouch(Conference_activity.this);
			Bitmap b = BitmapFactory.decodeFile(Floorplan.floorplanholder.getpicture());
			img.setImageBitmap(b);
			TextView title = new TextView(Conference_activity.this);
			title.setText("Floor plan");
			title.setTextColor(Color.WHITE);
			title.setTextSize(25);
//			title.setText
			title.setGravity(Gravity.CENTER_HORIZONTAL);
			content.addView(title);
			LinearLayout.LayoutParams llpm = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
			
			content.addView(img,llpm);
			}
		if(screenname.equalsIgnoreCase("venue")){
			mainholder.setBackgroundResource(R.drawable.annualconfvenueback);
			content.removeAllViews();
			createpreviousupcomingbuttonholders();
			previousbutton.setBackgroundResource(R.drawable.inactivetabbackright);
			 
			 upcominButton.setBackgroundResource(R.drawable.tabbackleftactive);
			 
			 
			content.addView(inflater.inflate(R.layout.conferencemapview,null,false));
			GoogleMapOptions gmo = (new GoogleMapOptions()).zoomControlsEnabled(false).rotateGesturesEnabled(false);
//			SupportMapFragment mapFragment = SupportMapFragment.newInstance(gmo);
			MiniMapFragment mapFragment = MiniMapFragment.newInstance(new LatLng(Float.parseFloat(Venue.currentvenue.getlattitude()),Float.parseFloat(Venue.currentvenue.getlongitude())));
			FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
			fragmentTransaction.add(R.id.mapFragmentHole, mapFragment);
			fragmentTransaction.commit();
			
			ImageView venueimage;
			TextView hotelname,hoteladdress,hotelmail,hotelnumber;
			venueimage = (ImageView)content.findViewById(R.id.venueimage);
			hotelname =(TextView)content.findViewById(R.id.hotelname);
			hoteladdress =(TextView)content.findViewById(R.id.hoteladdress);
			hotelmail =(TextView)content.findViewById(R.id.hotelmail);
			hotelnumber =(TextView)content.findViewById(R.id.hotelnumber);
			venueimage = (ImageView)content.findViewById(R.id.venueimage);
			venueimage.setImageBitmap(BitmapFactory.decodeFile(Venue.currentvenue.getpicture()));
			hotelname.setText(Venue.currentvenue.getname());
			hoteladdress.setText(Venue.currentvenue.getaddress());
			hotelmail.setText(Venue.currentvenue.getemail());
			hotelnumber.setText(Venue.currentvenue.getphone());
			
			hotelnumber.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					try {
	                    Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ Venue.currentvenue.getphone()));
	                    startActivity(callIntent);
	                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }
				}
			});
			hotelmail.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
				            "mailto",Venue.currentvenue.getemail(), null));
				startActivity(Intent.createChooser(emailIntent, "Send email..."));
				}
			});
			
			
		}
		if(screenname.equalsIgnoreCase("previous venue")){
			
			 
			 
			 
			mainholder.setBackgroundResource(R.drawable.annualconfvenueback);
			content.removeAllViews();
			content.addView(inflater.inflate(R.layout.conferencemapview,null,false));
			createpreviousupcomingbuttonholders();
			previousbutton.setBackgroundResource(R.drawable.tabbackrightactive);
			 
			 upcominButton.setBackgroundResource(R.drawable.inactivetabbackleft);
			 
			 
			GoogleMapOptions gmo = (new GoogleMapOptions()).zoomControlsEnabled(false).rotateGesturesEnabled(false);
			MiniMapFragment mapFragment = MiniMapFragment.newInstance(new LatLng(Float.parseFloat(Venue.previousvenue.getlattitude()),Float.parseFloat(Venue.previousvenue.getlongitude())));
			
			FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
			fragmentTransaction.add(R.id.mapFragmentHole, mapFragment);
			fragmentTransaction.commit();
			
			ImageView venueimage;
			TextView hotelname,hoteladdress,hotelmail,hotelnumber;
			venueimage = (ImageView)content.findViewById(R.id.venueimage);
			hotelname =(TextView)content.findViewById(R.id.hotelname);
			hoteladdress =(TextView)content.findViewById(R.id.hoteladdress);
			hotelmail =(TextView)content.findViewById(R.id.hotelmail);
			hotelnumber =(TextView)content.findViewById(R.id.hotelnumber);
			venueimage.setImageBitmap(BitmapFactory.decodeFile(Venue.previousvenue.getpicture()));
			
			hotelname.setText(Venue.previousvenue.getname());
			hoteladdress.setText(Venue.previousvenue.getaddress());
			hotelmail.setText(Venue.previousvenue.getemail());
			hotelnumber.setText(Venue.previousvenue.getphone());
			
			hotelnumber.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					try {
	                    Intent callIntent = new Intent(Intent.ACTION_CALL);
	                    callIntent.setData(Uri.parse("tel:"+ Venue.previousvenue.getphone()));
	                    startActivity(callIntent);
	                } catch (ActivityNotFoundException activityException) {
	                    Log.e("Calling a Phone Number", "Call failed", activityException);
	                }
				}
			});
			hotelmail.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
				            "mailto",Venue.previousvenue.getemail(), null));
				startActivity(Intent.createChooser(emailIntent, "Send email..."));
				}
			});
		}
	
	}
	Button previousbutton;
	Button upcominButton;
	public void createpreviousupcomingbuttonholders(){
		previousnextbuttonholder.setVisibility(View.VISIBLE);
		conftextholder.setVisibility(View.GONE);
		previousbutton = (Button)previousnextbuttonholder.findViewById(R.id.previousconferencebutton);
		previousbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				previousbutton.setBackgroundResource(R.drawable.tabbackrightactive);
				upcominButton.setBackgroundResource(R.drawable.inactivetabbackleft);
				LinearLayout conferencecontent = (LinearLayout)contentholder.findViewById(R.id.conferencecontent);
				createappdrawerfunction();
				createscreen(conferencecontent, "previous venue");
				
			}
		});
		
		upcominButton = (Button)previousnextbuttonholder.findViewById(R.id.upcomingconferencebutton);
		upcominButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				previousbutton.setBackgroundResource(R.drawable.inactivetabbackright);
				upcominButton.setBackgroundResource(R.drawable.tabbackleftactive);
				LinearLayout conferencecontent = (LinearLayout)contentholder.findViewById(R.id.conferencecontent);
				createappdrawerfunction();
				createscreen(conferencecontent, "venue");
				
			}
		});
	}

	protected void createappdrawerfunction() {
		// TODO Auto-generated method stub
		apconferencedrawer = (Button)contentholder.findViewById(R.id.conferencedrawer);
		apconferencedrawer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				conftextholderinit();
				contentholder.removeAllViews();
				LinearLayout.LayoutParams llpm = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
				contentholder.addView(inflater.inflate(R.layout.activity_conference_activity,null,false),llpm);
				appconferencebuttonholder = (LinearLayout)contentholder.findViewById(R.id.appconferencebuttonholder);
				appconferencebuttonholder.setVisibility(View.INVISIBLE);
				Animation zoomout = AnimationUtils.loadAnimation(Conference_activity.this, R.anim.zoomin);
				appconferencebuttonholder.startAnimation(zoomout);
				createbuttons();
			}
		});
	}
	static class MiniMapFragment extends SupportMapFragment {

		private LatLng mPosFija;


		public MiniMapFragment() {
		    super();

		}

		public static MiniMapFragment newInstance(LatLng posicion){
		    MiniMapFragment frag = new MiniMapFragment();
		    frag.mPosFija = posicion;
		    return frag;
		}

		@Override
		public View onCreateView(LayoutInflater arg0, ViewGroup arg1, Bundle arg2) {
		    View v = super.onCreateView(arg0, arg1, arg2);
		    initMap();
		    return v;
		}

		private void initMap(){
		    UiSettings settings = getMap().getUiSettings();
		    settings.setAllGesturesEnabled(false);
		    settings.setMyLocationButtonEnabled(false);

		    getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(mPosFija,12));
		    getMap().addMarker(new MarkerOptions().position(mPosFija));
		}
		}

	public ListView getsponsorlist(Context context,ArrayList <Sponsors> spon){
		final ArrayList<Sponsors>sponsors = spon;
		ListView lv = new ListView(context);
		sponsoradapter mra = new sponsoradapter(sponsors, context);
		ArrayAdapter ara = mra.returnadapter();
		CircularListAdapter circularAdapter = new CircularListAdapter(ara);
		lv.setAdapter(circularAdapter);
		circularAdapter.notifyDataSetChanged();
		lv.setSelector(android.R.color.transparent);
		lv.setCacheColorHint(Color.TRANSPARENT);
		lv.setOnScrollListener(new OnScrollListener() {
//			int i = 0;
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub
//				Toast.makeText(Conference_activity.this,""+ scrollState, Toast.LENGTH_SHORT).show();
//				mImageFetcher.loadImage("http://ftthapi.com/uploads/"+Members.allmembers.get(firstVisibleItem), memberlogo);
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				
				// TODO Auto-generated method stub
//				lv.getItemAtPosition(position)
//				if(firstVisibleItem > members.size()){
//					mImageFetcher.loadImage("http://ftthapi.com/uploads/"+members.get(firstVisibleItem).getlogo(), memberlogo);
//				}else{
				if((sponsoradapter.sponsorimages[firstVisibleItem%sponsors.size()] == null)){
					File newfile = new File("/sdcard/ftthconference/sponsors/"+sponsors.get(firstVisibleItem%sponsors.size()).getlogo());
					
					sponsoradapter.sponsorimages[firstVisibleItem%sponsors.size()] =  BitmapFactory.decodeFile(newfile.getAbsolutePath());
				}
				sponsorlogo.setImageBitmap(sponsoradapter.sponsorimages[firstVisibleItem%sponsors.size()]);
//				mImageFetcher.loadImage("http://ftthapi.com/uploads/"+members.get(firstVisibleItem%members.size()).getlogo(), memberlogo);
//				}
				sponsortext.setText(sponsors.get(firstVisibleItem%sponsors.size()).getcategory());
			}
		});
		return lv;
	}
}
