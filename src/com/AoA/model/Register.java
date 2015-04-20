package com.AoA.model;

import org.json.JSONException;

import org.json.JSONObject;
public class Register { 
	public static Register register;
String  id;
String  description;
String  link;
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
public String getlink() { 

		return link;

	}
public void setlink(String link) {

		this.link = link;

	}
public static Register create_obj_from_json(String json){

  JSONObject jobject = null;

  Register register = new Register();

  try {

 jobject = new JSONObject(json);
register.setid(jobject.getString("id"));
register.setdescription(jobject.getString("description"));
register.setlink(jobject.getString("link"));
} catch (JSONException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return register;

	}

	

	

}
