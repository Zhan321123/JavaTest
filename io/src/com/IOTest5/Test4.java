package com.IOTest5;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * Apache包下FileUtils类的测试
 */
public class Test4 {
    public static void main(String[] args) throws IOException {
        /**
         * FileUtils.copyDirectory(String src路径，String dest路径，new FileFilter（）{筛选方法}）
         * 将源文件夹按照方法复制到目标路径文件夹
         * 目标文件夹会自动创建
         */
        FileUtils.copyDirectory(new File("D:\\idea-code\\TestT"), new File("D:\\idea-code\\TestT\\zx"), new FileFilter() {
            /*
            筛选方法accept（File pathname）
            true为是，false不复制
             */
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory() || pathname.getName().endsWith("html")) {
                    return true;
                }
                return false;
            }
        });
    }
}
