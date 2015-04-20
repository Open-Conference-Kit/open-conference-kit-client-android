package com.AoA.utils;

import java.io.File;
import java.util.ArrayList;

import com.AoA.model.Members;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ArrayAdapter;

public class memberadapter {
	ArrayList<String> values;
	public static Bitmap [] memberimages;
	Context context;
	public memberadapter(ArrayList<Members> members,Context con){
		context = con;
		memberimages = new Bitmap [members.size()];
//		for(int i = 0;i<members.size();i++){
//			File newfile = new File("/sdcard/ftthconference/members/"+members.get(i).getlogo());
//			
//			memberimages[i] =  BitmapFactory.decodeFile(newfile.getAbsolutePath());
//		}
		values = new ArrayList<String>();
		for(int i = 0;i<members.size();i++){
			values.add(members.get(i).getname());
		}
	}
	public ArrayAdapter returnadapter(){
	ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, android.R.id.text1, values);
	return adapter;
	}
}
