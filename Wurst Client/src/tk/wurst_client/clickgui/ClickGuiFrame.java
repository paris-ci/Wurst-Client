/*
 * Copyright © 2014 - 2015 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.wurst_client.clickgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class ClickGuiFrame extends JDialog
{
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			ClickGuiFrame dialog = new ClickGuiFrame();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public ClickGuiFrame()
	{
		setUndecorated(true);
		setOpacity(0.5f);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel_1 = new JPanel();
			MouseAdapter mouseAdapter = new MouseAdapter()
			{
				private Point offset;
				
				@Override
				public void mousePressed(MouseEvent e)
				{
					offset = e.getPoint();
				}
				
				@Override
				public void mouseDragged(MouseEvent e)
				{
					Point location = e.getLocationOnScreen();
					location.translate(-offset.x, -offset.y);
					setLocation(location);
				}
			};
			panel_1.addMouseListener(mouseAdapter);
			panel_1.addMouseMotionListener(mouseAdapter);
			getContentPane().add(panel_1, BorderLayout.NORTH);
			panel_1.setBackground(new Color(8, 8, 8));
			FlowLayout fl_panel_1 = (FlowLayout)panel_1.getLayout();
			fl_panel_1.setAlignment(FlowLayout.RIGHT);
			{
				JButton btnMinimize = new JButton("Minimize");
				panel_1.add(btnMinimize);
			}
			{
				JButton btnPin = new JButton("Pin");
				panel_1.add(btnPin);
			}
			{
				JButton btnClose = new JButton("Close");
				panel_1.add(btnClose);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			{
				JPanel panel = new JPanel();
				panel.setBackground(new Color(64, 64, 64));
				scrollPane.setViewportView(panel);
				panel.setLayout(new GridLayout(0, 1, 0, 0));
			}
		}
	}
	
}
