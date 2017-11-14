/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

/**
 *
 * @author user
 */
public interface visitor {
    public void visit(user user);
    public void visit(group group);
}
