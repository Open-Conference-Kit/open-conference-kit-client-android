package com.AoA.model;

import org.json.JSONException;

import org.json.JSONObject;
public class Latest_studies { 
	public static Latest_studies lateststudyholder;
String  id;
String  description;
String  file;
public String getid() { 

		return id;

	}
public void setid(String id) {

		this.id = id;

	}
public String getdescription() { 

		return description;

	}
public void setdescription(String description) {

	this.description = description;

	}
public String getfile() { 

		return file;

	}
public void setfile(String file) {

	this.file = file;

	}
public static Latest_studies create_obj_from_json(String json){

  JSONObject jobject = null;

  Latest_studies latest_studies = new Latest_studies();

  try {

 jobject = new JSONObject(json);
latest_studies.setid(jobject.getString("id"));
latest_studies.setdescription(jobject.getString("description"));
latest_studies.setfile(jobject.getString("link"));
} catch (JSONException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return latest_studies;

	}

	

	

}