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

  public void openFile(String file) {
    if (recentFiles.contains(file)) {
      recentFiles.set(0, file);
    } else {
      recentFiles.add(file);
    }

  }
}
