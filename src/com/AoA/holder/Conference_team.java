package com.AoA.holder;

import java.util.ArrayList;

import org.json.JSONException;

import org.json.JSONObject;

import com.AoA.model.People;
public class Conference_team { 
public static ArrayList<People> all_conference_team;

public static ArrayList<People> getAll_conference_team() {
	return all_conference_team;
}

public static void setAll_conference_team(ArrayList<People> all_conference_team) {
	Conference_team.all_conference_team = all_conference_team;
}
	

	

}
