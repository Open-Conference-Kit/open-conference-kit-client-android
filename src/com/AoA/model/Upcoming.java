package com.AoA.model;

import org.json.JSONException;

import org.json.JSONObject;
public class Upcoming { 
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
public static Upcoming create_obj_from_json(String json){

  JSONObject jobject = null;

  Upcoming upcoming = new Upcoming();

  try {

 jobject = new JSONObject(json);
upcoming.setid(jobject.getString("id"));
upcoming.setpicture(jobject.getString("picture"));
upcoming.setdescription(jobject.getString("description"));
} catch (JSONException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return upcoming;

	}

	

	

}