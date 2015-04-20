package com.AoA.model;
import org.json.JSONException;

import org.json.JSONObject;

public class People { 
String  id;
String  name;
String  role;
String  description;
String  order;
String  picture;
public String getid() { 

		return id;

	}
public void setid(String id) {

		this.id = id;

	}
public String getname() { 

		return name;

	}
public void setname(String name) {

	this.name = name;

	}
public String getrole() { 

		return role;

	}
public void setrole(String role) {

	this.role = role;

	}
public String getdescription() { 

		return description;

	}
public void setdescription(String description) {

	this.description = description;

	}
public String getorder() { 

		return order;

	}
public void setorder(String order) {

	this.order = order;

	}
public String getpicture() { 

		return picture;

	}
public void setpicture(String picture) {

	this.picture = picture;

	}
public static People create_obj_from_json(String json){

  JSONObject jobject = null;

  People people = new People();

  try {

 jobject = new JSONObject(json);
people.setid(jobject.getString("id"));
people.setname(jobject.getString("name"));
people.setrole(jobject.getString("role"));
people.setdescription(jobject.getString("description"));
people.setorder(jobject.getString("order"));
people.setpicture(jobject.getString("picture"));
} catch (JSONException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return people;

	}

	

	

}