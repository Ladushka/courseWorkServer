package schedule.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import schedule.service.ExportService;

@Configuration
public class ExportConfig {

    @Autowired
    private ExportService exportService;

    @Bean
    public RmiServiceExporter getExporter() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("exportService");
        exporter.setServiceInterface(ExportService.class);
        exporter.setService(exportService);
        exporter.setRegistryPort(3333);
        return exporter;
    }
}
