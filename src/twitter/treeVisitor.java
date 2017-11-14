/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author user
 */
public class treeVisitor implements visitor{
    private JTree tree = new javax.swing.JTree();
    private final DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree.getCellRenderer();
    @Override
    public void visit(user user) {
        user.setIcon((ImageIcon) renderer.getDefaultLeafIcon());
    }

    @Override
    public void visit(group group) {
        group.setIcon((ImageIcon) renderer.getDefaultOpenIcon());
    }
    
}
