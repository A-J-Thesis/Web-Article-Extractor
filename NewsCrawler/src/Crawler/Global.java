// Project:  World News Articles Matching
// File:     Global.java
// Authors:  Jason Papapanagiotakis, Aris Kotsomitopoulos
// Github:   https://github.com/A-J-Thesis/Web-Arcticle-Extractor
package Crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Global {
	
    static final Map<String, String> RSS;
    static
    {
    	RSS = new HashMap<String, String>();
//    	RSS.put("Google","http://news.google.com/?output=rss");	//WORKING-but is google
//    	RSS.put("CNN","http://rss.cnn.com/rss/edition_world.rss");	//WORKING not all
//    	RSS.put("BBC","http://feeds.bbci.co.uk/news/world/rss.xml");	//WORKING
//    	RSS.put("Huffingtonpost","http://www.huffingtonpost.com/feeds/verticals/world/index.xml");	//WORKING
//    	RSS.put("Yahoo","http://news.yahoo.com/rss/");		//WORKING
//    	RSS.put("FOX News","http://feeds.foxnews.com/foxnews/world");		//WORKING
//    	RSS.put("nbcnews","http://feeds.nbcnews.com/feeds/topstories");		///not working main body
//    	RSS.put("dailymail","http://www.dailymail.co.uk/news/index.rss");	//WORKING
//    	RSS.put("abcnews","http://feeds.abcnews.com/abcnews/internationalheadlines");	//WORKING
//    	RSS.put("Latimes","http://www.latimes.com/world/rss2.0.xml");		//WORKING
//    	RSS.put("The Guardian","http://www.theguardian.com/world/rss");		// NA FTIAKSW AN DEN KSEKINANE ME http/domain/..
//    //RSS.put("Independent","http://rss.feedsportal.com/c/266/f/3492/index.rss"); //LATHOS APOTELESMATA!!!
//    	RSS.put("Reuters","http://feeds.reuters.com/Reuters/worldNews");
//    	RSS.put("Sky-News","http://feeds.skynews.com/feeds/rss/world.xml");
//    	RSS.put("Telegraph","http://www.telegraph.co.uk/news/worldnews/rss"); 
//    	RSS.put("cbc","http://www.cbc.ca/cmlink/rss-world");	//WORKING(no desc)
//    	RSS.put("rte","http://www.rte.ie/news/rss/news-headlines.xml");
//    	RSS.put("Global News","http://globalnews.ca/feed/");
//    	RSS.put("cbsnews","http://www.cbsnews.com/latest/rss/world");	//WORKING
//    	RSS.put("irishtimes","https://www.irishtimes.com/cmlink/news-1.1319192");
//    	RSS.put("tvnz","http://tvnz.co.nz/content/ta_tvnz_world_headlines_auto_group/rss_20_skin.xml");
//    	RSS.put("npr","http://www.npr.org/rss/rss.php?id=1004");
//    	RSS.put("metro","http://metro.co.uk/news/world/feed/");
//    	RSS.put("express","http://feeds.feedburner.com/daily-express-world-news");
//    	RSS.put("news24","http://feeds.news24.com/articles/News24/World/rss");
//    	RSS.put("Breaking News","http://api.breakingnews.com/api/v1/item/?format=rss");	//PART OF
//    	RSS.put("thestar","http://www.thestar.com.my/RSS/News/World/");
//    	RSS.put("caribbeannewsnow","http://www.caribbeannewsnow.com/news/_files/rss/news/Caribbean-News-Now!-Daily-Headlines.xml");	//WORKING
//    	RSS.put("dailynews","http://www.dailynews.com/section?template=RSS&profile=4000032&mime=xml");
//    	//RSS.put("galvestondailynews","http://www.galvestondailynews.com/search/?t=article&c[]=news/local*%2Cnews/edu*%2Cnews/pol*&f=rss");
//    	RSS.put("chathamdailynews","http://www.chathamdailynews.ca/news/world/rss.xml");	//WORKING
//    	RSS.put("sciencedaily","http://feeds.sciencedaily.com/sciencedaily");
//    	RSS.put("nwfdailynews","http://www.nwfdailynews.com/cmlink/news-rss-1.2266");
//    	RSS.put("scrippsobfeeds","http://scrippsobfeeds.endplay.com/content-syndication-portlet/feedServlet?obfType=RSS_FEED&siteId=100108&categoryId=10001");
//    	RSS.put("AP","http://hosted2.ap.org/atom/APDEFAULT/cae69a7523db45408eeb2b3a98c0c9c5");
//      RSS.put("sbs Asia Pacific News","http://sbs.feedsportal.com/c/34692/f/637529/index.rss");
//      RSS.put("sbs Europe News","http://sbs.feedsportal.com/c/34692/f/637531/index.rss");
//      RSS.put("sbs North America News","http://sbs.feedsportal.com/c/34692/f/637533/index.rss");
//      RSS.put("sbs South America News","http://sbs.feedsportal.com/c/34692/f/637534/index.rss");
//      RSS.put("sbs Africa News","http://sbs.feedsportal.com/c/34692/f/637532/index.rss");
//      RSS.put("sbs Middle East News","http://sbs.feedsportal.com/c/34692/f/637530/index.rss");
//      RSS.put("UPI","http://rss.upi.com/news/tn_int.rss");
//      RSS.put("USATODAY","http://rssfeeds.usatoday.com/usatodaycomworld-topstories&x=1");
//      RSS.put("NEWS","http://feeds.news.com.au/public/rss/2.0/news_theworld_3356.xml");
//      RSS.put("SMH","http://www.smh.com.au/rssheadlines/world/article/rss.xml");
//      RSS.put("Washington Post","http://feeds.washingtonpost.com/rss/rss_blogpost");
//      RSS.put("Times of India","http://timesofindia.feedsportal.com/c/33039/f/533917/index.rss");
//      RSS.put("canada","http://rss.canada.com/get/?F7432");
        
		FileReader fileReader;
		try {
			fileReader = new FileReader("RSS_feeds.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] temp = line.split(",");
				if(temp.length == 2){
					RSS.put(temp[0],temp[1]);
				}
			}
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
    }
	public static void setTrustAllCerts() throws Exception {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(
					java.security.cert.X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(
					java.security.cert.X509Certificate[] certs, String authType) {
			}
		} };

		// Install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection
					.setDefaultHostnameVerifier(new HostnameVerifier() {
						public boolean verify(String urlHostName,
								SSLSession session) {
							return true;
						}
					});
		} catch (Exception e) {
			// We can not recover from this exception.
			e.printStackTrace();
		}
	}
}
