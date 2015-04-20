package com.AoA.model;

import org.json.JSONException;

import org.json.JSONObject;
public class Agenda { 
	public static Agenda agenda;
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
public static Agenda create_obj_from_json(String json){

  JSONObject jobject = null;

  Agenda agenda = new Agenda();

  try {

 jobject = new JSONObject(json);
agenda.setid(jobject.getString("id"));
agenda.setdescription(jobject.getString("description"));
agenda.setfile(jobject.getString("file"));
} catch (JSONException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return agenda;

	}

	

	

}
