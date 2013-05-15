/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphcoursework.application;

import graphcoursework.components.*;
import graphcoursework.graph.*;

import static debug.Debug.*;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Main extends javax.swing.JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField widthField;
    private javax.swing.JButton dijkstraButton;
    private javax.swing.JTextField distanseField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton treeButton;
    
    private Graph graph;
    
    public static Color TREEANDMINIMUMCOLOR = new Color(204, 0, 0);
    
    public Main() {
        super("Graph Course Work");
        initComponents();
    }
    
    private void initGraph(JPanel jp) {
        this.graph = new Graph(jp, widthField);
    }
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        widthField = new javax.swing.JTextField();
        dijkstraButton = new javax.swing.JButton();
        distanseField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        treeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        jLabel1.setText("distanse:");
        jButton1.setText("connect");
        jButton2.setText("clear");
        jButton3.setText("tst");
        dijkstraButton.setText("get Dijkstra path");
        jLabel2.setText("Distanse:");
        treeButton.setText("tree");
        
        initGraph(jPanel2);
        //--------------------------------------------DONT TOUCH
        setSize(800, 500);
        jPanel2.setBackground(Color.white);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this.getContentPane());
        this.setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        //--------------------------------------------DONT TOUCH
        
        
//        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
//        jPanel1.setLayout(jPanel1Layout);
//        jPanel1Layout.setHorizontalGroup(
//            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(jLabel1)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jButton3)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
//                .addComponent(jButton2)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jButton1)
//                .addContainerGap())
//        );
//        jPanel1Layout.setVerticalGroup(
//            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(jLabel1)
//                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jButton1)
//                    .addComponent(jButton2)
//                    .addComponent(jButton3))
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
        
