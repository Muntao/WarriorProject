/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Klient;
import entities.KlientZdjecie;
import entities.Zdjecie;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import models.KlientFacade;
import models.KlientZdjecieFacade;
import models.ZdjecieFacade;

/**
 *
 * @author layfl
 */
@Named(value = "uploadBean")
@ManagedBean
@ViewScoped
public class UploadBean {

    private Zdjecie zdjecie = new Zdjecie();
    private Part file;

    @Inject
    private SessionController sessionController;

    @EJB
    private KlientZdjecieFacade klientZdjecieFacade;
    @EJB
    private KlientFacade klientFacade;
    @EJB
    private ZdjecieFacade zdjecieFacade;

    public UploadBean() {
    }

    public Zdjecie getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(Zdjecie zdjecie) {
        this.zdjecie = zdjecie;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String uploadImage() {
        String kontoName = sessionController.getKonto().getKontoLogin();
        String profileFolderURL = getServerPath() + "/resources/pictures/" + base64EncodeString(kontoName);

        if (isDir(profileFolderURL) == false) {
            File f = new File(profileFolderURL);
            if (f.mkdir() == true) {
                System.out.println("CREATED: " + f.getAbsolutePath());
            }
        }

        String filePath = getFileNameFromPart(file);
        String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1, filePath.length());
        File outputFile = new File(profileFolderURL + "/" + fileName);
        try {
            Klient klient = getKlient();
            KlientZdjecie klientZdjecie = new KlientZdjecie();

            zdjecie.setZdjecieOcenaIlosc(0);
            zdjecie.setZdjecieOcenaSuma(0);
            zdjecie.setZdjecieSciezka(profileFolderURL + "/" + fileName);
            zdjecieFacade.create(zdjecie);

            klientZdjecie.setKlientZdjecieKlientIdFk(klient);
            klientZdjecie.setKlientZdjecieZdjecieIdFk(zdjecie);
            klientZdjecieFacade.create(klientZdjecie);

            saveFileOnDisk(outputFile);

        } catch (IOException | SQLException ex) {
            System.out.println("uploadImage() : " + ex);
            Logger.getLogger(UploadBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/index.xhtml";
    }

    private Klient getKlient() throws SQLException {
        Klient klient = klientFacade.getKlientByKontoId(sessionController.getKonto().getKontoId());
        if (klient == null) {
            throw new SQLException("Nie znaleziono klienta z konto_id = " + sessionController.getKonto().getKontoId());
        }
        return klient;
    }

    private void saveFileOnDisk(File outputFile) throws FileNotFoundException, IOException {
        InputStream inputStream = file.getInputStream();
        OutputStream outputStream = new FileOutputStream(outputFile);

        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
    }

    private String getServerPath() {
        FacesContext context = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) context
                .getExternalContext().getContext();

        return servletContext.getRealPath("");
    }

    public static String getFileNameFromPart(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                String fileName = content.substring(content.indexOf('=') + 1)
                        .trim().replace("\"", "");
                return fileName;
            }
        }
        return null;
    }

    private static String base64EncodeString(String toEncode) {
        byte[] encoded = Base64.getEncoder().encode(toEncode.getBytes());
        return new String(encoded);
    }

    private static String base64DecodeString(String toDecode) {
        byte[] decoded = Base64.getDecoder().decode(toDecode.getBytes());
        return new String(decoded);
    }

    private static boolean isDir(String path) {
        File tmpFile = new File(path);
        return tmpFile.exists() && tmpFile.isDirectory();
    }

    public static void main(String[] args) {
        String napis = "C:\\users\\desktop\\1.png";
        String splitted = napis.substring(napis.lastIndexOf("\\") + 1, napis.length());
        System.out.println(splitted);
    }
}
