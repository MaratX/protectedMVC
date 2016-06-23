package com.springapp.mvc;

    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.util.ArrayList;
    import java.util.List;

/**
 * Created by Marat on 22.06.2016.
 */
public class Docjdbc implements DocImpl {
    BD bd = new BD();
    ResultSet rs = null;
    PreparedStatement PS = null;


    @Override
    public String create(String name, long link, String format){
        String SQL = "insert into cloude.document (docName, docLink, docFormat) values(?,?,?)";
        try {
            PS = bd.getPS(SQL);
            PS.setString(1, name);
            PS.setLong(2, link);
            PS.setString(3, format);
            PS.executeUpdate();
            return "Документ загружен";
        }catch (Exception e){
            return "Ошибка : документ не удалось загрузить";
        }finally {
            PS = null;
        }

    }

    @Override
    public Docs getDocById(Integer id) throws Exception{
        String SQL = "SELECT * FROM document WHERE id = " + id;
        rs = bd.getStm().executeQuery(SQL);
        Docs d = new Docs();
        rs.next();
        d.setName(rs.getString("docName"));
        d.setLink(rs.getLong("docLink"));
        d.setFormat(rs.getString("docFormat"));
        rs.close();
        return d;
    }

    @Override
    public ArrayList<Docs> listDocs(int tabul) throws Exception{
        ArrayList<Docs> list = new ArrayList<Docs>();
        Docs d = new Docs();
        String SQL = "SELECT id, docName, docFormat FROM cloude.document WHERE id >= ? LIMIT 20";
        PS = bd.getCon().prepareStatement(SQL);
        PS.setInt(1, tabul);
        rs = PS.executeQuery();

        while (rs.next()){
            list.add(rsDoc(rs));
        }
        PS.close();
        rs.close();
        return list;
    }

    private Docs rsDoc(ResultSet rs) throws Exception{
        Docs d = new Docs();
        d.setId(rs.getInt("id"));
        d.setName(rs.getString("docName"));
        d.setLink(0);
        d.setFormat(rs.getString("docFormat"));
        return d;
    }

    @Override
    public String delete(Integer id) throws Exception{
        String SQL = "DELETE FROM cloude.document where  id = ?";
        PS = bd.getPS(SQL);
        PS.setInt(1, id);
        PS.executeUpdate();
        PS.close();
        return "Запись удалена";
    }

    @Override
    public String update(Integer id, String name) throws Exception{
        String SQL = "UPDATE cloude.document SET docName=? WHERE id=?";
        PS = bd.getPS(SQL);
        PS.setString(1, name);
        PS.setInt(2, id);
        PS.executeUpdate();
        PS.close();
        return "Документ " + name + " обновлен";
    }
}
