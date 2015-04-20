package com.AoA.model;

import java.util.ArrayList;

import org.json.JSONException;

import org.json.JSONObject;
public class Sponsors { 
	public static ArrayList<Sponsors> allsponsors;
String  id;
String  category;
String  logo;
String  name;
String  order;
public String getid() { 

		return id;

	}
public void setid(String id) {

		this.id = id;

	}
public String getcategory() { 

		return category;

	}
public void setcategory(String category) {

	this.category = category;

	}
public String getlogo() { 

		return logo;

	}
public void setlogo(String logo) {

	this.logo = logo;

	}
public String getname() { 

		return name;

	}
public void setname(String name) {

	this.name = name;

	}
public String getorder() { 

		return order;

	}
public void setorder(String order) {

	this.order = order;

	}
public static Sponsors create_obj_from_json(String json){

  JSONObject jobject = null;

  Sponsors sponsors = new Sponsors();

  try {

 jobject = new JSONObject(json);
sponsors.setid(jobject.getString("id"));
sponsors.setcategory(jobject.getString("category"));
sponsors.setlogo(jobject.getString("logo"));
sponsors.setname(jobject.getString("name"));
sponsors.setorder(jobject.getString("order"));
} catch (JSONException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return sponsors;

	}

	

	

}
