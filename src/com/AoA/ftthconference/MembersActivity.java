package com.AoA.ftthconference;

import java.io.File;
import java.util.ArrayList;

import com.AoA.model.Members;
import com.AoA.utils.memberadapter;
import com.example.android.displayingbitmaps.util.ImageCache;
import com.example.android.displayingbitmaps.util.ImageFetcher;
import com.mobsandgeeks.adapters.CircularListAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MembersActivity extends BaseActivity {

	private LayoutInflater inflater;
	public ImageView memberlogo;
	private static final String IMAGE_CACHE_DIR = "thumbs";

    private int mImageThumbSize;
    private int mImageThumbSpacing;
    private ImageFetcher mImageFetcher;
    
    Button all,platinum,gold,silver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ImageCache.ImageCacheParams cacheParams =
                new ImageCache.ImageCacheParams(this, IMAGE_CACHE_DIR);

        cacheParams.setMemCacheSizePercent(0.25f); // Set memory cache to 25% of app memory

        // The ImageFetcher takes care of loading images into our ImageView children asynchronously
        mImageFetcher = new ImageFetcher(this, 94);
//        mImageFetcher.setLoadingImage(R.drawable.demopic);
        mImageFetcher.addImageCache(getSupportFragmentManager(), cacheParams);
		
		
		
		
		
		
		
		logo.setImageResource(R.drawable.memberscreenlogo);
		mainholder.setBackgroundResource(R.drawable.memberscreenback);
		initializesidebuttons(this);
		membersbutton.setBackgroundResource(R.drawable.membersselect);
		
		LinearLayout contentholder = (LinearLayout)findViewById(R.id.maincontentholder);		
		inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout.LayoutParams llpm = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		contentholder.addView(inflater.inflate(R.layout.activity_members,null,false),llpm);
		
		memberlogo = (ImageView)contentholder.findViewById(R.id.memberlogo);
		all = (Button)contentholder.findViewById(R.id.allbutton);
		platinum =  (Button)contentholder.findViewById(R.id.platinumbutton);
		gold = (Button)contentholder.findViewById(R.id.goldbutton);
		silver = (Button)contentholder.findViewById(R.id.silverbutton);
		
		final LinearLayout memberlistlayout = (LinearLayout)contentholder.findViewById(R.id.memberlistholder);
		memberlistlayout.addView(getmemberlist(this,Members.allmembers));
		all.setBackgroundResource(R.drawable.tabbackleftactive);
		all.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				all.setBackgroundResource(R.drawable.tabbackleftactive);
				platinum.setBackgroundResource(R.drawable.inactivetabbackright);
				gold.setBackgroundResource(R.drawable.inactivetabbackleft);
				silver.setBackgroundResource(R.drawable.inactivetabbackright);
				memberlistlayout.removeAllViews();
				memberlistlayout.addView(getmemberlist(MembersActivity.this,Members.allmembers));
			}
		});
		
		platinum.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				all.setBackgroundResource(R.drawable.inactivetabbackleft);
				platinum.setBackgroundResource(R.drawable.tabbackrightactive);
				gold.setBackgroundResource(R.drawable.inactivetabbackleft);
				silver.setBackgroundResource(R.drawable.inactivetabbackright);
				memberlistlayout.removeAllViews();
				memberlistlayout.addView(getmemberlist(MembersActivity.this,Members.platinum));
			}
		});
		
		gold.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				all.setBackgroundResource(R.drawable.inactivetabbackleft);
				platinum.setBackgroundResource(R.drawable.inactivetabbackright);
				gold.setBackgroundResource(R.drawable.tabbackleftactive);
				silver.setBackgroundResource(R.drawable.inactivetabbackright);
				memberlistlayout.removeAllViews();
				memberlistlayout.addView(getmemberlist(MembersActivity.this,Members.gold));
			}
		});
		
		silver.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				all.setBackgroundResource(R.drawable.inactivetabbackleft);
				platinum.setBackgroundResource(R.drawable.inactivetabbackright);
				gold.setBackgroundResource(R.drawable.inactivetabbackleft);
				silver.setBackgroundResource(R.drawable.tabbackrightactive);
				memberlistlayout.removeAllViews();
				memberlistlayout.addView(getmemberlist(MembersActivity.this,Members.silver));
			}
		});
		
		
		
	
	}

	public ListView getmemberlist(Context context,ArrayList <Members> mem){
		final ArrayList<Members>members = mem;
		ListView lv = new ListView(context);
		lv.setSelector(android.R.color.transparent);
		lv.setCacheColorHint(Color.TRANSPARENT);
		memberadapter mra = new memberadapter(members, context);
		ArrayAdapter ara = mra.returnadapter();
		CircularListAdapter circularAdapter = new CircularListAdapter(ara);
		if(mem.size()>1){
		lv.setAdapter(circularAdapter);
		circularAdapter.notifyDataSetChanged();
		}else{
			lv.setAdapter(ara);
			ara.notifyDataSetChanged();
		}
		lv.setOnScrollListener(new OnScrollListener() {
//			int i = 0;
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub
//				Toast.makeText(MembersActivity.this,""+ scrollState, Toast.LENGTH_SHORT).show();
//				mImageFetcher.loadImage("http://ftthapi.com/uploads/"+Members.allmembers.get(firstVisibleItem), memberlogo);
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				
				// TODO Auto-generated method stub
//				lv.getItemAtPosition(position)
//				if(firstVisibleItem > members.size()){
//					mImageFetcher.loadImage("http://ftthapi.com/uploads/"+members.get(firstVisibleItem).getlogo(), memberlogo);
//				}else{
				if((memberadapter.memberimages[firstVisibleItem%members.size()] == null)){
					File newfile = new File("/sdcard/ftthconference/members/"+members.get(firstVisibleItem%members.size()).getlogo());
					
					memberadapter.memberimages[firstVisibleItem%members.size()] =  BitmapFactory.decodeFile(newfile.getAbsolutePath());
				}
				memberlogo.setImageBitmap(memberadapter.memberimages[firstVisibleItem%members.size()]);
//				mImageFetcher.loadImage("http://ftthapi.com/uploads/"+members.get(firstVisibleItem%members.size()).getlogo(), memberlogo);
//				}
			}
		});
		return lv;
	}

}
