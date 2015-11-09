import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.jibble.pircbot.*;

public class Twitch {
	
	public static float mCounter = 0;
	public static float mSum = 0;
	public static float sCounter = 0;
	public static float avgCounter = 0;
	public static float hCounter = 0;
	public static int highlightFlag = 0;
    
    public static void main(String[] args) throws Exception {
        
        // Now start our bot up.
        myBot bot = new myBot();
        
        // Enable debugging output.
        bot.setVerbose(false);
        
        // Connect to the IRC server.
        bot.connect("irc.twitch.tv", 6667, "oauth:oa8xq5ayvpuj3n1aj3bdoibc9lmtal");

        // Join the #pircbot channel.
        bot.joinChannel("#sing_sing");
        
        Runnable helloRunnable = new Runnable() {
            public void run() {
            	sCounter += 1;
            	mSum += mCounter;
            	if(mCounter > 4*avgCounter){
            		hCounter += 1;
            		if(hCounter >= 3){
            			highlightFlag = 1;
            		}
            	}
            	else{
            		if(hCounter < 3 || hCounter >= 15){
            			hCounter = 0;
            			highlightFlag = 0;
            			avgCounter = 0;
            		}
            		else if(hCounter >= 3 && hCounter <=15){
            			hCounter += 1;
            		}
            	}
            	avgCounter = mSum/sCounter;
            	System.out.println("Average messages per second = "+(avgCounter));
                System.out.println("Messages per second = "+mCounter);
                System.out.println("hCounter = "+hCounter);
                System.out.println("Highlight Mode = "+highlightFlag);
                mCounter = 0;
            }
        };
        
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 1, TimeUnit.SECONDS);
        
        
    }
    
}