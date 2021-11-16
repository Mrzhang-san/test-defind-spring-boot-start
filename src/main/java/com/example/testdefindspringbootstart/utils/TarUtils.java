package com.example.testdefindspringbootstart.utils;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 *
 *
 * 通过 Apache compress 工具打包思路大致如下：
 *
 * ①：创建一个 FileOutputStream 到输出文件（.tar.gz）文件。
 *
 * ②：创建一个GZIPOutputStream，用来包装FileOutputStream对象。
 *
 * ③：创建一个TarArchiveOutputStream，用来包装GZIPOutputStream对象。
 *
 * ④：接着，读取文件夹中的所有文件。
 *
 * ⑤：如果是目录，则将其添加到 TarArchiveEntry。
 *
 * ⑥：如果是文件，依然将其添加到 TarArchiveEntry 中，然后还需将文件内容写入 TarArchiveOutputStream 中。
 */
public class TarUtils {
    public static void compress(String sourceFolder,String tarGzPath) throws IOException {
        createTarFile(sourceFolder,tarGzPath);

    }

    private static void createTarFile(String sourceFolder,String tarGzPath) {
        TarArchiveOutputStream tarOs = null;
        try {
            // 创建一个FileOutputStream 到输出文件（.tar.gz）
            FileOutputStream fos = new FileOutputStream(tarGzPath);
            //创建一个GZIPOutputStream 用来包装FileOutputStream对象
            GZIPOutputStream gos = new GZIPOutputStream(new BufferedOutputStream(fos));
            // 创建一个 TarArchiveOutputStream，用来包装 GZIPOutputStream 对象
            tarOs = new TarArchiveOutputStream(gos);
            // 若不设置此模式，当文件名超过 100 个字节时会抛出异常，异常大致如下：
            // is too long ( > 100 bytes)
            // 具体可参考官方文档： http://commons.apache.org/proper/commons-compress/tar.html#Long_File_Names
            tarOs.setLongFileMode(TarArchiveOutputStream.LONGFILE_POSIX);
            addFilesToTarGZ(sourceFolder, "", tarOs);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                tarOs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void addFilesToTarGZ(String filePath, String parent, TarArchiveOutputStream tarArchive) throws IOException {
        File file = new File(filePath);
        // Create entry name relative to parent file path
        String entryName = parent + file.getName();
        // 添加 tar ArchiveEntry
        tarArchive.putArchiveEntry(new TarArchiveEntry(file, entryName));
        if (file.isFile()) {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            // 写入文件
            IOUtils.copy(bis, tarArchive);
            tarArchive.closeArchiveEntry();
            bis.close();
        } else if (file.isDirectory()) {
            // 因为是个文件夹，无需写入内容，关闭即可
            tarArchive.closeArchiveEntry();
            // 读取文件夹下所有文件
            for (File f : file.listFiles()) {
                // 递归
                addFilesToTarGZ(f.getAbsolutePath(), entryName + File.separator, tarArchive);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 测试一波，将文件打包成名为 xxx.tar.gz 的 tar 包
        compress("E:\\学习资料\\mysql调优实战", "E:\\学习资料\\mysql调优实战.tar.gz");
    }


}
