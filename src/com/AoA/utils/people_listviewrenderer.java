package com.AoA.utils;

import java.io.File;
import java.util.ArrayList;

import com.AoA.ftthconference.R;
import com.AoA.model.People;
import com.example.android.displayingbitmaps.util.ImageCache;
import com.example.android.displayingbitmaps.util.ImageFetcher;
import com.example.android.displayingbitmaps.util.RecyclingBitmapDrawable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class people_listviewrenderer extends BaseAdapter{
	private static final String IMAGE_CACHE_DIR = "thumbs";

    private int mImageThumbSize;
    private int mImageThumbSpacing;
    private ImageFetcher mImageFetcher;
	ArrayList<People> peoplelist;
	public Bitmap [] peopleimages;
	Bitmap myBitmap;
	Context context;
	public people_listviewrenderer(ArrayList<People> peoplelist,Context con,FragmentActivity frgact){
		peopleimages = new Bitmap [peoplelist.size()];
//		for(int i = 0;i<peoplelist.size();i++){
//			
//		}
		
		
		this.peoplelist = peoplelist;
		context = con;
		 ImageCache.ImageCacheParams cacheParams =
	                new ImageCache.ImageCacheParams(con, IMAGE_CACHE_DIR);

	        cacheParams.setMemCacheSizePercent(0.25f); // Set memory cache to 25% of app memory

	        // The ImageFetcher takes care of loading images into our ImageView children asynchronously
	        mImageFetcher = new ImageFetcher(con, 176,215);
	        mImageFetcher.setLoadingImage(R.drawable.demopic);
	        mImageFetcher.addImageCache(frgact.getSupportFragmentManager(), cacheParams);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return peoplelist.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View arg1, ViewGroup arg2) {
		People person = peoplelist.get(position);
		if(peopleimages[position] == null){
			File newfile = new File("/sdcard/ftthconference/people/"+peoplelist.get(position).getpicture());
			
			peopleimages[position] =  BitmapFactory.decodeFile(newfile.getAbsolutePath());
		}
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row;
        row = inflater.inflate(R.layout.people_row, null, false);
        TextView title, role,organization;
        ImageView peopleimage;
        title = (TextView)row.findViewById(R.id.name);
        role = (TextView)row.findViewById(R.id.role);
        organization =  (TextView)row.findViewById(R.id.organization);
        peopleimage = (ImageView)row.findViewById(R.id.peoplepic);
        title.setText(person.getname());
        role.setText(person.getrole());
        organization.setText(person.getdescription());
//        mImageFetcher.loadImage("file:///"+"sdcard/Arief_Mustain,_Telekom_Indonesia.jpg", peopleimage);
        
//          RecyclingBitmapDrawable rbd = new RecyclingBitmapDrawable(context.getResources(), myBitmap);
          
         peopleimage.setImageBitmap(peopleimages[position]);
//        mImageFetcher.loadImage("http://ftthapi.com/uploads/"+person.getpicture(), peopleimage);
		return row;
	}

}
