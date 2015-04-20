package com.AoA.model;

import org.json.JSONException;

import org.json.JSONObject;
public class About { 
	public static About about;
String  id;
String  textaboutinfo;
public String getid() { 

		return id;

	}
public void setid(String id) {

		this.id = id;

	}
public String gettextaboutinfo() { 

		return textaboutinfo;

	}
public void settextaboutinfo(String textaboutinfo) {

	this.textaboutinfo = textaboutinfo;

	}
public static About create_obj_from_json(String json){

  JSONObject jobject = null;

  About about = new About();

  try {

 jobject = new JSONObject(json);
about.setid(jobject.getString("id"));
about.settextaboutinfo(jobject.getString("textaboutinfo"));
} catch (JSONException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return about;

	}

	

	

}