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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class WFrame extends JDialog
{
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			WFrame dialog = new WFrame();
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
	public WFrame()
	{
		setUndecorated(true);
		setOpacity(0.5f);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setLocation(100, 100);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel titleBar = new JPanel();
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
			titleBar.addMouseListener(mouseAdapter);
			titleBar.addMouseMotionListener(mouseAdapter);
			getContentPane().add(titleBar, BorderLayout.NORTH);
			titleBar.setBackground(new Color(8, 8, 8));
			FlowLayout fl_titleBar = (FlowLayout)titleBar.getLayout();
			fl_titleBar.setAlignment(FlowLayout.RIGHT);
			{
				WMinimizeButton btnMinimize = new WMinimizeButton();
				btnMinimize.addItemListener(new ItemListener()
				{
					@Override
					public void itemStateChanged(ItemEvent e)
					{
						scrollPane.setVisible(e.getStateChange() == ItemEvent.SELECTED);
						pack();
					}
				});
				titleBar.add(btnMinimize);
			}
			{
				JButton btnPin = new JButton("Pin");
				titleBar.add(btnPin);
			}
			{
				JButton btnClose = new JButton("Close");
				titleBar.add(btnClose);
			}
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setVisible(false);
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			{
				JPanel panel = new JPanel();
				panel.setBackground(new Color(64, 64, 64));
				scrollPane.setViewportView(panel);
				panel.setLayout(new GridLayout(0, 1, 0, 0));
			}
		}
		pack();
	}
}
