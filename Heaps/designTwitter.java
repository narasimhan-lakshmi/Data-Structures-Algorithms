// LC 355

class Twitter {
    // Global time counter to assign timestamps to tweets
    private static int timestamp = 0;

    // Maps a user to the set of users they follow
    private Map<Integer, Set<Integer>> followmap;

    // Maps a user to the list of their tweets
    private Map<Integer, List<Tweet>> tweetmap;

    // Constructor to initialize the maps
    public Twitter() {
        followmap = new HashMap<>();
        tweetmap = new HashMap<>();
    }

    // Adds a new tweet for the given user
    public void postTweet(int userId, int tweetId) {
        tweetmap.putIfAbsent(userId, new ArrayList<>()); // create list if absent
        tweetmap.get(userId).add(new Tweet(tweetId, timestamp++)); // add tweet with current timestamp
    }

    // Returns the 10 most recent tweets from the user and their followees
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> heap = new PriorityQueue<>((a, b) -> a.time - b.time); // min-heap by time

        followmap.putIfAbsent(userId, new HashSet<>()); // ensure the user has a follow list
        followmap.get(userId).add(userId); // user always follows themselves

        for (int followeeId : followmap.get(userId)) {
            List<Tweet> tweets = tweetmap.get(followeeId); // get followee's tweets
            if (tweets != null) {
                for (Tweet tweet : tweets) {
                    heap.offer(tweet); // add tweet to heap
                    if (heap.size() > 10) heap.poll(); // keep only 10 latest
                }
            }
        }

        List<Integer> result = new LinkedList<>();
        while (!heap.isEmpty()) {
            result.add(0, heap.poll().id); // reverse order for most recent first
        }

        return result;
    }

    // Adds a followee to the follower's set
    public void follow(int followerId, int followeeId) {
        followmap.putIfAbsent(followerId, new HashSet<>()); // ensure entry exists
        followmap.get(followerId).add(followeeId); // add followee
    }

    // Removes a followee from the follower's set (can't unfollow yourself)
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // do nothing if same person
        Set<Integer> followees = followmap.get(followerId);
        if (followees != null) {
            followees.remove(followeeId); // remove followee
        }
    }

    // Inner class to represent a Tweet with id and timestamp
    class Tweet {
        int id;
        int time;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
}

/*
Input
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
Output
[null, null, [5], null, null, [6, 5], null, [5]]

Explanation
Twitter twitter = new Twitter();
twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
twitter.follow(1, 2);    // User 1 follows user 2.
twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.unfollow(1, 2);  // User 1 unfollows user 2.
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.

*/