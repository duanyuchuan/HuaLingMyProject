package com.hualing.hualingmyproject.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭流的工具类
 */
public class IOUtils {
	/** 关闭流 */
	public static boolean close(Closeable io) {
		if (io != null) {
			try {
				io.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
