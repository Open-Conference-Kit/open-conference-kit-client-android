package com.AoA.model;

import org.json.JSONException;

import org.json.JSONObject;
public class Previous { 
	public static Previous previousholder;
String  id;
String  picture;
String  description;
String  title;
String  pdf;
public String getid() { 

		return id;

	}
public void setid(String id) {

		this.id = id;

	}
public String getpicture() { 

		return picture;

	}
public void setpicture(String picture) {

	this.picture = picture;

	}
public String getdescription() { 

		return description;

	}
public void setdescription(String description) {

	this.description = description;

	}
public String gettitle() { 

		return title;

	}
public void settitle(String title) {

	this.title = title;

	}
public String getpdf() { 

		return pdf;

	}
public void setpdf(String pdf) {

	this.pdf = pdf;

	}
public static Previous create_obj_from_json(String json){

  JSONObject jobject = null;

  Previous previous = new Previous();

  try {

 jobject = new JSONObject(json);
previous.setid(jobject.getString("id"));
previous.setpicture(jobject.getString("picture"));
previous.setdescription(jobject.getString("description"));
previous.settitle(jobject.getString("title"));
previous.setpdf(jobject.getString("pdf"));
} catch (JSONException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return previous;

	}

	

	

}
