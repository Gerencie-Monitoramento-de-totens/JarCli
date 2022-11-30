package slack;


import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Playstation
 */
public class SlackInt {
    
    private static String webHooksUrl = "https://hooks.slack.com/services/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";
    private static String oAuthToken = "xoxb-4320715824979-4320158586726-6oVdwTkkTbrNY9frKz4u8o9I";
    private static String slackChannel = "gerenciechannel";
    
    public static void main(String[] args) {
        System.out.print("Primeira mensagem para o slack usando automação");
    }
    
    public static void sendMessageToSlack(String message){
        
        try {
                    StringBuilder msgbuilder = new StringBuilder();
        msgbuilder.append(message);
        
        Payload payload = Payload.builder().channel(slackChannel).text(msgbuilder.toString()).build();
        
        WebhookResponse wbResp = Slack.getInstance().send(webHooksUrl, payload);
        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
