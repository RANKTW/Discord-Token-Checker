package net.ranktw.discord;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.zip.ZipFile;

public class FileUtil {
    public static class JarFileFilter extends javax.swing.filechooser.FileFilter {
        @Override
        public boolean accept(final File f) {
            final String name = f.getName();
            return f.isDirectory() || name.endsWith(".jar") || name.endsWith(".zip");
        }

        @Override
        public String getDescription() {
            return "Java Archives (*.jar/*.zip)";
        }
    }
    public static class TxtFileFilter extends javax.swing.filechooser.FileFilter {
        @Override
        public boolean accept(final File f) {
            final String name = f.getName();
            return f.isDirectory() || name.endsWith(".txt");
        }

        @Override
        public String getDescription() {
            return "Text Document (*.txt)";
        }
    }
    public static String chooseDirectory(final File currFolder, final Component parent) {
        final JFileChooser chooser = new JFileChooser(currFolder);
        chooser.setFileSelectionMode(1);
        if (chooser.showOpenDialog(parent) == 0) {
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
    public static String chooseDirectoryOrFile(final File currFolder, final Component parent) {
        final JFileChooser chooser = new JFileChooser(currFolder);
        chooser.setFileSelectionMode(2);
        if (chooser.showOpenDialog(parent) == 0) {
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
    public static String chooseFile(final File currFolder, final Component parent) {
        final JFileChooser chooser = new JFileChooser(currFolder);
        if (chooser.showOpenDialog(parent) == 0) {
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
    public static String chooseFile(final File currFolder, final Component parent, final javax.swing.filechooser.FileFilter filter) {
        final JFileChooser chooser = new JFileChooser(currFolder);
        chooser.setFileFilter(filter);
        if (chooser.showOpenDialog(parent) == 0) {
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
    public static String chooseFileToSave(final File currFolder, final Component parent, final FileFilter filter) {
        final JFileChooser chooser = new JFileChooser(currFolder);
        chooser.setFileFilter(filter);
        if (chooser.showSaveDialog(parent) == 0) {
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
    public static boolean checkZip(final String file) {
        try {
            new ZipFile(file).entries();
        }
        catch (Throwable e) {
            return false;
        }
        return true;
    }
    public static boolean checkFileExist(final String file) {
        try {
            return new File(file).exists();
        }
        catch (Throwable e) {
            return false;
        }
    }
    public static boolean checkFileExistOrCreate(final File file) {
        try {
            return file.exists() || file.createNewFile();
        } catch (Throwable e) {
            return false;
        }
    }
    public static void copyFileUsingChannel(File source, File dest) throws IOException {
        try (FileChannel sourceChannel = new FileInputStream(source).getChannel(); FileChannel destChannel = new FileOutputStream(dest).getChannel()) {
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        }
    }
}
