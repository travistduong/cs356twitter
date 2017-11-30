/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import java.util.ArrayList;

import javax.swing.ImageIcon;



/**
 *
 * @author user
 */
public class group implements composite{
    ArrayList<composite> group = new ArrayList<>();
    private String groupID;
    private ImageIcon icon;
    private long creationTime;
    public group(String id) {
        groupID = id;
        creationTime = System.currentTimeMillis();
    }
    
    public long getCreationTime() {
        return creationTime;
    }

    public void addToGroup(composite x) {
        group.add(x);
    }
    
    public ArrayList<composite> getGroup() {
        return group;
    }
    
    public void setGroupID(String id) {
        groupID = id;
    }
    
    public String getGroupID() {
        return groupID;
    }
    
    @Override
    public String toString() { 
        return groupID;
    } 

    @Override
    public void setID(String x) {
        groupID = x;
    }

    @Override
    public String getID() {
        return groupID;
    }

    @Override
    public void accept(visitor v) {
        v.visit(this);
    }
    
    @Override
    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
    
    @Override
    public ImageIcon getIcon() {
        return icon;
    }
}
