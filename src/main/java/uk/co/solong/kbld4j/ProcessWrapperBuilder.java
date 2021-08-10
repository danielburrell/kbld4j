package uk.co.solong.kbld4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeroturnaround.exec.ProcessExecutor;

import java.util.List;
import java.util.stream.Collectors;

public class ProcessWrapperBuilder {
    private static final Logger logger = LoggerFactory.getLogger(ProcessWrapperBuilder.class);
    private final ProcessExecutor r;

    public ProcessWrapperBuilder(List<String> commands) {
        logger.info("Execution plan: {}", commands.stream().collect(Collectors.joining(" ")));
        this.r = new ProcessExecutor().command(commands);
    }


}
