class Twitter {

    private int time;
    private Map<Integer, List<int[]>> tweetMap;   
    private Map<Integer, Set<Integer>> followMap; 

    public Twitter() {
        time = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time++, tweetId});
        
    }
    
    public List<Integer> getNewsFeed(int userId) {

        List<int[]> allTweets= new ArrayList<>();

        if(tweetMap.containsKey(userId)){
            allTweets.addAll(tweetMap.get(userId));
        }

        if(followMap.containsKey(userId)){
            for(int followeeId: followMap.get(userId)){
                if(tweetMap.containsKey(followeeId)){
                    allTweets.addAll(tweetMap.get(followeeId));
                }
            }
        }


allTweets.sort((a,b)-> b[0]-a[0]);

List<Integer> feed= new ArrayList<>();

for(int i=0;i< Math.min(10, allTweets.size());i++){
    feed.add(allTweets.get(i)[1]);
}

return feed;
        
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);

        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
        
    }
}
