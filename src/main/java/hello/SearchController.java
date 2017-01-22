package hello;

import org.json.*;
import redis.clients.jedis.*;
import java.util.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class SearchController {

	private static final Logger log = LoggerFactory.getLogger(SearchController.class);

    @RequestMapping("/search")
    public SearchResult searchResult(@RequestParam(value="query", defaultValue="*") String query,
	                                 @RequestParam(value="offset", defaultValue="0") int offset, 
									 @RequestParam(value="size", defaultValue="5") int size
  																								    ) {
		
		log.info("request : query "+query);
		ArrayList<String> result = getResult(query ,offset,size);		
		return new SearchResult(result.size(),result);
    }
	
	public ArrayList<String> getResult(String query ,int offset ,int size){
		
		int i=0,count = 0;		
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
		ArrayList<String> result = new ArrayList<String> ();		
		
		try(Jedis jedis = pool.getResource()) {
			
			Set<String> keySet = jedis.keys("*"+query+"*");
			for(String k: keySet) {
				if(count>=size)
					break;
				if(i>=offset){
					result.add(jedis.get(k));
					count++;
				}				
				i++;
			}
		}
		
		pool.destroy();
		
		return result;
	}
}