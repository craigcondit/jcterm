/* -*-mode:java; c-basic-offset:2; -*- */
/* JCTerm
 * Copyright (C) 2002 ymnk, JCraft,Inc.
 *  
 * Written by: 2002 ymnk<ymnk@jcaft.com>
 *   
 *   
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public License
 * as published by the Free Software Foundation; either version 2 of
 * the License, or (at your option) any later version.
   
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package com.jcraft.jcterm;

import java.awt.*;
import javax.swing.*;

public class JCTermApplet extends JApplet{
  JCTerm term;
  JInternalFrame frame;

  public JCTermApplet(){
    term=new JCTerm();
  }

  public void init(){    
    setVisible(true);

    JDesktopPane desktop = new JDesktopPane();
    Container content=getContentPane();
    content.add(desktop, BorderLayout.CENTER);
    desktop.setVisible(true);

    frame=new JInternalFrame();
    frame.setIconifiable(true);
    setFocusable(true);

    frame.getContentPane().add("Center", term);
    frame.setJMenuBar(term.getJMenuBar());
    frame.pack();

    desktop.add(frame);

    term.setVisible(true);
    frame.setVisible(true);

    frame.setResizable(true);
    {
      int foo=term.getTermWidth();
      int bar=term.getTermHeight();
      foo+=(frame.getWidth()-frame.getContentPane().getWidth());
      bar+=(frame.getHeight()-frame.getContentPane().getHeight());
      frame.setSize(foo, bar);
    }
    frame.setResizable(false);

    frame.setLocation((getWidth()-frame.getWidth())/2,
		      (getHeight()-frame.getHeight())/2);

    addKeyListener(term);
  }

  public void start(){
    requestFocus();
//    frame.requestFocus();
    //term.kick();
  }    
}
