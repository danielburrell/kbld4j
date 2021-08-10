package uk.co.solong.kbld4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeroturnaround.exec.ProcessExecutor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KbldBuilder {

    private static final Logger logger = LoggerFactory.getLogger(KbldBuilder.class);
    private final List<String> commandStrings;

    public KbldBuilder(String kbld) {
        commandStrings = new ArrayList<>();
        commandStrings.add(kbld);
    }
    public KbldBuilder() {
        this("kbld");
    }

    public KbldBuilder file(File file) {
        commandStrings.add("--file");
        commandStrings.add(file.getAbsolutePath());
        return this;
    }

    public KbldBuilder lockOutput(File lockOutputFile) {
        commandStrings.add("--lock-output");
        commandStrings.add(lockOutputFile.getAbsolutePath());
        return this;
    }

    public KbldBuilder buildConcurrency(int concurrency) {
        commandStrings.add("--build-concurrency");
        commandStrings.add(Integer.toString(concurrency));
        return this;
    }

    public KbldBuilder color() {
        commandStrings.add("--color");
        return this;
    }

    public KbldBuilder column(List<String> visibleColumns) {
        commandStrings.add("--column");
        commandStrings.addAll(visibleColumns);
        return this;
    }

    public KbldBuilder help() {
        commandStrings.add("--help");
        return this;
    }

    public KbldBuilder imageMapFile(File imageMapFile) {
        commandStrings.add("--image-map-file");
        commandStrings.add(imageMapFile.getAbsolutePath());
        return this;
    }

    public KbldBuilder imagesAnnotation(Boolean isAnnotated) {
        commandStrings.add("--images-annotation");
        commandStrings.add(Boolean.toString(isAnnotated));
        return this;
    }

    public KbldBuilder json() {
        commandStrings.add("--json");
        return this;
    }

    public KbldBuilder registryCaCertPath(File registryCaCertFile) {
        commandStrings.add("--registry-ca-cert-path");
        commandStrings.add(registryCaCertFile.getAbsolutePath());
        return this;
    }

    public KbldBuilder registryVerifyCerts(Boolean registryVerifyCerts) {
        commandStrings.add("--registry-verify-certs");
        commandStrings.add(Boolean.toString(registryVerifyCerts));
        return this;
    }

    public KbldBuilder sort(Boolean sort) {
        commandStrings.add("--sort");
        commandStrings.add(Boolean.toString(sort));
        return this;
    }

    public KbldBuilder tty() {
        commandStrings.add("--tty");
        return this;
    }

    public KbldBuilder version() {
        commandStrings.add("--version");
        return this;
    }

    public KbldBuilder yes() {
        commandStrings.add("--yes");
        return this;
    }

    public KbldBuilder inspect() {
        commandStrings.add("inspect");
        return this;
    }

    public KbldBuilder pkg() {
        commandStrings.add("package");
        return this;
    }

    public KbldBuilder unpackage() {
        commandStrings.add("unpackage");
        return this;
    }

    public KbldBuilder output(File tarball) {
        commandStrings.add("--output");
        commandStrings.add(tarball.getAbsolutePath());
        return this;
    }

    public ProcessExecutor executeAs() {
        logger.info("Execution plan: {}", commandStrings.stream().collect(Collectors.joining(" ")));
        return new ProcessExecutor().command(this.commandStrings);
    }
}
