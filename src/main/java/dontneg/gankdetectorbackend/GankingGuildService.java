package dontneg.gankdetectorbackend;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GankingGuildService {
    private final GankingGuildRepository repository;

    public GankingGuildService(GankingGuildRepository repository){
        this.repository = repository;
    }

    public List<String> findMatchingGuildNames(List<String> guildNames){
        List<GankingGuild> matchingGuilds = repository.findByGuildNameIn(guildNames);
        return matchingGuilds.stream().map(GankingGuild::getGuildName).collect(Collectors.toList());
    }

    public void addGuild(GankingGuild guild) {
        repository.save(guild);
    }

    public void removeGuild(String guildName) {
        repository.deleteById(guildName);
    }

    public List<GankingGuild> findAll(){
        return repository.findAll();
    }
}
