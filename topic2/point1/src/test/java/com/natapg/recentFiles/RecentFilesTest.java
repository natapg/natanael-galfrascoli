package com.natapg.recentFiles;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RecentFilesTest {

  @Test
  public void firstTimeEmptyList() {
    FileManager file1 = new FileManager();
    assertEquals(0, file1.getRecentFiles().size());
  }
}
