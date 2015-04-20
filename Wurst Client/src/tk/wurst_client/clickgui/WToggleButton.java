/*
 * Copyright © 2014 - 2015 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.wurst_client.clickgui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

public abstract class WToggleButton extends JToggleButton
{
	public WToggleButton()
	{
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentAreaFilled(false);
		setFocusPainted(false);
		setMargin(new Insets(0, 0, 0, 0));
		BufferedImage image =
			new BufferedImage(28, 28, BufferedImage.TYPE_4BYTE_ABGR);
		drawOffIcon(image.createGraphics());
		setIcon(new ImageIcon(image));
		image = new BufferedImage(28, 28, BufferedImage.TYPE_4BYTE_ABGR);
		drawOffHoverIcon(image.createGraphics());
		setRolloverIcon(new ImageIcon(image));
		image = new BufferedImage(28, 28, BufferedImage.TYPE_4BYTE_ABGR);
		drawOnIcon(image.createGraphics());
		setSelectedIcon(new ImageIcon(image));
		image = new BufferedImage(28, 28, BufferedImage.TYPE_4BYTE_ABGR);
		drawOnHoverIcon(image.createGraphics());
		setRolloverSelectedIcon(new ImageIcon(image));
		addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent e)
			{
				BufferedImage image =
					new BufferedImage(28, 28, BufferedImage.TYPE_4BYTE_ABGR);
				if(isSelected())
				{
					image =
						new BufferedImage(28, 28, BufferedImage.TYPE_4BYTE_ABGR);
					drawOnPressedIcon(image.createGraphics());
					setPressedIcon(new ImageIcon(image));
				}else
				{
					image =
						new BufferedImage(28, 28, BufferedImage.TYPE_4BYTE_ABGR);
					drawOffPressedIcon(image.createGraphics());
					setPressedIcon(new ImageIcon(image));
				}
			}
		});
	}
	
	protected abstract void drawOffIcon(Graphics2D g);
	
	protected abstract void drawOffHoverIcon(Graphics2D g);
	
	protected abstract void drawOffPressedIcon(Graphics2D g);
	
	protected abstract void drawOnIcon(Graphics2D g);
	
	protected abstract void drawOnHoverIcon(Graphics2D g);
	
	protected abstract void drawOnPressedIcon(Graphics2D g);
}
