package edu.eci.cvds.servlet.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {
    private final ConfigurationRepository configurationRepository;
    @Autowired
    public ConfigurationService(ConfigurationRepository configurationRepository){
        this.configurationRepository = configurationRepository;
    }
    public Configuration addConfiguration(Configuration configuration){
        return configurationRepository.save(configuration);
    }
    public Configuration getConfiguration(String propiedad){
        return configurationRepository.findById(propiedad);
    }
    public List<Configuration> getAllConfiguration(){
        return configurationRepository.findAll();
    }
    public Configuration updateConfiguration(Configuration configuration){
        if(configurationRepository.existsById(configuration.getId())){
            return configurationRepository.save(configuration);
        }
        return null;
    }
    public void deleteConfiguration(Long propiedad){
        configurationRepository.deleteById(propiedad);
    }
}
