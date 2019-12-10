package vgc.com.entities;

import javax.persistence.*;


//@SqlResultSetMappings(value = {
//        @SqlResultSetMapping(name = "ScheduleInfo", classes = @ConstructorResult(targetClass = Info.class, columns = {
//                @ColumnResult(name = "cinema_id"), @ColumnResult(name = "cinema_name"), @ColumnResult(name = "cinema_address"),
//                @ColumnResult(name = "cinema_data", type= String.class) })) })
//@NamedNativeQuery(name = "showSchedule", resultSetMapping = "ScheduleInfo", query = "SELECT cinemas.cinema_id, cinemas.cinema_name, cinemas.cinema_address,\n" +
//        "(\n" +
//        "    SELECT JSON_ARRAYAGG(JSON_OBJECT('format_film',movie_format,'format_data',format_data))\n" +
//        "    FROM (\n" +
//        "    \tSELECT movies.movie_format,\n" +
//        "    \t(\n" +
//        "        \t JSON_ARRAYAGG(JSON_OBJECT('schedule_id', schedule.schedule_id, 'start', schedule.schedule_start))\n" +
//        "        \t\n" +
//        "        \t\n" +
//        "    \t) AS format_data\n" +
//        "    \tFROM movies movies\n" +
//        "    \tINNER JOIN schedule schedule\n" +
//        "    \tON schedule.movie_id = movies.movie_id\n" +
//        "    \tINNER JOIN room room\n" +
//        "    \tON room.room_id = schedule.room_id\n" +
//        "    \tWHERE schedule.schedule_date = :date AND movies.movie_id = :cinema_id \n" +
//        "    \tGROUP BY movies.movie_format\n" +
//        "    ) d\n" +
//        ") AS cinema_data\n" +
//        "FROM cinemas cinemas")
@Entity
@Table(name = "cinemas")
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cinema_id;
    @Column(name = "cinema_name")
    private String cinema_name;

    private String cinema_address;

    public Cinema() {
    }

    public Cinema(int cinema_id, String cinema_name, String cinema_address) {
        this.cinema_id = cinema_id;
        this.cinema_name = cinema_name;
        this.cinema_address = cinema_address;
    }

    public int getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    public String getCinema_name() {
        return cinema_name;
    }

    public void setCinema_name(String cinema_name) {
        this.cinema_name = cinema_name;
    }

    public String getCinema_address() {
        return cinema_address;
    }

    public void setCinema_address(String cinema_address) {
        this.cinema_address = cinema_address;
    }
}
