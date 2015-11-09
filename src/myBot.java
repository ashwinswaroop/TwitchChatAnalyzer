import org.jibble.pircbot.*;

public class myBot extends PircBot {
    
    public myBot() {
        this.setName("lozoot93");
    }
    
    public void onMessage(String channel, String sender, String login, String hostname, String message){
    	//if(message.contains("Kreygasm")||message.contains("PogChamp"))
    		Twitch.mCounter+=1;
    }
    
}