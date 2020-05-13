package com.teksystems.directoryreader;

import java.io.FileNotFoundException;

/**
 * The purpose of this utility is to read and print all the file names under
 * parent directory and all it's subdirectories recursively. The project is
 * working code based on Maven and Java 8. I was re-factoring this code 
 * using good OO principles e.g. single responsibility principle, interface 
 * segregation, code readability. Exception handling was implemented as well. 
 * 
 * To run: 
 * mvn package 
 * and then 
 * mvn exec:java
 *
 * @author Ricardo Plascencia Silva
 * @email ricardo072@gmail.com
 * @version 1.0
 */
public class DirectoryReaderUtil 
{
	/**
	 * Main driver and entry point
	 *
	 * @param args
     * @throws java.io.FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException 
        {
            DirectoryReaderOutputter.getInstance().listAllFilesRecursively(DirectoryReaderConstants.ROOT_DIRECTORY, 0);
	}

}
