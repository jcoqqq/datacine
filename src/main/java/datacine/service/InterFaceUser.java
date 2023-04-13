package datacine.service;

import org.springframework.jdbc.core.JdbcTemplate;

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
    public String setverifuser(String user, String password, String mail, JdbcTemplate jdbcTemplates) {
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
}
