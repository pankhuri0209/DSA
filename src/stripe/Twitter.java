package stripe;

import java.util.*;

public class Twitter {
    private HashMap<Integer, HashSet<Integer>> followeeMap;
    private HashMap<Integer, List<Tweet>> tweetsMap;
    int timestamp;
    public Twitter() {
        followeeMap = new HashMap<>();
        tweetsMap = new HashMap<>();
        timestamp = 0;
    }
    public Twitter(int capacity) {
        followeeMap=new HashMap<>();
        tweetsMap=new HashMap<>();

    }


    class Tweet{
        int tweetId;
        int createdAt;
        public Tweet(int tweetId, int createdAt){
            this.tweetId=tweetId;
            this.createdAt=createdAt;
        }
    }

    public void follow(int followerId, int followeeId){
        followeeMap.putIfAbsent(followerId, new HashSet<>());
        followeeMap.get(followerId).add(followeeId);
    }
    public void unfollow(int followerId, int followeeId){
        if(followeeMap.containsKey(followerId) && followerId!=followeeId){
            followeeMap.get(followerId).remove(followeeId);
        }
    }
    public void postTweet(int userId, int tweetId) {
        follow(userId, userId);// user follows self
        if (!tweetsMap.containsKey(userId)){
            tweetsMap.put(userId, new ArrayList<>());
        }
        tweetsMap.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq=new PriorityQueue<>((a,b)->a.createdAt-b.createdAt);
        HashSet<Integer> followees=followeeMap.get(userId);
        if (followees!=null){
            for (Integer followee : followees) {
                List<Tweet> tweets=tweetsMap.get(followee);
                if (tweets!=null){
                    for (Tweet tweet : tweets) {
                        pq.offer(tweet);
                        if (pq.size()>10){
                            pq.poll();
                        }
                    }
                }
            }
        }
        List<Integer> list=new ArrayList<>();
        while (!pq.isEmpty()){
            list.add(0,pq.poll().tweetId);
        }
    }
}
