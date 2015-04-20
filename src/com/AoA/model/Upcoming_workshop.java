package com.AoA.model;

import org.json.JSONException;

import org.json.JSONObject;
public class Upcoming_workshop { 
String  id;
String  picture;
String  description;
public String getid() { 

		return id;

	}
public void setid(String id) {

		id = id;

	}
public String getpicture() { 

		return picture;

	}
public void setpicture(String picture) {

		picture = picture;

	}
public String getdescription() { 

		return description;

	}
public void setdescription(String description) {

		description = description;

	}
public static Upcoming_workshop create_obj_from_json(String json){

  JSONObject jobject = null;

  Upcoming_workshop upcoming_workshop = new Upcoming_workshop();

  try {

 jobject = new JSONObject(json);
upcoming_workshop.setid(jobject.getString("id"));
upcoming_workshop.setpicture(jobject.getString("picture"));
upcoming_workshop.setdescription(jobject.getString("description"));
} catch (JSONException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return upcoming_workshop;

	}

	

	

}