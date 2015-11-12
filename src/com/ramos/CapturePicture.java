package com.ramos;

import java.io.File;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

public class CapturePicture extends ImageTestCase {

	/**
	 * @param args
	 * @throws UiObjectNotFoundException
	 * 步骤：
	 * 1.打开上拉菜单；
	 * 2.截取上拉菜单中所有快捷开关
	 * 3.第一次截取的是所有开关均处于关闭时的图片；
	 * 4.若需再次截取所有开关均处于打开时的图片，则需将ImageTestCase中开启saveBitMapToSdcard(m,menu+"Open");
	 */

	public void testCapture() throws UiObjectNotFoundException {
		// 打开上拉菜单
		UiDevice.getInstance().swipe(540, 1918, 540, 1318, 50);
		sleep(1000);

		// 截取图片
		String[] menu = { "wifi", "data", "bt", "gps", "mute", "roration",
				"flymode", "busy" };
		for (int i = 0; i < menu.length; i++) {
			String id = "com.android.systemui:id/" + menu[i];
			UiObject MenuIcon = new UiObject(new UiSelector().resourceId(id));
			Rect rect = MenuIcon.getBounds();
			String path = "/mnt/sdcard/ScreenShot.png";
			File file = new File(path);
			UiDevice.getInstance().takeScreenshot(file);
			// cutBitmap(rect,path);
			cutBitmap(menu[i], rect, path);

		}

	}

	public static void main(String[] args) {
		String jarName, testClass, testName, androidId;
		jarName = "CapturePicture";
		testClass = "com.ramos.CapturePicture";
		testName = "testCapture";
		androidId = "1";
		new UiAutomatorHelper(jarName, testClass, testName, androidId);
	}

}
