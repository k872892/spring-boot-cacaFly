package hello;


import java.util.Timer;

public class Crawler {

    public Crawler(int seconde) {
		Timer timer = new Timer();
		timer.schedule(new CrawlerTask(), 0, seconde * 1000);
	}
}