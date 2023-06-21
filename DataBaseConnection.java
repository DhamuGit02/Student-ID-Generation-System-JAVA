import java.sql.*;
public class DataBaseConnection {
    static Connection con = null;
    static final String url = "jdbc:mysql://localhost:3306/DBMS";
    static final String uname = "root";
    static final String password = "YOUR_PASSWORD";

    public static Connection getConnection() {
        if (con != null) {
            return con;
        } else {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, uname, password);
                return con;
            } catch (Exception exp) {
                exp.printStackTrace();
	        return con;
            }
        }
    }

    public static boolean checkconnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, uname, password);
            return true;
        } catch (Exception exp) {
            exp.printStackTrace();
            return false;
        }
    }

    public static void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean registration(String name, String username, String password, String mobNo, String emailId) throws SQLException {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from login_reg where username = '" + username + "' and password = '" + password + "';");
        resultSet.next();
        try {
            if (resultSet.getString("username").equals(username) && resultSet.getString("password").equals(password)) {
                System.out.print("Username & password already exists!");
                return false;
            }
        } catch (Exception ignored) {
            String query = "insert into login_reg values('" + name + "', '" + username + "', '" + password + "', '" + mobNo + "', '" + emailId + "');";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
            System.out.println("Registration successful!");
            return true;
        }
        return false;
    }

    public boolean login(String username, String password) throws SQLException {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from login_reg where username = '" + username + "' and password = '" + password + "';");
        resultSet.next();
        try {
            return resultSet.getString("username").equals(username) && resultSet.getString("password").equals(password);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }

    public boolean uploadStudentData(String[] data) {
        String sid, name, Class, branch, mobNo, college, stud_photo, clg_logo, address;
        sid = data[0];
        name = data[1];
        Class = data[2];
        branch = data[3];
        mobNo = data[4];
        stud_photo = data[5];
        clg_logo = data[6];
        address = data[7];
        college = data[8];
        String query = "insert into student_data " +
                "values('" + sid + "', '" + name + "', '" + Class + "', '" + branch + "', '" + mobNo + "', '" +
                stud_photo + "', '" + clg_logo + "', '" + address + "', '" + college + "');";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean checkStudent(String sid) {
        String query = "select * from student_data where sid = '" + sid + "';";
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            return resultSet.getString("sid").equals(sid);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }

    public ResultSet getStudentData(String sid) {
        String query = "select * from student_data where sid = '" + sid + "';";
        try {
            Statement statement = con.createStatement();
            return statement.executeQuery(query);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    public boolean updateStudentDetails(String[] data) {
        String sid, name, Class, branch, mobNo, college, stud_photo, clg_logo, address;
        sid = data[0];
        name = data[1];
        Class = data[2];
        branch = data[3];
        mobNo = data[4];
        stud_photo = data[5];
        clg_logo = data[6];
        address = data[7];
        college = data[8];
        if(checkStudent(sid)) {
            try {
                Statement statement = con.createStatement();
                String query = "update student_data " +
                        "set " +
                        "name = '" + name + "'," +
                        "class = '" + Class + "'," +
                        "branch = '" + branch + "'," +
                        "mobno = '" + mobNo + "'," +
                        "studentphoto = '" + stud_photo + "'," +
                        "collgename = '" + college + "'," +
                        "collegelogo = '" + clg_logo + "'," +
                        "address = '" + address + "'" +
                        " where sid = '" + sid + "';";
                statement.executeUpdate(query);
                return true;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return false;
    }
    public boolean deleteStudentData(String sid) {
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate("delete from student_data where sid = '" + sid + "';");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public ResultSet getAllStudents(){
        try
        {
            Statement statement = con.createStatement();
            return statement.executeQuery("select name, sid from student_data;");
        }
        catch (Exception e){System.out.println(e.getMessage());}
        return null;
    }
    public ResultSet getUIDAndPassword(String mobNo)
    {
        try
        {
            Statement statement = con.createStatement();
            return statement.executeQuery("select username, password from Login_reg where mobile = '" + mobNo + "';");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
