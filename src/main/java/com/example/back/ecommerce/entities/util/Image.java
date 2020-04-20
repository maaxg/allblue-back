package com.example.back.ecommerce.entities.util;

import org.apache.tomcat.util.http.fileupload.FileItemHeaders;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.context.annotation.ApplicationScope;

import java.io.*;

@ApplicationScope
public class Image implements Serializable {
    private static final String pasta ="C:\\Users\\PC\\IdeaProjects\\ecommerce\\src\\main\\java\\com\\example\\back\\ecommerce\\entities\\util\\Image.java";
    //    private static final String pasta = "/Users/matheus/img";
    private File file;

    public static String getPasta() {
        return pasta;
    }

    public void upload(final FileUpload[] uploads) {
        // TODO Auto-generated method stub
        for (FileUpload upload : uploads) {
            upload(upload, "shoes", upload.toString());
        }
    }

    public void upload(final FileUpload upload, final String categoria, final String nome) {
        // TODO Auto-generated method stub
        if (upload != null) {
            InputStream in = new InputStream() {
                @Override
                public int read() throws IOException {
                    return 0;
                }
            };
            save(in, createFile(categoria, nome));
        }
    }

    public File download(String categoria, String nome) {
        // TODO Auto-generated method stub
        return open(categoria, nome);
    }

    public File show(String categoria, String nome) {
        // TODO Auto-generated method stub
        return download(categoria, nome);
    }

    private void save(InputStream in, File to) {
        // TODO Auto-generated method stub
        try {
            IOUtils.copyLarge(in, new FileOutputStream(to));
        } catch (Exception e) {
            throw new RuntimeException("Error ao salvar a imagem", e);
        }
    }

    private File open(String categoria, String nome) {
        // TODO Auto-generated method stub
        return open(createFile(categoria, nome));
    }

    private File open(File file) {
        // TODO Auto-generated method stub
        try {
            if (!file.exists()) {
                throw new FileUploadException(file.getAbsolutePath());
            } else {
                return file;
            }
        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private File createFile(String categoria, String nome) {
        // TODO Auto-generated method stub
        return new File(String.format("%s/%s/%s", pasta, categoria, nome));
    }

}

