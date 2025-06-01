package dontneg.gankdetectorbackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GankingGuildRepository extends JpaRepository<GankingGuild, String> {
    List<GankingGuild> findByGuildNameIn(List<String> guildNames);
}
