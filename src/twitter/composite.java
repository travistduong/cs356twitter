/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public interface composite {
    public void setID(String x);
    public String getID();
    void accept(visitor v); // Visitor
    void setIcon(ImageIcon icon);
    ImageIcon getIcon();
    @Override
    public String toString();
}
