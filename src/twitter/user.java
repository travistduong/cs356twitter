
package twitter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

/**
 * Class: CS356
 * Assignment: Project 2
 * @author travisduong
 */
public class user extends subject implements composite, observer{
    private String userID;
    private String tweet;
    private final DefaultListModel listModel = new DefaultListModel();
    private ImageIcon icon;
    private long creationTime;
    private long lastUpdateTime;
    ArrayList<user> followers = new ArrayList<>();
    ArrayList<user> followings = new ArrayList<>();
    ArrayList<String> tweets = new ArrayList<>();
    
    
    public user() {
        
    }
    
    public user(String x) {
        userID = x;
        creationTime = System.currentTimeMillis();
    }
    
    public long getLastUpdateTime() {
        return lastUpdateTime;
    }
    
    public long getCreationTime() {
        return creationTime;
    }
    
    public DefaultListModel getListModel() {
        return listModel;
    }
    
    public void addToListModel() {
        
    }
    
    public ArrayList<user> getFollowers() {
        return followers;
    }
    
    public void addFollower(user follower) {
        followers.add(follower);
    }
    
    public void follow(user follower) {
        followings.add(follower);
        follower.addFollower(this);
    }

    
    public ArrayList<user> getFollowings() {
        return followings;
    }
    
    public ArrayList<String> getTweets() {
        return tweets;
    }
    
    public void addTweet(String tweet) {
        tweets.add(userID + ": " + tweet);
        this.tweet = tweet;
        lastUpdateTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date date = new Date(lastUpdateTime);
        System.out.println("[" + getID() + "] last updated: " + sdf.format(date));
        notifyObservers();
    }
    
    public String getLatestTweet() {
        return tweet;
    }
    
    @Override
    public String toString() { 
        return userID;
    } 

    @Override
    public void setID(String x) {
        userID = x;
    }

    @Override
    public String getID() {
        return userID;
    }

    @Override
    public void accept(visitor v) {
        v.visit(this);
    }

    @Override
    public void update(subject subject) {
        if (subject instanceof user) {
            tweets.add(((user) subject).getID() + ": " + ((user) subject).getLatestTweet());
            // Check the output
            System.out.println(tweets.get(tweets.size() - 1));
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
            Date date = new Date(lastUpdateTime);
            System.out.println("A user you follow [" + ((user) subject).getID() + "] last updated: " + sdf.format(date));
        }
    }
    
    @Override
    public ImageIcon getIcon() {
        return icon;
    }

    @Override
    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }


}
