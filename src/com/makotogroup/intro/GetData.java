package com.makotogroup.intro;

import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;





public class GetData{
	
	private static final Pattern TAG_REGEX_Character = Pattern.compile("<a href='/reports/[^>]*>(.*?)</a>");
	private static final Pattern TAG_REGEX_Server = Pattern.compile("href='/realms/\\w.*>(.*)-(.*)</a>");
	private static final Pattern TAG_REGEX_Guild = Pattern.compile("href='/guilds/\\w.*>(.*?)</a>");
	private static final Pattern TAG_REGEX_DPSe = Pattern.compile("href='/realms/\\w.*>(.*)-(.*)</a></td>\\s*<td>(\\d*)</td>");
	private static final Pattern TAG_REGEX_Date = Pattern.compile("href='/realms/\\w.*>.*</a></td>\\s*<td>.*</td>\\s*.*\\s*.*\\s*.*\\s*<td>(.*?)</td>");
	private static final Pattern TAG_REGEX_Time = Pattern.compile("href='/realms/\\w.*>.*</a></td>\\s*<td>.*</td>\\s*.*\\s*.*\\s*.*\\s*<td>.*</td>\\s*<td>(.*?)</td>");
	
    private static List<Character> getTagValues(final String str) {
        final List<Character> tagValues = new ArrayList<Character>();
        final Matcher mCharacter = TAG_REGEX_Character.matcher(str);
        final Matcher mServer = TAG_REGEX_Server.matcher(str);
        final Matcher mDPSe = TAG_REGEX_DPSe.matcher(str);
        final Matcher mGuild = TAG_REGEX_Guild.matcher(str);
        final Matcher mDate = TAG_REGEX_Date.matcher(str);
        final Matcher mTime = TAG_REGEX_Time.matcher(str);
        
        while (mCharacter.find() && mServer.find() && mDPSe.find() && mGuild.find() && mDate.find() && mTime.find()) {
        	Character ch = new Character();
        	ch.setName(mCharacter.group(1));
        	ch.setRegion(mServer.group(1));
        	ch.setServer(mServer.group(2));
        	ch.setDps(Integer.parseInt(mDPSe.group(3)));
        	ch.setGuild(mGuild.group(1));
        	ch.setDate(mDate.group(1));
        	ch.setTime(mTime.group(1));
        	tagValues.add(ch);
        }
        return tagValues;
    }
    
    
    private static List<Character> GetCharactersList( String page ) throws Exception
    {
      	URL temp_url = new URL("http://www.worldoflogs.com/rankings/players/Throne_of_Thunder/Jin'rokh_the_Breaker/10N/dps/?page=" + page);
    	URLConnection con = temp_url.openConnection();
    	Pattern p = Pattern.compile("text/html;\\s+charset=([^\\s]+)\\s*");
    	Matcher m = p.matcher(con.getContentType());
    	/* If Content-Type doesn't match this pre-conception, choose default and 
    	 * hope for the best. */
    	String charset = m.matches() ? m.group(1) : "ISO-8859-1";
    	Reader r = new InputStreamReader(con.getInputStream(), charset);
    	StringBuilder buf = new StringBuilder();
    	while (true) {
    	  int ch = r.read();
    	  if (ch < 0)
    	    break;
    	  buf.append((char) ch);
    	}
    	
        return getTagValues(buf.toString()); 
    }

    public static void main(String[] args) throws Exception {
    	List<Character> charList = null;
    	
    	for (int i = 1; i <= 2; i++)	{
    		charList = GetCharactersList( String.valueOf(i));
    	}
    	System.out.println(charList);
    	
	  
    	//System.out.println(GetURLasHTML("http://eu.battle.net/api/wow/character/"));
    }
}



