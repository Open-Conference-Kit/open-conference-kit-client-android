package com.AoA.holder;
import java.util.ArrayList;

import org.json.JSONException;

import org.json.JSONObject;

import com.AoA.model.People;
public class Committees { 
public static ArrayList <People> all_committees;

public static ArrayList<People> getAll_committees() {
	return all_committees;
}

public static void setAll_committees(ArrayList<People> all_committees) {
	Committees.all_committees = all_committees;
}

	

	

}