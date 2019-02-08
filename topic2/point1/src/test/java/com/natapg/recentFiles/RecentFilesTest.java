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
  @Test
  public void ifRecentListGetsFullRemoveOldestFile() {
    FileManager file1 = new FileManager();
    file1.openFile("text0.txt");
    file1.openFile("text1.txt");
    file1.openFile("text2.txt");
    file1.openFile("text3.txt");
    file1.openFile("text4.txt");
    file1.openFile("text5.txt");
    file1.openFile("text6.txt");
    file1.openFile("text7.txt");
    file1.openFile("text8.txt");
    file1.openFile("text6.txt");
    file1.openFile("text9.txt");
    file1.openFile("text10.txt");
    file1.openFile("text11.txt");
    file1.openFile("text12.txt");
    file1.openFile("text13.txt");
    file1.openFile("text14.txt");
    file1.openFile("text15.txt");
    file1.openFile("text16.txt");
    file1.openFile("text17.txt");
    assertEquals(15,file1.getRecentFiles().size());
    assertEquals(0,file1.getRecentFiles().indexOf("text17.txt"));
  }

}


