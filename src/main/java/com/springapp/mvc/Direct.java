package com.springapp.mvc;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

/**
 * Created by Marat on 22.06.2016.
 */
public class Direct {
    static DocImpl doc = new Docjdbc();

    public static void add(){
        File file = new File("C:/directSberTat");
        file.mkdirs();
    }

    public static String saveFile(String name, long link, String path, MultipartFile file){
        if(!file.isEmpty()){
            try{
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path + link + "." + getFileExtension(file))));
                stream.write(file.getBytes());
                stream.close();
                doc.create(name, link, getFileExtension(file));

                return "Вы удачно загрузили " + name + "!";
            }catch (Exception e){
                return "Вам не удалось загрузить " + name + " => " + e.getMessage();
            }
        }else {
            return "Вам не удалось загрузить " + name + " Потому что файл пустой.";
        }
    }

    public static String deleteFile(Integer id){
        if(id != null){
            try{

                Docs d = doc.getDocById(id);
                File file = new File("C:/directSberTat/" + d.getLink() + "." + d.getFormat());
                file.delete();
                file = null;
                doc.delete(id);
                return "Файл удален";
            }catch (Exception e){
                System.out.println("INFO: " + e);
                return "Ошибка: файл не удален";
            }
        }
        return null;
    }

    public static String renameFile(int id, String name){
        try {
            doc.update(id, name);
            return "Документ обнавлен";
        }catch (Exception e){
            return "Ошибка обнавления";
        }
    }

    public static ArrayList<Docs> listFile(int tabul){
        try {
            return doc.listDocs(tabul);
        }catch (Exception e){
            System.out.println("INFO: " + e);
            return null;
        }
    }




    public static long countDirect(){
        File count = new File("C:/directSberTat");
        return count.list().length;
    }

    public static String getFileExtension(MultipartFile file) {

        String fileName = file.getOriginalFilename();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
