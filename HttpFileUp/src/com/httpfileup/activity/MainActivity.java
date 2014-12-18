package com.httpfileup.activity;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	public static final String TAG = "MainActivity";
	Button button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		button = (Button) findViewById(R.id.button);
		 button.setOnClickListener(listener);
	}

	String code = "";

	/**
	 * 按钮响应事件
	 */
	private View.OnClickListener listener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			Button button = (Button) v;
			switch (button.getId()) {
			case R.id.button:
				String actionUrl = "";
				Map<String, String> params = new HashMap<String, String>();
				params.put("title", "strParamValue");
				params.put("remark", "strParamValue");
				params.put("usemame", "strParamValue");
				params.put("usertel", "strParamValue");
				params.put("eventime", "strParamValue");
				params.put("evenaddress", "strParamValue");
				params.put("addtime", "strParamValue");
				params.put("edittime", "strParamValue");
				params.put("muploadid", "strParamValue");
				Map<String, File> files = new HashMap<String, File>();
				files.put("test.png", new File("/sdcard/test.png"));
				files.put("sample.png", new File("/sdcard/sample.png"));
				files.put("22.png", new File("/sdcard/22.png"));
				files.put("6.png", new File("/sdcard/6.png"));
				try {
						HttpFileUpTool.post(actionUrl, params, files);
					} catch (IOException e) {
						e.printStackTrace();
						Log.i(TAG, e.toString());
					}
//					Log.i(TAG, "code:"+code);
				break;
			}
		}
	};

}