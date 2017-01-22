package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.*;
import org.json.*;
import java.net.MalformedURLException;
import java.net.*;
import java.security.cert.Certificate;
import java.io.*;
import javax.net.ssl.*;
import java.util.*;
public class CrawlerTask extends TimerTask {

	private static final Logger log = LoggerFactory.getLogger(CrawlerTask.class);
	
	
	
	@Override
	public void run() {
        try{
			//crawl data
			String content = startCrawl("https://beta-ssp.tenmax.io/supply/mobile/native/rmax-ad?rmaxSpaceId=55ba76bca772421f&dpid=bd4b9b7903cf40ce&v=1");
			
			//parse data to extract title
			String title = getTitle(content);
			
			//use title as key, content as value , put the pair into redis
			if(title==null)
				return;
			putRedis(title,content);
			
		}
		catch(Exception ex){
			
		}
	}

 

    public String startCrawl(String url) throws Exception{
		
		String inputLine="",tmpLine;

		URL myURL = new URL("https://beta-ssp.tenmax.io/supply/mobile/native/rmax-ad?rmaxSpaceId=55ba76bca772421f&dpid=bd4b9b7903cf40ce&v=1");
        HttpsURLConnection httpsConn = (HttpsURLConnection) myURL
                .openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
                                    httpsConn.getInputStream()));

        while ((tmpLine = in.readLine()) != null) 
			inputLine += tmpLine;
		
        in.close();
		httpsConn.disconnect();
		return inputLine;
    }

	public String getTitle(String content) throws Exception{
	
		JSONObject obj = new JSONObject(content);
		JSONArray arr = obj.getJSONObject("native").getJSONArray("assets");
		String title = arr.getJSONObject(0).getJSONObject("title").getString("text");
		log.info("Crawl data title : "+title);
		return title;
	}
 
    public void putRedis(String key , String value){
						
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
		
		try(Jedis jedis = pool.getResource()) {
			jedis.set(key, value);
			log.info("put the data into redis:"+key);
		}
		
		pool.destroy();
		
		return;
	}
}