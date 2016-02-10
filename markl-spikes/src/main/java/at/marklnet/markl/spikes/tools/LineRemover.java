package at.marklnet.markl.spikes.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Removes lines from given Input and appends to the end of each file.
 * 
 * Usage: TBD
 * 
 * @author Markl M.
 *
 */
public class LineRemover {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        final File file = new File(args[0]);
        
        final String append = args.length == 2 ? args[1] : "";
        
        if (!file.exists()) {
            throw new IllegalArgumentException("File doesn't exist. " + args[0]);
        }
        
        System.out.println(String.format("Going to read file %s and append '%s' to each line, but the last.", args[0], append));
        
        final Scanner scanner = new Scanner(file);
        
        final StringBuilder str = new StringBuilder();
        
        while (scanner.hasNext()) {
            final String cLine = scanner.nextLine();
            str.append(cLine).append(append);
        }
        
        scanner.close();
        
        System.out.println(str.toString());
        
    }
 
}
