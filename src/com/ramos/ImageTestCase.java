package com.ramos;

import java.io.File;
import java.io.FileOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class ImageTestCase extends UiAutomatorTestCase {

	public void saveBitMapToSdcard(Bitmap bitmap, String newName) {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("/mnt/sdcard/" + newName + ".png");
			if (out != null) {
				bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
				out.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 截取一张图片另存为
	public void cutBitmap(String menu, Rect rect, String path) {
		Bitmap m = BitmapFactory.decodeFile(path);
		m = m.createBitmap(m, rect.left, rect.top, rect.width(), rect.height());
		saveBitMapToSdcard(m, menu + "Close");
		// saveBitMapToSdcard(m,menu+"Open");
	}

}
