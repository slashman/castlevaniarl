package crl.game;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;


public class GameVersion {
	private static final GameVersion currentVersion = new GameVersion("0.8.2", 2024, 2, 25);
	
	public static GameVersion getCurrentVersion(){
		return currentVersion;
	}

	public GameVersion(String code, int year, int month, int date) {
		this.code = code;
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		c.set(year, month, date);
		this.date = c.getTime();
	}

	@Override
	public boolean equals(Object arg0)
	{
		return ((GameVersion) arg0).getCode().equals(code);
	}

	private String code;
	private Date date;

	public String getCode() {
		return code;
	}

	private DateFormat sdf = DateFormat.getDateInstance(DateFormat.MEDIUM);

	public String getFormattedDate(){
		return sdf.format(date);
	}

	public static GameVersion getLatestVersion() throws HttpException, IOException
	{
		String url = "http://slashie.net/cvrl/latestVersion.txt";
		HttpClient client = new HttpClient();
		GetMethod latestVersion = new GetMethod(url);
		client.executeMethod(latestVersion);
		String str = latestVersion.getResponseBodyAsString();
		String[] info = str.split(",");
		latestVersion.releaseConnection();
		try {
			return new GameVersion(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[3]));
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid content for latest version URL: " + str);
			return null;
		}
	}
}
