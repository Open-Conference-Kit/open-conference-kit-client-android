package com.AoA.holder;

import java.util.ArrayList;

import org.json.JSONException;

import org.json.JSONObject;

import com.AoA.model.People;
public class Team { 
public static ArrayList<People>allTeam;

public static ArrayList<People> getAllTeam() {
	return allTeam;
}

public static void setAllTeam(ArrayList<People> allTeam) {
	Team.allTeam = allTeam;
}

	

	

}
