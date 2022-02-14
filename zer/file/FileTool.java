package zer.file;



import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;



public class FileTool
{
	private static String lastErrorMessage;
	public static String lastErrorMessage() { return lastErrorMessage; }

	private static boolean isKnownFileType(String test)
	{
		for (FileType type : FileType.values())
			if (type.name().equals(test))
				return true;
		return false;
	}

	public static FileType getFileTypeByPath(String path)
	{
		if (path.contains("."))
		{
			String[] parts = path.split("\\.");
			String type = parts[parts.length - 1];

			if (!isKnownFileType(type))
			{
				lastErrorMessage = "unknown file type \"" + type + "\"..";
				return null;
			}

			return FileType.valueOf(type.toUpperCase());
		}
		return null;
	}

	public static String readPlain(String path)
	{
		String result = new String();
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			String line;
			while ((line = br.readLine()) != null)
				result += line + "\n";
		}
		catch (IOException e) { e.printStackTrace(); }
	
		if (result.length() > 0)
			/*
			 * remove last new line character
			 */
			result = result.substring(0, result.length() - 1);
		
		return result;
	}
}
