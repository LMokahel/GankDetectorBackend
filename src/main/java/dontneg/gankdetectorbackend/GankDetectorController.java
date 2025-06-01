package dontneg.gankdetectorbackend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/guilds")
public class GankDetectorController {
    private final GankingGuildService service;

    public GankDetectorController(GankingGuildService service){
        this.service = service;
    }

    @PostMapping("/match")
    public List<String> findMatchingGuilds(@RequestBody List<String> guildList){
        if(guildList==null||guildList.isEmpty()){
            return new ArrayList<>();
        }
        return service.findMatchingGuildNames(guildList);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addGuild(@RequestBody GankingGuild guild) {
        System.out.println("ADDGUILD: " + guild.getGuildName());
        service.addGuild(guild);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove/{guildName}")
    public ResponseEntity<?> removeGuild(@PathVariable String guildName) {
        service.removeGuild(guildName);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/all")
    public List<String> getAllGuilds() {
        return service.findAll().stream()
                .map(GankingGuild::getGuildName)
                .collect(Collectors.toList());
    }
}
