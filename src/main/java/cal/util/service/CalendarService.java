package cal.util.service;

import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import javax.inject.Singleton;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Singleton
public class CalendarService {
  private String tenantsFile;
  List<String> orgs;

  public void load() {
    log.info("Loading [{}]", tenantsFile);
    Yaml yaml = new Yaml();
    String content = null;
    try {
      content = Files.readString(Paths.get(tenantsFile));
    } catch (IOException e) {
      throw new RuntimeException("Valio...");
    }
    orgs = yaml.load(content);
  }
}
