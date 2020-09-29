package me.aaron.wallpaper;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class WallpaperGUI {

	void makeGui(String name, Dimension size) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		JFrame frame = new JFrame(name);
		frame.setSize(size);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
		
		JButton day = new JButton("Day");
		day.setVisible(true);
		day.setLocation(0, 15);
		day.setSize(100, 50);
		day.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Wallpaper.change(Wallpapers.DAY_WALLPAPER);
			}
		});
		
		JButton night = new JButton("Night");
		night.setVisible(true);
		night.setLocation(200, 15);
		night.setSize(100, 50);
		night.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Wallpaper.change(Wallpapers.NIGHT_WALLPAPER);
			}
		});

		frame.getContentPane().add(day);
		frame.getContentPane().add(night);
	}

	/*
	 * JButton chooser = new JButton("Choose file"); chooser.addActionListener(new
	 * ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { final JFileChooser fc
	 * = new JFileChooser(); int returnVal = fc.showOpenDialog(frame); if (returnVal
	 * == JFileChooser.APPROVE_OPTION) { File file = fc.getSelectedFile();
	 * System.out.println("File: " + file.getName() + ".");
	 * file1.setText(file.getPath()); } else {
	 * System.out.println("Open command cancelled by user."); }
	 * System.out.println(returnVal); } });
	 */

}
