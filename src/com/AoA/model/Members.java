package com.AoA.model;

import java.util.ArrayList;

import org.json.JSONException;

import org.json.JSONObject;
public class Members { 
	public static ArrayList<Members> allmembers;
	public static ArrayList<Members> platinum;
	public static ArrayList<Members> gold;
	public static ArrayList<Members> silver;


String  id;
String  name;
String  logo;
String  category;
String  order;
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
public String getlogo() { 

		return logo;

	}
public void setlogo(String logo) {

	this.logo = logo;

	}
public String getcategory() { 

		return category;

	}
public void setcategory(String category) {

	this.category = category;

	}
public String getorder() { 

		return order;

	}
public void setorder(String order) {

	this.order = order;

	}
public static Members create_obj_from_json(String json){

  JSONObject jobject = null;

  Members members = new Members();

  try {

 jobject = new JSONObject(json);
members.setid(jobject.getString("id"));
members.setname(jobject.getString("name"));
members.setlogo(jobject.getString("logo"));
members.setcategory(jobject.getString("category"));
members.setorder(jobject.getString("order"));
} catch (JSONException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return members;

	}

	

	

}
