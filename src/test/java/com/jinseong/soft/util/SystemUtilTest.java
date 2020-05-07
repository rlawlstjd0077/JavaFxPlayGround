package com.jinseong.soft.util;

import org.junit.Test;



public class SystemUtilTest {
  @Test
  public void testGetMemory() {
    System.out.println("Total Memory(Byte): " + SystemUtil.getTotalMemoryByte());
    System.out.println("Total Memory(KB): " + SystemUtil.getTotalMemoryByte() / 1024 );
    System.out.println("Total Memory(MB): " + SystemUtil.getTotalMemoryByte() / 1024 / 1024 );
    System.out.println("Total Memory(GB): " + SystemUtil.getTotalMemoryByte() / 1024 / 1024 / 1024 );

    System.out.println("Available Memory(Byte): " + SystemUtil.getAvailableMemoryByte());
    System.out.println("Available Memory(KB): " + SystemUtil.getAvailableMemoryByte() / 1024 );
    System.out.println("Available Memory(MB): " + SystemUtil.getAvailableMemoryByte() / 1024 / 1024 );
    System.out.println("Available Memory(GB): " + SystemUtil.getAvailableMemoryByte() / 1024 / 1024 / 1024 );

    System.out.println("Percentage of Memory(%): " + SystemUtil.getMemoryPercent());
  }

}
