# kbld4j

kbld4j is a java wrapper around the popular kbld binary integrating with
zeroturnaround's excellent process executor.

## Usage

```java
ProcessExecutor pe = Kbld.kbld()
        .pkg()
        .file(lockFile)
        .output(archiveFile)
        .executeAs();
```

You can then execute this command via the zero-turnaround API as follows:

```java
try {
    pe.directory(lockfileDirectory)
        .redirectErrorStream(true)
        .readOutput(true)
        .exitValue(0).execute();
} catch (InvalidExitValueException e) {
    logger.error("kbld exited with code {}", e.getExitValue());
    logger.error("Check the following kbld logs for what went wrong: {}", e.getResult().outputUTF8());
    throw new KbldException(e);
}
```
