/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fragtastic.jrpg;

import java.io.File;

/**
 *
 * @author mitch
 */
public class Util {

    // TODO - deal with netbeans running from target/..
    // shitty fix for now
    public static void setNatives() {
        File t = new File(System.getProperty("user.dir") + "/target");
        if (t.exists() && t.isDirectory()) {
            System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/target/natives/");
        } else {
            System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/natives/");
        }
    }

    public static String getOs() {
        String s = System.getProperty("os.name").toLowerCase();
        if (s.contains("win")) {
            return "windows";
        }
        if (s.contains("mac")) {
            return "macosx";
        }
        if (s.contains("solaris")) {
            return "solaris";
        }
        if (s.contains("sunos")) {
            return "solaris";
        }
        if (s.contains("linux")) {
            return "linux";
        }
        if (s.contains("unix")) {
            return "linux";
        } else {
            System.out.println("Your OS was not detected!");
            System.exit(1);
            return "unknown";
        }
    }
}
