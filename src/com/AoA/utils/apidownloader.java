package com.AoA.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.AoA.holder.Committees;
import com.AoA.holder.Conference_team;
import com.AoA.holder.Directors;
import com.AoA.holder.Speakers;
import com.AoA.holder.Team;
import com.AoA.model.About;
import com.AoA.model.Agenda;
import com.AoA.model.Conference_text;
import com.AoA.model.Floorplan;
import com.AoA.model.Latest_studies;
import com.AoA.model.Members;
import com.AoA.model.People;
import com.AoA.model.Previous;
import com.AoA.model.Previous_studies;
import com.AoA.model.Register;
import com.AoA.model.Sponsors;
import com.AoA.model.Venue;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.AvoidXfermode.Mode;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class apidownloader extends AsyncTask {
	protected Context context;
	public boolean error = false;
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
//		Toast.makeText(context, "initializing resources please wait", Toast.LENGTH_SHORT).show();
	}
	public apidownloader(Context con){
		context = con;
	}
	@Override
	protected Object doInBackground(Object... arg0) {
		// TODO Auto-generated method stub
		
		try {
			SharedPreferences sp = context.getSharedPreferences("firstime", 0);
			SharedPreferences.Editor editor = sp.edit();
			Boolean firstrun = sp.getBoolean("fistrun", true);
			if(firstrun){
			editor.putBoolean("fistrun", false);
			editor.commit();
			
			File dir = new File("/sdcard/ftthconference/people/");
			if(!dir.exists()){
				dir.mkdirs();
			}
			File dir2 = new File("/sdcard/ftthconference/members/");
			if(!dir2.exists()){
				dir2.mkdirs();
			}
			File dir3 = new File("/sdcard/ftthconference/sponsors/");
			if(!dir3.exists()){
				dir3.mkdirs();
			}
			File dir4 = new File("/sdcard/ftthconference/venue/");
			if(!dir4.exists()){
				dir4.mkdirs();
			}
			File dir5 = new File("/sdcard/ftthconference/workshop/");
			if(!dir5.exists()){
				dir5.mkdirs();
			}
			copyAssets("people");
			copyAssets("members");
			copyAssets("sponsors");
		}
			String resultdata = HttpRequest.GetText(HttpRequest.GetRequest("http://ftthapi.com/index.php/ftthapi/getallapi"));
			JSONObject mainresult = new JSONObject(resultdata);
			aboutparser(new JSONArray(mainresult.getString("about")));
			directorsparser(new JSONArray(mainresult.getString("directors")));
			committeesparser(new JSONArray(mainresult.getString("committees")));
			teamparser(new JSONArray(mainresult.getString("team")));
			memberparser(new JSONArray(mainresult.getString("members")));
			Conference_textparser(new JSONArray(mainresult.getString("conference_text")));
			conference_teamparser(new JSONArray(mainresult.getString("conference_team")));
			speakerparser(new JSONArray(mainresult.getString("speakers")));
			floorplanparser(new JSONArray(mainresult.getString("floorplan")));
			agendaparser(new JSONArray(mainresult.getString("agenda")));
			sponsorparser(new JSONArray(mainresult.getString("sponsors")));
			venueparser(new JSONArray(mainresult.getString("venue")));
			previousvenueparser(new JSONArray(mainresult.getString("previous_venue")));
			registerparser(new JSONArray(mainresult.getString("register")));
			
			
			previousworkshopparser(new JSONArray(mainresult.getString("previous")));
			
			lateststudyparser(new JSONArray(mainresult.getString("latest_studies")));
			previoustudyparser(new JSONArray(mainresult.getString("previous_studies")));
		} catch (Exception e) {
			error = true;
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}
	@Override
	protected void onPostExecute(Object result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if(error){
			((Activity) context).finish();
		}
	}
	
	private void agendaparser(JSONArray jsonArray) {
		// TODO Auto-generated method stub
		for(int i = 0;i < jsonArray.length(); i ++){
			try {
				Agenda.agenda = Agenda.create_obj_from_json(jsonArray.getString(i));
				Agenda.agenda.setfile("http://ftthapi.com/uploads/"+Agenda.agenda.getfile());
//				Directors.allDirectors.add(person);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void registerparser(JSONArray jsonArray) {
		// TODO Auto-generated method stub
		for(int i = 0;i < jsonArray.length(); i ++){
			try {
				Register.register = Register.create_obj_from_json(jsonArray.getString(i));
//				Directors.allDirectors.add(person);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void Conference_textparser(JSONArray jsonArray) {
		// TODO Auto-generated method stub
		for(int i = 0;i < jsonArray.length(); i ++){
			try {
				Conference_text.conferencetext = Conference_text.create_obj_from_json(jsonArray.getString(i));
//				Directors.allDirectors.add(person);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void previousworkshopparser(JSONArray jsonArray) {
		// TODO Auto-generated method stub
		for(int i = 0;i < jsonArray.length(); i ++){
			try {
				Previous.previousholder = Previous.create_obj_from_json(jsonArray.getString(i));
				File workshopimage = new File("/sdcard/ftthconference/workshop/"+Previous.previousholder.getpicture());
				if(!workshopimage.exists()){
				DownloadFile("http://ftthapi.com/uploads/"+Previous.previousholder.getpicture(), workshopimage);
				Previous.previousholder.setpicture("/sdcard/ftthconference/workshop/"+Previous.previousholder.getpicture());
				}else{
					Previous.previousholder.setpicture("/sdcard/ftthconference/workshop/"+Previous.previousholder.getpicture());
				}
//				Directors.allDirectors.add(person);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void previousvenueparser(JSONArray jsonArray) {
		// TODO Auto-generated method stub
		for(int i = 0;i < jsonArray.length(); i ++){
			try {
				Venue.previousvenue = Venue.create_obj_from_json(jsonArray.getString(i));
				File venueimage = new File("/sdcard/ftthconference/venue/"+Venue.previousvenue.getpicture());
				if(!venueimage.exists()){
				DownloadFile("http://ftthapi.com/uploads/"+Venue.previousvenue.getpicture(), venueimage);
				Venue.previousvenue.setpicture("/sdcard/ftthconference/venue/"+Venue.previousvenue.getpicture());
				}else{
					Venue.previousvenue.setpicture("/sdcard/ftthconference/venue/"+Venue.previousvenue.getpicture());
				}
//				Directors.allDirectors.add(person);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void venueparser(JSONArray jsonArray) {
		// TODO Auto-generated method stub
		for(int i = 0;i < jsonArray.length(); i ++){
			try {
				Venue.currentvenue = Venue.create_obj_from_json(jsonArray.getString(i));
				File venueimage = new File("/sdcard/ftthconference/venue/"+Venue.currentvenue.getpicture());
				if(!venueimage.exists()){
				DownloadFile("http://ftthapi.com/uploads/"+Venue.currentvenue.getpicture(), venueimage);
				Venue.currentvenue.setpicture("/sdcard/ftthconference/venue/"+Venue.currentvenue.getpicture());
				}else{
					Venue.currentvenue.setpicture("/sdcard/ftthconference/venue/"+Venue.currentvenue.getpicture());
				}
//				Directors.allDirectors.add(person);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void sponsorparser(JSONArray jsonArray) {
		// TODO Auto-generated method stub
		Sponsors.allsponsors = new ArrayList<Sponsors>();
		for(int i = 0;i < jsonArray.length(); i ++){
			try {
				Sponsors sponsors = Sponsors.create_obj_from_json(jsonArray.getString(i));
				Sponsors.allsponsors.add(sponsors);
				File sponsorsimage = new File("/sdcard/ftthconference/sponsors/"+sponsors.getlogo());
				if(!sponsorsimage.exists()){
				DownloadFile("http://ftthapi.com/uploads/"+sponsors.getlogo(), sponsorsimage);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	private void previoustudyparser(JSONArray jsonArray) {
		// TODO Auto-generated method stub
		Previous_studies.allpreviousStudies = new ArrayList<Previous_studies>();
		for(int i = 0;i < jsonArray.length(); i ++){
			try {
				Previous_studies ps = Previous_studies.create_obj_from_json(jsonArray.getString(i));
				Previous_studies.allpreviousStudies.add(ps);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	private void lateststudyparser(JSONArray jsonArray) {
		// TODO Auto-generated method stub
		for(int i = 0;i < jsonArray.length(); i ++){
			try {
				Latest_studies.lateststudyholder = Latest_studies.create_obj_from_json(jsonArray.getString(i));
//				Directors.allDirectors.add(person);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void floorplanparser(JSONArray jsonArray) {
		// TODO Auto-generated method stub
		for(int i = 0;i < jsonArray.length(); i ++){
			try {
				Floorplan.floorplanholder = Floorplan.create_obj_from_json(jsonArray.getString(i));
				File dir = new File("/sdcard/ftthconference/floorplan/");
				if(!dir.exists()){
					dir.mkdirs();
				}
				File floorplanimage = new File("/sdcard/ftthconference/floorplan/"+Floorplan.floorplanholder.getpicture());
				if(!floorplanimage.exists()){
					DownloadFile("http://ftthapi.com/uploads/"+Floorplan.floorplanholder.getpicture(), floorplanimage);
					Floorplan.floorplanholder.setpicture("/sdcard/ftthconference/floorplan/"+Floorplan.floorplanholder.getpicture());
				}else{
					Floorplan.floorplanholder.setpicture("/sdcard/ftthconference/floorplan/"+Floorplan.floorplanholder.getpicture());
				}
//				Directors.allDirectors.add(person);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void speakerparser(JSONArray jsonArray) {
		// TODO Auto-generated method stub
		Speakers.allspeakers = new ArrayList<People>();
		for(int i = 0;i < jsonArray.length(); i ++){
			try {
				People person = People.create_obj_from_json(jsonArray.getString(i));
				Speakers.allspeakers.add(person);
				File personimage = new File("/sdcard/ftthconference/people/"+person.getpicture());
				if(!personimage.exists()){
				DownloadFile("http://ftthapi.com/uploads/"+person.getpicture(), personimage);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	private void aboutparser(JSONArray jsonArray) {
		// TODO Auto-generated method stub
		for(int i = 0;i < jsonArray.length(); i ++){
			try {
				About.about = About.create_obj_from_json(jsonArray.getString(i));
//				Directors.allDirectors.add(person);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void directorsparser(JSONArray directors){
		Directors.allDirectors = new ArrayList<People>();
		for(int i = 0;i < directors.length(); i ++){
			try {
				People person = People.create_obj_from_json(directors.getString(i));
				Directors.allDirectors.add(person);
				File personimage = new File("/sdcard/ftthconference/people/"+person.getpicture());
				if(!personimage.exists()){
				DownloadFile("http://ftthapi.com/uploads/"+person.getpicture(), personimage);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void committeesparser(JSONArray directors){
		Committees.all_committees = new ArrayList<People>();
		for(int i = 0;i < directors.length(); i ++){
			try {
				People person = People.create_obj_from_json(directors.getString(i));
				Committees.all_committees.add(person);
				File personimage = new File("/sdcard/ftthconference/people/"+person.getpicture());
				if(!personimage.exists()){
				DownloadFile("http://ftthapi.com/uploads/"+person.getpicture(), personimage);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void teamparser(JSONArray directors){
		Team.allTeam = new ArrayList<People>();
		for(int i = 0;i < directors.length(); i ++){
			try {
				People person = People.create_obj_from_json(directors.getString(i));
				Team.allTeam.add(person);
				File personimage = new File("/sdcard/ftthconference/people/"+person.getpicture());
				if(!personimage.exists()){
				DownloadFile("http://ftthapi.com/uploads/"+person.getpicture(), personimage);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void conference_teamparser(JSONArray directors){
		Conference_team.all_conference_team = new ArrayList<People>();
		for(int i = 0;i < directors.length(); i ++){
			try {
				People person = People.create_obj_from_json(directors.getString(i));
				Conference_team.all_conference_team.add(person);
				File personimage = new File("/sdcard/ftthconference/people/"+person.getpicture());
				if(!personimage.exists()){
				DownloadFile("http://ftthapi.com/uploads/"+person.getpicture(), personimage);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void memberparser(JSONArray members){
		Members.allmembers = new ArrayList<Members>();
		Members.platinum = new ArrayList<Members>();
		Members.gold = new ArrayList<Members>();
		Members.silver = new ArrayList<Members>();
		for(int i = 0;i < members.length(); i ++){
			try {
				Members member = Members.create_obj_from_json(members.getString(i));
				if(member.getcategory().equalsIgnoreCase("gold")){
					Members.gold.add(member);
				}else if (member.getcategory().equalsIgnoreCase("platinum")){
					Members.platinum.add(member);
				}else if (member.getcategory().equalsIgnoreCase("silver")){
					Members.silver.add(member);
				}
				File memberimage = new File("/sdcard/ftthconference/members/"+member.getlogo());
				if(!memberimage.exists()){
				DownloadFile("http://ftthapi.com/uploads/"+member.getlogo(), memberimage);
				}
				Members.allmembers.add(member);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	 public static void DownloadFile(String fileURL, File directory) {
	        try {

	            FileOutputStream f = new FileOutputStream(directory);
	            URL u = new URL(fileURL);
	            HttpURLConnection c = (HttpURLConnection) u.openConnection();
	            c.setRequestMethod("GET");
	            c.setDoOutput(true);
	            c.connect();

	            InputStream in = c.getInputStream();

	            byte[] buffer = new byte[1024];
	            int len1 = 0;
	            while ((len1 = in.read(buffer)) > 0) {
	                f.write(buffer, 0, len1);
	            }
	            f.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	 private void copyAssets(String foldername) {
		    AssetManager assetManager = context.getAssets();
		    String[] files = null;
		    try {
		        files = assetManager.list(foldername);
		    } catch (IOException e) {
		       
		    }
		    for(String filename : files) {
		    	Log.v("assetname", filename);
		        InputStream in = null;
		        OutputStream out = null;
		        try {
		          in = assetManager.open(foldername+"/"+filename);
		          File outFile = new File("/sdcard/ftthconference/"+foldername+"/", filename);
		          out = new FileOutputStream(outFile);
		          copyFile(in, out);
		          in.close();
		          in = null;
		          out.flush();
		          out.close();
		          out = null;
		        } catch(IOException e) {
		            
		        }       
		    }
		}
		private void copyFile(InputStream in, OutputStream out) throws IOException {
		    byte[] buffer = new byte[1024];
		    int read;
		    while((read = in.read(buffer)) != -1){
		      out.write(buffer, 0, read);
		    }
		}
		
		public static void downloadpdf(Context con ,String url){
//			new Intent(Intent.ACTION_VIEW, Uri.parse(url));
			DownloadManager.Request r = new DownloadManager.Request(Uri.parse(url));

			// This put the download in the same Download dir the browser uses
			r.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, url.split("/")[url.split("/").length-1]);

			// When downloading music and videos they will be listed in the player
			// (Seems to be available since Honeycomb only)
			r.allowScanningByMediaScanner();

			// Notify user when download is completed
			// (Seems to be available since Honeycomb only)
			r.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

			// Start download
			DownloadManager dm = (DownloadManager)con.getSystemService(con.DOWNLOAD_SERVICE);
			dm.enqueue(r);
			Toast.makeText(con, "please see notification bar the pdf is being downloaded", Toast.LENGTH_LONG).show();
		}
}
