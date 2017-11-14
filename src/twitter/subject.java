/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author user
 */
public abstract class subject {
    private List<observer> observers = new ArrayList<observer>();
	
	public void attach(observer observer) {
		observers.add(observer);
	}
	
	public void detach(observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		for(observer ob : observers) {
			ob.update(this);
		}
	}
    
}
