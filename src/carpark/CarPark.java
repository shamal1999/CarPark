/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class CarPark extends AbstractTableModel {
    
    Vector data;
    Vector columns;

    public CarPark() {
            String line;
            data = new Vector();
            columns = new Vector();
            try {
                    FileInputStream fis = new FileInputStream("C:\\Users\\shamal.gomes\\Desktop\\CarPark\\Cars.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                    StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
                    while (st1.hasMoreTokens())
                            columns.addElement(st1.nextToken());
                    while ((line = br.readLine()) != null) {
                            StringTokenizer st2 = new StringTokenizer(line, "/t");
                            while (st2.hasMoreTokens())
                                    data.addElement(st2.nextToken());
                    }
                    br.close();
            } catch (Exception e) {
                    e.printStackTrace();
            }
    }

    public int getRowCount() {
            return data.size() / getColumnCount();
    }

    public int getColumnCount() {
            return columns.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
            return (String) data.elementAt((rowIndex * getColumnCount())
                            + columnIndex);
    }

    public static void main(String s[]) {
            CarPark model = new CarPark();
            JTable table = new JTable();
            table.setModel(model);
            JScrollPane scrollpane = new JScrollPane(table);
            JPanel panel = new JPanel();
            panel.add(scrollpane);
            JFrame frame = new JFrame();
            frame.add(panel, "Center");
            frame.pack();
            frame.setVisible(true);
    }
}

