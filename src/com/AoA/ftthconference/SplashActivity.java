package com.AoA.ftthconference;

import com.AoA.holder.Directors;
import com.AoA.model.About;
import com.AoA.utils.apidownloader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashcreen);
		apidownloaderextend task = new apidownloaderextend(this);
		task.execute();
	}
	class apidownloaderextend extends apidownloader{
		public apidownloaderextend(Context con){
			super(con);
		}
		@Override
		protected void onPostExecute(Object result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if(error){
				Toast.makeText(context, "no internet connection application would be unstable", Toast.LENGTH_SHORT).show();
				if (Directors.allDirectors !=null){
					Intent i = new Intent(SplashActivity.this, MainMenuActivity.class);
					startActivity(i);}
			}else if (Directors.allDirectors !=null){
			Intent i = new Intent(SplashActivity.this, MainMenuActivity.class);
			startActivity(i);
			finish();
			}
		}
		
	}

}
