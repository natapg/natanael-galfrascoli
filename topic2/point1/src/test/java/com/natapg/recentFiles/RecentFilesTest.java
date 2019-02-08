package com.natapg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.natapg.recentFiles.FileManager;
import org.junit.Test;

public class RecentFilesTest {

  @Test

  public void firstTimeEmptyList() {
    FileManager file1 = new FileManager();
    assertTrue(file1.getRecentFiles().isEmpty());
  }

  @Test
  public void openFileAddedList() {
    FileManager file1 = new FileManager();
    file1.openFile("text.txt");
    assertEquals(1, file1.getRecentFiles().size());
  }
  @Test
  public void openFileAlreadyOpenNotDuplicateBumped(){
    FileManager file1 = new FileManager();
    file1.openFile("text.txt");
    file1.openFile("text.txt");
    assertEquals(1,file1.getRecentFiles().size());
    assertEquals(0,file1.getRecentFiles().indexOf("text.txt"));
  }

}
