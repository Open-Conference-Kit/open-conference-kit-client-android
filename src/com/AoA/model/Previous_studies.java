package com.AoA.model;

import java.util.ArrayList;

import org.json.JSONException;

import org.json.JSONObject;
public class Previous_studies { 
	public static ArrayList<Previous_studies> allpreviousStudies;
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
public static Previous_studies create_obj_from_json(String json){

  JSONObject jobject = null;

  Previous_studies previous_studies = new Previous_studies();

  try {

 jobject = new JSONObject(json);
previous_studies.setid(jobject.getString("id"));
previous_studies.setdescription(jobject.getString("description"));
previous_studies.setfile(jobject.getString("file"));
} catch (JSONException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return previous_studies;

	}

	

	

}