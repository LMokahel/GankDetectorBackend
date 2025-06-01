package dontneg.gankdetectorbackend;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GankingGuild {

    @Id
    private String guildName;
    private long lastSeen;

    public GankingGuild() {}

    public GankingGuild(String guildName, long lastSeen){
        this.guildName = guildName;
        this.lastSeen = lastSeen;
    }

    public String getGuildName(){
        return this.guildName;
    }

    public long getLastSeen(){
        return this.lastSeen;
    }

    public void setGuildName(String guildName){
        this.guildName = guildName;
    }

    public void setLastSeen(long lastSeen){
        this.lastSeen = lastSeen;
    }
}
