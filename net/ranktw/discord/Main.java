package net.ranktw.discord;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.ranktw.discord.GuiDTC.Status;
import net.ranktw.http.HttpRequest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static GuiDTC guiMain;
    static GuiInput guiInput;
    static List<String> tokens = new ArrayList<>();

    public static File currFolder;

    public static void main(String[] args) {
	// write your code here
        GuiDTC.start();
        GuiInput.start();
    }
    private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36 OPR/53.0.2907.43";
    public static Status InfoToken(String token,int in) {
        String response = HttpRequest.get("https://discordapp.com/api/v6/users/@me")
                .contentType("application/json")
                .userAgent(userAgent)
                .authorization(token)
                .body();
        guiMain.addLine("# " + in);
        guiMain.addLine("Token: " + token);
        guiMain.addLine("");
//        guiMain.addLine(response);
        JsonObject json = new JsonParser().parse(response).getAsJsonObject();
        String message = json.get("message") != null ? json.get("message").getAsString() : "";
        if (!message.equals("")) {
            guiMain.addLine(message);
            guiMain.addLine("");
            return Status.Invalid;
        }
        String username = json.get("username").getAsString();
        String discriminator = json.get("discriminator").getAsString();
        String verified = json.get("verified").getAsString();
        String email = json.get("email").getAsString();
        String phone = json.get("phone").isJsonNull() ? "null" : json.get("phone").getAsString();
        String avatar = json.get("avatar").isJsonNull() ? "Null" : "\"Has Avatar\"";
        guiMain.addLine(username + "#" + discriminator);
        guiMain.addLine("Email Verified: " + verified);
        guiMain.addLine("Email: " + email);
        guiMain.addLine("Phone: " + phone);
        guiMain.addLine("Avatar: " + avatar);

        String flags = Flags.getFlags(json.get("flags")==null?0:json.get("flags").getAsInt());
        guiMain.addLine("Badges: " + flags);
        String premium_type = Premium.getPremium(json.get("premium_type")==null?0:json.get("premium_type").getAsInt()).DESCRIPTION;
        guiMain.addLine("Premium: " + premium_type);

        response = HttpRequest.get("https://discordapp.com/api/v6/users/@me/guilds")
                .contentType("application/json")
                .userAgent(userAgent)
                .authorization(token)
                .body();
//        guiMain.addLine(response);
        JsonArray jsona =  new JsonParser().parse(response).isJsonArray()?new JsonParser().parse(response).getAsJsonArray():null;

        if (jsona != null) {
            guiMain.addLine("Guild Count: " + jsona.size());
            guiMain.addLine("");
            return Status.Worked;
        }else {
            guiMain.addLine("Need to verify account");
            guiMain.addLine("");
            return Status.Unverified;
        }

    }
    enum Flags{
        None("None",0),
        DiscordStaff("Discord Staff",1 << 0),
        DiscordPartner("Discord Partner",1 << 1),
        HypeSquadEvents("HypeSquad Events",1 << 2),
        BugHunter("Bug Hunter",1 << 3),
        Subscriber("Subscriber",1 << 5),
        HouseBravery("House Bravery",1 << 6),
        HouseBrilliance("House Brilliance",1 << 7),
        HouseBalance("House Balance",1 << 8),
        EarlySupporter("Early Supporter",1 << 9),
        Unknown("Unknown",-1);
        String DESCRIPTION;
        int VALUE;
        Flags(String DESCRIPTION,int VALUE){
            this.DESCRIPTION=DESCRIPTION;
            this.VALUE=VALUE;
        }
        public static String getFlags(int flag){
            List<String> list = new ArrayList<>();
            for (int i = 9; i >= 0; i--) {
                if((flag >> i)==1){
                    flag-=(1 << i);
                    list.add(intToFlag(i));
                }
            }
            return String.valueOf(list);
        }
        private static String intToFlag(int i){
            switch (i){
                case 9:
                    return EarlySupporter.DESCRIPTION;
                case 8:
                    return HouseBalance.DESCRIPTION;
                case 7:
                    return HouseBrilliance.DESCRIPTION;
                case 6:
                    return HouseBravery.DESCRIPTION;
                case 5:
                    return Subscriber.DESCRIPTION;
                case 4:
                    return BugHunter.DESCRIPTION;
                case 3:
                    return HypeSquadEvents.DESCRIPTION;
                case 2:
                    return DiscordPartner.DESCRIPTION;
                case 1:
                    return DiscordStaff.DESCRIPTION;
                case 0:
                    return None.DESCRIPTION;
            }
            return Unknown.DESCRIPTION;
        }
    }
    enum Premium{
        None("None",0),
        NitroClassic("Nitro Classic",1),
        Nitro("Nitro",2),
        Unknown("Unknown",-1);
        String DESCRIPTION;
        int VALUE;
        Premium(String DESCRIPTION,int VALUE){
            this.DESCRIPTION=DESCRIPTION;
            this.VALUE=VALUE;
        }
        public static Premium getPremium(int i){
            for (Premium p:Premium.values()){
                if (p.VALUE==i){
                    return p;
                }
            }
            return Unknown;
        }
    }
}
