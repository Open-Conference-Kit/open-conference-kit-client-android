package com.AoA.model;

import org.json.JSONException;

import org.json.JSONObject;
public class Conference_text { 
	public static Conference_text conferencetext;
String  id;
String  text;
public String getid() { 

		return id;

	}
public void setid(String id) {

		this.id = id;

	}
public String gettext() { 

		return text;

	}
public void settext(String text) {

	this.text = text;

	}
public static Conference_text create_obj_from_json(String json){

  JSONObject jobject = null;

  Conference_text conference_text = new Conference_text();

  try {

 jobject = new JSONObject(json);
conference_text.setid(jobject.getString("id"));
conference_text.settext(jobject.getString("text"));
} catch (JSONException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return conference_text;

	}

	

	

}
