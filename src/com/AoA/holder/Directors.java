package com.AoA.holder;
import java.util.ArrayList;

import org.json.JSONException;

import org.json.JSONObject;

import com.AoA.model.People;
public class Directors { 
public static ArrayList<People> allDirectors;

public static ArrayList<People> getDirectors() {
	return allDirectors;
}

public static void setDirectors(ArrayList<People> directors) {
	allDirectors = directors;
}

	

}