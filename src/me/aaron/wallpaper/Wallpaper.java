package me.aaron.wallpaper;

import java.awt.Dimension;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.win32.W32APIOptions;

public class Wallpaper {

	String dayWallpaper = "E:\\day-wallpaper.jpg";
	String nightWallpaper = "E:\\night-wallpaper2.jpg";

	public static void main(String[] args) {
		Wallpaper clazz = new Wallpaper();
		change(clazz.dayWallpaper);

		WallpaperGUI gui = new WallpaperGUI();
		gui.makeGui("Change Wallpaper", new Dimension(400, 400));

		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				Calendar calendar = Calendar.getInstance();
				int time = calendar.get(Calendar.HOUR_OF_DAY);

				if (time <= 18) {
					change(Wallpapers.DAY_WALLPAPER);
				} else if (time == 19) {
					change(Wallpapers.NIGHT_WALLPAPER);
				}
			}
		};
		timer.schedule(timerTask, 1000, 1000 * 5);
	}

	static void change(String fileName) {
		User32.INSTANCE.SystemParametersInfo(0x0014, 0, fileName, 1);
	}

	static interface User32 extends Library {
		User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);
		boolean SystemParametersInfo(int one, int two, String s, int three);
	}

}