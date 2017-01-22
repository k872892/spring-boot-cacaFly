package hello;

import org.json.*;
import redis.clients.jedis.*;
import java.util.*;

public class SearchResult {

    private final int hits;
    private final ArrayList<String> result;

    public SearchResult(int hits, ArrayList<String> result) {
        this.hits = hits;
        this.result = result;
    }

    public int getHits() {
        return hits;
    }

    public ArrayList<String> getResult() {
        return result;
    }
}