package com.jinseong.soft.util;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

public class SystemUtil {
  public static long getTotalMemoryByte() {
    SystemInfo si = new SystemInfo();
    final HardwareAbstractionLayer hw = si.getHardware();
    final GlobalMemory memory = hw.getMemory();

    return memory.getTotal();
  }

  public static long getAvailableMemoryByte() {
    SystemInfo si = new SystemInfo();
    final HardwareAbstractionLayer hw = si.getHardware();
    final GlobalMemory memory = hw.getMemory();

    return memory.getAvailable();
  }

  public static double getMemoryPercent() {
    return (double) getAvailableMemoryByte() / getTotalMemoryByte() * 100;
  }


}
