package com.AoA.model;
import org.json.JSONException;

import org.json.JSONObject;
public class Venue { 
	public static Venue currentvenue;
	public static Venue previousvenue;
String  id;
String  picture;
String  lattitude;
String  longitude;
String  phone;
String  description;
String  pdf;
String  name;
String  address;
String  url;
String  email;
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
public String getlattitude() { 

		return lattitude;

	}
public void setlattitude(String lattitude) {

	this.lattitude = lattitude;

	}
public String getlongitude() { 

		return longitude;

	}
public void setlongitude(String longitude) {

	this.longitude = longitude;

	}
public String getphone() { 

		return phone;

	}
public void setphone(String phone) {

	this.phone = phone;

	}
public String getdescription() { 

		return description;

	}
public void setdescription(String description) {

	this.description = description;

	}
public String getpdf() { 

		return pdf;

	}
public void setpdf(String pdf) {

	this.pdf = pdf;

	}
public String getname() { 

		return name;

	}
public void setname(String name) {

	this.name = name;

	}
public String getaddress() { 

		return address;

	}
public void setaddress(String address) {

	this.address = address;

	}
public String geturl() { 

		return url;

	}
public void seturl(String url) {

	this.url = url;

	}
public String getemail() { 

		return email;

	}
public void setemail(String email) {

	this.email = email;

	}
public static Venue create_obj_from_json(String json){

  JSONObject jobject = null;

  Venue venue = new Venue();

  try {

 jobject = new JSONObject(json);
venue.setid(jobject.getString("id"));
venue.setpicture(jobject.getString("picture"));
venue.setlattitude(jobject.getString("lattitude"));
venue.setlongitude(jobject.getString("longitude"));
venue.setphone(jobject.getString("phone"));
venue.setdescription(jobject.getString("description"));
venue.setpdf(jobject.getString("pdf"));
venue.setname(jobject.getString("name"));
venue.setaddress(jobject.getString("address"));
venue.seturl(jobject.getString("url"));
venue.setemail(jobject.getString("email"));
} catch (JSONException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return venue;

	}

	

	

}
