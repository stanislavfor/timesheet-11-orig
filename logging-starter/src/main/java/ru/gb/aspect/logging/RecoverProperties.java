package ru.gb.aspect.logging;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties("application.recover")
public class RecoverProperties {
    private boolean enabled = true;
    private List<String> noRecoverFor;
}
