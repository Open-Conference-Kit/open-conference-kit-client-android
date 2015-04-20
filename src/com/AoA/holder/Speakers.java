package com.AoA.holder;
import java.util.ArrayList;

import org.json.JSONException;

import org.json.JSONObject;

import com.AoA.model.People;
public class Speakers { 
public static ArrayList<People> allspeakers;

public ArrayList<People> getAllspeakers() {
	return allspeakers;
}

public void setAllspeakers(ArrayList<People> allspeakers) {
	this.allspeakers = allspeakers;
}

}
