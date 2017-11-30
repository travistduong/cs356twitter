/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class metadata {
    private int userTotal;
    private int groupTotal;
    private int messageTotal;
    private double positivePercentage;
    private ArrayList<String> messages = new ArrayList<>();
    String[] positiveKeywords = {"good", "great", "excellent", "amazing", "cool"};
    private user lastUserUpdated;
    
    
    public metadata() {
        userTotal = 0;
        groupTotal = 0;
        messageTotal = 0;
        positivePercentage = 0;
        lastUserUpdated = null;
    }
    
    
    
    public void lastUserUpdated(user u) {
        if (lastUserUpdated == null) {
            lastUserUpdated = u;
        } else {
            if (u.getLastUpdateTime() > lastUserUpdated.getLastUpdateTime()) {
                lastUserUpdated = u;
            }
        }

    }
    
    public user getLastUserUpdated() {
        return lastUserUpdated;
    }
    
    public void addUser() {
        userTotal++;
    }
    
    public int getUserTotal() {
        return userTotal;
    }
    
    public void addGroup() {
        groupTotal++;
    }
    
    public int getGroupTotal() {
        return groupTotal;
    }
    
    public void addMessage(String what) {
        messages.add(what);
        messageTotal++;
    }
    
    public int getMessageTotal() {
        return messageTotal;
    }
    
    public void calcPP() {
        double positive = 0;
        // Look for positive keywords
        for (String s : messages) {
            for (String key : positiveKeywords) {
                if (s.contains(key)) {
                    positive++;
                    break;
                }
            }
        }
        // Calculate percentage
        if (messageTotal == 0) {
            positivePercentage = 0;
        } else {
            positivePercentage = Math.floor((positive*100)/messageTotal);
        }
        
    }
    
    public double getPP() {
        calcPP();
        return positivePercentage;
    }
    
    
}
