package com.natapg;
import com.natapg.recentFiles.*;
import static org.junit.Assert.*;

import java.util.LinkedList;
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
    assertEquals(1,file1.getRecentFiles().size());
  }
}
