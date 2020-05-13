
package com.teksystems.directoryreader;

import java.io.File;

/**
 * @author Ricardo Plascencia Silva
 * @email ricardo072@gmail.com
 * @version 1.0
 * 
 * Collected constants of general utility, all members of this class are immutable.
 * 
 */
public class DirectoryReaderConstants
{
    /**
     * This is the root directory file path given for this coding exercise.
     */
    public final static String MAIN_DIRECTORY_PATH = "./testdirectory/Main Project";
    
    /**
     * The system-dependent default name-separator character, represented as a
     * string for convenience, on UNIX systems the value of this field 
     * is <code>'/'</code>; on Microsoft Windows systems it is <code>'\\'</code>.
     */
    public final static String DELIMETER = File.separator + ".";
    
    /**
     * This is the instance of the root directory file path given for this coding exercise.
     */
    public final static File ROOT_DIRECTORY = new File(MAIN_DIRECTORY_PATH);
}
