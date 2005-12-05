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

  public JCTermApplet(){
    term=new JCTerm();
  }

  public void init(){    
    setVisible(true);

    String host = getCodeBase().getHost();
    JButton connect = new JButton("Connect");
    connect.addActionListener(term);
    connect.setActionCommand("Open SHELL Session...");
    
    JButton disconnect = new JButton("Disconnect");
    disconnect.addActionListener(term);
    disconnect.setActionCommand("Quit");
            
    JButton about = new JButton("About");
    about.addActionListener(term);
    about.setActionCommand("About...");
    
    JPanel padding = new JPanel();
    padding.setBackground(Color.white);
    
    Container content = getContentPane();
    content.setBackground(Color.white);
    content.setLayout(new GridBagLayout());
    
    // add buttons
    content.add(connect, new GridBagConstraints(
            0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE,
            new Insets(0, 0, 9, 9), 0, 0
    ));
    content.add(disconnect, new GridBagConstraints(
            1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE,
            new Insets(0, 0, 9, 9), 0, 0
    ));
    content.add(about, new GridBagConstraints(
            2, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE,
            new Insets(0, 0, 9, 0), 0, 0
    ));
    
    // add terminal
    content.add(term, new GridBagConstraints(
            0, 1, 3, 1, 1.0, 1.0,
            GridBagConstraints.NORTH, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0
    ));
    
    Dimension d = connect.getPreferredSize();
    d.height = 24;
    connect.setPreferredSize(d);
    connect.setMinimumSize(d);
    connect.setMaximumSize(d);
    
    d = disconnect.getPreferredSize();
    d.height = 24;
    disconnect.setPreferredSize(d);
    disconnect.setMinimumSize(d);
    disconnect.setMaximumSize(d);

    d = about.getPreferredSize();
    d.height = 24;
    about.setPreferredSize(d);
    about.setMinimumSize(d);
    about.setMaximumSize(d);
    
    term.setBackground(Color.white);
    
    term.setVisible(true);
    term.setHost(host);

    addKeyListener(term);
  }

  public void start(){
    requestFocus();
//    frame.requestFocus();
    term.kick();
  }    
}
