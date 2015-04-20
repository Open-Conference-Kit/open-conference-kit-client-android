package com.AoA.model;

import org.json.JSONException;

import org.json.JSONObject;
public class Floorplan { 
String  id;
String  picture;
String  description;

public static Floorplan floorplanholder;
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
public static Floorplan create_obj_from_json(String json){

  JSONObject jobject = null;

  Floorplan floorplan = new Floorplan();

  try {

 jobject = new JSONObject(json);
floorplan.setid(jobject.getString("id"));
floorplan.setpicture(jobject.getString("picture"));
floorplan.setdescription(jobject.getString("description"));
} catch (JSONException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return floorplan;

	}

	

	

}