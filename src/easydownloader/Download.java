/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easydownloader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gattolfo
 */
public class Download extends Thread{
    private static String path;
    private static String url;
    //public static final JLabel text;
    private static final int BUFFER_SIZE = 4096;
    public Download(String url, String path){
        Download.path = path;
        Download.url = url;

    }
    @Override
    public void run(){
        try {
            //starter(path,url);
            System.out.println("avvio il download");
            //startes(url,path);
            test(url,path);
            System.out.println("file scaricato");
            error("Finito","File scaricato con successo in:"+path);
            DownloadFrame.start.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public static void startes(String FileURL , String FilePath) throws IOException{
//        File fileToCheck = new File(FilePath);
//        URL urls = new URL(FileURL);
//        BufferedInputStream inputStream = null;
//        BufferedOutputStream outputStream = null;
//        long DownloadedSoFar = 0;
//        URLConnection urlconnection = urls.openConnection();
//        long biggerFile = urlconnection.getContentLength();
//        System.out.println(biggerFile+"    -------");
//        FileOutputStream FOS = null;
//        if(fileToCheck.exists()){
//            DownloadedSoFar = fileToCheck.length();
//            urlconnection.setRequestProperty("Range", "bytes=" + DownloadedSoFar + "-");
//            FOS = new FileOutputStream(fileToCheck, true);
//            outputStream = new BufferedOutputStream(FOS);
//        }else{
//            FOS = new FileOutputStream(fileToCheck);
//            outputStream = new BufferedOutputStream(FOS);
//        }
//        urlconnection.connect();
//        inputStream = new BufferedInputStream(urlconnection.getInputStream());
//        byte[] buffer = new byte[8192];
//        int byteCount;
//        while ((byteCount = inputStream.read(buffer)) != -1){
//            System.out.println(buffer);
//            outputStream.write(buffer, 0, byteCount);
//        } // while
//        inputStream.close();
//        outputStream.flush();
//        outputStream.close();
//}
   
    
    
    public void test(String fileUrl,String filePath)throws IOException{
        URL url = new URL(fileUrl);
        HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
        httpConnection.addRequestProperty("User-Agent", "Mozilla");
        httpConnection.setFollowRedirects(true);
        long completeFileSize = httpConnection.getContentLength();
        System.out.println(completeFileSize+" ------ File size");
        java.io.BufferedInputStream in = new java.io.BufferedInputStream(httpConnection.getInputStream());
        java.io.FileOutputStream fos = new java.io.FileOutputStream(filePath);
        java.io.BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
        byte[] data = new byte[1024];
        long downloadedFileSize = 0;
        int x = 0;
        while ((x = in.read(data, 0, 1024)) >= 0) {
            downloadedFileSize += x;
            // calculate progress
            final int currentProgress = (int) ((((double)downloadedFileSize) / ((double)completeFileSize))* 100000d );
            System.out.println(currentProgress+ "%");
            DownloadFrame.progress_bar.setValue(currentProgress);
            bout.write(data, 0, x);
        }
        bout.close();
        in.close();
    
}  
    
    
    
    
  
    
//    public static void starter(String fileName, String fileUrl)throws MalformedURLException, IOException {
//        BufferedInputStream inStream = null;
//        FileOutputStream outStream = null;
//        try {
//            URL fileUrlObj=new URL(fileUrl);
//            inStream = new BufferedInputStream(fileUrlObj.openStream());
//            outStream = new FileOutputStream(fileName);
// 
//            byte data[] = new byte[1024];
//            int count;
//            while ((count = inStream.read(data, 0, 1024)) != -1) {
//            outStream.write(data, 0, count);
//        }
//        } finally {
//        if (inStream != null)
//            inStream.close();
//        if (outStream != null)
//            outStream.close();
//        }
//    }
//     
        public static void error(String action, String errore){
                /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ErrorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ErrorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ErrorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ErrorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ErrorFrame(action,errore).setVisible(true);
            }
        });
    }
}
