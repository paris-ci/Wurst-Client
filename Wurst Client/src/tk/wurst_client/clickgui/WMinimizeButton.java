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

public class WMinimizeButton extends WButton
{
	@Override
	protected void drawIcon(Graphics2D g)
	{
		drawGreenIcon(g, 64);
	}

	@Override
	protected void drawHoverIcon(Graphics2D g)
	{
		drawGreenIcon(g, 128);
	}

	@Override
	protected void drawPressedIcon(Graphics2D g)
	{
		drawGreenIcon(g, 192);
	}
	
	private void drawGreenIcon(Graphics2D g, int opacity)
	{
		g.setColor(new Color(64, 64, 64, 128));
		g.fillRect(0, 0, 28, 28);
		g.setColor(new Color(0, 0, 0, 128));
		g.drawPolygon(new int[]{2, 26, 14}, new int[]{8, 8, 22}, 3);
		g.setColor(new Color(0, 255, 0, opacity));
		g.fillPolygon(new int[]{2, 26, 14}, new int[]{8, 8, 22}, 3);
	}
}
