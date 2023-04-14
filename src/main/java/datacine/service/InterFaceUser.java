package datacine.service;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InterFaceUser {

    public String setverifuser(String user, String password, JdbcTemplate jdbcTemplates) {
        String sqlQuery = "SELECT count(*) as verif,admin FROM user WHERE user = '"+user+"' AND password ='"+password+"'; ";
        System.out.println(sqlQuery);
        List<Map<String, Object>> rows = jdbcTemplates.queryForList(sqlQuery);
        String verif=rows.get(0).get("verif").toString();
        String session="null";
        if(verif.equals("1")){
             session=rows.get(0).get("admin").toString();

         }
        String result = verif + "," + session;
        return result;
    }
    public String setverifuser(String user, String mail, String password, JdbcTemplate jdbcTemplates) {
        String sqlQuery = "SELECT count(*) as verif FROM user WHERE user = '"+user+"' OR mail ='"+mail+"'; ";
        System.out.println(sqlQuery);
        List<Map<String, Object>> rows = jdbcTemplates.queryForList(sqlQuery);
        String verif=rows.get(0).get("verif").toString();
        String session="null";
        if(verif.equals("1")){
            return "compte existant";

        }
        //utilisateur classique
        String sql ="INSERT INTO `user` ( `user`, `mail`, `password`, `admin`) VALUES ('"+user+"', '"+mail+"','"+password+"', '0');";
        jdbcTemplates.execute(sql);
        return "compte cree";
    }

    public  Map<String, Object> getfilm(JdbcTemplate jdbcTemplates) {
        String sqlQuery = "SELECT * FROM `film` ";
        System.out.println(sqlQuery);
        List<Map<String, Object>> rows = jdbcTemplates.queryForList(sqlQuery);
        Map<String, Object> result = new LinkedHashMap<>();
        for (Map<String, Object> row : rows) {
            String id_film = row.get("id_film").toString();
            String nom = row.get("nom").toString();
            result.put(id_film, nom);
        }
        return result;
    }
    public Map<String, Object>  getsearchfilm(JdbcTemplate jdbcTemplates,String nomfilm) {
        String sqlQuery = "SELECT * FROM `film` where nom like '%"+nomfilm+"%';";
        System.out.println(sqlQuery);
        List<Map<String, Object>> rows = jdbcTemplates.queryForList(sqlQuery);
        Map<String, Object> result = new LinkedHashMap<>();
        for (Map<String, Object> row : rows) {
            String id_film = row.get("id_film").toString();
            String nom = row.get("nom").toString();
            result.put(id_film, nom);
        }
        return result;
    }

    public String getdescriptionfilm(JdbcTemplate jdbcTemplates, String id) {
        String sqlQuery = "SELECT description FROM `film` where id_film="+id+";";
        System.out.println(sqlQuery);
        List<Map<String, Object>> rows = jdbcTemplates.queryForList(sqlQuery);
        return rows.get(0).get("description").toString();
    }

    public Map<String, Object> getlistcommentaire(JdbcTemplate jdbcTemplates, String id) {
        String sqlQuery = "SELECT * FROM `avisfilm` where id_film="+id+";";
        System.out.println(sqlQuery);
        List<Map<String, Object>> rows = jdbcTemplates.queryForList(sqlQuery);
        Map<String, Object> result = new LinkedHashMap<>();
        for (Map<String, Object> row : rows) {
            String id_film = row.get("id_filmAvis").toString();
            String nom = row.get("avis").toString()+ " : "+row.get("note").toString();
            result.put(id_film, nom);
        }
        return result;
    }

    public String insercommentaire(JdbcTemplate jdbcTemplates, String id, String note, String description) {
        String sql ="INSERT INTO `avisfilm` ( `id_film`, `note`, `avis`) VALUES ('"+id+"', '"+note+"','"+description+"');";
        jdbcTemplates.execute(sql);
        return "compte cree";

    }

    public String dellistcommentaire(JdbcTemplate jdbcTemplates, String id) {
        String sql ="DELETE FROM avisfilm WHERE `avisfilm`.`id_filmAvis` ="+id+" ;";
        jdbcTemplates.execute(sql);
        return "compte cree";
    }
}
