package find;

import java.io.File;
import java.util.ArrayList;

public class Find {
    private ArrayList<String> result = new ArrayList<String>();
    private File fileName;
    private boolean flagR;

    public Find(boolean flagR, File directory, File fileName) {
        this.flagR = flagR;
        this.fileName = fileName;
        if (directory.exists()) find(directory);
        else throw new IllegalArgumentException("Директория не найдена");

    }

    private void find(File directory) {
        File[] names = directory.listFiles();
        assert names != null;
        for (File file: names) {
            if (file.getName().equals(fileName.getName()))
                result.add(file.getAbsolutePath());
            if (file.isDirectory() & flagR)
                find(file);
        }

    }

    public ArrayList<String> getFilePath() {
        return result;
    }
}