//        jPanel1Layout.setHorizontalGroup(
//            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(jLabel1)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jButton3)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
//                .addComponent(widthField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jButton2)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jButton1)
//                .addContainerGap())
//        );
//        jPanel1Layout.setVerticalGroup(
//            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(jLabel1)
//                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jButton1)
//                    .addComponent(jButton2)
//                    .addComponent(jButton3)
//                    .addComponent(widthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
                
        
//        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
//        jPanel1.setLayout(jPanel1Layout);
//        jPanel1Layout.setHorizontalGroup(
//            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(dijkstraButton)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addComponent(jLabel2)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(distanseField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
//                .addComponent(widthField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jButton2)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jButton1)
//                .addContainerGap())
//        );
//        jPanel1Layout.setVerticalGroup(
//            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(jButton1)
//                    .addComponent(jButton2)
//                    .addComponent(widthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(dijkstraButton)
//                    .addComponent(distanseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabel2))
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(treeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dijkstraButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(distanseField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(widthField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(widthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dijkstraButton)
                    .addComponent(distanseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(treeButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTest(evt);
            }
        });
        
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelete(evt);
            }
        });
        
        treeButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treeButtonClick(evt);
            }
        });
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnect(evt);
            }
        });
        
        dijkstraButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dijkstraButtonClick(evt);
            }
        });
        
        jPanel2.setLayout(null);
        
        jPanel2.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouseClicked JPanel2");
                if (e.getButton() == 3) {
                    graph.addPoint(e.getX(), e.getY());
                }
                if (e.getButton() == 1) {
                    graph.deselectAll();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("mousePressed - " + e.getButton());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //System.out.println("mouseReleased - " + e.getButton());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //System.out.println("mouseEntered - " + e.getButton());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //System.out.println("mouseExited - " + e.getButton());
            }
        });
        
        widthField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int buf = 0;
                try {
                    buf = Integer.parseInt(((JTextField)e.getSource()).getText());
                } catch(Exception ex) {
                    buf = Integer.MAX_VALUE;
                }  
                graph.syncWidthField(buf);
            }
        });
        
    }
    
    private void jButtonTest(java.awt.event.ActionEvent evt) {                                         
        
        //jPanel2.setLayout(null);
        
        dbg("jButtonTestClick");
        //GraphPointComponent gp = new GraphPointComponent(50, 50);
        //gp.setSelect(true);
        //Component c = jPanel2.add(gp);
        
        // IT WORK
        //jPanel2.getComponents()[0].setSize(jPanel2.getWidth(), jPanel2.getHeight());
        ////jPanel2.getComponents()[0].setSize(new Dimension(30, 30));
        //jPanel2.getComponents()[0].setLocation(0, 0);
        //c.setLocation(gp.getLocation());
        //c.setSize(gp.getSize());
        
        //jPanel2.getComponents()[0].setSize(30, 30);
        
        //jPanel2.add(new JButton("test2"));
        ///jPanel2.repaint();
        //System.out.println(jPanel2.getComponentCount());
    }
    
    private void dijkstraButtonClick(java.awt.event.ActionEvent evt) {                                         
        GraphPoint[] gps =  graph.getSelectedPoints();
        GraphElement[] ges;// = GraphElement[0];
        if (gps.length == 2) {
            ges = graph.getDijkstraPath(gps[0], gps[1]);
        } else {
            return;
        }
        if (ges == null) {
            distanseField.setText("Infinit");
            return;
        }
        int dist = 0;
        for (int i = 0; i < ges.length; i++) {
            ges[i].getComponent().setColor(TREEANDMINIMUMCOLOR);
            if (GraphLine.class.isInstance(ges[i])) {
                dist += ((GraphLine)ges[i]).getWeight();
            }
        }
        distanseField.setText(dist + "");
    }
    
    private void jButtonConnect(java.awt.event.ActionEvent evt) {  
        
        GraphPoint[] gps = graph.getSelectedPoints();
        dbg("gps.length " + gps.length);
        if (gps.length == 2) {
            graph.addLine(gps[0], gps[1]);
            graph.deselectAll();
        }
        
//        GraphPointComponent g1 = null, g2 = null, gb;
//        for (Component cp : jPanel2.getComponents()) {
//            if (GraphPointComponent.class.isInstance(cp)) {
//                gb = (GraphPointComponent)cp;
//                if (gb.getSelect()) {
//                    g1 = (g1 == null) ? gb : g1;
//                    g2 = ((g2 == null) && (g1 != gb)) ? gb : g2;
//                }
//            }
//        }
//        
//        if (g1 != null && g2 != null) {
//            graph.addLine(g1.getGraphPoint(), g2.getGraphPoint());
//        }
        
        //GraphLineComponent gl = new GraphLineComponent(g1, g2);
        //JPanelAddGraphLine(jPanel2, gl);
        //jPanel2.repaint();
    }
    
    private void jButtonDelete(java.awt.event.ActionEvent evt) {                                         
        jPanel2.removeAll();
        jPanel2.repaint();
        this.graph = new Graph(jPanel2, widthField);
    }
    
    private void treeButtonClick(java.awt.event.ActionEvent evt) {                                         
        GraphElement[] ges = graph.getMinimalSpanningTree();
        if (ges == null) dbg("@");
        for (int i = 0; i < ges.length; i++) {
            ges[i].getComponent().setColor(TREEANDMINIMUMCOLOR);
        }
    }
    
    public static void main(String[] args) {
        Main m = new Main();
        m.setVisible(true);
        m.graph.TEST_FUNC();
    }
    
    private void JPanelAddGraphPoint(JPanel jp, GraphPointComponent gp) {
        dbg("NOT WORK ANYMORE [JPanelAddGraphPoint]");
//        System.out.println("JPanelAddGraphPoint");
//        Component cp = jp.add(gp);
//        cp.addMouseListener(new MouseListener() {
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                GraphPointComponent gp = (GraphPointComponent)e.getSource();
//                Container parent = gp.getParent();
//                System.out.println("ComponentClick!!!");
//                if (e.getButton() == 1) {
//                    gp.changeSelect();
//                }
//                if (e.getButton() == 3) {
//                    gp.remove();
//                }
//                parent.repaint();
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                //System.out.println("mousePressed - " + e.getButton());
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                //System.out.println("mouseReleased - " + e.getButton());
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                //System.out.println("mouseEntered - " + e.getButton());
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                //System.out.println("mouseExited - " + e.getButton());
//            }
//        });
//        cp.setLocation(gp.getLocation());
//        cp.setSize(gp.getSize());
//        jp.repaint();
    }
    
    private void JPanelAddGraphLine(JPanel jp, GraphLineComponent gl) {
        System.out.println("NOT WORK ANYMORE [JPanelAddGraphLine]");
//        System.out.println("JPanelAddGraphLine");
//        Component cp = jp.add(gl);
//        cp.addMouseListener(new MouseListener() {
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println(e.getSource().getClass().getName() + " click event.");
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                //System.out.println("mousePressed - " + e.getButton());
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                //System.out.println("mouseReleased - " + e.getButton());
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                //System.out.println("mouseEntered - " + e.getButton());
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                //System.out.println("mouseExited - " + e.getButton());
//            }
//        });
//        cp.setLocation(gl.getLocation());
//        cp.setSize(gl.getSize());
//        System.out.println(gl.getSize());
//        jp.repaint();
    }
    
    private void JPanelDeselectAll(JPanel jp) {
        GraphPointComponent gp;
        for (Component cp : jp.getComponents()) {
            if (GraphPointComponent.class.isInstance(cp)) {
                gp = (GraphPointComponent)cp;
                gp.setSelect(false);
            }
        }
        jp.repaint();
    }
    
}
