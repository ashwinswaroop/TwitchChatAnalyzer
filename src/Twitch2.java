import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Twitch2 {
	
	public static float mCounter = 0;
	
	public static void main(String[] args) throws Exception {
	
		
		myBot bot = new myBot();
		bot.setVerbose(false);
		bot.connect("irc.twitch.tv", 6667, "oauth:oa8xq5ayvpuj3n1aj3bdoibc9lmtal");
		bot.joinChannel("#sing_sing");
		Runnable helloRunnable = new Runnable() {
            public void run() {
            System.out.println(mCounter);
            
            }
		};
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 1, TimeUnit.SECONDS);
	}
}
