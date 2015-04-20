package com.AoA.model;

import org.json.JSONException;

import org.json.JSONObject;
public class Details { 
String  id;
String  description;
String  picture;
public String getid() { 

		return id;

	}
public void setid(String id) {

		id = id;

	}
public String getdescription() { 

		return description;

	}
public void setdescription(String description) {

		description = description;

	}
public String getpicture() { 

		return picture;

	}
public void setpicture(String picture) {

		picture = picture;

	}
public static Details create_obj_from_json(String json){

  JSONObject jobject = null;

  Details details = new Details();

  try {

 jobject = new JSONObject(json);
details.setid(jobject.getString("id"));
details.setdescription(jobject.getString("description"));
details.setpicture(jobject.getString("picture"));
} catch (JSONException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return details;

	}

	

	

}
