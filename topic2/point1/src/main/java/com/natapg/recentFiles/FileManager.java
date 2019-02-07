package com.natapg.recentFiles;

import java.util.LinkedList;

public class FileManager {

  LinkedList<String> recentFiles;

  public FileManager() {
    recentFiles = new LinkedList<>();
  }


  public LinkedList<String> getRecentFiles() {
    return recentFiles;
  }

}
