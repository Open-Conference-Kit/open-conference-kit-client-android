package com.AoA.utils;

import java.io.File;
import java.util.ArrayList;

import com.AoA.model.Members;
import com.AoA.model.Sponsors;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ArrayAdapter;

public class sponsoradapter {
	ArrayList<String> values;
	public static Bitmap [] sponsorimages;
	Context context;
	public sponsoradapter(ArrayList<Sponsors> sponsors,Context con){
		context = con;
		sponsorimages = new Bitmap [sponsors.size()];
//		for(int i = 0;i<members.size();i++){
//			File newfile = new File("/sdcard/ftthconference/members/"+members.get(i).getlogo());
//			
//			memberimages[i] =  BitmapFactory.decodeFile(newfile.getAbsolutePath());
//		}
		values = new ArrayList<String>();
		for(int i = 0;i<sponsors.size();i++){
			values.add(sponsors.get(i).getname());
		}
	}
	public ArrayAdapter returnadapter(){
	ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, android.R.id.text1, values);
	return adapter;
	}
}
