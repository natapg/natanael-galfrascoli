package com.natapg.recentFiles;

import java.util.LinkedList;

public class FileManager {

  private int maxFiles = 15;
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
    } else if (recentFiles.size() == maxFiles) {
      recentFiles.removeLast();
      recentFiles.addFirst(file);
    } else {
      recentFiles.addFirst(file);
    }

  }
}
