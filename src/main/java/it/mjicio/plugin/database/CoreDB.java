package it.mjicio.plugin.database;

import java.util.Date;

public class CoreDB {

    private String playerUUID;

    //random stats on each player
    private String nomeMafia;
    private String bossmafia;
    private long blocksBroken;
    private double balance;

    //last login and logout times
    private Date lastLogin;
    private Date lastLogout;

    public CoreDB(String playerUUID, String nomeMafia, String bossmafia, Date lastLogin, Date lastLogout) {
        this.playerUUID = playerUUID;
        this.nomeMafia = nomeMafia;
        this.bossmafia = bossmafia;
        this.blocksBroken = blocksBroken;
        this.balance = balance;
        this.lastLogin = lastLogin;
        this.lastLogout = lastLogout;
    }

    public String getPlayerUUID() {
        return playerUUID;
    }

    public void setPlayerUUID(String playerUUID) {
        this.playerUUID = playerUUID;
    }

    public long getBlocksBroken() {
        return blocksBroken;
    }

    public void setBlocksBroken(long blocksBroken) {
        this.blocksBroken = blocksBroken;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLastLogout() {
        return lastLogout;
    }

    public void setLastLogout(Date lastLogout) {
        this.lastLogout = lastLogout;
    }
}
