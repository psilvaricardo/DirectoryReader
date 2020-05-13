
package com.teksystems.directoryreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author Ricardo Plascencia Silva
 * @email ricardo072@gmail.com
 * @version 1.0
 * 
 * The {@code DirectoryReaderOutputter} class contains all the functionality
 * to handle any kind of output for this coding exercise. For this version 
 * it only prints information out to the console, but if in the future we 
 * need to output the data as JSON or something else, we should be able to 
 * add that functionality here.
 * 
 */
public class DirectoryReaderOutputter
{
    private int lenghtOfDirectory = 0;
    private static DirectoryReaderOutputter instance = null;

    /**
     * Exists only to avoid instantiation.
     */
    private DirectoryReaderOutputter()
    {
        this.lenghtOfDirectory = 
                DirectoryReaderConstants.ROOT_DIRECTORY.getAbsolutePath().length() - 
                DirectoryReaderConstants.ROOT_DIRECTORY.getName().length();
    }
    
    public static DirectoryReaderOutputter getInstance()
    {
        if ( instance == null )
        {            
            instance = new DirectoryReaderOutputter();
        }
        
      return instance;
   }
    
    /**
     * This methods list and print all files recursively
     *
     * @param file
     * @param tabs
     * @throws java.io.FileNotFoundException
     * @throws NullPointerException If the <code>file</code> argument is <code>null</code>
     */
    public void listAllFilesRecursively(File file, int tabs) throws FileNotFoundException
    {
        if (file != null)
        {
            if (file.isDirectory())
            {
                for (int i = 0; i < tabs; i++)
                {
                    System.out.print("  ");
                }
                
                System.out.println("- Project: " + file.getName() + " - URL: " + 
                                   file.getAbsolutePath().substring(lenghtOfDirectory));
                String listOfFileNames[] = file.list();
                // sortedList = sort(s);
                
                DirectoryReaderFileOperations dirReaderFileOps = new DirectoryReaderFileOperations();
                List<String> sortedListOfFiles = dirReaderFileOps.sortFilesByExtensions(listOfFileNames);
                dirReaderFileOps.iterateListOfFiles(sortedListOfFiles, tabs, file);
            }
            else
            {
                System.out.println("Please provide a path to root directory");
            }
	}
        else
        {
            System.out.println("The file paramenter is not a directory, is null");
            throw new NullPointerException("The file paramenter is not a directory, is null");
        }
    }
   
    
    /**
     * This method prints directory and files on console
     *
     * @param file
     * @param tabs
     * @throws java.io.FileNotFoundException If the <code>file name</code> is empty
     * @throws NullPointerException If the <code>file</code> argument is <code>null</code>
     * 
     */
    public void printFileOnConsole(File file, int tabs) 
            throws FileNotFoundException
    {
        if (file == null)
        {
            System.out.println("The file paramenter is not a directory, is null");
            throw new NullPointerException("The file paramenter is not a directory, is null");
        }
        
        String fileName = file.getName();
        if (fileName.isEmpty())
        {
            System.out.println("The file name is empty");
            throw new FileNotFoundException("The file name is empty");
        }
        //String[] split = fileName.split(DirectoryReaderConstants.DELIMETER);
        
	for (int i = 0; i < tabs; i++)
        {
            System.out.print("  ");
        }
        
        System.out.println( "- Document: " + fileName + 
                            " - Extension: ." + fileName.substring( fileName.lastIndexOf(".")+1 , fileName.length() ) + 
                            " - URL: " + file.getAbsolutePath().substring(lenghtOfDirectory));
    }
        
}
