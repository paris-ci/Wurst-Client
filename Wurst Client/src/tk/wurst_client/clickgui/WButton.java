/*
 * Copyright � 2014 - 2015 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.wurst_client.clickgui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public abstract class WButton extends JButton
{	
	public WButton()
	{
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentAreaFilled(false);
		setFocusPainted(false);
		setMargin(new Insets(0, 0, 0, 0));
		BufferedImage image = new BufferedImage(28, 28, BufferedImage.TYPE_4BYTE_ABGR);
		drawIcon(image.createGraphics());
		setIcon(new ImageIcon(image));
		image = new BufferedImage(28, 28, BufferedImage.TYPE_4BYTE_ABGR);
		drawHoverIcon(image.createGraphics());
		setRolloverIcon(new ImageIcon(image));
		image = new BufferedImage(28, 28, BufferedImage.TYPE_4BYTE_ABGR);
		drawPressedIcon(image.createGraphics());
		setPressedIcon(new ImageIcon(image));
	}
	
	protected abstract void drawIcon(Graphics2D g);
	
	protected abstract void drawHoverIcon(Graphics2D g);

	protected abstract void drawPressedIcon(Graphics2D g);
}