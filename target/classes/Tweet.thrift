namespace java org.bdigital.mobility

struct TweetDTO {
	10: optional string id,
	20: optional string screenName,
	30: optional string mensaje,
	40: optional i64 timestamp
}

service TweetService {

	TweetDTO tweetById(10: string id),
	void guardarTweet(10: TweetDTO tweetDTO),
	oneway void reset()
}