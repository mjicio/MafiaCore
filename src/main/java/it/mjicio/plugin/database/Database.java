package it.mjicio.plugin.database;

import it.mjicio.plugin.MafiaCore;

import java.sql.*;

public class Database {

    private Connection connection;

    MafiaCore plugin;

    public Connection getConnection() throws SQLException {

        if(connection != null){
            return connection;
        }

        //Try to connect to my MySQL database running locally
        String url = plugin.getConfig().getString("database-url");
        String user = plugin.getConfig().getString("database-user");
        String password = plugin.getConfig().getString("database-password");

        Connection connection = DriverManager.getConnection(url, user, password);

        this.connection = connection;

        System.out.println("Connected to database.");

        return connection;
    }

    public void initializeDatabase() throws SQLException {

        Statement statement = getConnection().createStatement();

        //Create the plugin.getConfig().getString("database-name") table
        String sql = "CREATE TABLE IF NOT EXISTS " + plugin.getConfig().getString("database-name") + "(uuid varchar(36) primary key, mafiaName string, boss-mafia string, last_login DATE)";

        statement.execute(sql);

        statement.close();

    }

    public CoreDB findmafiaCoreByUUID(String uuid) throws SQLException {

        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM " + plugin.getConfig().getString("database-name") + " WHERE uuid = ?");
        statement.setString(1, uuid);

        ResultSet resultSet = statement.executeQuery();

        CoreDB mafiaCore;

        if(resultSet.next()){

            mafiaCore = new CoreDB(resultSet.getString("uuid"), resultSet.getString("mafiaName"), resultSet.getString("bossmafia"), resultSet.getDate("last_login"), resultSet.getDate("last_logout"));

            statement.close();

            return mafiaCore;
        }

        statement.close();

        return null;
    }

    public void createCoreDB(CoreDB mafiaCore) throws SQLException {

        PreparedStatement statement = getConnection()
                .prepareStatement("INSERT INTO " + plugin.getConfig().getString("database-name") + "(uuid, deaths, kills, blocks_broken, balance, last_login, last_logout) VALUES (?, ?, ?, ?, ?, ?, ?)");
        statement.setString(1, mafiaCore.getPlayerUUID());
        statement.setLong(4, mafiaCore.getBlocksBroken());
        statement.setDouble(5, mafiaCore.getBalance());
        statement.setDate(6, new Date(mafiaCore.getLastLogin().getTime()));
        statement.setDate(7, new Date(mafiaCore.getLastLogout().getTime()));

        statement.executeUpdate();

        statement.close();

    }

    public void updateCoreDB(CoreDB mafiaCore) throws SQLException {

        PreparedStatement statement = getConnection().prepareStatement("UPDATE " + plugin.getConfig().getString("database-name") + " SET mafiaName = ?, bossmafia = ?, blocks_broken = ?, balance = ?, last_login = ?, last_logout = ? WHERE uuid = ?");
        statement.setLong(3, mafiaCore.getBlocksBroken());
        statement.setDouble(4, mafiaCore.getBalance());
        statement.setDate(5, new Date(mafiaCore.getLastLogin().getTime()));
        statement.setDate(6, new Date(mafiaCore.getLastLogout().getTime()));
        statement.setString(7, mafiaCore.getPlayerUUID());

        statement.executeUpdate();

        statement.close();

    }

    public void deleteCoreDB(CoreDB mafiaCore) throws SQLException {

        PreparedStatement statement = getConnection().prepareStatement("DELETE FROM " + plugin.getConfig().getString("database-name") + " WHERE uuid = ?");
        statement.setString(1, mafiaCore.getPlayerUUID());

        statement.executeUpdate();

        statement.close();

    }
}

