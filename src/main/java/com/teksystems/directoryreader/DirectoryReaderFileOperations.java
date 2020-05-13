
package com.teksystems.directoryreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Ricardo Plascencia Silva
 * @email ricardo072@gmail.com
 * @version 1.0
 * 
 * The {@code DirectoryReaderFileOperations} class contains all the functionality
 * to handle any kind of file operations given for this coding exercise.
 * 
 */
public class DirectoryReaderFileOperations 
{
	/**
	 * Iterate over the directories and sub directories, whenever a directory is found 
         * on the file structure it navigates recursively until there is no more directories
         * and it print out a list of files, if any.
	 *
	 * @param sortedListOfFiles
	 * @param tabs
	 * @param dir
         * @throws java.io.FileNotFoundException
         * @throws NullPointerException If the <code>dir</code> argument is <code>null</code>
	 */
	public void iterateListOfFiles(List<String> sortedListOfFiles, int tabs, File dir) 
                throws FileNotFoundException 
        {
            if (dir == null)
            {
                System.out.println("The file parameter is not a directory, is null");
                throw new NullPointerException("The file paramenter is not a directory, is null");
            }
            
            for (String item : sortedListOfFiles) 
            {
                    tabs++;
                    File file = new File(dir + "/" + item);
                    if (file.isDirectory()) 
                    {
                        DirectoryReaderOutputter.getInstance().listAllFilesRecursively(file, tabs);
                        tabs--;
                    }
                    else
                    {
                        DirectoryReaderOutputter.getInstance().printFileOnConsole(file, tabs);
                        tabs--;
                    }
            }
	}

	/**
	 * This methods sort the list of files by extension
	 *
	 * @param listOfFileNames
	 * @return The final list of all files sorted by extension.
	 */
	public List<String> sortFilesByExtensions(String[] listOfFileNames) {
		List<String> orginalList = new CopyOnWriteArrayList<>(Arrays.asList(listOfFileNames));
		Set<String> setOfuniqueExtension = new TreeSet<>();

		for (String item : listOfFileNames) {
			if (item.contains(".")) {
				String[] split = item.split(DirectoryReaderConstants.DELIMETER);
				String temp = "." + split[split.length - 1];
				setOfuniqueExtension.add(temp);
			}
		}

		List<String> finalListOfAllFiles = new LinkedList<>();
		setOfuniqueExtension.stream().forEach((s1) -> 
                {
			for (int i = 0; i < orginalList.size(); i++) 
                        {
                            if (orginalList.get(i).contains(s1)) 
                            {
                                finalListOfAllFiles.add(orginalList.get(i));
                                orginalList.remove(orginalList.get(i));
                                i--;
                            }
			}
		});

		orginalList.stream().filter((s1) -> (!finalListOfAllFiles.contains(s1))).forEach((s1) -> {
			finalListOfAllFiles.add(s1);
		});

		return finalListOfAllFiles;
	}
    
}
