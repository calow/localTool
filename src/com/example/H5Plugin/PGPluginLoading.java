package com.example.H5Plugin;

import io.dcloud.DHInterface.AbsMgr;
import io.dcloud.DHInterface.IFeature;
import io.dcloud.DHInterface.IWebview;
import io.dcloud.util.JSUtil;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;

public class PGPluginLoading implements IFeature {

	private boolean mIsRun = false;
	
	@Override
	public void dispose(String arg0) {

	}

	public boolean isIsRun() {
		return mIsRun;
	}

	public void setIsRun(boolean isRun) {
		mIsRun = isRun;
	}

	@SuppressWarnings("deprecation")
	@TargetApi(Build.VERSION_CODES.CUPCAKE)
	@SuppressLint("NewApi")
	@Override
	public String execute(final IWebview pWebview, final String action,
			final String[] pArgs) {
		if(action.equals("test1")){
			for(int i=0; i < pArgs.length; i++)
				System.out.println(pArgs[i]);
			
			JSONObject retJSONObj = new JSONObject();
			try {
				retJSONObj.put("RetArgu1", "plugin1test1");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			if(mIsRun){
				return retJSONObj.toString();
			}
			return JSUtil.wrapJsVar(retJSONObj.toString(),false);
		}else if(action.equals("test2")){
			for(int i=0; i < pArgs.length; i++)
				System.out.println(pArgs[i]);
			
			JSONObject retJSONObj = new JSONObject();
			try {
				retJSONObj.put("RetArgu1", "plugin1test2");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			if(mIsRun){
				return retJSONObj.toString();
			}
			return JSUtil.wrapJsVar(retJSONObj.toString(),false);
		}
		return null;
		
	}

	@Override
	public void init(AbsMgr arg0, String arg1) {

	}

}
