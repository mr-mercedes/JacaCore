package ru.geekbrains.lesson5;

import ru.geekbrains.lesson5.excep.ContainRootDirectoryInCopyDirectoryException;
import ru.geekbrains.lesson5.excep.CopyFileException;
import ru.geekbrains.lesson5.excep.CreateDirectoryException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BackupDirectory {
    private final static List<String> STORAGE_PATH = new ArrayList<>();
    private final String backupDirectory;

    public BackupDirectory(String backupDirectory) {
        this.backupDirectory = backupDirectory;
    }

    public void copyDir(String absolutePath) throws IOException {
        File baseFile = new File(new File(absolutePath).getCanonicalPath());
        if (baseFile.isDirectory()) {
            String url = getUrl(baseFile, false);
            File subDirectory = new File(url);
            if (!subDirectory.exists()) {
                if (subDirectory.mkdirs()) {
                    doCopyDirectory(baseFile);
                } else {
                    throw new CreateDirectoryException(String.format("Unexpected error with creating directory %s\n", subDirectory.getName()));
                }
            } else {
                doCopyDirectory(baseFile);
            }
        }
    }

    private void doCopyDirectory(File baseFile) throws IOException {
        File[] files = baseFile.listFiles();
        assert files != null;
        doBackup(files);
        STORAGE_PATH.remove(STORAGE_PATH.size() - 1);
    }

    private void doBackup(File[] files) throws IOException {
        for (File file : files) {
            File newFile = new File(file.getCanonicalPath());
            if (newFile.isDirectory()) {
                copyDir(newFile.getAbsolutePath());
            } else {
                copyFile(newFile.getAbsolutePath(), newFile.getParent());
            }
        }
    }

    private String getUrl(File baseFile, boolean parentDirectory) {
        StringBuilder url = new StringBuilder(this.backupDirectory);
        String[] splitLocation = getSplitUrl(baseFile);
        String lastDirectory = splitLocation[splitLocation.length - 1];
        if (!parentDirectory) STORAGE_PATH.add(lastDirectory);

        if (STORAGE_PATH.contains(isContainRootDirectory())) {
            throw new ContainRootDirectoryInCopyDirectoryException("Coping directory contain backup directory");
        }
        for (String path : STORAGE_PATH) {
            url.append(path).append("/");
            if (parentDirectory) {
                if (isLastPath(lastDirectory, path)) break;
            }
        }
        return url.toString();
    }

    private String isContainRootDirectory() {
        String[] split = backupDirectory.replace("\\", "/").split("/");
        return split[split.length - 1] + STORAGE_PATH.get(0);
    }

    private boolean isLastPath(String lastDirectory, String path) {
        return path.equals(lastDirectory);
    }

    private String[] getSplitUrl(File baseFile) {
        return baseFile.getPath().replace("\\", "/").split("/");
    }

    private void copyFile(String copyPath, String parent) throws CopyFileException {
        File parentFile = new File(parent);
        String url = getUrl(parentFile, true);
        String fileName = new File(copyPath).getName();
        doCopy(copyPath, url, fileName);
    }

    private void doCopy(String copyPath, String url, String fileName) throws CopyFileException {
        try (InputStream is = new BufferedInputStream(new FileInputStream(copyPath));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(url + fileName))) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
                os.flush();
            }
        } catch (IOException e) {
            throw new CopyFileException(String.format("Unexpected error with coping file %s\n", fileName) + e);
        }
    }
}
