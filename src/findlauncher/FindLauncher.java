package findlauncher;

import find.*;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.util.List;

public class FindLauncher {
    @Option(name = "-r", metaVar = "SubDirectory", usage = "Search in a subdirectory")
    private boolean flagR = false;

    @Option(name = "-d", metaVar = "Directory", usage = "Search in a directory")
    private File directory = new File(".");

    @Argument(metaVar = "File name", usage = "Input file name", required = true)
    private File fileName;

    public static void main(String[] args) {
        new FindLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        }
        catch (CmdLineException e) {
            System.err.println("[-r] [-d directory] filename.txt");
            parser.printUsage(System.err);
            return;
        }

        Find file = new Find(flagR, directory, fileName);
        List<String> result = file.getFilePath();
        for (String s: result) System.out.println(s);
    }
}
